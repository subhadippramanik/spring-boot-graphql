package com.subhadip.springboot.graphql.type;

import org.springframework.stereotype.Component;

@Component
public class Blog {

	private String title;

	private String content;

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

}
