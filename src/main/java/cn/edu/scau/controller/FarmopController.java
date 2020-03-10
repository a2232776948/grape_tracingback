package cn.edu.scau.controller;

import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.vo.Response;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.exception.NotFoundException;
import cn.edu.scau.service.impl.FarmopServiceImpl;
import cn.edu.scau.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class FarmopController {
    @Autowired
    private  FarmopServiceImpl farmopService;

    @RequestMapping(value = "getAllFarmop",method = RequestMethod.GET)
    @ApiOperation(value="获取所有农事操作记录")

    public Response getAllFarmop(){
        List<FarmopDTO> allFarmop = farmopService.getAllFarmop();
        return ResponseUtil.success(allFarmop);
    }

    @RequestMapping(value = "getAllFarmop1",method = RequestMethod.GET)
    FarmopDTO getAllFarmop1(FarmopDTO farmopDTO){
        farmopDTO.setAreaId(1);
        return farmopDTO;
    }
    @RequestMapping(value = "getAllFarmop2",method = RequestMethod.GET)
    List<FarmopDTO> getAllFarmop2(){
        List<FarmopDTO> allFarmop = farmopService.getAllFarmop();
        return allFarmop;
    }

    @RequestMapping(value = "getOneFarmop/{id}",method = RequestMethod.GET)
    FarmopDTO getOneFarmop(@PathVariable("id") Integer id) throws GlobalException {
        FarmopDTO oneFarmop = farmopService.getOneFarmopById(id);
        return oneFarmop;
    }
}
