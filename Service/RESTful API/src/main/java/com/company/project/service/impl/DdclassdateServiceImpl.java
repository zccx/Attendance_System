package com.company.project.service.impl;

import com.company.project.dao.DdclassdateMapper;
import com.company.project.model.Ddclassdate;
import com.company.project.service.DdclassdateService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by suIBIanTeam on 2018/06/02.
 */
@Service
@Transactional
public class DdclassdateServiceImpl extends AbstractService<Ddclassdate> implements DdclassdateService {
    @Resource
    private DdclassdateMapper ddclassdateMapper;

}
