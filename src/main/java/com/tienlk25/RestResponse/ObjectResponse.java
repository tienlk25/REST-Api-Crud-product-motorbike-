package com.tienlk25.RestResponse;

import java.util.List;

import javax.management.loading.PrivateClassLoader;

import com.tienlk25.controller.VariantRestController;
import com.tienlk25.entity.Variants;

//public class ObjectResponse {
//
//	private String status;
//	private String message;
//	private Object object; 
////	private final List<Object> objects;
//	
//	public ObjectResponse(Object object2) {
//		this.object = object2;
//	}
//
//
//	public Object getObject() {
//		return object;
//	}
//
//
//	public void setObject(Object object) {
//		this.object = object;
//	}
//	
//	public static ObjectResponse success(String message) {
//		ObjectResponse response = new ObjectResponse();
//		response.setStatus("success");
//		response.setMessage(message);
//		
//		return response;
//	}
//	
//	public static ObjectResponse success(Object object) {
//		ObjectResponse objectResponse = new ObjectResponse(object);
//		
//		return objectResponse;
//	}
//
//
//	// thông báo dăng kí không thành công
//	
//	public static ObjectResponse failed(String message) {
//		ObjectResponse response = new ObjectResponse();
//		response.setStatus("failed");
//		response.setMessage(message);
//		return response;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//}
