/*
* ChisFileSystemMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-25
*/
package com.gz.medicine.gzfile.filesystem.mapper;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.gzfile.filesystem.bean.ChisFileSystem;

import java.util.List;
import java.util.Map;

public interface BaseDaoMapper {
    /**
     * 执行任意select
     * @param p
     * @return
     * @throws CommonException
     */
    List<Map<String,Object>> QuerySql(Map<String,Object> p)throws CommonException;

    /**
     * 执行任意update
     * @param p
     * @return
     * @throws CommonException
     */
    int UpdateSql(Map<String,Object> p)throws CommonException;

    /**
     * 执行任意insert
     * @param p
     * @return
     * @throws CommonException
     */
    int InsertSql(Map<String,Object> p)throws CommonException;
}