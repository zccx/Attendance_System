package com.company.project.service.impl;

import com.company.project.dao.CalltherollMapper;
import com.company.project.model.Calltheroll;
import com.company.project.service.CalltherollService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by suIBIanTeam on 2018/06/02.
 */
@Service
@Transactional
public class CalltherollServiceImpl extends AbstractService<Calltheroll> implements CalltherollService {
    @Resource
    private CalltherollMapper calltherollMapper;

}
