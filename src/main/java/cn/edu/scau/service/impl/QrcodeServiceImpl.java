package cn.edu.scau.service.impl;

import cn.edu.scau.constent.Qr;
import cn.edu.scau.dao.QrcodeDao;
import cn.edu.scau.entities.dto.PageDTO;
import cn.edu.scau.entities.dto.QrcodeCSDTO;
import cn.edu.scau.entities.dto.QrcodeDTO;
import cn.edu.scau.entities.pojo.Qrcode;
import cn.edu.scau.entities.vo.QrcodeVO;
import cn.edu.scau.service.QrcodeService;
import cn.edu.scau.util.Transform;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QrcodeServiceImpl implements QrcodeService {
    @Autowired
    QrcodeDao qrcodeDao;
    @Override
    public void insertQrcodes(List<QrcodeVO> qrcodeVO) {
        for(QrcodeVO q:qrcodeVO){
            String dateAT = q.getDateAT();
            if(qrcodeDao.findLastQrcode(dateAT) != "" && qrcodeDao.findLastQrcode(dateAT) !=null){
                String lastOrder = qrcodeDao.findLastQrcode(dateAT);
                lastOrder = lastOrder.substring(lastOrder.length()-2,lastOrder.length());
                lastOrder = Qr.numTransFormat(lastOrder,"000",1);
                Qrcode qrcode = new Qrcode(dateAT+lastOrder);
                qrcodeDao.insertOneQrcode(qrcode);
            }else{
                Qrcode qrcode = new Qrcode(dateAT+"001");
                qrcodeDao.insertOneQrcode(qrcode);
            }
        }
        //String lastDate = qrcodeDao.findLastQrcode(qrcodeDTOS.get);
        //qrcodeDao.insertQrcode();
    }

    @Override
    public void insertOneQrcode(QrcodeVO q) {
        String dateAT = q.getDateAT();

        if(qrcodeDao.findLastQrcode(dateAT) == null || qrcodeDao.findLastQrcode(dateAT).equals("")){
            Qrcode qrcode = new Qrcode(dateAT+"001");
            qrcodeDao.insertOneQrcode(qrcode);
        }else{
            String lastOrder = qrcodeDao.findLastQrcode(dateAT);
            lastOrder = lastOrder.substring(lastOrder.length()-2,lastOrder.length());
            lastOrder = Qr.numTransFormat(lastOrder,"000",1);
            Qrcode qrcode = new Qrcode(dateAT+lastOrder);
            qrcodeDao.insertOneQrcode(qrcode);
        }
    }

    @Override
    public void deleteQrcode(List<QrcodeDTO> qrcodeDTOS) {
        List<String> s = new ArrayList<String>();
        for(QrcodeDTO q:qrcodeDTOS){
            String dateAT = q.getQrcodeId();
            s.add(dateAT);
        }
        qrcodeDao.deleteQrcode(s);
    }


    public PageDTO<List<QrcodeDTO>> getQrcodePage(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<QrcodeDTO> qrcodeDTOS = new ArrayList<QrcodeDTO>();
        List<String> qrcodeIds = qrcodeDao.findAllQrcodeId();
        for(String q:qrcodeIds){
            qrcodeDTOS.add(new QrcodeDTO(q,Integer.parseInt(q.substring(8,10)),Integer.parseInt(q.substring(10,12)),q.substring(0,8)));
        }
        int count = qrcodeIds.size();
        PageDTO<List<QrcodeDTO>> pageDTO = new PageDTO<>(pageNum,pageSize,count,qrcodeDTOS);
        return pageDTO;
    }

    @Override
    public PageDTO<List<QrcodeDTO>> getQrcodeCSPage(int pageNum, int pageSize, QrcodeCSDTO qrcodeCSDTO) {
        PageHelper.startPage(pageNum,pageSize);
        List<QrcodeDTO> qrcodeDTOS = new ArrayList<QrcodeDTO>();
        List<String> qrcodeIds = qrcodeDao.findQrcodeIdsByCondition(qrcodeCSDTO);
        for(String q:qrcodeIds){
            qrcodeDTOS.add(new QrcodeDTO(q,Integer.parseInt(q.substring(8,10)),Integer.parseInt(q.substring(10,12)),q.substring(0,8)));
        }
        int count = qrcodeIds.size();
        PageDTO<List<QrcodeDTO>> pageDTO = new PageDTO<>(pageNum,pageSize,count,qrcodeDTOS);
        return pageDTO;
    }

    @Override
    public List<QrcodeDTO> getAllQrcode() {
        return qrcodeDao.getAllQrcode();
    }


}
