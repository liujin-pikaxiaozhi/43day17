package com.liujin.pregnant.util;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext-dubbo-provider.xml")
public class TestDate {

	@Test
	public void test01() {
		String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}' ";
		Date date = new Date();
		Date dateByInitMonth = DateUtil.getDateByInitMonth(date);
		Date dateByFullMonth = DateUtil.getDateByFullMonth(date);
		
	}
	
}
