package cn.edu.scau.controller;

import cn.edu.scau.constent.Qr;
import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.dto.PageDTO;
import cn.edu.scau.entities.dto.QrcodeDTO;
import cn.edu.scau.entities.pojo.Farmcate;
import cn.edu.scau.entities.pojo.Farmop;
import cn.edu.scau.entities.vo.FarmopConditionVO;
import cn.edu.scau.entities.vo.Response;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.exception.NotFoundException;
import cn.edu.scau.service.impl.FarmopServiceImpl;
import cn.edu.scau.util.ResponseUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/farmop")
@Api(tags = "农事操作接口")
public class FarmopController {
    @Autowired
    private  FarmopServiceImpl farmopService;

    @ApiOperation(value = "获取所有农事操作分类")
    @RequestMapping(value = "/getAllFarmCate",method = RequestMethod.GET)
    public Response<List<Farmcate>> getAllFarmCate(){
        return ResponseUtil.success(farmopService.getAllFarmCate());
    }

    @RequestMapping(value = "/getAllFarmop",method = RequestMethod.GET)
    @ApiOperation(value="获取所有农事操作记录",notes = "若treeId=10000,则说明这条农事记录是地块的农事记录")
    public Response<List<FarmopDTO>> getAllFarmop(){
        List<FarmopDTO> allFarmop = farmopService.getAllFarmop();
        return ResponseUtil.success(allFarmop);
    }

    @ApiOperation("获取农事操作分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码",name="pageNum",required = true),
            @ApiImplicitParam(value = "每页显示条数",name="pageSize",required = true)
    })
    @RequestMapping(value = "/getFarmopsPage",method = RequestMethod.GET)
    public Response<PageDTO> getFarmopsPage(int pageNum, int pageSize){
        PageDTO<List<FarmopDTO>> pageDTO = farmopService.getFarmopsPage(pageNum, pageSize);
        return ResponseUtil.success(pageDTO);
    }

    @ApiOperation("根据条件获取农事操作分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码",name="pageNum",required = true),
            @ApiImplicitParam(value = "每页显示条数",name="pageSize",required = true)
    })
    @RequestMapping(value = "/getFarmopsByConditionPage",method = RequestMethod.GET)
    public Response<PageDTO> getFarmopsByConditionPage(FarmopConditionVO farmopConditionVO,int pageNum, int pageSize){
        PageDTO<List<FarmopDTO>> pageDTO = farmopService.getFarmopsByConditionPage(farmopConditionVO,pageNum, pageSize);
        return ResponseUtil.success(pageDTO);
    }


    @RequestMapping(value = "/getFarmopByCondition",method = RequestMethod.GET)
    @ApiOperation(value = "根据条件查找农事操作")
    Response<List<FarmopDTO>> getFarmopByCondition(FarmopConditionVO farmopConditionVO) throws GlobalException {
        List<FarmopDTO> farmopByCondition = farmopService.getFarmopByCondition(farmopConditionVO);
//        if(farmopConditionVO.getTreeId()==0 && farmopConditionVO.getAreaId()!=0){
//            List<FarmopDTO> farmopDTOS = new ArrayList<FarmopDTO>();
//            for(FarmopDTO f:farmopByCondition){
//                if(f.getTreeId() == Qr.symbolOnlyTreeFarmOp){
//                    farmopDTOS.add(f);
//                }
//            }
//            return ResponseUtil.success(farmopDTOS);
//        }
        return ResponseUtil.success(farmopByCondition);
    }

    @ApiOperation(value="获取一项农事操作记录")
   // @ApiImplicitParam(paramType = "path", dataType = "int", name = "id", value = "农事操作id", required = true)
    @ApiResponses(@ApiResponse(code = 40401, message = "指定id的农事操作不存在"))
    @RequestMapping(value = "/getOneFarmop",method = RequestMethod.GET)
    Response<FarmopDTO> getOneFarmop(Integer id) throws GlobalException {
        FarmopDTO oneFarmop = farmopService.getOneFarmopById(id);
        return ResponseUtil.success(oneFarmop);
    }

    @ApiOperation(value="为树插入一项农事操作记录",notes = "areaId、tree_Id、farmcateName为必填项")
    @RequestMapping(value = "/insertOneFarmopForTree",method = RequestMethod.POST)
    Response insertOneFarmopForTree(@RequestBody FarmopDTO farmopDTO){
        farmopService.insertOneFarmopForTree(farmopDTO);
        return ResponseUtil.success("插入成功");
    }

    @ApiOperation(value="为地块插入一项农事操作记录",notes = "areaId、farmcateName为必填项，tree_Id填0")
    @RequestMapping(value = "insertOneFarmopForArea",method = RequestMethod.POST)
    Response insertOneFarmopForArea(@RequestBody FarmopDTO farmopDTO){
        farmopService.insertOneFarmopForArea(farmopDTO);
        return ResponseUtil.success("插入成功");
    }

    @ApiOperation(value="为地块插入一项或多项农事操作记录",notes = "areaId、farmcateName为必填项，tree_Id填0")
    @RequestMapping(value = "/insertFarmsForArea",method = RequestMethod.POST)
    Response insertFarmsForArea(@RequestBody List<FarmopDTO> farmopDTOs){
        farmopService.insertFarmopsForArea(farmopDTOs);
        return ResponseUtil.success("插入成功");
    }

    @ApiOperation(value="为树插入一项或多项农事操作记录",notes = "areaId、farmcateName、tree_Id为必填项")
    @RequestMapping(value = "/insertFarmsForTree",method = RequestMethod.POST)
    Response insertFarmsForTree(@RequestBody List<FarmopDTO> farmopDTOs){
        farmopService.insertFarmopsForTree(farmopDTOs);
        return ResponseUtil.success("插入成功");
    }


    @ApiOperation(value ="删除农事记录")
    @ApiImplicitParam( name = "ids",value = "农事操作id,一个或多个,参数举例:{\"ids\": [1,3]}", required = true)
    @RequestMapping(value = "/deleteOneFarmop",method = RequestMethod.POST)
    Response deleteOneFarmop(@RequestBody Map<String,List<Integer>> ids){
       farmopService.deleteFarmop((List<Integer>) ids.get("ids"));
        return ResponseUtil.success("删除成功");
    }

    @ApiOperation(value = "更改一条农事记录,farmcatename可以不填")
    @RequestMapping(value = "/updateOneFarmop",method = RequestMethod.POST)
    Response updateOneFarmop(@RequestBody FarmopDTO farmopDTO) throws NotFoundException {
        farmopService.updataOneFarmop(farmopDTO);
        return ResponseUtil.success("更改成功");
    }
}
