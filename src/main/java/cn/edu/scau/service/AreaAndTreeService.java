package cn.edu.scau.service;

import cn.edu.scau.entities.dto.AreaDTO;
import cn.edu.scau.entities.dto.TreeForAreaDTO;
import cn.edu.scau.entities.pojo.Area;
import cn.edu.scau.entities.pojo.Tree;
import cn.edu.scau.entities.pojo.TreeCate;
import cn.edu.scau.entities.vo.AreaVO;

import java.util.List;

public interface AreaAndTreeService {
    List<Integer> findAllArea();
    public void addArea(AreaDTO areaDTO);
    public void updateAreaName(Area area);
    public List<Tree> getAllTreeByAreaId(int areaId);
    public void addTreeForArea(List<TreeForAreaDTO> trees,int areaId);
    public List<TreeCate> getAllTreeCate();
    public void addTreeCate(String treeCate);
    public void deleteTreeCate(int id);
    public List<AreaVO> getAllAreaVO();
}
