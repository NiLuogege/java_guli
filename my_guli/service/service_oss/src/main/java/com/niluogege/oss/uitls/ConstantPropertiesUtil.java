package com.niluogege.oss.uitls;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * 读取oss 的配置信息
 *
 * 实现 InitializingBean 后会在 所有属性都被初始化后 调用 afterPropertiesSet方法
 *
 * 然后再 afterPropertiesSet方法 中对静态变量赋值
 *
 */
public class ConstantPropertiesUtil implements InitializingBean {
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyid;

    @Value("${aliyun.oss.file.keysecret}")
    private String keysecret;

    @Value("${aliyun.oss.file.bucketname}")
    private String bucketname;
    @Value("${aliyun.oss.file.filehost}")
    private String filehost;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    public static String FILE_HOST;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT=endpoint;
        ACCESS_KEY_ID = keyid;
        ACCESS_KEY_SECRET = keysecret;
        BUCKET_NAME = bucketname;
        FILE_HOST = filehost;
    }
}
