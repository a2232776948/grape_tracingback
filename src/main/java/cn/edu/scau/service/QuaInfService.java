package cn.edu.scau.service;

import cn.edu.scau.entities.dto.QuaInfDTO;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.exception.RequestException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QuaInfService {
    public void addQuaInf(QuaInfDTO quaInfDTO) throws Exception;
    public void setQuaInfImageName(String quaInfImageName);
    public String findLastImageName();
    public void deleteOneQuaInf(int quaInfId);
}
