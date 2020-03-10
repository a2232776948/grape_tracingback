package cn.edu.scau.service;

import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.exception.NotFoundException;

import java.util.List;

public interface FarmopService {
    List<FarmopDTO> getAllFarmop();
    FarmopDTO getOneFarmopById(Integer id) throws NotFoundException, GlobalException;
}
