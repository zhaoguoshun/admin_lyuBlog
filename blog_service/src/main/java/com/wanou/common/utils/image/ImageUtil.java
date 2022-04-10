package com.wanou.common.utils.image;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;

import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author txh
 * @date 2021/8/11 17:05
 * 图片工具类
 */
public class ImageUtil {

    /**
     * 旋转图片并保存至指定目录
     * @param base64
     * @param degree
     * @param outFile
     */
    public static void rotateImgByBase64Save(String base64, int degree, File outFile){
        ImageOutputStream ios = null;
        try {
            FileUtil.mkParentDirs(outFile);
            BufferedImage bufferedImage = ImgUtil.toImage(base64);
            ios = new FileImageOutputStream(outFile);
            ImgUtil.rotate(bufferedImage,degree,ios);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ios != null){
                try {
                    ios.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 判断图片base64字符串的文件格式
     *
     * @param base64ImgData
     * @return
     */
    public static String checkImageBase64Format(String base64ImgData) {
        byte[] b = Base64.decode(base64ImgData);
        String type = "";
        if (0x424D == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "bmp";
        } else if (0x8950 == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "png";
        } else if (0xFFD8 == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "jpg";
        }
        return type;
    }
}
