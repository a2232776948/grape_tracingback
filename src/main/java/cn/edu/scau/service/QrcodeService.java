package cn.edu.scau.service;

import cn.edu.scau.entities.dto.PageDTO;
import cn.edu.scau.entities.dto.QrcodeCSDTO;
import cn.edu.scau.entities.dto.QrcodeDTO;
import cn.edu.scau.entities.pojo.Qrcode;
import cn.edu.scau.entities.vo.QrcodeVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QrcodeService {
    public void insertQrcodes(List<QrcodeVO> qrcodeVO);
    public void insertOneQrcode(QrcodeVO qrcodeVO);
    public void deleteQrcode(List<QrcodeDTO> qrcodeDTOS);

    public PageDTO<List<QrcodeDTO>> getQrcodePage(int pageNum, int pageSize);
    public PageDTO<List<QrcodeDTO>> getQrcodeCSPage(int pageNum, int pageSize,QrcodeCSDTO qrcodeCSDTO);
    public List<QrcodeDTO> getAllQrcode();
}
