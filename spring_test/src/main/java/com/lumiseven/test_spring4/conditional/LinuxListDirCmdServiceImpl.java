package com.lumiseven.test_spring4.conditional;

public class LinuxListDirCmdServiceImpl implements ListDirCmdService{

	@Override
	public String showListDirCmd() {
		return "ls";
	}

}
