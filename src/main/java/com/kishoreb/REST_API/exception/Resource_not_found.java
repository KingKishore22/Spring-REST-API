package com.kishoreb.REST_API.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class Resource_not_found extends RuntimeException {

	public static final long serialVersionUID=1L;
	String resource_name;
	String  field_name;
	Object msg;
	public Resource_not_found(String resource_name, String field_name, Object msg) {
		super(String.format("%s not found with %s:%s",resource_name,field_name,msg));
		this.resource_name = resource_name;
		this.field_name = field_name;
		this.msg = msg;
	}
	
	
	
}
