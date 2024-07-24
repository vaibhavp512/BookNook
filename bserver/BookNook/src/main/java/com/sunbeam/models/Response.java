package com.sunbeam.models;

import java.util.Map;
import java.util.HashMap;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
	public static ResponseEntity<?> success(Object data) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", "success");
		if(data != null)
			map.put("data", data);
		return ResponseEntity.ok(map);
	}
	
	public static ResponseEntity<?> error(Object err) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", "error");
		if(err != null)
			map.put("error", err);
		return ResponseEntity.ok(map);
	}
	
	public static ResponseEntity<?> other(Object other) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", "other");
		if(other != null)
			map.put("other", other);
		return ResponseEntity.ok(map);
	}
	
	public static ResponseEntity<?> status(HttpStatus status) {
		return ResponseEntity.status(status).build();
	}
}
