package cn.edu.scau;

import cn.edu.scau.entities.pojo.Qrcode;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestApplication {
    @Ignore
    @Test
    void test1(){
        String s = "2109-23-2";
        s = s.replace("-","");
        System.out.println(s);
    }

    @Test
    void test2(){
        String lastOrder = "019";
        DecimalFormat df3=new DecimalFormat("000");
        lastOrder = String.valueOf(df3.format(Integer.parseInt(lastOrder)+1));
        System.out.println(lastOrder);
    }

    @Test
    void test3(){
        List<Qrcode> qrcodeList = new ArrayList<Qrcode>();
        qrcodeList.add(new Qrcode("233"));
        System.out.println(qrcodeList.get(0));
    }

    @Test
    void saveImage() throws IOException {
        InputStream input = new FileInputStream("E:\\image\\u0.png");
        FileOutputStream output = new FileOutputStream("E:\\image\\qqq\\u0_1.png");
        FileCopyUtils.copy(input, output);
//        File imageFile = new File("E:\\image\\u0.png");
//        System.out.println(imageFile);
//        File imageFile2=new File("E:\\qqq");
//        imageFile2.
    }

    @Test
    void saveImage1() throws FileNotFoundException {
        //获取跟目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        System.out.println("path:"+path.getAbsolutePath());

//如果上传目录为/static/images/upload/，则可以如下获取：
        File upload = new File(path.getAbsolutePath(),"static/images/upload/");
        if(!upload.exists()) upload.mkdirs();
        System.out.println("upload url:"+upload.getAbsolutePath());
//在开发测试模式时，得到的地址为：{项目跟目录}/target/static/images/upload/
//在打包成jar正式发布时，得到的地址为：{发布jar包目录}/static/images/upload/

    }


}
