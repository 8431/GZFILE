package com.gz.medicine.gzfile.filesystem.server;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzfile.filesystem.request.HealthyDoctorVo;

/**
 * Created by dlf on 2017/11/17 0017.
 * Email 1429264916@qq.com
 */
public interface HealthDoctorService {
    /**
     * 注册医生
     * @param hv
     * @return
     * @throws CommonException
     */
    String zhuCeDoctor(HealthyDoctorVo hv) throws CommonException;
}
