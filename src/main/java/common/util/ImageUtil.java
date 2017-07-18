package common.util;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Author: Tennyson
 * E-Mail:fwx_love@sina.com
 * Package:common.util
 * DateTime: 2016/3/10  15:52
 * Description:自己修改描述
 */
public class ImageUtil {

    @SuppressWarnings("unused")
	public static void main(String[] args) {
        String srcImgPath = "E:/Download/timg.jpg";  //源图片路径
        String iconPath = "E:/zhzq/2.jpg";  //水印图片路径
        String targerPath = "E:/Download/timg1.jpg"; //目标图片路径
        // 给图片添加水印
//      ImageUtil.waterMarkImageByIcon("java水印图片", iconPath, srcImgPath, targerPath, 0, 0, 0, 0.5f);
        //ImageUtil.waterMarkByText("说好的水印呢？", srcImgPath, targerPath, 50, 50, 30, 0.5f);
        // 给图片添加水印,水印旋转-45
        //
        String result = addComma("782323.23");
        System.out.println(result);
        String a = "1234567890";
        System.out.println("1234567890反转："+ new StringBuilder(a).reverse().toString());
    }

    /**
     * 将每三个数字加上逗号处理（通常使用金额方面的编辑）
     * @param str 无逗号的数字
     * @return 加上逗号的数字
     */
    private static String addComma(String str) {
        if (StringUtils.isNotBlank(str)) {
            str = str.replace(".00", "");
        }
        if (StringUtils.isNotBlank(str)) {
            str = str.replace(".", "");
        }
        // 将传进数字反转
        String reverseStr = new StringBuilder(str).reverse().toString();
        String strTemp = "";
        for (int i = 0; i < reverseStr.length(); i++) {
            if (i * 3 + 3 > reverseStr.length()) {
                strTemp += reverseStr.substring(i * 3, reverseStr.length());
                break;
            }
            strTemp += reverseStr.substring(i * 3, i * 3 + 3) + " ";
        }
        // 将 【789,456,】 中最后一个【,】去除
        if (strTemp.endsWith(",")) {
            strTemp = strTemp.substring(0, strTemp.length() - 1);
        }
        // 将数字重新反转
        String resultStr = new StringBuilder(strTemp).reverse().toString();
        return resultStr;
    }

    /**
     * 给图片添加水印、可设置水印图片旋转角度
     * @param iconPath  水印图片路径
     * @param srcImgPath  源图片路径
     * @param targerPath 目标图片路径
     * @param degree 水印图片旋转角度
     * @param width 宽度(与左相比)
     * @param height 高度(与顶相比)
     * @param clarity  透明度(小于1的数)越接近0越透明
     */
    public static void waterMarkImageByIcon(String logoText, String iconPath, String srcImgPath, String targerPath,
                                            Integer degree, Integer width, Integer height, float clarity) {
        OutputStream os = null;
        try {
            Image srcImg = ImageIO.read(new File(srcImgPath));
            System.out.println("width:" + srcImg.getWidth(null));
            System.out.println("height:" + srcImg.getHeight(null));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // 得到画笔对象
            Graphics2D g = buffImg.createGraphics();
            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
            }
            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);
            // 得到Image对象。
            Image img = imgIcon.getImage();
            float alpha = clarity; // 透明度
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            // 表示水印图片的位置
            //          g.drawImage(img, width, height, null);
            g.drawImage(img, srcImg.getWidth(null) - img.getWidth(null), srcImg.getHeight(null) - img.getHeight(null), null);

            //          g.drawString(logoText, srcImg.getWidth(null) - img.getWidth(null), srcImg.getHeight(null) - img.getHeight(null));

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            g.dispose();
            os = new FileOutputStream(targerPath);
            // 生成图片
            ImageIO.write(buffImg, "JPG", os);
            System.out.println("添加水印图片完成!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给图片添加水印、可设置水印图片旋转角度
     * @param logoText  水印文字
     * @param srcImgPath  源图片路径
     * @param targerPath 目标图片路径
     * @param degree 水印图片旋转角度
     * @param width  宽度(与左相比)
     * @param height 高度(与顶相比)
     * @param clarity  透明度(小于1的数)越接近0越透明
     */
    public static void waterMarkByText(String logoText, String srcImgPath, String targerPath, Integer degree, Integer width,
                                       Integer height, Float clarity) {
        // 主图片的路径
        InputStream is = null;
        OutputStream os = null;
        try {
        	logoText = new String(logoText.getBytes(),"utf-8");
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // 得到画笔对象
            // Graphics g= buffImg.getGraphics();
            Graphics2D g = buffImg.createGraphics();
            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
            }
            // 设置颜色
            g.setColor(Color.red);
            // 设置 Font
            g.setFont(new Font("", Font.BOLD, 30));//服务器上框框原因：linux上没有安装相应字体
            float alpha = clarity;
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            // 第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y) .
            g.drawString(logoText, width, height);
            g.dispose();
            os = new FileOutputStream(targerPath);
            // 生成图片
            ImageIO.write(buffImg, "JPG", os);
            System.out.println("添加水印文字完成!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 图片缩放(图片等比例缩放为指定大小，空白部分以白色填充)
     * @param srcPath 源图片路径
     * @param destPath 缩放后图片路径
     */
    public static void zoomImage(String srcPath, String destPath, int destHeight, int destWidth) {
        try {
            BufferedImage srcBufferedImage = ImageIO.read(new File(srcPath));
            int imgWidth = destWidth;
            int imgHeight = destHeight;
            int srcWidth = srcBufferedImage.getWidth();
            int srcHeight = srcBufferedImage.getHeight();
            if (srcHeight >= srcWidth) {
                imgWidth = (int) Math.round(((destHeight * 1.0 / srcHeight) * srcWidth));
            } else {
                imgHeight = (int) Math.round(((destWidth * 1.0 / srcWidth) * srcHeight));
            }
            BufferedImage destBufferedImage = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = destBufferedImage.createGraphics();
            graphics2D.setBackground(Color.WHITE);
            graphics2D.clearRect(0, 0, destWidth, destHeight);
            graphics2D.drawImage(srcBufferedImage.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH), (destWidth / 2)
                    - (imgWidth / 2), (destHeight / 2) - (imgHeight / 2), null);
            graphics2D.dispose();
            ImageIO.write(destBufferedImage, "JPEG", new File(destPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 截取图片
     * @param srcImageFile  原图片地址
     * @param x    截取时的x坐标
     * @param y    截取时的y坐标
     * @param desWidth   截取的宽度
     * @param desHeight   截取的高度
     */
    public static void imgCut(String srcImageFile, int x, int y, int desWidth,
                              int desHeight) {
        try {
            Image img;
            ImageFilter cropFilter;
            BufferedImage bi = ImageIO.read(new File(srcImageFile+".jpg"));
            int srcWidth = bi.getWidth();
            int srcHeight = bi.getHeight();
            if (srcWidth >= desWidth && srcHeight >= desHeight) {
                Image image = bi.getScaledInstance(srcWidth, srcHeight,Image.SCALE_DEFAULT);
                cropFilter = new CropImageFilter(x, y, desWidth, desHeight);
                img = Toolkit.getDefaultToolkit().createImage(
                        new FilteredImageSource(image.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(desWidth, desHeight,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, null);
                g.dispose();
                //输出文件
                ImageIO.write(tag, "JPEG", new File(srcImageFile+"_cut.jpg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 文件重命名
     */
    public static String rename(String fileName){
        int i = fileName.lastIndexOf(".");
        String str = fileName.substring(i);
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime())
        		+ new Random().nextInt(999) +str;
    }
    
    /**
     * 图片格式验证
     */
    public static final List<String> ALLOW_TYPES = Arrays.asList(
            "image/jpg","image/jpeg","image/png","image/gif","image/bmp"
    );
    
    /**
     * 校验文件类型是否是被允许的
     */
    public static boolean allowUpload(String postfix){
        return ALLOW_TYPES.contains(postfix);
    }
    
    /**
     * 图片上传
     * @param imageFile		图片上传文件
     * @param resourcePath	保存路径
     * @param realPath		服务器路径
     * @return				实际存储路径
     * @param is_compress   图片是否压缩
     */
    public static String uploadImg(MultipartFile imageFile, String resourcePath, String realPath,boolean is_compress) throws Exception{
    	//文件重命名
		String fileName = rename(imageFile.getOriginalFilename());
		int end = fileName.lastIndexOf(".");
		//获取保存名称
		String saveName = fileName.substring(0, end);
		File dir = new File(realPath + resourcePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 获取存储路径
		String imgUrl = resourcePath + saveName + ".jpg";
        // 读取文件后获取源文件保存
        File file = new File(dir, saveName + ".jpg");
        if(is_compress){
            //压缩图片
            ImgCompress compress = new ImgCompress(imageFile.getInputStream());
            compress.resizeFix(1920, 1080, realPath+imgUrl);
        }else{
            //不进行压缩
            imageFile.transferTo(file);
        }
		return imgUrl;
    }
}
