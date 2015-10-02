package br.com.gt.controller;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;

import br.com.gt.social.FacebookInterceptor;

@Controller
public class FacebookController extends ConnectController {
	
	@Inject
	public FacebookController(ConnectionFactoryLocator connectionFactoryLocator,
			ConnectionRepository connectionRepository, FacebookInterceptor interceptor) {
		super(connectionFactoryLocator, connectionRepository);
		addInterceptor(interceptor);
	}
	
	@Override
    protected String connectedView(String providerId){
        return "redirect:/announcements";
    }
	
}