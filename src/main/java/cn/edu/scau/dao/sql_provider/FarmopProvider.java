package cn.edu.scau.dao.sql_provider;

import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.pojo.Farmop;
import cn.edu.scau.entities.vo.FarmopConditionVO;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class FarmopProvider {
    public String findFarmopByCondition(FarmopConditionVO farmopConditionVO){
        return new SQL(){
            {
                SELECT("farmop_id,area_id,tree_id,farmop_des,farmcate_name,farmop_time,opperson");
                FROM("farmop,farmcate");
                WHERE("farmop.farmcate_id=farmcate.farmcate_id");
                if (farmopConditionVO.getAreaId()>0){
                    WHERE("area_id="+farmopConditionVO.getAreaId());
                }
                if (farmopConditionVO.getTreeId()>0){
                    WHERE("tree_id="+farmopConditionVO.getTreeId());
                }
                if (farmopConditionVO.getFarmopDes() != "" && farmopConditionVO.getFarmopDes() != null){
                    WHERE("farmop_des="+"'"+farmopConditionVO.getFarmopDes()+"'");
                }
                if (farmopConditionVO.getFarmcateName() != "" && farmopConditionVO.getFarmcateName() != null){
                    WHERE("farmcate_name="+farmopConditionVO.getFarmcateName());
                }
                if(farmopConditionVO.getStartTime()!=null){
                    WHERE("farmop_time>" + farmopConditionVO.getStartTime());
                    if(farmopConditionVO.getEndTime()!=null) {
                        WHERE("farmop_time<" + farmopConditionVO.getEndTime());
                    }
                }else{
                    if(farmopConditionVO.getEndTime()!=null) {
                        WHERE("farmop_time<" + farmopConditionVO.getEndTime());
                    }
                }
                if(farmopConditionVO.getOpperson()!=null){
                    WHERE("opperson=" + farmopConditionVO.getOpperson());
                }
                WHERE("1=1");
            }
        }.toString();
    }

    public String addFarmops(List<Farmop> farmops) {
        String s = "insert into farmop(area_id,tree_id,farmop_des,farmcate_id,farmop_time,opperson) VALUES ";
        for(Farmop f:farmops){
            s+='('+f.getAreaId()+','+f.getTreeId()+','+"'"+f.getFarmopDes()+"'"+','+f.getFarmcateId()+','+"'"+f.getFarmopTime()+"'"+','+"'"+f.getOpperson()+"'"+')'+',';
        }
        s = s.substring(0, s.length() - 1);
        return s;
    }

    public String insertFarmopsForTree(List<Farmop> farmops) {
        String s = "insert into farmop(area_id,tree_id,farmop_des,farmcate_id,farmop_time,opperson) VALUES ";
        for(Farmop f:farmops){
            s+='('+String.valueOf(f.getAreaId())+','+String.valueOf(f.getTreeId())+','+"'"+f.getFarmopDes()+"'"+','+f.getFarmcateId()+','+"'"+f.getFarmopTime()+"'"+','+"'"+f.getOpperson()+"'"+')'+',';
        }
        s = s.substring(0, s.length() - 1);
        return s;
    }

    public String insertFarmopsForArea(List<Farmop> farmops) {
        String s = "insert into farmop(area_id,tree_id,farmop_des,farmcate_id,farmop_time,opperson) VALUES ";
        for(Farmop f:farmops){
            s+='('+String.valueOf(f.getAreaId())+','+String.valueOf(f.getTreeId())+','+"'"+f.getFarmopDes()+"'"+','+f.getFarmcateId()+','+"'"+f.getFarmopTime()+"'"+','+"'"+f.getOpperson()+"'"+')'+',';
        }
        s = s.substring(0, s.length() - 1);
        return s;
    }

    public String findOneFarmop(FarmopDTO farmopDTO){
        return new SQL(){
            {
                //INSERT_INTO("farmop(area_id,tree_id,farmop_des,farmcate_id,farmop_time,opperson) VALUES (#{areaId},#{treeId},#{farmopDes}, #{Db.farmopcate.get(farmcateName())},#{farmopTime},#{opperson})")

            }
        }.toString();
    }

    public String updateOneFarmop(Farmop farmop){
        return new SQL(){
            {
                UPDATE("farmop");
                SET("area_id=#{areaId},tree_id=#{treeId},farmop_des=#{farmopDes},farmcate_id=#{farmcateId},farmop_time=#{farmopTime},opperson=#{opperson}");
                WHERE("farmop_id=#{farmopId}");
            }
        }.toString();
    }

    public String deleteFarmop(List<Integer> ids){
        String s="(";
        for(Integer id:ids){
            s+=String.valueOf(id)+',';
        }
        s=s.substring(0,s.length()-1);
        s+=')';
        String finalS = s;
        return new SQL(){
            {

                DELETE_FROM("farmop");
                WHERE("farmop_id in"+ finalS);
            }
        }.toString();
    }
}
