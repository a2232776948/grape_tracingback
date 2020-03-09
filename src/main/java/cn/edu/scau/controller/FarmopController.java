package cn.edu.scau.controller;

import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.vo.Response;
import cn.edu.scau.service.impl.FarmopServiceImpl;
import cn.edu.scau.util.ResponseUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class FarmopController {
    @Autowired
    private  FarmopServiceImpl farmopService;
    @RequestMapping(value = "getAllFarmop",method = RequestMethod.GET)
    public Response getAllFarmop(){
        List<FarmopDTO> allFarmop = farmopService.getAllFarmop();
        return ResponseUtil.success(allFarmop);
    }

    @RequestMapping(value = "getAllFarmop1",method = RequestMethod.GET)
    FarmopDTO getAllFarmop1(FarmopDTO farmopDTO){
        farmopDTO.setAreaId(1);
        return farmopDTO;
    }
}
