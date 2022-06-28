package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MyBatisImpl implements TestDao{
    @Override
    public String Select() {
        return "MyBatis Selected";
    }
}
