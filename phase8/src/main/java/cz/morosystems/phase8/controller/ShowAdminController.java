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
import cz.morosystems.phase8.entity.AdminEntity;
import cz.morosystems.phase8.entity.LoginEntity;
import cz.morosystems.phase8.service.AdminManager;

@Controller
@RequestMapping("/admin/administrator")
public class ShowAdminController {
	
	@Autowired
	private AdminManager adminManager;

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listAdmins(Model model) 
	{
		model.addAttribute("adminList", adminManager.getAllAdmins());
		return "adminList";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String initAddAdminForm(Model model) 
	{
		model.addAttribute("login", new LoginEntity());
		return "editAdmin";
	}
	
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitAddAdminForm(@ModelAttribute(value="login")@Valid LoginEntity login, BindingResult loginResult) 
	{
		if (!(login.getPassword().equals(login.getConfirmPassword()))) {
			loginResult.rejectValue("password", "password.notmatch");
		}
		// osetri vysledek kontroly validatoru
		if(loginResult.hasErrors()) {
			return "editAdmin";
		}
		// pridej administratora
		if (login.getId() == null) {
			adminManager.addAdmin(new AdminEntity(login));
		} else {
			adminManager.editAdmin(new AdminEntity(login));
		}
		return "redirect:/admin/administrator/";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete/{adminId}")
	public String deleteAdmin(@PathVariable("adminId") Integer adminId)
	{
		adminManager.deleteAdmin(adminId);
		return "redirect:/admin/administrator";
	}

	public AdminManager getAdminManager() {
		return adminManager;
	}

	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}
}
