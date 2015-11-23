package com.dxj.wecard.weixin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dxj.wecard.weixin.message.response.Article;
import com.dxj.wecard.weixin.message.response.ImageMessage;
import com.dxj.wecard.weixin.message.response.ImageTextMessage;
import com.dxj.wecard.weixin.message.response.MusicMessage;
import com.dxj.wecard.weixin.message.response.TextMessage;
import com.dxj.wecard.weixin.message.response.VideoMessage;
import com.dxj.wecard.weixin.message.response.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 微信xml消息处理
 * 类WeixinXmlUtils.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年10月8日 上午9:28:18
 */
public class WeixinXmlUtils {	
	//请求消息类型
	public static final String REQUEST_MESSAGE_TYPE_TEXT="text";
	public static final String REQUEST_MESSAGE_TYPE_IMAGE="image";
	public static final String REQUEST_MESSAGE_TYPE_VOICE="voice";
	public static final String REQUEST_MESSAGE_TYPE_VODEO="vodeo";
	public static final String REQUEST_MESSAGE_TYPE_LOCATION="location";
	public static final String REQUEST_MESSAGE_TYPE_LINK="link";
	public static final String REQUEST_MESSAGE_TYPE_EVENT="event";
	//请求消息类型-事件推送
	public static final String EVENT_TYPE_SUNSCRIBE="subscribe";
	public static final String EVENT_TYPE_UNSUBSCRIBE="unsunscribe";
	public static final String EVENT_TYPE_SCAN="scan";
	public static final String EVENT_TYPE_LOCATION="LOCATION";
	public static final String EVENT_TYPE_CLICK="CLICK";
	//响应时间类型
	public static final String RESPONSE_MESSAGE_TYPE_TEXT="text";
	public static final String RESPONSE_MESSAGE_TYPE_IMAGE="image";
	public static final String RESPONSE_MESSAGE_TYPE_VOICE="voice";
	public static final String RESPONSE_MESSAGE_TYPE_VIDEO="vidoe";
	public static final String RESPONSE_MESSAGE_TYPE_MUSIC="music";
	public static final String RESPONSE_MESSAGE_TYPE_NEWS="news";
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> parseXml(HttpServletRequest request) throws Exception{
		System.out.println("进入MessageUtil");
		Map<String,String> map =new HashMap<String, String>();
		InputStream  in =request.getInputStream();
		//读取输入
		SAXReader reader=new SAXReader();
		Document document=reader.read(in);
		String pasXml=getStrFromInputSteam(in);
		
		Element root=document.getRootElement();
		//得到跟节点的所有子节点
		List<Element> elementList=root.elements();
		if(elementList!=null && elementList.size()>0){
			for(Element e:elementList){
				map.put(e.getName(), e.getTextTrim());
			}
		}
		map.put("pasXml", pasXml);
		in.close();
		in=null;
		return map;	
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> parseXmlFromStr(String xml) throws Exception{
		System.out.println("进入MessageUtil");
		Map<String,String> map =new HashMap<String, String>();
		Document doc = DocumentHelper.parseText(xml); // 将字符串转为XML
		Element root=doc.getRootElement();
		//得到跟节点的所有子节点
		List<Element> elementList=root.elements();
		if(elementList!=null && elementList.size()>0){
			for(Element e:elementList){
				map.put(e.getName(), e.getTextTrim());
			}
		}
		return map;	
	}
	/**
	 * 扩展xstream 支持CDATA
	 */
	private static XStream stream =new XStream(new XppDriver()){
		@SuppressWarnings("unused")
		public HierarchicalStreamWriter createWriter(Writer out){
			return new PrettyPrintWriter(out){
				boolean cdate=true;
				@SuppressWarnings("unchecked")
				public void startNode(String name,Class clazz){
					super.startNode(name, clazz);
				}
				protected void writeText(QuickWriter writer,String text){
					if(cdate){
						writer.write("<![CDATA[A");
						writer.write(text);
						writer.write("]]>");
					}else{
						writer.write(text);
					}
				}
			};
		}
	};
	public static String getStrFromInputSteam(InputStream in) throws IOException{  
	     BufferedReader bf=new BufferedReader(new InputStreamReader(in,"UTF-8"));  
	     //最好在将字节流转换为字符流的时候 进行转码  
	     StringBuffer buffer=new StringBuffer();  
	     String line="";  
	     while((line=bf.readLine())!=null){  
	         buffer.append(line);  
	     }  
	       
	    return buffer.toString();  
	}  
	public static String messageToXml(TextMessage textMessage){
		stream.alias("xml", textMessage.getClass());
		return stream.toXML(textMessage);
	}
	public static String messageToXml(ImageMessage imageMessage){
		stream.alias("xml", imageMessage.getClass());
		return stream.toXML(imageMessage);
	}
	public static String messageToXml(VoiceMessage voiceMessage){
		stream.alias("xml", voiceMessage.getClass());
		return stream.toXML(voiceMessage);
	}
	public static String messageToXml(VideoMessage videoMessage){
		stream.alias("xml", videoMessage.getClass());
		return stream.toXML(videoMessage);
	}
	public static String messageToXml(MusicMessage musicMessage){
		stream.alias("xml", musicMessage.getClass());
		return stream.toXML(musicMessage);
	}
	public static String messageToXml(ImageTextMessage imageTextMessage){
		stream.alias("xml", imageTextMessage.getClass());
		stream.alias("item", new Article().getClass());
		return stream.toXML(imageTextMessage);
	}
	public static void main(String[] args) {
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName("wx_dsafa");
		textMessage.setFromUserName("wxasdasdsa");
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WeixinXmlUtils.RESPONSE_MESSAGE_TYPE_TEXT);
		textMessage.setContent("from_callback");
		System.out.println(WeixinXmlUtils.messageToXml(textMessage));
	}
}
