package cn.edu.scau.controller;

import cn.edu.scau.entities.dto.AmountDTO;
import cn.edu.scau.entities.pojo.Amount;
import cn.edu.scau.entities.vo.AmountConditionVO;
import cn.edu.scau.entities.vo.Response;
import cn.edu.scau.service.impl.AmountServiceImpl;
import cn.edu.scau.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags="地块采摘量接口")
public class AmountController {

    @Autowired
    private AmountServiceImpl amountService;

    @ApiOperation("添加采摘量")
    @RequestMapping(value = "/insertAmounts", method = RequestMethod.POST)
    public Response insertAmounts(@RequestBody List<AmountDTO> amountDTOs){
        amountService.insertAmounts(amountDTOs);
        return ResponseUtil.success("添加成功");
    }

    @ApiOperation("按条件查找采摘量")
    @RequestMapping(value = "/getAmountsByCondition",method = RequestMethod.POST)
    public Response<List<Amount>> getAmountsByCondition(@RequestBody AmountConditionVO amountConditionVO){
        List<Amount> amountsByCondition = amountService.getAmountsByCondition(amountConditionVO);
        return ResponseUtil.success(amountsByCondition);
    }
}
