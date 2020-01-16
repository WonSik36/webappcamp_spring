package com.handong.webcamp.util;

public enum ServiceResult {
	OK(1,"성공"),
	ERR_DUP_PRM_KEY(-1,"중복키 문제 발생"),
	ERR_REQUIRED(-2, "부족한 항목 존재");
	
	private final int code;
	private final String status;
	
	private ServiceResult(int code, String status) {
		this.code = code;
		this.status = status;
	}
	
	public int code() {
		return code;
	}
	
	public String status() {
		return status;
	}
	
	public boolean isOK() {
		return this.code==1?true:false;
	}
	
	public static ServiceResult valueOf(int value) {
		switch(value){
			case 1: return OK;
			case -1: return ERR_DUP_PRM_KEY;
			case -2: return ERR_REQUIRED;
			default: throw new AssertionError("Unknown value: "+value);
		}
	}
}
