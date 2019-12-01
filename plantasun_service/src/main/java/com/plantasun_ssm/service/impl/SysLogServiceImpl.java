package com.plantasun_ssm.service.impl;

import com.plantasun_ssm.dao.ISysLogDao;
import com.plantasun_ssm.domain.SysLog;
import com.plantasun_ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
