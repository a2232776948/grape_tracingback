package cn.edu.scau.service;

import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.dto.PageDTO;
import cn.edu.scau.entities.pojo.Farmcate;
import cn.edu.scau.entities.vo.FarmopConditionVO;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.exception.NotFoundException;

import java.util.List;

public interface FarmopService {
    public List<Farmcate> getAllFarmCate();
    public List<FarmopDTO> getAllFarmop();
    public FarmopDTO getOneFarmopById(Integer id) throws GlobalException;
    public List<FarmopDTO> getFarmopByCondition(FarmopConditionVO farmopConditionVO) throws GlobalException;
    public boolean insertFarmops(List<FarmopDTO> farmopDTOs);
    public void insertFarmopsForArea(List<FarmopDTO> farmopDTOS);
    public void insertFarmopsForTree(List<FarmopDTO> farmopDTOS);
    public boolean insertOneFarmopForTree(FarmopDTO farmopDTO);
    public boolean deleteFarmop(List<Integer> ids);
    public boolean updataOneFarmop(FarmopDTO farmopDTO) throws NotFoundException;
    public boolean insertOneFarmopForArea(FarmopDTO f);
    public PageDTO<List<FarmopDTO>> getFarmopsPage(int pageNum, int pageSize);
    public PageDTO<List<FarmopDTO>> getFarmopsByConditionPage(FarmopConditionVO farmopConditionVO,int pageNum,int pageSize);

}
