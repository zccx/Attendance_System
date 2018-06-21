package com.company.project.service.impl;

import com.company.project.dao.DdstateMapper;
import com.company.project.model.Ddstate;
import com.company.project.service.DdstateService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by suIBIanTeam on 2018/06/07.
 */
@Service
@Transactional
public class DdstateServiceImpl extends AbstractService<Ddstate> implements DdstateService {
    @Resource
    private DdstateMapper ddstateMapper;

}
