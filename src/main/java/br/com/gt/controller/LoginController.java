package br.com.gt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.ImageType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gt.model.bean.Usr;
import br.com.gt.model.service.UsrService;

@RestController
public class LoginController {

	@Autowired
    private Facebook facebook;
	
	@Autowired
	private UsrService usrService;

    @RequestMapping(value = "/home/user", method = RequestMethod.GET)
    public Usr findUser() {
    	Usr user;
    	
    	if (!facebook.isAuthorized()) {
    		user = new Usr();
    		user.setName("");
    		return user;
    	}
    	
    	String name = facebook.userOperations().getUserProfile().getName();
    	String email = facebook.userOperations().getUserProfile().getEmail();
    	byte[] avatar = facebook.userOperations().getUserProfileImage(ImageType.SQUARE);
    	
    	user = usrService.find(email);
    	
    	if (user == null) {
    		user = new Usr(email, name, avatar, 0);
    		user.setName(name);
    		user.setAvatar(avatar);
    		user.setLikes(0);
    		usrService.save(user);
    	}
    	
    	return user;
    }
	
}