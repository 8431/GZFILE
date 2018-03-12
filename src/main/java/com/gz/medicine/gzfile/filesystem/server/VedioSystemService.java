package com.gz.medicine.gzfile.filesystem.server;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzfile.filesystem.request.FileSystemVo;

/**
 * Created by json snow on 2017/9/21 0021.
 */
public interface VedioSystemService {

    /**
     * 查询视频列表
     * @param p
     * @return
     * @throws CommonException
     */
    Page queryPageVedioList(PageModel p) throws CommonException;



}
