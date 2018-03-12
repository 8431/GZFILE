package com.gz.medicine.gzfile.filesystem.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by dlf on 2017/10/25 0025.
 * Email 1429264916@qq.com
 */
public class HealthyDoctorVo {
    @NotEmpty(message = "账号不能为空")
    private String name;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "姓名不能为空")
    private String docname;
    @NotEmpty(message = "titlecode不能为空")
    private String titlecode;
    @NotEmpty(message = "擅长不能为空")
    private String begood;
    private String photoid;
    private String qualificationsid;
    @NotEmpty(message = "个人介绍不能为空")
    private String perintroduction;
    @Length(min=10,message = "培训经验不能为空,必须大于10个子")
    private String trainingexperience;
    private String senioritycode;
    @NotEmpty(message = "图文价格不能为空")
    private String graphicprice;
    @NotEmpty(message = "语音价格不能为空")
    private String speechprice;
    @NotEmpty(message = "视屏价格不能为空")
    private String videoprice;
    @NotEmpty(message = "手机号不能为空")
    private String phone;
    @NotEmpty(message = "性别不能为空")
    private String sex;
    @NotEmpty(message = "身份证不能为空")
    private String idcard;
    //资质图片
    private List<MultipartFile> file;
    //医生头像
    private MultipartFile headimg;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public List<MultipartFile> getFile() {
        return file;
    }

    public void setFile(List<MultipartFile> file) {
        this.file = file;
    }

    public String getTitlecode() {
        return titlecode;
    }

    public void setTitlecode(String titlecode) {
        this.titlecode = titlecode;
    }

    public String getBegood() {
        return begood;
    }

    public void setBegood(String begood) {
        this.begood = begood;
    }

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    public String getQualificationsid() {
        return qualificationsid;
    }

    public void setQualificationsid(String qualificationsid) {
        this.qualificationsid = qualificationsid;
    }

    public String getPerintroduction() {
        return perintroduction;
    }

    public void setPerintroduction(String perintroduction) {
        this.perintroduction = perintroduction;
    }

    public String getTrainingexperience() {
        return trainingexperience;
    }

    public MultipartFile getHeadimg() {
        return headimg;
    }

    public void setHeadimg(MultipartFile headimg) {
        this.headimg = headimg;
    }

    public void setTrainingexperience(String trainingexperience) {
        this.trainingexperience = trainingexperience;
    }

    public String getSenioritycode() {
        return senioritycode;
    }

    public void setSenioritycode(String senioritycode) {
        this.senioritycode = senioritycode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGraphicprice() {
        return graphicprice;
    }

    public void setGraphicprice(String graphicprice) {
        this.graphicprice = graphicprice;
    }

    public String getSpeechprice() {
        return speechprice;
    }

    public void setSpeechprice(String speechprice) {
        this.speechprice = speechprice;
    }

    public String getVideoprice() {
        return videoprice;
    }

    public void setVideoprice(String videoprice) {
        this.videoprice = videoprice;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
