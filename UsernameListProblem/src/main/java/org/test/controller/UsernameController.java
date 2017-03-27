package org.test.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.test.model.Username;
import org.test.service.UsernameService;
 
@Controller
public class UsernameController {
 
    @SuppressWarnings("unused")
	private static final Logger logger = Logger
            .getLogger(UsernameController.class);
 
    public UsernameController() {
        System.out.println("UsernameController()");
    }
 
    @Autowired
    private UsernameService usernameService;
    
    @RequestMapping(value = "/getAllUsernames", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getUsernames(Model model) {
		List<Username> listOfUsername = usernameService.getAllUsernames();
		model.addAttribute("listUsername", listOfUsername);
		return "usernames";
	}
	
	@RequestMapping(value = "/newUsername", method = RequestMethod.GET, headers = "Accept=application/json")
    public String newUsername(Model model) {
		model.addAttribute("username", new Username());
        return "username_form";
    }
	
	@RequestMapping(value = "/editUsername", method = RequestMethod.GET, headers = "Accept=application/json")
    public String editUsername(HttpServletRequest request,Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		model.addAttribute("username", usernameService.getUsername(id));
		return "username_form";
    }

	@RequestMapping(value = "/saveUsername", method = RequestMethod.POST, headers = "Accept=application/json")
	public String saveUsername(@ModelAttribute Username username, Model model) {
		Locale loc = LocaleContextHolder.getLocale();
		if(username.getId()==0) {
			int result = usernameService.addUsername(username);
			if(result == 0) {
				return "redirect:/getAllUsernames";
			} else if(result == 1) {
				List<String> suggestedUsernames = usernameService.getAllSuggestedUsernames(username.getValue(),loc);
				model.addAttribute("invalidUser", "");
				model.addAttribute("listSuggestedUSernames", suggestedUsernames);
				return "error_username";
			} else {
				model.addAttribute("invalidUser", "The username is invalid, has a Restricted Word.");
				return "error_username";
			}
		} else {	
			usernameService.updateUsername(username);
			return "redirect:/getAllUsernames";
		}
	}
	
	@RequestMapping(value = "/deleteUsername/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteUsername(@PathVariable("id") int id) {
		usernameService.deleteUsername(id);
		return "redirect:/getAllUsernames";
	}
}