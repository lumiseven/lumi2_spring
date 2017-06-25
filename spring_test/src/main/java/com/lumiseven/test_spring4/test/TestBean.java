package com.lumiseven.test_spring4.test;

public class TestBean {
	
	public TestBean(String testContent){
		super();
		this.testContent = testContent;
	}
	
	private String testContent;

	public String getTestContent() {
		return testContent;
	}

	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}

}
