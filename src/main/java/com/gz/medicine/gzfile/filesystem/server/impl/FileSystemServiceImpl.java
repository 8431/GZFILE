package com.gz.medicine.gzfile.filesystem.server.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.TimeUtil;
import com.gz.medicine.ftpUtil.FTPClientPool;
import com.gz.medicine.ftpUtil.Ftp;
import com.gz.medicine.gzfile.filesystem.bean.ChisFileSystem;
import com.gz.medicine.gzfile.filesystem.mapper.ChisFileSystemMapper;
import com.gz.medicine.gzfile.filesystem.request.FileSystemVo;
import com.gz.medicine.gzfile.filesystem.server.FileSystemService;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2017/10/25 0025.
 * Email 1429264916@qq.com
 */
@Service("FileSystemService")
public class FileSystemServiceImpl implements FileSystemService {
    public static final Logger LOGGER = Logger.getLogger(FileSystemServiceImpl.class);
    private final static String FILE_PATH = "/filesystem/webrtc_vedio/";
    @Autowired
    FTPClientPool ftpclientpool;
    @Autowired
    ChisFileSystemMapper chisfilesystemmapper;

    @Override
    @Async("asyncExecutor")
    public void uploadVedioBy(FileSystemVo pm) throws CommonException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            String time = sdf.format(new Date());
            String fileName = "WebRTC_" + pm.getUsrid() + "_" + time;
            pm.setFilename(fileName);
            ChisFileSystem cs = new ChisFileSystem();
            BeanUtils.copyProperties(pm, cs);
            chisfilesystemmapper.insertSelective(cs);
            uploadFile(pm.getFile(), FILE_PATH, fileName);
        } catch (Exception e) {
            LOGGER.error("视频上传异常:" + e.getMessage(), e);
        }
    }
    @Override
    public void uploadFile(MultipartFile file, String filePath, String name) throws CommonException {
        Ftp f = null;
        try {
            f = ftpclientpool.borrowObject();
            f.uploadFile(file.getInputStream(), name, filePath);
            ftpclientpool.returnObject(f);
        } catch (Exception e) {
            throw new CommonException("uploadFile异常");
        }

    }
}


