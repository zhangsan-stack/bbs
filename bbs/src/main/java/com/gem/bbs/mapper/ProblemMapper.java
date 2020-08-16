package com.gem.bbs.mapper;

import com.gem.bbs.entity.Problem;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProblemMapper {

    void insert(Problem question);

    //查询所有问题
    List<Problem> selectAll(String firsttitle);

    //查询记录总数
    Integer getTotal(@Param("firsttitle")String fristtitle);

}
