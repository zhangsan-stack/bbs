package com.gem.bbs.service.impl;

import com.gem.bbs.entity.Likes;
import com.gem.bbs.mapper.LikesMapper;
import com.gem.bbs.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private LikesMapper likesMapper;


    @Override
    public void insert(Likes likes){
        likesMapper.insert(likes);
    }
}
