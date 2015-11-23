package com.dxj.wecard.weixin.message.response;

import java.util.List;

/**
 * 平台推送消息给微信用户图文消息
 * 类ImageTextMessage.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年9月29日 上午11:43:56
 */
public class ImageTextMessage extends BaseMessage {
	private int ArticleCount;
	private List<Article> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}
