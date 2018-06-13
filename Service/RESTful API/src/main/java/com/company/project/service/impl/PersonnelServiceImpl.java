package com.company.project.service.impl;

import com.company.project.dao.PersonnelMapper;
import com.company.project.model.Personnel;
import com.company.project.service.PersonnelService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by suIBIanTeam on 2018/06/02.
 */
@Service
@Transactional
public class PersonnelServiceImpl extends AbstractService<Personnel> implements PersonnelService {
    @Resource
    private PersonnelMapper personnelMapper;

}
