package com.nowcoder.community.service;

import com.nowcoder.community.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype") // 多次创建对象；默认"single"单个实例
public class TestService {
    public TestService() {
        System.out.println("TestService 实例化");
    }

    @PostConstruct
    public void init() {
        System.out.println("TestService 初始化");
    }

    @Autowired
    private TestDao testDao;

    @PreDestroy
    public void destroy() {
        System.out.println("TestService 销毁");
    }

    public String getSelect() {
        return testDao.Select();
    }
}
