package com.gz.medicine.gzfile.filesystem.server;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzfile.filesystem.request.FileSystemVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by json snow on 2017/9/21 0021.
 */
public interface FileSystemService {

    /**
     * 上传werrtc文件流
     * @param pm
     * @throws CommonException
     */
    void uploadVedioBy(FileSystemVo pm)throws CommonException;

    void uploadFile(MultipartFile file, String filePath, String name)throws CommonException;


}
