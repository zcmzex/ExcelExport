package cn.zhangcm.utils;

import java.util.Arrays;

public class Constant {
	public static final String CURRENT_USER = "current_user";
	public static final String CURRENT_QUESTION = "current_question";
	public static final String CURRENT_STUDENT = "current_student";
	public static final String CURRENT_EXAM = "current_exam";

	public static String join(String[] strs) {
		if (strs.length == 0) {
			return null;
		}
		String s = Arrays.toString(strs);
		return s.substring(1, s.length() - 1);

	}
}
