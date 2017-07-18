package com.blf.common.controller;

import common.util.ImageUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * Author: Tennyson
 * E-Mail:xing_wang@cxsoft.com.cn
 * Package:com.blf.common.controller
 * DateTime: 2016年5月2日 下午12:32:42
 * Description:文件上传
 */
@Controller
@RequestMapping("/uploadFile")
public class FileUploadController {

    protected final Log LOG = LogFactory.getLog(getClass());

    //返回json字符串
    @RequestMapping("/upload")
    public @ResponseBody
    HashMap<String,String> upload(HttpServletRequest request){
        LOG.info("开始上传文件！");
        HashMap<String,String> hashMap = new HashMap<String, String>();
        String returnUrl= null;
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
            /**构建图片保存的目录**/
            String logoPathDir = "/files"+ dateformat.format(new Date())+"/";
            /**得到图片保存目录的真实路径**/
            String logoRealPathDir =  request.getSession().getServletContext().getRealPath(logoPathDir);
            
            System.out.println("logorealpathdir="+logoRealPathDir);
            /**根据真实路径创建目录**/
            File logoSaveFile = new File(logoRealPathDir);
            if(!logoSaveFile.exists())
                logoSaveFile.mkdirs();
            /**页面控件的文件流**/
            MultipartFile multipartFile = multipartRequest.getFile("imgUrl");
            
            LOG.info("multipartFile  ="+multipartFile);
            
            /**获取文件的后缀**/
            String suffix = multipartFile.getOriginalFilename().substring
                    (multipartFile.getOriginalFilename().lastIndexOf("."));
    //        /**使用UUID生成文件名称**/
            String logImageName = UUID.randomUUID().toString().replace("-", "")+ suffix;//构建文件名称
//            String waterMarkFileName =  UUID.randomUUID().toString().replace("-", "")+ suffix;
//            String logImageName = multipartFile.getOriginalFilename();
            
            LOG.info("logImageName="+logImageName);
            
            returnUrl = logoPathDir + logImageName;
            
            System.out.println(returnUrl);
            /**拼成完整的文件保存路径加文件**/
            String fileName = logoRealPathDir + File.separator   + logImageName;
            
            File file = new File(fileName);
            multipartFile.transferTo(file);
            
            if(suffix.equals(".jpg")|| suffix.equals(".jpeg")|| suffix.equals(".png")|| suffix.equals(".bmp")|| suffix.equals(".gif")){
            	String addWaterMark = request.getParameter("name");
                if(null != addWaterMark && addWaterMark.equals("file")){
                	ImageUtil.waterMarkByText("bailefen", fileName, fileName, 0, 10,
                            50, (float) 0.2);
                }
            }
            
            //获取base64编码
            String tString= GetImageStr(fileName);
            /*System.out.println(tString);*/
            
            if (null!=returnUrl){
                hashMap.put("filePath",returnUrl);
                hashMap.put("base64", tString);
                hashMap.put("msg","上传成功！");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            LOG.error("error",e);
            hashMap.put("msg","上传失败！");
        } catch (IOException e) {
            LOG.error("error",e);
            hashMap.put("msg","上传失败！");
            e.printStackTrace();
        }
        return hashMap;  //json
    }
    
  //生成base64图片编码
    public  String GetImageStr(String imgFile)
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
      //  String imgFile = "d:\\hwy.jpg";//待处理的图片
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFile);        
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder=new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }
}
