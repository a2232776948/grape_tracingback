package cn.edu.scau.controller;

import cn.edu.scau.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping("/imageUpload.do")
    public void imageUpload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        File imageFile = ImageUtil.multipartFileToFile(multipartFile);
        InputStream input = new FileInputStream(imageFile);
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        System.out.println(staticPath);
        FileOutputStream output = new FileOutputStream(staticPath+"/u1.jpg");//"classpath:/templates/u1.jpg"
        FileCopyUtils.copy(input, output);
        input.close();
        output.close();
    }

}
