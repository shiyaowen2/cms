package com.xuecheng.fastdfs;


import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testFastDFS {
    //上传文件

    @Test
    public void testUpload()  {

        try {
            //加载fastdfs-client.properties配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient，用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            //创建stroageClient
            StorageClient1 storageClient1=new StorageClient1(trackerServer,storageServer);
            //向stroage服务器上传文件
            //本地文件的路径
            String filePath = "d:/logo.txt";
            String fileId = storageClient1.upload_appender_file1(filePath,"txt",null);

            //上传成功后拿到文件Id group1/M00/00/00/wKgfgV3pCz-EefIHAAAAAM2SDJ4595.txt
            System.out.println("上传的文件ID为"+fileId);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }







    }



    //下载文件
    @Test
    public void testDownload(){

        try {
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient，用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            //创建stroageClient
            StorageClient1 storageClient1=new StorageClient1(trackerServer,storageServer);
            //服务器文件Id
            String fileId="group1/M00/00/00/wKgfgV3pCz-EefIHAAAAAM2SDJ4595.txt";
            //下载文件
            byte[] file = storageClient1.download_file1(fileId);
             //使用输出流保存文件
            FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/test.txt"));
            fileOutputStream.write(file);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
