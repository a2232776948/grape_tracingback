package cn.edu.scau.service;

import cn.edu.scau.entities.dto.LogisticsDTO;
import cn.edu.scau.entities.pojo.Logistics;

import java.util.List;

public interface LogisticsService {
    public List<Logistics> getAllLogisticsInfo();
    public void insertLogisticsInfo(List<LogisticsDTO> logisticsDTOS);
    public void deleteLogisticsInfo(int[] ids);
}
