package com.restapi.tutorial;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BookResponse {
    public Map<String, Object> successResponse(String message, Object data) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("success", "true");
        map.put("data", data == null ? null : data);
        map.put("message", message);
        return map;
    }

    public Map<String, Object> errorResponse(String message) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("success", "false");
        map.put("message", message);
        return map;
    }
}
