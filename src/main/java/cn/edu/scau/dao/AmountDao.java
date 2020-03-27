package cn.edu.scau.dao;

import cn.edu.scau.dao.sql_provider.AmountProvider;
import cn.edu.scau.entities.dto.AmountDTO;
import cn.edu.scau.entities.pojo.Amount;
import cn.edu.scau.entities.vo.AmountConditionVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AmountDao {
    @InsertProvider(type = AmountProvider.class,method = "insertAmounts")
    public void insertAmounts(@Param("amountDTOs") List<AmountDTO> amountDTOs);

    @SelectProvider(type = AmountProvider.class, method = "getAmountsByCondition")
    public List<Amount> getAmountsByCondition(@Param("amountConditionVO") AmountConditionVO amountConditionVO);
}
