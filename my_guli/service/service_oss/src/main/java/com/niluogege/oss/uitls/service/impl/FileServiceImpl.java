package com.niluogege.oss.uitls.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.niluogege.oss.uitls.ConstantPropertiesUtil;
import com.niluogege.oss.uitls.service.FileService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadFile(MultipartFile file) {

        //获取阿里云存储相关常量
        String endPoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        String fileHost = ConstantPropertiesUtil.FILE_HOST;

        String imageUrl = "";
        try {
            OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);

            //bucket 不存在 则创建
            if (!client.doesBucketExist(bucketName)) {
                client.createBucket(bucketName);
                //设置bucket 权限为 公共读
                client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }

            InputStream inputStream = file.getInputStream();


            //每天的图片存储到一个文件夹下
            String filePath = new DateTime().toString("yyyy/MM/dd");

            //创建文件名 防止重复 格式为 uuid.扩展名
            String originalFilename = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newName = uuid + fileType;
            String fileUrl = fileHost + File.separator + filePath + File.separator + newName;

            //上传
            client.putObject(bucketName, fileUrl, inputStream);

            //关闭client
            client.shutdown();

            //组装图片地址
            imageUrl = "http://" + bucketName + "." + endPoint + "/" + fileUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageUrl;
    }
}
