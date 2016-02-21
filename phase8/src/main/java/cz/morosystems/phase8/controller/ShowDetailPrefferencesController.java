package cz.morosystems.phase8.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cz.morosystems.phase8.entity.AccountEntity;
import cz.morosystems.phase8.entity.BookEntity;
import cz.morosystems.phase8.entity.UserEntity;
import cz.morosystems.phase8.service.UserManager;

@Controller
@RequestMapping("/admin/detail/prefferences")
@SessionAttributes("user")
public class ShowDetailPrefferencesController {
	
	@Autowired
	private UserManager userManager;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public String submitSetPrefferencesForm(@PathVariable("userId") Integer userId, @ModelAttribute(value="prefferedAccount")AccountEntity prefferedAccount, @ModelAttribute(value="favouriteBook") BookEntity favouriteBook, @ModelAttribute(value="user") UserEntity user, BindingResult result, Model model, HttpServletRequest request, SessionStatus status) 
	{
		// user je ulozen v session
		// osetri vysledek kontroly validatoru
		if(favouriteBook.getTitle() == null) {
			result.rejectValue("favouriteBook", "error.user", "The favourite book was not selected.");
		}
		if(prefferedAccount.getName() == null) {
			result.rejectValue("prefferedAccount", "error.user", "The preffered account was not selected.");
		}
		if(result.hasErrors()) {
			model.addAttribute("bookList", user.getBooks());
			model.addAttribute("accountList", user.getAccounts());
			return "detailList";
		}
		// pridej ucet k uzivateli
		user.setPrefferedAccount(prefferedAccount);
		user.setFavouriteBook(favouriteBook);
		userManager.editUser(user);
		// ukonci update session
		status.setComplete();
		// konec
		return String.format("redirect:/admin/detail/%d", userId);
	}
}
