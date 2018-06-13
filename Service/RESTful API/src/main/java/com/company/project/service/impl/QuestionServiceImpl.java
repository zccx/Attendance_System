package com.company.project.service.impl;

import com.company.project.dao.QuestionMapper;
import com.company.project.model.Question;
import com.company.project.service.QuestionService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by suIBIanTeam on 2018/06/02.
 */
@Service
@Transactional
public class QuestionServiceImpl extends AbstractService<Question> implements QuestionService {
    @Resource
    private QuestionMapper questionMapper;

}
