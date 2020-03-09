package cn.edu.scau.service.impl;

import cn.edu.scau.dao.FarmopDao;
import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.pojo.Farmop;
import cn.edu.scau.service.FarmopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmopServiceImpl implements FarmopService {
    @Autowired
    private FarmopDao farmopDao;
    @Override
    public List<FarmopDTO> getAllFarmop() {
        List<FarmopDTO> allFarmop = farmopDao.findDTOAllFarmop();

        return allFarmop;
    }
}
