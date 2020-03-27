package cn.edu.scau.service.impl;

import cn.edu.scau.dao.LogisticsDao;
import cn.edu.scau.entities.dto.LogisticsDTO;
import cn.edu.scau.entities.pojo.Logistics;
import cn.edu.scau.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogisticsServiceImpl implements LogisticsService {
    @Autowired
    LogisticsDao logisticsDao;
    @Override
    public List<Logistics> getAllLogisticsInfo() {
        return logisticsDao.getAllLogisticsInfo();
    }

    @Override
    public void insertLogisticsInfo(List<LogisticsDTO> logisticsDTOS) {
        logisticsDao.insertLogisticses(logisticsDTOS);
    }

    @Override
    public void deleteLogisticsInfo(int[] ids) {
        logisticsDao.deleteLogisticsInfo(ids);
    }
}
