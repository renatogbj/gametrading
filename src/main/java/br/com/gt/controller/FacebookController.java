package br.com.gt.controller;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.view.RedirectView;

import br.com.gt.social.FacebookInterceptor;

@Controller
@RequestMapping("/connect")
public class FacebookController extends ConnectController {

	@Inject
	public FacebookController(
			ConnectionFactoryLocator connectionFactoryLocator,
			ConnectionRepository connectionRepository, FacebookInterceptor interceptor) {
		
		super(connectionFactoryLocator, connectionRepository);
		addInterceptor(interceptor);
		addDisconnectInterceptor(interceptor);
	}

	@Override
	protected RedirectView connectionStatusRedirect(String providerId, NativeWebRequest request) {
		return new RedirectView("/index.html#/announcements", true);
	}
	
}
