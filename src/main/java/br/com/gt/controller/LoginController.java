package br.com.gt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gt.model.bean.Usr;

@RestController
public class LoginController {

	@Autowired
    private Facebook facebook;

    @RequestMapping(value = "/home/user", method = RequestMethod.GET)
    public Usr helloFacebookSuccess() {
    	Usr user = new Usr();
    	
    	if (!facebook.isAuthorized()) {
    		user.setName("");
    		return user;
    	}
    	
    	String name = facebook.userOperations().getUserProfile().getName();
    	String email = facebook.userOperations().getUserProfile().getEmail();
//    	byte[] avatar = facebook.userOperations().getUserProfileImage();
    	
    	user.setName(name);
    	user.setEmail(email);
    	
    	return user;
    }
	
}