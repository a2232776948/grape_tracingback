package cn.edu.scau.service.impl;

import cn.edu.scau.dao.FarmopDao;
import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.pojo.Farmop;
import cn.edu.scau.entities.vo.Result;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.exception.NotFoundException;
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

    @Override
    public FarmopDTO getOneFarmopById(Integer id) throws GlobalException {
        FarmopDTO farmop = farmopDao.findOneFarmopById(id);
        if(farmop == null){
            throw new NotFoundException("农事操作"+id+"不存在", Result.ErrorCode.NOT_FOUND.getCode());
        }
        return farmopDao.findOneFarmopById(id);
    }
}
