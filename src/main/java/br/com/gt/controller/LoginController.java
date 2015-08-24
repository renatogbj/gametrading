package br.com.gt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
    private Facebook facebook;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView helloFacebookSuccess(Model model) {
    	if (!facebook.isAuthorized()) {
    		return new ModelAndView("redirect:/");
    	}
    	
    	String name = facebook.userOperations().getUserProfile().getName();
    	
    	System.out.println("Hello, " + facebook.userOperations().getUserProfile().getName());
    	
    	return new ModelAndView("forward:/index.html", "name", name);
    }
	
}