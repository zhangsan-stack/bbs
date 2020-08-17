package com.select.service.impl;

import com.select.entity.Admin;
import com.select.mapper.AdminMapper;
import com.select.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin selectById(Integer id) {
        return adminMapper.selectById(id);


    }
}
