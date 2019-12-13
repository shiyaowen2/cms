package com.xuecheng.api.filesystem;


import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;


@Api(value = "文件管理接口",description = "文件管理接口，提供页面的增删改查")
public interface FileSystemControllerApi {

    /**
     * 上传文件
     * @param multipartFile 文件
     * @param businesskey  业务key
     * @param filetag     文件标签
     * @param metadata    元信息json数据
     * @return
     */
    @ApiOperation("上传文件接口")
    public UploadFileResult upload( MultipartFile multipartFile,
                                    String businesskey,
                                    String filetag,
                                    String metadata
    );

}
