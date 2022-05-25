package com.choong.spr.controller.ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choong.spr.domain.ex02.Book;

@Controller
@RequestMapping("ex02")
public class Ex02Controller {

	@RequestMapping("sub01")
	public String method01() {
		
		return "hello";
	}
	
	@RequestMapping("sub02")
	@ResponseBody
	public String method02() {
		
		return "hello";
	}
	
	@RequestMapping("sub03")
	@ResponseBody
	public String method03() {
		
		
		
		return "{\"title\":\"java\", \"writer\":\"son\"}";
	}
	
	@RequestMapping("sub04")
	@ResponseBody
	public Book method04() { // java Object(Book) -> json string으로 변환 
		Book b = new Book();
		b.setTitle("spring");
		b.setWriter("son");
		
		return b;
	}
	
	
	@RequestMapping("sub05")
	public String method05() {
		return "/ex03/sub01";
	}
	
	@PostMapping("sub06")
	public String method06() {
		return "ex03/sub01";
	}
	
	
}

























