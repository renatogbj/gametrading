package br.com.gt.social;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.ImageType;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.WebRequest;

import br.com.gt.model.bean.User;
import br.com.gt.model.service.UserService;

@Component
public class FacebookInterceptor implements ConnectInterceptor<Facebook> {

	private static final Logger LOG = Logger.getLogger(FacebookInterceptor.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public void postConnect(Connection<Facebook> connection, WebRequest request) {
		UserOperations userOperations = connection.getApi().userOperations();
		UserProfile userProfile = connection.fetchUserProfile();
		org.springframework.social.facebook.api.User userFacebook = userOperations.getUserProfile();
		
		User user = userService.findByEmail(userFacebook.getEmail());
		
		if (user != null) {
			Authentication auth = new RememberMeAuthenticationToken(user.getUsername(), user, user.getAuthorities());
			auth.setAuthenticated(true);
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			LOG.info("User '" + user.getUsername() + "' logged in.");
			return;
		}
		
		// sign up the new user
		user = new User();
		user.setAvatar(userOperations.getUserProfileImage(ImageType.SQUARE));
		user.setEmail(userProfile.getEmail());
		user.setLikes(0);
		user.setName(userProfile.getName());
		user.setUsername(userProfile.getUsername());
		user.setCity(userFacebook.getAddress().getCity());
		
		userService.save(user);
		
		Authentication auth = new RememberMeAuthenticationToken(user.getUsername(), user, user.getAuthorities());
		auth.setAuthenticated(true);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		LOG.info("User '" + user.getUsername() + "' logged in.");
	}

	@Override
	public void preConnect(ConnectionFactory<Facebook> provider, MultiValueMap<String, String> parameters, WebRequest request) {
		// nothing to do
	}

}
