package com.lumiseven.test_spring4.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod")
public class DemoBeanIntegrationTests {
	
	@Autowired
	private TestBean testBean;
	
	@Test
	public void productionBeanInject(){
		String expectedString = "from prodTestBean profile";
		String actualString = testBean.getTestContent();
		Assert.assertEquals(expectedString, actualString);
	}

}
