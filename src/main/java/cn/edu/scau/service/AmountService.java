package cn.edu.scau.service;

import cn.edu.scau.entities.dto.AmountDTO;
import cn.edu.scau.entities.pojo.Amount;
import cn.edu.scau.entities.vo.AmountConditionVO;

import java.util.List;

public interface AmountService {
    public void insertAmounts(List<AmountDTO> amountDTOs);
    public List<Amount> getAmountsByCondition(AmountConditionVO amountConditionVOS);
}
