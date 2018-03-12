package com.gz.medicine.gzfile.filesystem.server.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzfile.filesystem.mapper.ChisFileSystemMapper;
import com.gz.medicine.gzfile.filesystem.server.VedioSystemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2017/10/26 0026.
 * Email 1429264916@qq.com
 */
@Service("VedioSystemService")
public class VedioSystemServiceImpl implements VedioSystemService {
    public static final Logger LOGGER = Logger.getLogger(VedioSystemServiceImpl.class);

    @Autowired
    ChisFileSystemMapper chisfilesystemmapper;

    @Override
    public Page queryPageVedioList(PageModel p) throws CommonException {
        Page page= p.getPage();
        String usrid= (String) page.get("usrid");
        String receiveid= (String) page.get("receiveid");
        List<Map<String,Object>> vedioLi=new ArrayList<Map<String, Object>>();
        if(StringUtils.isEmpty(usrid)||StringUtils.isEmpty(receiveid)){
            throw new CommonException("usrid,receiveid不能为空");
        }
        try {
            vedioLi=chisfilesystemmapper.queryPageVedioList(page);
            page.setParameterType(vedioLi);
        } catch (Exception e) {
            LOGGER.error("查询视频列表异常:" + e.getMessage(), e);
        }
        return page;
    }
}
