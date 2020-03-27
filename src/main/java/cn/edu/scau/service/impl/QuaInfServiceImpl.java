package cn.edu.scau.service.impl;

import cn.edu.scau.constent.Qr;
import cn.edu.scau.dao.QuaInfDao;
import cn.edu.scau.entities.dto.QuaInfDTO;
import cn.edu.scau.entities.pojo.QuaInf;
import cn.edu.scau.entities.vo.Result;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.exception.RequestException;
import cn.edu.scau.service.QuaInfService;
import cn.edu.scau.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class QuaInfServiceImpl implements QuaInfService {
    @Autowired
    private QuaInfDao quaInfDao;
    @Override
    public void addQuaInf(QuaInfDTO q) throws Exception {
        String picName,proPath;
        QuaInf quainf = new QuaInf();
        if(q.getTreeId() != 0){
            quainf.setTreeId(q.getTreeId());
            proPath = Qr.treeImagePath;
            picName = Qr.longToStringFormat(q.getTreeId(),"00");
        }else if(q.getAreaId() !=0){
            quainf.setAreaId(q.getAreaId());
            proPath = Qr.areaImagePath;
            picName = Qr.longToStringFormat(q.getAreaId(),"00");
        }else if(q.getQrcodeId() != null && q.getQrcodeId() != ""){
            quainf.setQrcodeId(q.getQrcodeId());
            proPath = Qr.qrcodeImagePath;
            picName = q.getQrcodeId();
        }else{
            throw new RequestException("地块号、树号、二维码至少要有一个", Result.ErrorCode.PARAM_ERROR.getCode());
        }

        picName+="_"+String.valueOf(new Date().getTime());

        if(q.getQuaInf() != null && q.getQuaInf() != ""){
            quainf.setInf(q.getQuaInf());
        }
        quainf.setImageName(proPath+'/'+picName+".jpg");
        //ImageUtil.saveImage(q.getImage(),proPath,picName);
        quaInfDao.insertQuaInf(quainf);
    }

    @Override
    public void setQuaInfImageName(String quaInfImageName) {
        long lastQuaInfId = quaInfDao.findLastQuaInfId();
        quaInfDao.setQuaInfImageName(quaInfImageName,lastQuaInfId);
    }

    @Override
    public String findLastImageName() {
        return quaInfDao.findLastImageName();
    }

    @Override
    public void deleteOneQuaInf(int quaInfId) {
        quaInfDao.deleteOneQuaInf(quaInfId);
    }


}
