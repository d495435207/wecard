package com.dxj.wecard.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;

public class Utils {

	static final Logger logger = LogManager.getLogger(Utils.class);

	public static Date getAddDate(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getAddDate(Date time, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date getDate(String time, String format) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			Date date = simpleDateFormat.parse(time);
			return date;
		} catch (Exception e) {
		}
		return null;
	}

	public static String getDateString(Date time, String format) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			return simpleDateFormat.format(time);
		} catch (Exception e) {
		}
		return null;
	}

	public static String uuid() {
		UUID uuid = UUID.randomUUID();
		long mostSigBits = uuid.getMostSignificantBits();
		long leastSigBits = uuid.getLeastSignificantBits();

		return (digits(mostSigBits >> 32, 8) + digits(mostSigBits >> 16, 4) + digits(mostSigBits, 4)
				+ digits(leastSigBits >> 48, 4) + digits(leastSigBits, 12));
	}

	public static boolean isInt(String number) {
		String regex = "^-?[0-9]*$";
		return pattern(number, regex);
	}

	public static boolean isDouble(String number) {
		String regex = "^-?[0-9]*.?[0-9]*$";
		return pattern(number, regex);
	}

	public static boolean isPhone(String phone) {
		String regex = "^[1][3-9]+\\d{9}$";
		return pattern(phone, regex);
	}

	public static boolean isCurrency(String charge) {
		String regex = "^[0-9]\\d*\\.?\\d*$|^0\\.\\d*[1-9]\\d*$";
		return pattern(charge, regex);
	}

	public static boolean isMail(String mail) {
		String regex = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
		return pattern(mail, regex);
	}

	public static boolean isPermitUrl(String url, String str) {
		String regex = ".*?/" + str + "/.*?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);
		return matcher.matches();
	}

	public static String getJsonResult(String res, String code, String msg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("res", res);
		map.put("code", code);
		map.put("msg", msg);
		return JSON.toJSONString(map);
	}

	public static String getJsonResult(String res, String code, String msg, String url) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("res", res);
		map.put("code", code);
		map.put("msg", msg);
		map.put("url", url);
		return JSON.toJSONString(map);
	}

	public static String verifyCode() {
		int i = (int) (Math.random() * 10000);
		String verifyCode = i + "";
		while (verifyCode.length() < 4) {
			verifyCode = "0" + verifyCode;
		}
		return verifyCode;
	}

	private static String digits(long val, int digits) {
		long hi = 1L << (digits * 4);
		return Long.toHexString(hi | (val & (hi - 1))).substring(1);
	}

	private static boolean pattern(String str, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static void main(String[] args) {
		System.out.println(isPhone("13910253932"));
		System.out.println(isPermitUrl("mang/", "mang"));
		System.out.println(isMail("13910253932@139.com"));
		String num = "-0123";
		System.out.println(isInt(num));
		System.out.println(Integer.valueOf(num));
		String d = "-.012307";
		System.out.println(isDouble(d));
		System.out.println(Double.valueOf(d));
		// Double cost=0.12455;
		// System.out.println(new BigDecimal(cost*100).setScale(0,
		// BigDecimal.ROUND_HALF_UP).intValue());
	}
}
