package cn.edu.scau.controller;

import cn.edu.scau.entities.dto.AddTreeForAreaDTO;
import cn.edu.scau.entities.dto.AreaDTO;
import cn.edu.scau.entities.dto.TreeForAreaDTO;
import cn.edu.scau.entities.pojo.Area;
import cn.edu.scau.entities.pojo.Tree;
import cn.edu.scau.entities.pojo.TreeCate;
import cn.edu.scau.entities.vo.AreaVO;
import cn.edu.scau.entities.vo.Response;
import cn.edu.scau.service.impl.AreaAndTreeServiceImpl;
import cn.edu.scau.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "地块和树接口")
@RestController
public class AreaAndTreeController {
    @Autowired
    AreaAndTreeServiceImpl areaAndTreeService;

    @ApiOperation(value = "获取所有地块的ID")
    @RequestMapping(value = "/getAllAreaID",method = RequestMethod.GET)
    public Response<List<Integer>> getAllAreaID(){
        return ResponseUtil.success(areaAndTreeService.findAllArea());
    }

    @ApiOperation(value = "获取所有地块")
    @RequestMapping(value = "/getAllArea",method = RequestMethod.GET)
    public Response<List<AreaVO>> getAllAreaVO(){
        return ResponseUtil.success(areaAndTreeService.getAllAreaVO());
    }

    @ApiOperation(value = "添加一个地块")
    @RequestMapping(value = "/addArea",method = RequestMethod.POST)
    public Response addArea(@RequestBody AreaDTO areaDTO){
        areaAndTreeService.addArea(areaDTO);
        return ResponseUtil.success("添加成功");
    }

    @ApiOperation(value = "改变一个地块的信息")
    @RequestMapping(value="/changeAreaName",method = RequestMethod.POST)
    public Response changeAreaName(Area area){
        areaAndTreeService.updateAreaName(area);
        return ResponseUtil.success("更新成功");
    }

    @ApiOperation(value ="获取某个地块下所有的树")
    @RequestMapping(value = "/getAllTreeByAreaId",method = RequestMethod.GET)
    public Response<List<Tree>> getAllTreeByAreaId(int areaId){
        return ResponseUtil.success(areaAndTreeService.getAllTreeByAreaId(areaId));
    }

    @ApiOperation(value="为一个地块添加树,一棵或多棵",notes = "id 和 treeId 不用填")
    @RequestMapping(value = "/addTreeForArea",method = RequestMethod.POST)
    public Response addTreeForArea(@RequestBody AddTreeForAreaDTO addTreeForAreaDTO){
        areaAndTreeService.addTreeForArea(addTreeForAreaDTO.getTreeForAreaDTOS(),addTreeForAreaDTO.getAreaId());
        return ResponseUtil.success("添加成功");
    }

    @ApiOperation(value = "获取所有植株种类")
    @RequestMapping(value = "/getAllTreeCate",method = RequestMethod.GET)
    public Response<List<TreeCate>> getAllTreeCate(){
        List<TreeCate> allTreeCate = areaAndTreeService.getAllTreeCate();
        return ResponseUtil.success(allTreeCate);
    }

    @ApiOperation(value = "添加植株种类")
    @ApiImplicitParam(name = "treeCate",value = "植株种类")
    @RequestMapping(value = "/addTreeCate",method = RequestMethod.POST)
    public Response addTreeCate(@RequestBody String treeCate){
        areaAndTreeService.addTreeCate(treeCate);
        return ResponseUtil.success("添加成功");
    }

    @ApiOperation(value = "删除植株种类")
    @ApiImplicitParam(name = "id",value = "植株种类ID")
    @RequestMapping(value = "/deleteTreeCate",method = RequestMethod.GET)
    public Response deleteTreeCate( int id){
        areaAndTreeService.deleteTreeCate(id);
        return ResponseUtil.success("删除成功");
    }

}
