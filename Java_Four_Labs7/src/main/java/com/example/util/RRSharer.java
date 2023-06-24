package com.example.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RRSharer {
	private static Map<Long, HttpServletRequest> reqs = new HashMap<>();
	private static Map<Long, HttpServletResponse> resqs = new HashMap<>();

	public static void add(HttpServletRequest req, HttpServletResponse resp) {
		reqs.put(Thread.currentThread().getId(), req);
		resqs.put(Thread.currentThread().getId(), resp);
	}

	public static void remove() {
		reqs.remove(Thread.currentThread().getId());
		resqs.remove(Thread.currentThread().getId());
	}

	public static HttpServletRequest request() {
		return reqs.get(Thread.currentThread().getId());
	}

	public static HttpServletResponse response() {
		return resqs.get(Thread.currentThread().getId());
	}
}
