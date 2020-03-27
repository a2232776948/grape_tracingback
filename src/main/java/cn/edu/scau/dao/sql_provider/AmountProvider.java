package cn.edu.scau.dao.sql_provider;

import cn.edu.scau.entities.dto.AmountDTO;
import cn.edu.scau.entities.pojo.Amount;
import cn.edu.scau.entities.vo.AmountConditionVO;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class AmountProvider {
    public String insertAmounts(List<AmountDTO> amountDTOs) {
        String sql = "insert into amount(area_id,amount,year,month) values ";
        for(AmountDTO amountDTO:amountDTOs){
            sql+='('+String.valueOf(amountDTO.getAreaId())+','+String.valueOf(amountDTO.getAmount())+','+amountDTO.getYear()+','+amountDTO.getMonth()+"),";
        }
        sql=sql.substring(0,sql.length()-1);
        return sql;
    }

    public String getAmountsByCondition(AmountConditionVO amountConditionVO){
        return new SQL(){
            {
                SELECT("*");
                FROM("amount");
                if(amountConditionVO.getAreaId() !=0 && amountConditionVO.getAreaId()!=null){
                    WHERE("area_id="+String.valueOf(amountConditionVO.getAreaId()));
                }
                if(amountConditionVO.getYear() !=0 && amountConditionVO.getYear()!=null){
                    WHERE("year="+String.valueOf(amountConditionVO.getYear()));
                }
                if(amountConditionVO.getMonth() !=0 && amountConditionVO.getMonth()!=null){
                    WHERE("month="+String.valueOf(amountConditionVO.getMonth()));
                }
                WHERE("1=1");
            }
        }.toString();
    }
}
