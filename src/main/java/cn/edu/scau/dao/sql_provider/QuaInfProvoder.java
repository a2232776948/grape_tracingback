package cn.edu.scau.dao.sql_provider;

import cn.edu.scau.entities.dto.QuaInfDTO;
import cn.edu.scau.entities.pojo.QuaInf;
import org.apache.ibatis.jdbc.SQL;

public class QuaInfProvoder {
    public String insertQuaInf(QuaInf quaInf){
        String value="";
        if(quaInf.getQrcodeId() != null && quaInf.getQrcodeId() != ""){
           value+="'"+quaInf.getQrcodeId()+"'"+',';
        }
        if(quaInf.getTreeId() != 0){
            value+=String.valueOf(quaInf.getTreeId())+',';
        }
        if(quaInf.getAreaId()!= 0){
            value+=String.valueOf(quaInf.getAreaId())+',';
        }
        if(quaInf.getImageName()!= null && quaInf.getImageName() != ""){
            value+="'"+quaInf.getImageName()+"'"+',';
        }
        if(quaInf.getInf()!= null && quaInf.getInf() != ""){
            value+="'"+quaInf.getInf()+"'"+',';
        }
        value=value.substring(0,value.length()-1);
        String finalValue = value;
        return new SQL(){
            {
                INSERT_INTO("quainf");
                if(quaInf.getQrcodeId() != null && quaInf.getQrcodeId() !=""){
                    INTO_COLUMNS("qrcode_id");
                }
                if(quaInf.getTreeId() != 0){
                    INTO_COLUMNS("tree_id");
                }
                if(quaInf.getAreaId()!= 0){
                    INTO_COLUMNS("area_id");
                }
                if(quaInf.getImageName()!= null && quaInf.getImageName() !=""){
                   INTO_COLUMNS("image_name");
                }
                if(quaInf.getInf()!= null && quaInf.getInf()!=""){
                   INTO_COLUMNS("inf");
                }
                INTO_VALUES(finalValue);
            }
        }.toString();
    }
}
