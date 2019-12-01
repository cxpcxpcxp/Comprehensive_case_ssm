package com.plantasun_ssm.service;

import com.plantasun_ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {
        public void save(SysLog sysLog);
        public List<SysLog> findAll();
}
