package cz.morosystems.phase8.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.morosystems.phase8.entity.AccountEntity;
import cz.morosystems.phase8.entity.UserEntity;
import cz.morosystems.phase8.service.AccountManager;
import cz.morosystems.phase8.service.UserManager;

@Controller
@RequestMapping("/admin/detail/account")
public class ShowDetailAccountController {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private AccountManager accountManager;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/add/{userId}", method = RequestMethod.GET)
	public String initAddAccountForm(@PathVariable("userId") Integer userId, Model model) 
	{
		model.addAttribute("user", userManager.getUser(userId));
		model.addAttribute("account", new AccountEntity());
		return "addAccount";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/add/{userId}", method = RequestMethod.POST)
	public String submitAddAccountForm(@PathVariable("userId") Integer userId, @ModelAttribute(value="account")@Valid AccountEntity account, BindingResult addAccountFormBindingResult, Model model) 
	{
		// osetri vysledek kontroly validatoru
		if(addAccountFormBindingResult.hasErrors()) {
			model.addAttribute("user", userManager.getUser(userId));
			return "addAccount";
		}
		// pridej ucet k uzivateli
		UserEntity user = userManager.getUserWithLinks(userId);
		user.getAccounts().add(account);
		userManager.editUser(user);
		return String.format("redirect:/admin/detail/%d", userId);
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/edit/{userId}/{accountId}", method = RequestMethod.GET)
	public String initEditAccountForm(@PathVariable("userId") Integer userId, @PathVariable("accountId") Integer accountId, Model model) 
	{
		model.addAttribute("user", userManager.getUser(userId));
		model.addAttribute("account", accountManager.getAccount(accountId));
		return "editAccount";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/edit/{userId}/{accountId}", method = RequestMethod.POST)
	public String submitEditAccountForm(@PathVariable("userId") Integer userId, @PathVariable("accountId") Integer accountId, @ModelAttribute(value="account")@Valid AccountEntity account, BindingResult editAccountFormBindingResult, Model model) 
	{
		// osetri vysledek kontroly validatoru
		if(editAccountFormBindingResult.hasErrors()) {
			model.addAttribute("user", userManager.getUser(userId));
			return "editAccount";
		}
		// edituj ucet
		accountManager.editAccount(account);
		return String.format("redirect:/admin/detail/%d", userId);
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete/{userId}/{accountId}")
	public String deleteAccount(@PathVariable("userId") Integer userId, @PathVariable("accountId") Integer accountId)
	{
		accountManager.deleteAccount(accountId);
		return String.format("redirect:/admin/detail/%d", userId);
	}

	public AccountManager getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
}
