package com.project.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

	public String splitString(String s) {
		String result = "";
		String[] words = s.split("/");
		for(int i = 2; i>=0; i--) {
			result = result + words[i];
		}
		return result;
	}
}
