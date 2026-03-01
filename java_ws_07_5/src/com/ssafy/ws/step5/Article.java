package com.ssafy.ws.step5;

import java.util.Date;

public class Article {

	protected int articleId;
	protected String title;
	protected String content;
	protected int userSeq;
	protected int viewCnt;
	protected Date regDate;

	public Article() {
		this.regDate = new Date();
	}

	public Article(int articleId, String title, String content, int userSeq) {
		this.articleId = articleId;
		this.title = title;
		this.content = content;
		this.userSeq = userSeq;
		this.viewCnt = 0;
		this.regDate = new Date();
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Article [id=" + articleId + ", title=" + title + ", userSeq=" + userSeq + ", views=" + viewCnt + "]";
	}
}