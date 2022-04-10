package com.wanou.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSONArray;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.wanou.common.utils.IdUtils;
import com.wanou.project.system.domain.SysDept;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author txh
 * @date 2021/8/12 14:27
 */

public class DemoTest {

    @Test
    public void test1() throws IOException {
        // ImgUtil.compress(new File("C:\\Users\\Administrator\\Desktop\\IMG_20210812_141852.jpg"),new File("C:\\Users\\Administrator\\Desktop\\compress.jpg"),0.1F);
        //ImgUtil.scale(new File("C:\\Users\\Administrator\\Desktop\\IMG_20210812_141852.jpg"),new File("C:\\Users\\Administrator\\Desktop\\compress.jpg"),480,640,null);
        //updateImage("C:\\Users\\Administrator\\Desktop\\IMG_20210812_141852.jpg","C:\\Users\\Administrator\\Desktop\\compress.jpg",480);
        //zipImageFile(new File("C:\\Users\\Administrator\\Desktop\\IMG_20210812_141852.jpg"),new File("C:\\Users\\Administrator\\Desktop\\compress.jpg"),480,640,1F);
        BufferedImage read = ImgUtil.read(new File("C:\\Users\\Administrator\\Desktop\\IMG_20210812_141852.jpg"));
        int width = read.getWidth();
        double div = NumberUtil.div(width, 480, 2);
        //float scale =  width / 480F;
        //Image img = ImgUtil.scale(read, 0.25F);
        //ImgUtil.write(img,new File("C:\\Users\\Administrator\\Desktop\\compress.jpg"));

        Thumbnails.of(new File("C:\\Users\\Administrator\\Desktop\\IMG_20210812_141852.jpg")).size(640,480).toFile(new File("C:\\Users\\Administrator\\Desktop\\compress.jpg"));
    }

    @Test
    public void test2() throws InterruptedException, FileNotFoundException {
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        PrivateKey aPrivate = pair.getPrivate();
        PublicKey aPublic = pair.getPublic();
        RSA rsa = SecureUtil.rsa(aPrivate.getEncoded(), aPublic.getEncoded());
        String abc = rsa.encryptBase64("abc", KeyType.PublicKey);

        System.out.println(abc);
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("开始");
        syncTest();
        System.out.println("结束");
    }

    @Async
    public void syncTest() throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("异步执行");
    }


    public void updateImage(String inPath,String outPath,int wid) throws IOException {

        InputStream inputStream = new FileInputStream(new File(inPath));

        BufferedImage bufferedImage = ImageIO.read(inputStream);

        int height = bufferedImage.getHeight(); //图片的高
        int width = bufferedImage.getWidth();  //图片的宽

        int newHeight =0;
        int newWidth =0;
        //
        if(wid>width){
            double s = wid/width;
            newHeight = (int) ((int) height*s);
            newWidth = (int) ((int) width*s);
        }
        if(wid<width){
            double s = width/wid;
            newHeight = (int) ((int) height/s);
            newWidth = (int) ((int) width/s);
        }


        BufferedImage image = new BufferedImage(newWidth,newHeight, BufferedImage.TYPE_INT_BGR);

        Graphics graphics = image.createGraphics();
        graphics.drawImage(bufferedImage, 0, 0, newWidth, newHeight, null);

        OutputStream outputStream = new FileOutputStream(new File(outPath));

        JPEGImageEncoder j = JPEGCodec.createJPEGEncoder(outputStream);
        j.encode(image);

        outputStream.close();

    }

    /**
     * 等比例压缩图片文件<br> 先保存原文件，再压缩、上传
     * @param oldFile  要进行压缩的文件
     * @param newFile  新文件
     * @param width  宽度 //设置宽度时（高度传入0，等比例缩放）
     * @param height 高度 //设置高度时（宽度传入0，等比例缩放）
     * @param quality 质量
     * @return 返回压缩后的文件的全路径
     */
    public static String zipImageFile(File oldFile,File newFile, int width, int height,
                                      float quality) {
        if (oldFile == null) {
            return null;
        }
        try {
            /** 对服务器上的临时文件进行处理 */
            Image srcFile = ImageIO.read(oldFile);
            int w = srcFile.getWidth(null);
            //  System.out.println(w);
            int h = srcFile.getHeight(null);
            //  System.out.println(h);
            double bili;
            if(width>0){
                bili=width/(double)w;
                height = (int) (h*bili);
            }else{
                if(height>0){
                    bili=height/(double)h;
                    width = (int) (w*bili);
                }
            }
            /** 宽,高设定 */
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
            //String filePrex = oldFile.getName().substring(0, oldFile.getName().indexOf('.'));
            /** 压缩后的文件名 */
            //newImage = filePrex + smallIcon+  oldFile.getName().substring(filePrex.length());

            /** 压缩之后临时存放位置 */
            FileOutputStream out = new FileOutputStream(newFile);

            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
            /** 压缩质量 */
            jep.setQuality(quality, true);
            encoder.encode(tag, jep);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile.getAbsolutePath();
    }

    @Test
    public void test4(){
        String url = "http://www.netbian.com/mei/";


        int index = 1;
        int ii = 0;
        while (true){
            String body = HttpRequest.get(url).execute().body();
            Document parse = Jsoup.parse(body);
            Elements select = parse.select("img[src]");
            for (int i = (index*20)-19; i <= index*20; i++) {
                String src = select.get(ii++).attr("src");
                if(!src.endsWith("gif") && src.startsWith("http")){
                    //保存
                    InputStream inputStream = HttpRequest.get(src).execute().bodyStream();
                    FileUtil.writeFromStream(inputStream,new File("D:\\img\\" + i + ".jpg"));
                }
            }
            index++;
            ii = 0;
            url = "http://www.netbian.com/mei/index_" + index + ".htm";

            if((index*20) >= 1300){
                break;
            }
        }

    }

    @Test
    public void test5() throws IOException {
        //d41d8cd98f00b204e9800998ecf8427e
        FileInputStream fileInputStream = IoUtil.toStream(new File("D:\\img\\430481098912034722.jpg"));
        byte[] bytes1 = IoUtil.readBytes(fileInputStream,false);
        String md5 = SecureUtil.md5(new File("D:\\img\\430481098912034722.jpg"));
        System.out.println(bytes1.length);
        fileInputStream.close();
    }
}
