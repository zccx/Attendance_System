package com.company.project.service.impl;

import com.company.project.dao.DdroleMapper;
import com.company.project.model.Ddrole;
import com.company.project.service.DdroleService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by suIBIanTeam on 2018/06/02.
 */
@Service
@Transactional
public class DdroleServiceImpl extends AbstractService<Ddrole> implements DdroleService {
    @Resource
    private DdroleMapper ddroleMapper;

}
