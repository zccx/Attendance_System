package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Ddmajor;
import com.company.project.service.DdmajorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by suIBIanTeam on 2018/06/02.
*/
@RestController
@RequestMapping("/ddmajor")
public class DdmajorController {
    @Resource
    private DdmajorService ddmajorService;

    @PostMapping("/add")
    public Result add(Ddmajor ddmajor) {
        ddmajorService.save(ddmajor);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        ddmajorService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Ddmajor ddmajor) {
        ddmajorService.update(ddmajor);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Ddmajor ddmajor = ddmajorService.findById(id);
        return ResultGenerator.genSuccessResult(ddmajor);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Ddmajor> list = ddmajorService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
