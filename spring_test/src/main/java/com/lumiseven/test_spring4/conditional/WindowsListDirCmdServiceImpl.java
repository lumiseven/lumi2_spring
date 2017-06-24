package com.lumiseven.test_spring4.conditional;

public class WindowsListDirCmdServiceImpl implements ListDirCmdService{

	@Override
	public String showListDirCmd() {
		return "dir";
	}

}
