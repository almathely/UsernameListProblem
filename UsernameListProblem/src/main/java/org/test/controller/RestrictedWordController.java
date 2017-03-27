package org.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
 
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.test.model.RestrictedWord;
import org.test.service.RestrictedWordService;
 
@Controller
public class RestrictedWordController {
 
    @SuppressWarnings("unused")
	private static final Logger logger = Logger
            .getLogger(RestrictedWordController.class);
 
    public RestrictedWordController() {
        System.out.println("RestrictedWordController()");
    }
 
    @Autowired
    private RestrictedWordService restrictedWordService;
    
    @RequestMapping(value = "/getAllRestrictedWords", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCountries(Model model) {
		List<RestrictedWord> listOfRestrictedWord = restrictedWordService.getAllRestrictedWords();
		model.addAttribute("listRestrictedWord", listOfRestrictedWord);
		return "restricted_words";
	}
	
	@RequestMapping(value = "/newRestrictedWord", method = RequestMethod.GET, headers = "Accept=application/json")
    public String newRestrictedWord(Model model) {
		model.addAttribute("restrictedWord", new RestrictedWord());
        return "restricted_word_form";
    }
	
	@RequestMapping(value = "/editRestrictedWord", method = RequestMethod.GET, headers = "Accept=application/json")
    public String editRestrictedWord(HttpServletRequest request,Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		model.addAttribute("restrictedWord", this.restrictedWordService.getRestrictedWord(id));
		return "restricted_word_form";
    }

	@RequestMapping(value = "/saveRestrictedWord", method = RequestMethod.POST, headers = "Accept=application/json")
	public String saveRestrictedWord(@ModelAttribute RestrictedWord restrictedWord) {	
		if(restrictedWord.getId()==0) {
			restrictedWordService.addRestrictedWord(restrictedWord);
		} else {	
			restrictedWordService.updateRestrictedWord(restrictedWord);
		}
		return "redirect:/getAllRestrictedWords";
	}
	
	@RequestMapping(value = "/deleteRestrictedWord/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteRestrictedWord(@PathVariable("id") int id) {
		restrictedWordService.deleteRestrictedWord(id);
		return "redirect:/getAllRestrictedWords";
	}
}