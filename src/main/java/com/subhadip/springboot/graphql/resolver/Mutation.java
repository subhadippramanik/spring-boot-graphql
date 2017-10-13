package com.subhadip.springboot.graphql.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.subhadip.springboot.graphql.type.Blog;

@Component
public class Mutation implements GraphQLMutationResolver {

	public Blog createBlog(String title, String content) {
		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setContent(content);
		return blog;
	}
}
