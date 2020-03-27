package cn.edu.scau.service.impl;

import cn.edu.scau.constent.Qr;
import cn.edu.scau.dao.FarmopDao;
import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.dto.PageDTO;
import cn.edu.scau.entities.pojo.Farmcate;
import cn.edu.scau.entities.pojo.Farmop;
import cn.edu.scau.entities.vo.FarmopConditionVO;
import cn.edu.scau.entities.vo.Result;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.exception.NotFoundException;
import cn.edu.scau.service.FarmopService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmopServiceImpl implements FarmopService {
    @Autowired
    private FarmopDao farmopDao;

    public List<Farmcate> getAllFarmCate(){
        return farmopDao.getAllFarmCate();
    }

    @Override
    public List<FarmopDTO> getAllFarmop() {
        List<FarmopDTO> allFarmop = farmopDao.findDTOAllFarmop();
        return allFarmop;
    }

    @Override
    public FarmopDTO getOneFarmopById(Integer id) throws GlobalException {
        FarmopDTO farmop = farmopDao.findOneFarmopById(id);
        if(farmop == null){
            throw new NotFoundException("农事操作"+id+"不存在", Result.ErrorCode.NOT_FOUND.getCode());
        }
        return farmopDao.findOneFarmopById(id);
    }

    @Override
    public List<FarmopDTO> getFarmopByCondition(FarmopConditionVO farmopConditionVO) throws GlobalException {
        List<FarmopDTO> farmopByCondition = farmopDao.findFarmopByCondition(farmopConditionVO);
        return farmopByCondition;
    }

    @Override
    public boolean insertFarmops(List<FarmopDTO> farmopDTOs) {
        List<Farmop> farmops = new ArrayList<Farmop>();
        for(FarmopDTO f: farmopDTOs){
            //Long cate = Db.ntoi(f.getFarmcateName());
            farmops.add(new Farmop(f.getAreaId(),f.getTreeId(),f.getFarmopDes(),f.getFarmcateId(),f.getFarmopTime(),f.getOpperson()));
        }
        farmopDao.addFarmops(farmops);
        return true;
    }

    @Override
    public void insertFarmopsForArea(List<FarmopDTO> farmopDTOs) {
        List<Farmop> farmops = new ArrayList<Farmop>();
        for(FarmopDTO f: farmopDTOs){
            //Long cate = Db.ntoi(f.getFarmcateName());
            Farmop farmop = new Farmop(f.getAreaId(), Qr.symbolOnlyTreeFarmOp,f.getFarmopDes(),f.getFarmcateId(),f.getFarmopTime(),f.getOpperson());
            farmops.add(farmop);
        }
        farmopDao.insertFarmopsForArea(farmops);
    }

    @Override
    public void insertFarmopsForTree(List<FarmopDTO> farmopDTOs) {
        List<Farmop> farmops = new ArrayList<Farmop>();
        for(FarmopDTO f: farmopDTOs){
            //Long cate = Db.ntoi(f.getFarmcateName());
            Farmop farmop = new Farmop(f.getAreaId(), f.getTreeId(),f.getFarmopDes(),f.getFarmcateId(),f.getFarmopTime(),f.getOpperson());
            farmops.add(farmop);
        }
        farmopDao.insertFarmopsForTree(farmops);
    }

    @Override
    public boolean insertOneFarmopForTree(FarmopDTO f) {
        //Long cate = Db.ntoi(f.getFarmcateName());
        Farmop farmop = new Farmop(f.getAreaId(),f.getTreeId(),f.getFarmopDes(),f.getFarmcateId(),f.getFarmopTime(),f.getOpperson());
        farmopDao.insertOneFarmop(farmop);
        return true;
    }

    @Override
    public boolean insertOneFarmopForArea(FarmopDTO f){
        //Long cate = Db.ntoi(f.getFarmcateName());
        Farmop farmop = new Farmop(f.getAreaId(), Qr.symbolOnlyTreeFarmOp,f.getFarmopDes(),f.getFarmcateId(),f.getFarmopTime(),f.getOpperson());
        farmopDao.insertOneFarmop(farmop);
        return true;
    }

    @Override
    public boolean deleteFarmop(List<Integer> ids) {
        farmopDao.deleteFarmop(ids);
        return true;
    }

    @Override
    public boolean updataOneFarmop(FarmopDTO f) throws NotFoundException {
        //Long cate = Db.ntoi(f.getFarmcateName());
        Farmop farmop = new Farmop(f.getFarmopId(),f.getAreaId(),f.getTreeId(),f.getFarmopDes(),f.getFarmcateId(),f.getFarmopTime(),f.getOpperson());
        FarmopDTO farmop1 = farmopDao.findOneFarmopById((int) f.getFarmopId());
        if(farmop1==null){
            throw new NotFoundException("farmopId"+f.getFarmopId()+"不存在",40401);
        }
        farmopDao.updateOneFarmop(farmop);
        return true;
    }

    public PageDTO<List<FarmopDTO>> getFarmopsPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<FarmopDTO> farmopDTOS = new ArrayList<>();
        farmopDTOS = farmopDao.findDTOAllFarmop();
        int count = farmopDTOS.size();
        PageDTO<List<FarmopDTO>> pageDTO = new PageDTO<>(pageNum, pageSize, count, farmopDTOS);
        return pageDTO;
    }

    public PageDTO<List<FarmopDTO>> getFarmopsByConditionPage(FarmopConditionVO farmopConditionVO,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<FarmopDTO> farmopDTOS = new ArrayList<>();
        farmopDTOS = farmopDao.findFarmopByCondition(farmopConditionVO);
        int count = farmopDTOS.size();
        PageDTO<List<FarmopDTO>> pageDTO = new PageDTO<>(pageNum, pageSize, count, farmopDTOS);
        return pageDTO;
    }


}
