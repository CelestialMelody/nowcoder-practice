package com.nowcoder.community;

import com.nowcoder.community.config.TestConfig;
import com.nowcoder.community.dao.MyBatisImpl;
import com.nowcoder.community.dao.TestDao;
import com.nowcoder.community.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

//@RunWith(SpringRunner.class)
@SpringBootTest
// ioc
@ContextConfiguration(classes = NowCoderCommunityApplication.class)
class NowCoderCommunityApplicationTests implements ApplicationContextAware {
	// 检测bean，利用setApplicationContext传入自身
	private ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appContext = applicationContext;
	}

	@Test
	public void testAppContextLoads() {
		System.out.println("Loading application context...\n");
		System.out.println(appContext);

		// ioc 利用容器获取bean
//		TestDao testdao = appContext.getBean(MyBatisImpl.class); // 使用类.class
		TestDao testdao = appContext.getBean(TestDao.class);
		// 使用接口找实现的接口类.class -> 问题 存在多个实现的类 -> 改注解: add name or @Primary
		System.out.println(testdao.Select());
		testdao = appContext.getBean("hibernate", TestDao.class); // add name
		System.out.println(testdao.Select());
	}

	@Test
	public void testBeanManager() {
		TestService testService = appContext.getBean(TestService.class);
		System.out.println(testService);

		testService = appContext.getBean(TestService.class);
		System.out.println(testService);
	}

	@Test
	public void testBeanConfig() {
		SimpleDateFormat simpleDateFormat = appContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired
	@Qualifier("hibernate")
	private TestDao testDao;

	@Autowired
	private TestService testService;

	@Autowired
	SimpleDateFormat simpleDateFormat;

	@Test
	public void testDI() {
		System.out.println(testDao);
		System.out.println(testService);
		System.out.println(simpleDateFormat.format(new Date()));
	}
}
