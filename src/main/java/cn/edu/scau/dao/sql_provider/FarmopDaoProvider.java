package cn.edu.scau.dao.sql_provider;

import org.apache.ibatis.jdbc.SQL;

public class FarmopDaoProvider {
    String getDTOFarmop(){
        return new SQL(){

        }.toString();
    }
}
