package com.lumiseven.springhttpmonitor.service;

import org.springframework.stereotype.Service;

/*
 * 仅为测试改变status的值
 */
@Service
public class StatusService {
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
