package com.wanou;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class },scanBasePackages = {"org.jeecg.modules.jmreport","com.wanou"})
@EnableScheduling
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  若依启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }

    @Value("${oss.accessKeyId}")
    private String ACCESS_KEY_ID;
    @Value("${oss.accessSecret}")
    private String ACCESS_SECRET;
    @Value("${oss.end-point}")
    private String END_POINT;
    @Bean(name = "OSSUploadIAcsClient")
    public IAcsClient getIAcsClient(){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        return client;
    }

    @Value("${oss.roleArn}")
    private String ROLE_ARN;
    @Bean(name = "uploadAssumeRoleRequest")
    public AssumeRoleRequest getAssumeRoleRequest(){
        //构造请求，设置参数。
        AssumeRoleRequest request = new AssumeRoleRequest();
        request.setRoleArn(ROLE_ARN);
        request.setRoleSessionName("upload_STS");
        request.setDurationSeconds(900L); //过期时间，单位为秒,过期时间最小值为900秒，最大值为MaxSessionDuration设置的时间。默认值为3600秒。
        return request;
    }

    @Bean(name = "OSSClient")
    public OSS createdOSSClient(){
        return new OSSClientBuilder().build(END_POINT,ACCESS_KEY_ID,ACCESS_SECRET);
    }

    @Bean(name = "meetingRecordCacheList")
    public List meetingRecord(){
        return new ArrayList();
    }
}
