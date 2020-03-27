package cn.edu.scau.dao.sql_provider;

import cn.edu.scau.entities.pojo.Tree;

import java.util.List;

public class AreaAndTreeProvider {

    public String addTreeForArea(List<Tree> trees){
        String sql="insert into tree(area_id,tree_id,tree_cate,plant_date,tree_state) values";
        for(Tree tree :trees){
            sql+="("+String.valueOf(tree.getAreaId())+","+String.valueOf(tree.getTreeId())+",'"+tree.getTreeCate()+"','"+tree.getPlantDate()
                    +"','"+tree.getTreeState()+"'),";
        }
        sql=sql.substring(0,sql.length()-1);
        return sql;
    }
}
