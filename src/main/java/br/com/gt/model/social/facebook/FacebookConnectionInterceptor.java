package br.com.gt.model.social.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.WebRequest;

import br.com.gt.model.bean.Usr;
import br.com.gt.model.service.UsrService;

@Component
public class FacebookConnectionInterceptor implements ConnectInterceptor<Facebook> {

	@Autowired
	private UsrService usrService;
	
	@Override
	public void preConnect(ConnectionFactory<Facebook> connectionFactory,
			MultiValueMap<String, String> parameters, WebRequest request) {
	}

	@Override
	public void postConnect(Connection<Facebook> connection, WebRequest request) {
		UserProfile profile = connection.fetchUserProfile();
		
		Usr usr = new Usr();
		usr.setName(profile.getUsername());
		usr.setEmail(profile.getEmail());
		usr.setLikes(0);
		
		usrService.save(usr);
	}
}
