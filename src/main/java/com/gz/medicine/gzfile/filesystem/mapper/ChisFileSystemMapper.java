/*
* ChisFileSystemMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-25
*/
package com.gz.medicine.gzfile.filesystem.mapper;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.gzfile.filesystem.bean.ChisFileSystem;

import java.util.List;
import java.util.Map;

public interface ChisFileSystemMapper {


    /**
     *  动态字段,写入数据库记录:CHIS_FILE_SYSTEM
     *
     * @param record
     */
    int insertSelective(ChisFileSystem record);

    /**
     *  根据指定主键获取一条数据库记录:CHIS_FILE_SYSTEM
     *
     * @param guid
     */

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:CHIS_FILE_SYSTEM
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ChisFileSystem record);

    /**
     * 获取视频文件列表
     * @param p
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> queryPageVedioList(Page p)throws  Exception;
}