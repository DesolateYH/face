package com.example.arcsoft.controller;

import com.example.arcsoft.domain.po.FaceInfoPO;
import com.example.arcsoft.domain.vo.FaceInfoVO;
import com.example.arcsoft.domain.vo.Msg;
import com.example.arcsoft.service.FaceEngineTest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
;import static com.example.arcsoft.util.Base64ToPic.GenerateImage;

/**
 * @program: arcsoft
 * @description:
 * @author: QWS
 * @create: 2019-12-06 23:44
 */
@RestController
@RequestMapping("cloudDetection")
@CrossOrigin
public class FileDataController {
    private final
    FaceEngineTest faceEngineTest;

    public FileDataController(FaceEngineTest faceEngineTest) {
        this.faceEngineTest = faceEngineTest;
    }

    @PostMapping(value = "/SingleDetection")
    public Msg handleFileUpload(@RequestParam("file") String base64) throws IOException {
        System.out.println(base64);
      /*  File f = new File(this.getClass().getResource("").getPath());
        System.out.println(f);
        String path = String.valueOf(f);*/
        base64 = base64.substring(base64.indexOf(",") + 1);
        String path = "./1.jpg";
        System.out.println(GenerateImage(base64, path));;
        FaceInfoPO faceInfo = faceEngineTest.singleDetection(path);
        return Msg.statu200().add("FaceInfo", faceInfo);
    }

    /**
     * MultipartFile类型转File
     *
     * @param file(MultipartFile)
     * @reutrn File
     */
    private File convert1(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

}
