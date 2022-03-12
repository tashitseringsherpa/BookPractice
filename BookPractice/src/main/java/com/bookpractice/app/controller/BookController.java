package com.bookpractice.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookpractice.app.service.BookService;
import com.bookpractice.app.vo.BookVo;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/") // http://localhost:1234
	public String home() {
		System.out.println("IM in home.");
		return "index";
	}
	
	@GetMapping("/createBook") // http://localhost:1234/createBook
	public String crateBook() {
		System.out.println("Opening createBook.jsp");
		return "createBook";
	}
	
	@PostMapping("createBookServlet")
	// @ModelAttribut -> send to service
	public String createBookServlet(@ModelAttribute BookVo bv, Model model) {
		String message = service.createBookForm(bv);
		System.out.println("Book created");
		model.addAttribute("message",message);
		return "createBook";
	}
	
	@GetMapping("/allBooks")
	//       -> receive from service
	public String allBook(Model model) {
		List<BookVo> allBooks = service.allBook();
		model.addAttribute("books",allBooks);
		return "allBooks";
	}
	
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam int id, Model model) {
		String message= service.deleteBook(id);
		model.addAttribute("message",message);
		return "redirect:/allBooks";
	}
	
//  (GET) jsp with data -> (POST) submit updated values to service -> repo
	
	@GetMapping("/editBook") // http://localhost:1234/editBook
	public String editBook(@RequestParam int id, Model model) {
		System.out.println("Opening editBook.jsp");
		BookVo bookVo = service.findUserById(id);
		model.addAttribute("bookData", bookVo);
		System.out.println("Controller -> "+bookVo);
		return "editBook";
	}
	
	@PostMapping("/editBookServlet")
	// @ModelAttribut -> send to service
		public String editBookServlet(@ModelAttribute BookVo bv, Model model) {
			String message = service.editBookServlet(bv);
			System.out.println("Book edited");
			model.addAttribute("message",message);
			return "redirect:/allBooks";
	}
}
