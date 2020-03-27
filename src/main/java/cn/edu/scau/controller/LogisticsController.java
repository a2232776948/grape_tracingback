package cn.edu.scau.controller;

import cn.edu.scau.entities.dto.LogisticsDTO;
import cn.edu.scau.entities.pojo.Logistics;
import cn.edu.scau.entities.vo.Response;
import cn.edu.scau.service.impl.LogisticsServiceImpl;
import cn.edu.scau.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logistics")
@Api(tags = "物流接口")
public class LogisticsController {
    @Autowired
    LogisticsServiceImpl logisticsService;

    @ApiOperation(value = "获取所有物流信息")
    @RequestMapping(value = "/getAllLogisticsInfo",method = RequestMethod.GET)
    public Response<List<Logistics>> getAllLogisticsInfo(){
        return ResponseUtil.success(logisticsService.getAllLogisticsInfo());
    }

    @ApiOperation(value = "插入物流信息，一条或多条")
    @RequestMapping(value = "insertLogisticsInfo",method = RequestMethod.POST)
    public Response insertLogisticsInfo(@RequestBody List<LogisticsDTO> logisticsDTOS){
        logisticsService.insertLogisticsInfo(logisticsDTOS);
        return ResponseUtil.success("添加成功");
    }

    @ApiOperation(value = "删除物流信息，一个或多个")
    @ApiParam(value = "物流ID",name = "ids")
    @RequestMapping(value = "/deleteLogisticsInfo",method = RequestMethod.POST)
    public Response deleteLogisticsInfo(@RequestBody int[] ids){
        logisticsService.deleteLogisticsInfo(ids);
        return ResponseUtil.success("删除成功");
    }

}
