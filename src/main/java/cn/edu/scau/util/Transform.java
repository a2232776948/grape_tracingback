package cn.edu.scau.util;

import cn.edu.scau.entities.dto.QrcodeDTO;
import cn.edu.scau.entities.dto.QuaInfDTO;
import cn.edu.scau.entities.pojo.Qrcode;
import cn.edu.scau.entities.pojo.QuaInf;

public class Transform {
    public static Qrcode qrDTOtoQr(QrcodeDTO qrcodeDTO){
        String date = qrcodeDTO.getDate().replace("-","");
        String areaId = String.valueOf(qrcodeDTO.getAreaId());
        String treeId = String.valueOf(qrcodeDTO.getTreeId());
        return new Qrcode(date+areaId+treeId);
    }

    public static QuaInf quainfDTOtoQuainf(QuaInfDTO quaInfDTO){
        return new QuaInf();
    }

}
