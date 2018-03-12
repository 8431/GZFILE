package com.gz.medicine.gzfile.filesystem.server.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.ftpUtil.Ftp;
import com.gz.medicine.gzfile.filesystem.mapper.BaseDaoMapper;
import com.gz.medicine.gzfile.filesystem.request.HealthyDoctorVo;
import com.gz.medicine.gzfile.filesystem.server.FileSystemService;
import com.gz.medicine.gzfile.filesystem.server.HealthDoctorService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2017/11/17 0017.
 * Email 1429264916@qq.com
 */
@Service("HealthDoctorService")
public class HealthDoctorServiceImpl implements HealthDoctorService {
    @Autowired
    BaseDaoMapper basedaomapper;
    @Autowired
    FileSystemService filesystemservice;
    public static final Logger LOGGER = Logger.getLogger(HealthDoctorServiceImpl.class);

    @Override
    public String zhuCeDoctor(HealthyDoctorVo hv) throws CommonException {
        String re = "注册失败";




        try {
            String loginSql = "insert into healthylogin(id,name,password,role)" +
                    " values(#{id},#{name},#{password},#{role})";
            String jySql = "select * from healthylogin where name=#{name}";
            //healthylogin 数据录入
            Map<String, Object> loginParam = new HashedMap();
            String loginid = UUIDTool.getUUID();//login id
            String doctorGuid = UUIDTool.getUUID();//医生guid
            loginParam.put("id", loginid);
            loginParam.put("name", hv.getName());
            loginParam.put("password", hv.getPassword());
            loginParam.put("role", "1");
            loginParam.put("sql", jySql);
            List<Map<String, Object>> jyResut = basedaomapper.QuerySql(loginParam);
            if (jyResut != null && jyResut.size() > 0) {
                throw new CommonException("该用户已存在！");
            }
            loginParam.put("sql", loginSql);
            basedaomapper.InsertSql(loginParam);
            //healthydoctor 数据录入
            String doctorSql = "insert into healthdoctor (id,loginid,name,titlecode,begood,photoid,qualificationsid,perintroduction,trainingexperience,senioritycode,phone,sex,idcard)" +
                    "values(#{id},#{loginid},#{name},#{titlecode},#{begood},#{photoid},#{qualificationsid},#{perintroduction},#{trainingexperience},#{senioritycode},#{phone},#{sex},#{idcard})";
            Map<String, Object> doctorParam = new HashedMap();
            doctorParam.put("id", doctorGuid);
            doctorParam.put("loginid", loginid);
            doctorParam.put("name", hv.getDocname());
            doctorParam.put("titlecode", hv.getTitlecode());
            doctorParam.put("begood", hv.getBegood());

            doctorParam.put("perintroduction", hv.getPerintroduction());
            doctorParam.put("trainingexperience", hv.getTrainingexperience());
            doctorParam.put("senioritycode", "003");
            doctorParam.put("phone", hv.getPhone());
            doctorParam.put("sex", hv.getSex());
            doctorParam.put("idcard", hv.getIdcard());
            //ftp上传医生头像和医生资质
            doctorParam.put("photoid", doctorGuid);
            MultipartFile mf = hv.getHeadimg();
            filesystemservice.uploadFile(mf, "/healthmanage/doctor/head2/", doctorGuid);
            List<MultipartFile> li = hv.getFile();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < li.size(); i++) {
                String zlname = UUIDTool.getUUID();
                if (i == li.size() - 1) {
                    sb.append(zlname);
                } else {
                    sb.append(zlname + ",");
                }
                filesystemservice.uploadFile(li.get(i), "/healthmanage/doctor/seniority2/", zlname);
            }
            doctorParam.put("qualificationsid", sb.toString());
            doctorParam.put("sql", doctorSql);
            basedaomapper.InsertSql(doctorParam);
            //价格表
            Map<String, Object> priceParam = new HashedMap();
            priceParam.put("docid",doctorGuid);
            priceParam.put("graphicprice",hv.getGraphicprice());
            priceParam.put("speechprice",hv.getSpeechprice());
            priceParam.put("videoprice",hv.getVideoprice());
            String pricesql="insert into healthPrice(docid, graphicprice, speechprice, videoprice)values(#{docid},#{graphicprice},#{speechprice},#{videoprice})";
            priceParam.put("sql",pricesql);
            basedaomapper.InsertSql(priceParam);
            re = "注册成功";
//
//            List<MultipartFile> li = hv.getFile();
//
//            filesystemservice.uploadFile(li.get(0), "/healthmanage/doctor/seniority/", "tttt2");

        } catch (Exception e) {
            LOGGER.error("医生注册异常");
            if (e instanceof CommonException) {
                throw new CommonException("COM001", e.getMessage(), e);
            } else {
                throw new CommonException("COM001", "医生注册异常:", e);
            }
        }
        return re;
    }

}
