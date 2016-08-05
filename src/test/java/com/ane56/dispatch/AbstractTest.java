package com.ane56.dispatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ane56.bi.config.ApplicationConfig;
import com.ane56.bi.config.DatabaseConfig;
import com.ane56.bi.config.DomainConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class, DomainConfig.class, 
		ApplicationConfig.class })
public class AbstractTest {

	@Test
	public void testAll() {
	}

}
