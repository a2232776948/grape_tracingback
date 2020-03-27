package cn.edu.scau.service.impl;

import cn.edu.scau.dao.AmountDao;
import cn.edu.scau.entities.dto.AmountDTO;
import cn.edu.scau.entities.pojo.Amount;
import cn.edu.scau.entities.vo.AmountConditionVO;
import cn.edu.scau.service.AmountService;
import cn.edu.scau.service.AreaAndTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmountServiceImpl implements AmountService {
    @Autowired
    private AmountDao amountDao;
    @Override
    public void insertAmounts(List<AmountDTO> amountDTOs) {
        amountDao.insertAmounts(amountDTOs);
    }

    @Override
    public List<Amount> getAmountsByCondition(AmountConditionVO amountConditionVO) {
        return amountDao.getAmountsByCondition(amountConditionVO);
    }


}
