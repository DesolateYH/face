package com.example.arcsoft.controller;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.scheduling.annotation.Async;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * @program: arcsoft
 * @description:
 * @author: QWS
 * @create: 2019-12-07 22:32
 */
public class CFileDataUDP  {
    private static int IMAGE_PORT = 8083;
    private DatagramPacket datagramPacket;
    private DatagramSocket datagramSocket;

    byte[] b = new byte[8192];

    @Async
    public byte[] receive() throws SocketException {
        System.out.println(1);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if(datagramSocket == null){
            datagramSocket = new DatagramSocket(null);
            datagramSocket.setReuseAddress(true);
            datagramSocket.bind(new InetSocketAddress(IMAGE_PORT));
        }else
            try {
                datagramSocket = new DatagramSocket(IMAGE_PORT);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        while(true){
            datagramPacket = new DatagramPacket(b, b.length);
            try {
                datagramSocket.receive(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String msg  = new String(datagramPacket.getData(),0,datagramPacket.getLength());
            if(msg.startsWith(";!")){
                System.out.println("-->接收到所有数据");
                break;
            }
            baos.write(datagramPacket.getData(),0,datagramPacket.getLength());
            System.out.println("-->正在接收数据:"+datagramPacket.getData());
        }
        try {
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return baos.toByteArray();


    }


}
