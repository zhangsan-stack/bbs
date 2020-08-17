package com.select.service.impl;

import com.select.entity.Test;
import com.select.mapper.TestMapper;
import com.select.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public void insert(Test test) {
        System.out.println(test);
        testMapper.insert(test);
    }
}
