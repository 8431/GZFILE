/*
* ChisFileSystem.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-25
*/
package com.gz.medicine.gzfile.filesystem.bean;

import java.util.Date;

/**
 * @Title CHIS_FILE_SYSTEM表的实体类
 * @Description webrtc视频流存储表
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-25 14:14:45
 */
public class ChisFileSystem {
    /**
     * @Fields guid 主键
     */
    private String guid;

    /**
     * @Fields org 组织号
     */
    private String org;

    /**
     * @Fields usrid 用户guid
     */
    private String usrid;

    /**
     * @Fields vediouuid 视频集合唯一标识
     */
    private String vediouuid;

    /**
     * @Fields createdate 创建时间
     */
    private Date createdate;

    /**
     * @Fields filename 文件名
     */
    private String filename;

    /**
     * @Fields filepath 文件路径
     */
    private String filepath;

    /**
     * @Fields type 文件类型
     */
    private String type;
    /**
     * @Fields receiveid 视频接收放id
     */
    private String receiveid;

    /**
     * 获取 主键 字段:CHIS_FILE_SYSTEM.GUID
     *
     * @return CHIS_FILE_SYSTEM.GUID, 主键
     */
    public String getGuid() {
        return guid;
    }

    /**
     * 设置 主键 字段:CHIS_FILE_SYSTEM.GUID
     *
     * @param guid the value for CHIS_FILE_SYSTEM.GUID, 主键
     */
    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    /**
     * 获取 组织号 字段:CHIS_FILE_SYSTEM.ORG
     *
     * @return CHIS_FILE_SYSTEM.ORG, 组织号
     */
    public String getOrg() {
        return org;
    }

    /**
     * 设置 组织号 字段:CHIS_FILE_SYSTEM.ORG
     *
     * @param org the value for CHIS_FILE_SYSTEM.ORG, 组织号
     */
    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    /**
     * 获取 用户guid 字段:CHIS_FILE_SYSTEM.USRID
     *
     * @return CHIS_FILE_SYSTEM.USRID, 用户guid
     */
    public String getUsrid() {
        return usrid;
    }

    /**
     * 设置 用户guid 字段:CHIS_FILE_SYSTEM.USRID
     *
     * @param usrid the value for CHIS_FILE_SYSTEM.USRID, 用户guid
     */
    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    /**
     * 获取 视频集合唯一标识 字段:CHIS_FILE_SYSTEM.VEDIOUUID
     *
     * @return CHIS_FILE_SYSTEM.VEDIOUUID, 视频集合唯一标识
     */
    public String getVediouuid() {
        return vediouuid;
    }

    /**
     * 设置 视频集合唯一标识 字段:CHIS_FILE_SYSTEM.VEDIOUUID
     *
     * @param vediouuid the value for CHIS_FILE_SYSTEM.VEDIOUUID, 视频集合唯一标识
     */
    public void setVediouuid(String vediouuid) {
        this.vediouuid = vediouuid == null ? null : vediouuid.trim();
    }

    /**
     * 获取 创建时间 字段:CHIS_FILE_SYSTEM.CREATEDATE
     *
     * @return CHIS_FILE_SYSTEM.CREATEDATE, 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 创建时间 字段:CHIS_FILE_SYSTEM.CREATEDATE
     *
     * @param createdate the value for CHIS_FILE_SYSTEM.CREATEDATE, 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 文件名 字段:CHIS_FILE_SYSTEM.FILENAME
     *
     * @return CHIS_FILE_SYSTEM.FILENAME, 文件名
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 设置 文件名 字段:CHIS_FILE_SYSTEM.FILENAME
     *
     * @param filename the value for CHIS_FILE_SYSTEM.FILENAME, 文件名
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * 获取 文件路径 字段:CHIS_FILE_SYSTEM.FILEPATH
     *
     * @return CHIS_FILE_SYSTEM.FILEPATH, 文件路径
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * 设置 文件路径 字段:CHIS_FILE_SYSTEM.FILEPATH
     *
     * @param filepath the value for CHIS_FILE_SYSTEM.FILEPATH, 文件路径
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    /**
     * 获取 文件类型 字段:CHIS_FILE_SYSTEM.TYPE
     *
     * @return CHIS_FILE_SYSTEM.TYPE, 文件类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 文件类型 字段:CHIS_FILE_SYSTEM.TYPE
     *
     * @param type the value for CHIS_FILE_SYSTEM.TYPE, 文件类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(String receiveid) {
        this.receiveid = receiveid;
    }


}