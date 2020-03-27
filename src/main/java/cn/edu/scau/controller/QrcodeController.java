package cn.edu.scau.controller;

import cn.edu.scau.entities.dto.PageDTO;
import cn.edu.scau.entities.dto.QrcodeCSDTO;
import cn.edu.scau.entities.dto.QrcodeDTO;
import cn.edu.scau.entities.pojo.Qrcode;
import cn.edu.scau.entities.vo.QrcodeVO;
import cn.edu.scau.entities.vo.Response;
import cn.edu.scau.service.QrcodeService;
import cn.edu.scau.service.impl.QrcodeServiceImpl;
import cn.edu.scau.util.ResponseUtil;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/qrcode")
@Api(tags = "二维码接口")
public class QrcodeController {
    @Autowired
    QrcodeServiceImpl qrcodeService;

    @ApiOperation(value = "创建二维码,一个或多个")
    @RequestMapping(value = "/createQrcode",method = RequestMethod.POST)
    public Response createQrcode(@RequestBody List<QrcodeVO> qrcodeVOs) throws Exception {
        if(qrcodeVOs.size()==0){
            throw new Exception("地块Id，树Id，采摘时间都不能为空");
        } else if (qrcodeVOs.size()==1) {
            QrcodeVO qrcodeVO = qrcodeVOs.get(0);
            qrcodeService.insertOneQrcode(qrcodeVO);
        }else{
            qrcodeService.insertQrcodes(qrcodeVOs);
        }
        return ResponseUtil.success("创建成功");
    }

    @ApiOperation(value = "删除二维码，一个或多个",notes = "输入qrcodeId即可")
    @RequestMapping(value = "/deleteQrcode",method = RequestMethod.POST)
    public Response deleteQrcode(@RequestBody List<QrcodeDTO> qrcodeDTOs){
        qrcodeService.deleteQrcode(qrcodeDTOs);
        return ResponseUtil.success("删除成功");
    }

//    public List<QrcodeDTO> getAllQrcode(){
//        return ;
//    }

    @ApiOperation("获取二维码分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码",name="pageNum",required = true),
            @ApiImplicitParam(value = "每页显示条数",name="pageSize",required = true)
    })
    @RequestMapping(value = "/getQrcodePage",method = RequestMethod.GET)
    public Response<List<QrcodeDTO>> getQrcodePage( int pageNum, int pageSize){
        PageDTO<List<QrcodeDTO>> pageDTO = qrcodeService.getQrcodePage(pageNum, pageSize);
        return ResponseUtil.success(pageDTO);
    }

    @ApiOperation("根据条件获取二维码分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码",name="pageNum",required = true),
            @ApiImplicitParam(value = "每页显示条数",name="pageSize",required = true)
    })
    @RequestMapping(value = "/getQrcodePageByCondition",method = RequestMethod.GET)
    public Response<List<QrcodeDTO>> getQrcodePageByCondition( int pageNum, int pageSize,QrcodeCSDTO qrcodeCSDTO){
        PageDTO<List<QrcodeDTO>> pageDTO = qrcodeService.getQrcodeCSPage(pageNum,pageSize,qrcodeCSDTO);
        return ResponseUtil.success(pageDTO);
    }

    @ApiOperation(value = "获取所有二维码")
    @RequestMapping(value = "/getAllQrcode",method = RequestMethod.GET)
    public Response<List<QrcodeDTO>> getAllQrcode(){
        List<QrcodeDTO> allQrcode = qrcodeService.getAllQrcode();
        return ResponseUtil.success(allQrcode);
    }

}
