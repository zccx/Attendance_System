package com.company.project.service.impl;

import com.company.project.dao.MarkMapper;
import com.company.project.model.Mark;
import com.company.project.service.MarkService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by suIBIanTeam on 2018/06/07.
 */
@Service
@Transactional
public class MarkServiceImpl extends AbstractService<Mark> implements MarkService {
    @Resource
    private MarkMapper markMapper;

}
