package com.wanou.common.component.OSS;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.wanou.common.domain.STSEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author txh
 * @date 2021/7/27 15:46
 * 对象存储组件
 */
@Component
@Slf4j
public class OSSComponent {

    @Resource(name = "OSSUploadIAcsClient")
    private IAcsClient I_ACS_CLIENT;
    @Resource(name = "uploadAssumeRoleRequest")
    private AssumeRoleRequest ASSUME_ROLE_REQUEST;
    @Value("${oss.region}")
    private String REGION;
    @Value("${oss.bucket-name}")
    private String BUCKET_NAME;
    @Value("${oss.end-point}")
    private String END_POINT;

    @Resource(name = "OSSClient")
    private OSS ossClient;

    //获取STS临时授权TOKEN
    public STSEntity getSTSToken(){
        try {
            AssumeRoleResponse acsResponse = I_ACS_CLIENT.getAcsResponse(ASSUME_ROLE_REQUEST);
            AssumeRoleResponse.Credentials credentials = acsResponse.getCredentials();
            STSEntity stsEntity = new STSEntity();
            stsEntity.setAccessKeyId(credentials.getAccessKeyId());
            stsEntity.setAccessKeySecret(credentials.getAccessKeySecret());
            stsEntity.setSecurityToken(credentials.getSecurityToken());

            stsEntity.setRegion(REGION);
            stsEntity.setBucketName(BUCKET_NAME);
            return stsEntity;
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 批量生成签名授权访问链接
     * @return
     */
    public List<String> generateSignUrlBatch(List<String> objectNameList){
        /*STSEntity stsToken = getSTSToken();
        if(stsToken == null){
            throw new STSException("获取授权失败");
        }

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(END_POINT, stsToken.getAccessKeyId(), stsToken.getAccessKeySecret(), stsToken.getSecurityToken());*/

        // 设置签名URL过期时间为3600秒（1小时）。
        // Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        DateTime expiration = DateUtil.offsetMinute(DateUtil.date(), 30);
        List<String> urlList = new ArrayList<>();
        for (String objectName : objectNameList) {
            URL url = ossClient.generatePresignedUrl(BUCKET_NAME, objectName, expiration);
            urlList.add(url.toString());
        }
        return urlList;
    }


    /**
     * 单独生成临时访问链接
     * @param objectName
     * @return
     */
    public String generateSignUrl(String objectName) {
        DateTime expiration = DateUtil.offsetMinute(DateUtil.date(), 30);
        URL url = ossClient.generatePresignedUrl(BUCKET_NAME, objectName, expiration);
        return url.toString();
    }

    /**
     * 流式下载
     */
    public byte[] downFile4Stream(String objectName){
        if(StrUtil.isBlank(objectName)){
            return null;
        }
        byte[] resultByteArr = null;
        OSSObject ossObject = null;
        try {
            // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
            ossObject = ossClient.getObject(BUCKET_NAME, objectName);

            // 读取文件内容。
            InputStream inputStream = ossObject.getObjectContent();
            /*BufferedReader reader = new BufferedReader(new InputStreamReader());
            while (true) {
                String line = reader.readLine();
                if (line == null) break;

                System.out.println("\n" + line);
            }
            // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
            reader.close();*/
            byte[] bytes = IoUtil.readBytes(inputStream, true);

            ossObject.close();

            resultByteArr = bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ossObject != null){
                try {
                    ossObject.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultByteArr;
    }
    //cd8e8302e0ef96178be7d0de5105556f
    public void uploadByte(String objName,byte[] bytes){
        // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
        ossClient.putObject(BUCKET_NAME, objName, new ByteArrayInputStream(bytes));
    }

    //判断文件是否存在
    public boolean isExist(String objectName){
        // 判断文件是否存在。如果返回值为true，则文件存在，否则存储空间或者文件不存在。
        // 设置是否进行重定向或者镜像回源。默认值为true，表示忽略302重定向和镜像回源；如果设置isINoss为false，则进行302重定向或者镜像回源。
        //boolean isINoss = true;
        //boolean found = ossClient.doesObjectExist("examplebucket", "exampleobject.txt", isINoss);
        return ossClient.doesObjectExist(BUCKET_NAME, objectName);
    }

    /**
     * 获取文件基本元信息
     * @return
     */
    public SimplifiedObjectMeta getObjectMetaSimplified(String objectName){
        return ossClient.getSimplifiedObjectMeta(BUCKET_NAME, objectName);
    }
}
