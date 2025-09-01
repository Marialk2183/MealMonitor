package com.MealMonitor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class MealMonitorApplicationTests {

	@Test
	void contextLoads() {
		// Test that the application context loads successfully
	}

	@Test
	void testApplicationStartup() {
		// Test that the application can start up
		MealMonitorApplication.main(new String[]{});
	}
}
