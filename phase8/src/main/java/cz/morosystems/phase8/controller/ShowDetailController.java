package cz.morosystems.phase8.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import cz.morosystems.phase8.entity.BookEntity;
import cz.morosystems.phase8.entity.UserEntity;
import cz.morosystems.phase8.service.AccountManager;
import cz.morosystems.phase8.service.BookManager;
import cz.morosystems.phase8.service.UserManager;

@Controller
@RequestMapping("/admin/detail")
@SessionAttributes("user")
public class ShowDetailController {

	@Autowired
	private UserManager userManager;

	@Autowired
    private ConversionService conversionService;
	
//	@InitBinder
//	protected void initBinder(ServletRequestDataBinder binder) {
//		binder.setConversionService(conversionService);
//	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String listDetail(@PathVariable("userId") Integer userId, Model model) {
		UserEntity user = userManager.getUserWithLinks(userId);
		// nastav atributy modelu
		model.addAttribute("user", user);
		model.addAttribute("bookList", user.getBooks());
		model.addAttribute("accountList", user.getAccounts());
		model.addAttribute("favouriteBook", user.getFavouriteBook());
		model.addAttribute("prefferedAccount", user.getPrefferedAccount());
		
		return "detailList";
	}
}
