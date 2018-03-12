package com.gz.medicine.gzfile.filesystem.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzfile.filesystem.request.FileSystemVo;
import com.gz.medicine.gzfile.filesystem.request.HealthyDoctorVo;
import com.gz.medicine.gzfile.filesystem.server.FileSystemService;

import com.gz.medicine.gzfile.filesystem.server.HealthDoctorService;
import com.gz.medicine.gzfile.filesystem.server.VedioSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validator;


import java.util.concurrent.Callable;

import static com.gz.medicine.common.util.ValidateWithException.validates;

/**
 * Created by Administrator on 2017/9/21 0021.
 */
@RestController
@RequestMapping("/v1/file/")
public class FileSystemController {

    @Autowired
    Validator validator;
    @Autowired
    FileSystemService filesystemservice;
    @Autowired
    VedioSystemService vediosystemservice;
    @Autowired
    HealthDoctorService healthdoctorservice;
    private int i=0;

    //上传文件
    @RequestMapping(value = "/uploadVedioBy", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Callable<SimpleResult> uploadVedioBy(final FileSystemVo page) {

        Callable<SimpleResult> callable = new Callable<SimpleResult>() {
            @Override
            public SimpleResult call() throws Exception {
                SimpleResult sr = null;
                String result = validates(validator, page);
                if (result != null) {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), result);
                }
                try {
                    filesystemservice.uploadVedioBy(page);
                    sr = SimpleResult.success();
                } catch (CommonException e) {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
                }
                return sr;
            }
        };
        return callable;
    }

    //获取文件列表
    @RequestMapping(value = "/queryVedio", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Callable<SimpleResult> queryVedio(final PageModel p) {
        Callable<SimpleResult> callable = new Callable<SimpleResult>() {
            @Override
            public SimpleResult call() throws Exception {
                SimpleResult sr = null;
                try {
                  //  Page pg = vediosystemservice.queryPageVedioList(p);
                    sr = SimpleResult.success();
                  //  sr.put("data", pg);
                    Thread.sleep(2000);
                    i++;
                    sr.put("num", i);
                } catch (Exception e) {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
                }
                return sr;
            }
        };
        return callable;
    }

    /***********************************医生注册*************************************/
    //医生注册
    @RequestMapping(value = "/zhuceDoctor", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Callable<SimpleResult> zhuceDoctor(final HealthyDoctorVo hv) {
        Callable<SimpleResult> callable = new Callable<SimpleResult>() {
            @Override
            public SimpleResult call() throws Exception {
                SimpleResult sr = null;
                try {
                    String re = healthdoctorservice.zhuCeDoctor(hv);
                    sr=SimpleResult.success();

                    sr.put("data", re);

                } catch (CommonException e) {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
                }
                return sr;
            }
        };
        return callable;
    }

}

