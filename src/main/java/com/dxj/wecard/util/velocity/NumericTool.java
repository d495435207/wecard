package com.dxj.wecard.util.velocity;

import org.apache.velocity.tools.config.DefaultKey;

@DefaultKey("numeric")
public class NumericTool {
	public static String toFixedCurrency(Double d) {
		if (d == null) {
			return "";
		}
		String valStr = String.format("%,.2f", d);
		return valStr;
	}
	
	public static String toFixedCurrency(Integer d) {
		if (d == null) {
			return "";
		}
		String valStr = String.format("%,d.00", d);
		return valStr;
	}
	
	public static String toFixedNumber(Double d) {
		if (d == null) {
			return "";
		}
		String valStr = String.format("%,.0f", d);
		return valStr;
	}
	
	public static String toFixedNumber(Integer d) {
		if (d == null) {
			return "";
		}
		String valStr = String.format("%,d", d);
		return valStr;
	}

	public static void main(String[] args) {
//		System.out.println(NumericTool.toFixedNumber(1000005.623D));
//		System.out.println(NumericTool.toFixedNumber(1000005));
//		System.out.println(NumericTool.toFixedCurrency(1000005.623D));
//		System.out.println(NumericTool.toFixedCurrency(1000005));
		System.out.println((int)(Double.parseDouble("12.345678")*100));
	}
}