package com.base;

public class DeletePet {

	private int code;
	private String message;
	private String type;
	public DeletePet() {
		// TODO Auto-generated constructor stub
	}
	public DeletePet(int code, String message, String type) {
		super();
		this.code = code;
		this.message = message;
		this.type = type;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
