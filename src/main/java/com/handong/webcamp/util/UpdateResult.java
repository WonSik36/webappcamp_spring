package com.handong.webcamp.util;

public enum UpdateResult {
	OK(1,"성공"),
	ERR_UNKNOWN(-1,"서버 에러"),
	ERR_DUP_KEY(-2,"중복키 문제 발생"),
	ERR_REQUIRED(-3, "부족한 항목 존재");
	
	private final int code;
	private final String status;
	
	private UpdateResult(int code, String status) {
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
	
	public static UpdateResult valueOf(int value) {
		switch(value){
			case 1: return OK;
			case -1: return ERR_DUP_KEY;
			case -2: return ERR_REQUIRED;
			default: throw new AssertionError("Unknown value: "+value);
		}
	}
}
