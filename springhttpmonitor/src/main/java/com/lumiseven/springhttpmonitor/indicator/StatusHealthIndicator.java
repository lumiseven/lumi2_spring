package com.lumiseven.springhttpmonitor.indicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.lumiseven.springhttpmonitor.service.StatusService;

/*
 * 定制healthindicator
 */
@Component
public class StatusHealthIndicator implements HealthIndicator{

	@Autowired
	StatusService statusService;
	
	@Override
	public Health health() {
		String status = statusService.getStatus();
		if (status == null || !status.equals("running")){
			return Health.down().withDetail("error", "not running").build();
		}
		return Health.up().build();
	}

}
