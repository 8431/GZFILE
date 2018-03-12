package com.gz.medicine.gzfile.filesystem.request;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by dlf on 2017/10/25 0025.
 * Email 1429264916@qq.com
 */
public class FileSystemVo {
    private String guid;//唯一ID
    private String type;//消息类型  1 txt 2file 3cf
    @NotEmpty(message="用户id不能为空")
    private String usrid;//用户id
    @NotEmpty(message="视频流唯一标识不能为空")
    private String vediouuid;//视频流唯一标识
    private String filename;//文件名
    private String filepath;//文件路径
    private String receiveid;

    //视频文件流
    private MultipartFile file;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public String getVediouuid() {
        return vediouuid;
    }

    public void setVediouuid(String vediouuid) {
        this.vediouuid = vediouuid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(String receiveid) {
        this.receiveid = receiveid;
    }
}
