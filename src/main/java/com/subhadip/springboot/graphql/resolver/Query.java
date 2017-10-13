package com.subhadip.springboot.graphql.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import com.subhadip.springboot.graphql.type.Blog;

@Component
public class Query implements GraphQLQueryResolver{
	
	public List<Blog> getAllBlogs() {
		Blog blog = new Blog();
		blog.setTitle("Hello World");
		blog.setContent("First GraphQL example");
		return Lists.newArrayList(blog);
	}

}
