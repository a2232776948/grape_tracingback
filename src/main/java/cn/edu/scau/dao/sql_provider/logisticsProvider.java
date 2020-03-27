package cn.edu.scau.dao.sql_provider;

import cn.edu.scau.entities.dto.LogisticsDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class logisticsProvider {
    public String insertLogisticses(List<LogisticsDTO> logisticsDTOS){
        String SQL;
        String s = "";
        for(LogisticsDTO l:logisticsDTOS){
            s+="('"+l.getQrcodeId()+"',"+"'"+l.getTime()+"',"+"'"+l.getDescri()+"'),";
        }
        s = s.substring(0,s.length()-1);
        SQL="insert into logistics (qrcode_id,time,descri) values "+s;
        return SQL;
    }

    public String deleteLogisticsInfo(int ids[]){
        String s="(",SQL;
        for(int id:ids){
            s+=String.valueOf(id)+",";
        }
        s=s.substring(0,s.length()-1);
        s+=")";
        SQL = "delete from logistics where logistics_id in "+s;
        return SQL;
    }
}
