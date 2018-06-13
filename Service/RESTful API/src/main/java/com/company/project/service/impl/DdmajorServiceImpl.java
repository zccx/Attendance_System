package com.company.project.service.impl;

import com.company.project.dao.DdmajorMapper;
import com.company.project.model.Ddmajor;
import com.company.project.service.DdmajorService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by suIBIanTeam on 2018/06/02.
 */
@Service
@Transactional
public class DdmajorServiceImpl extends AbstractService<Ddmajor> implements DdmajorService {
    @Resource
    private DdmajorMapper ddmajorMapper;

}
