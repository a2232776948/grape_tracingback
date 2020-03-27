package cn.edu.scau.service.impl;

import cn.edu.scau.dao.AreaAndTreeDao;
import cn.edu.scau.entities.dto.AreaDTO;
import cn.edu.scau.entities.dto.TreeForAreaDTO;
import cn.edu.scau.entities.pojo.Area;
import cn.edu.scau.entities.pojo.Tree;
import cn.edu.scau.entities.pojo.TreeCate;
import cn.edu.scau.entities.vo.AreaVO;
import cn.edu.scau.service.AreaAndTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaAndTreeServiceImpl implements AreaAndTreeService {
    @Autowired
    AreaAndTreeDao areaAndTreeDao;
    @Override
    public List<Integer> findAllArea() {
        return areaAndTreeDao.findAllArea();
    }

    public void addArea(AreaDTO areaDTO){
        areaAndTreeDao.addArea(areaDTO);
    }

    @Override
    public void updateAreaName(Area area) {
        areaAndTreeDao.updateAreaName(area);
    }

    @Override
    public List<Tree> getAllTreeByAreaId(int areaId) {
        return areaAndTreeDao.getAllTreeByAreaId(areaId);
    }

    @Override
    public void addTreeForArea(List<TreeForAreaDTO> trees,int areaId) {
        int lastTreeIdByAreaId = areaAndTreeDao.findLastTreeIdByAreaId(areaId);
        List<Tree> treesToDb = new ArrayList<Tree>();
        int end = trees.size();
        int i=lastTreeIdByAreaId+1;
        for(TreeForAreaDTO tree:trees){
            treesToDb.add(new Tree(areaId,i,tree.getTreeCate(),tree.getPlantDate(),tree.getTreeState()));
            i++;
        }
        areaAndTreeDao.addTreeForArea(treesToDb);
    }

    @Override
    public List<TreeCate> getAllTreeCate() {
        return areaAndTreeDao.getAllTreeCate();
    }

    @Override
    public void addTreeCate(String treeCate) {
        areaAndTreeDao.addTreeCate(treeCate);
    }

    @Override
    public void deleteTreeCate(int id) {
        areaAndTreeDao.deleteTreeCate(id);
    }

    @Override
    public List<AreaVO> getAllAreaVO() {
        return areaAndTreeDao.getAllAreaVO();
    }
}

