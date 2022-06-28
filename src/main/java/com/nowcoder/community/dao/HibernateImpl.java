package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository( "hibernate")
public class HibernateImpl implements TestDao {
    @Override
    public String Select() {
        return "Hibernate Selected";
    }
}
