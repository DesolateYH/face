package com.example.arcsoft;

import com.example.arcsoft.controller.CFileDataUDP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

import java.net.SocketException;

@SpringBootApplication
public class ArcsoftApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArcsoftApplication.class);

     /*   CFileDataUDP cFileDataUDP = new CFileDataUDP();
        try {
            cFileDataUDP.receive();
        } catch (SocketException e) {
            e.printStackTrace();
        }*/
    }


  /*  @Async
    public void executeAsync1(){
        SpringApplication.run(ArcsoftApplication.class);
    }

    @Async
    public void executeAsync2(){
        SpringApplication.run(ArcsoftApplication.class);
    }
*/
}
