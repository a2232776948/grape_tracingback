package cn.edu.scau.util;

import cn.edu.scau.constent.Qr;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @ClassName MultipartFileToFile
 * @Description MultipartFile转fie
 * @Author TongGuoBo
 * @Date 2019/6/19 13:48
 **/
public class ImageUtil {

    /**
     * MultipartFile 转 File
     *
     * @param file
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }

    public static String getImageprefix(String oriPath){
        String result = "";
        if(oriPath.substring(0, 1).equals("/")){
            oriPath = oriPath.substring(1);
        }
        String[] splits = oriPath.split("/");
        result = splits[0];
        return result;
    }

    public static String getImageName(String oriPath) {
        String result = "";
        if(oriPath.substring(0, 1).equals("/")){
            oriPath = oriPath.substring(1);
        }
        String[] splits = oriPath.split("/");
        result = splits[1];
        return result;
    }

    public static void saveImage(MultipartFile multipartFile,String imagePathAndName) throws Exception{

        File imageFile = ImageUtil.multipartFileToFile(multipartFile);
        //System.out.println(imageFile.getAbsolutePath());
        InputStream input = new FileInputStream(imageFile);

        //获取跟目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        //System.out.println("path:"+path.getAbsolutePath());

//如果上传目录为/static/images/upload/，则可以如下获取：
        File upload = new File(path.getAbsolutePath(),"static/images/upload/");
        if(!upload.exists()) upload.mkdirs();
        //System.out.println("upload url:"+upload.getAbsolutePath());
//在开发测试模式时，得到的地址为：{项目跟目录}/target/static/images/upload/
//在打包成jar正式发布时，得到的地址为：{发布jar包目录}/static/images/upload/

        File finlPath = new File(upload.getAbsolutePath(),getImageprefix(imagePathAndName));
        if(!finlPath.exists()){
            finlPath.mkdirs();
        }

        FileOutputStream output = new FileOutputStream(finlPath+"/"+getImageName(imagePathAndName));
        FileCopyUtils.copy(input, output);
        imageFile.delete();
        input.close();
        output.close();
    }
}