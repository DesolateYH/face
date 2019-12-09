package com.example.arcsoft.domain.po;

import lombok.Data;

/**
 * @program: arcsoft
 * @description:
 * @author: QWS
 * @create: 2019-12-07 22:07
 */
@Data
public class FaceInfoPO {
    /*
     * 性别：0男生，1女生
     */
    int gender;
    int age;
    String angleFor3D;
    int livenessCode;
    int livenessIr;

}
