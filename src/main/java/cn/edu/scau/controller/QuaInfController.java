package cn.edu.scau.controller;

import cn.edu.scau.entities.dto.QuaInfDTO;
import cn.edu.scau.entities.pojo.QuaInf;
import cn.edu.scau.entities.vo.Response;
import cn.edu.scau.entities.vo.Result;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.exception.NotFoundException;
import cn.edu.scau.exception.RequestException;
import cn.edu.scau.service.impl.QrcodeServiceImpl;
import cn.edu.scau.service.impl.QuaInfServiceImpl;
import cn.edu.scau.util.ImageUtil;
import cn.edu.scau.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Api(tags = "质检操作接口")
@RestController
@RequestMapping("/quaInf")
public class QuaInfController {

    @Autowired
    private QuaInfServiceImpl quaInfService;
    private boolean addOneQuaInfIsCalled=false;
    private QuaInfDTO quaInfDTO;

    @ApiOperation(value = "添加一个质检信息",notes = "对于同一个质检信息调用的顺序为先/addOneQuaInf，再/addOneQuaInfImage,/addOneQuaInf和/addOneQuaInfImage都要调用，若没有图片则/addOneQuaInfImage传一个空值")
    @RequestMapping(value = "/addOneQuaInf",method = RequestMethod.POST)
    public Response addOneQuaInfNotImage(@RequestBody @Validated QuaInfDTO quaInfDTO) throws Exception {
//        if(quaInfDTO.getAreaId() == 0 && quaInfDTO.getTreeId()==0 && quaInfDTO.getQrcodeId()==null){
//            throw new RequestException("地块号、树号、二维码至少要有一个", Result.ErrorCode.PARAM_ERROR.getCode());
//        }else{
        //quaInfDTO.setImage(multipartFile);
        quaInfService.addQuaInf(quaInfDTO);
        //}
        addOneQuaInfIsCalled=true;
        return ResponseUtil.success("添加成功");
    }

    @ApiOperation(value = "添加质检信息的图片",notes = "对于同一个质检信息调用的顺序为先/addOneQuaInf，再/addOneQuaInfImage,/addOneQuaInf和/addOneQuaInfImage都要调用，若没有图片则/addOneQuaInfImage传一个空值")
    @RequestMapping(value = "/addOneQuaInfImage",method = RequestMethod.POST)
    public Response addOnQuaInfImage(@RequestBody MultipartFile multipartFile) throws Exception {
        if (addOneQuaInfIsCalled == true) {
            if (multipartFile == null) {
                quaInfService.setQuaInfImageName("");
            } else {
                String imageName = quaInfService.findLastImageName();
                ImageUtil.saveImage(multipartFile, imageName);
            }
            addOneQuaInfIsCalled=false;
            return ResponseUtil.success("");
        }else{
            throw new GlobalException("要先调用/addOneQuaInf");
        }
    }

    @ApiOperation(value = "删除一项质检信息")
    @ApiImplicitParam(name="quaInfId",value = "质检项的Id")
    @RequestMapping(value = "/deleteOneQuaInf",method = RequestMethod.POST)
    public Response deleteOneQuaInf(int quaInfId){
        quaInfService.deleteOneQuaInf(quaInfId);
        return ResponseUtil.success("删除成功");
    }

/*    @RequestMapping(value = "/updateOneQuaInf",method = RequestMethod.POST)
    public Response updateOneQuaInf(QuaInfDTO quaInfDTO){
        return ResponseUtil.success("更新成功");
    }*/

}
