package com.dxj.wecard.weixin.qq.aes;

import java.util.ArrayList;
/**
 * 微信消息加密解密工具类
 * 类ByteGroup.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年9月29日 下午1:49:48
 */
class ByteGroup {
	ArrayList<Byte> byteContainer = new ArrayList<Byte>();

	public byte[] toBytes() {
		byte[] bytes = new byte[byteContainer.size()];
		for (int i = 0; i < byteContainer.size(); i++) {
			bytes[i] = byteContainer.get(i);
		}
		return bytes;
	}

	public ByteGroup addBytes(byte[] bytes) {
		for (byte b : bytes) {
			byteContainer.add(b);
		}
		return this;
	}

	public int size() {
		return byteContainer.size();
	}
}
