package cz.morosystems.phase8.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import cz.morosystems.phase8.entity.BookEntity;
import cz.morosystems.phase8.entity.UserEntity;
import cz.morosystems.phase8.service.AccountManager;
import cz.morosystems.phase8.service.BookManager;
import cz.morosystems.phase8.service.UserManager;

@Controller
@RequestMapping("/admin/detail/book")
public class ShowDetailBookController {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private BookManager bookManager;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/add/{userId}", method = RequestMethod.GET)
	public String initAddBookForm(@PathVariable("userId") Integer userId, Model model) 
	{
		model.addAttribute("user", userManager.getUser(userId));
		model.addAttribute("book", new BookEntity());
		return "addBook";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/add/{userId}", method = RequestMethod.POST)
	public String submitAddBookForm(@PathVariable("userId") Integer userId, @ModelAttribute(value="book")@Valid BookEntity book, BindingResult addBookFormBindingResult, Model model) 
	{
		// osetri vysledek kontroly validatoru
		if(addBookFormBindingResult.hasErrors()) {
			model.addAttribute("user",userManager.getUser(userId));
			return "addBook";
		}
		// pridej knihu k uzivateli
		UserEntity user = userManager.getUserWithLinks(userId);
		user.getBooks().add(book);
		userManager.editUser(user);
		return String.format("redirect:/admin/detail/%d", userId);
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/edit/{userId}/{bookId}", method = RequestMethod.GET)
	public String initEditBookForm(@PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId, Model model) 
	{
		UserEntity user = userManager.getUser(userId);
		model.addAttribute("user", user);
		model.addAttribute("book", bookManager.getBook(bookId));
		return "editBook";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/edit/{userId}/{bookId}", method = RequestMethod.POST)
	public String submitEditBookForm(@PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId, @ModelAttribute(value="book")@Valid BookEntity book, BindingResult editBookFormBindingResult, Model model) 
	{
		// osetri vysledek kontroly validatoru
		if(editBookFormBindingResult.hasErrors()) {
			model.addAttribute("user", userManager.getUser(userId));
			return "editBook";
		}
		// pridej uzivatele
		bookManager.editBook(book);
		return String.format("redirect:/admin/detail/%d", userId);
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete/{userId}/{bookId}")
	public String deleteBook(@PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId)
	{
		bookManager.deleteBook(bookId);
		return String.format("redirect:/admin/detail/%d", userId);
	}

	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}
}
