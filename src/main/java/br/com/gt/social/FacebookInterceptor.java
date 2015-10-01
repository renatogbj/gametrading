package br.com.gt.social;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private UserService userService;
	
	@Override
	public void postConnect(Connection<Facebook> connection, WebRequest request) {
		UserOperations userOperations = connection.getApi().userOperations();
		UserProfile userProfile = connection.fetchUserProfile();
		org.springframework.social.facebook.api.User userFacebook = userOperations.getUserProfile();
		
		User user = userService.findByEmail(userFacebook.getEmail());
		
		if (user != null) {
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
	}

	@Override
	public void preConnect(ConnectionFactory<Facebook> provider, MultiValueMap<String, String> parameters, WebRequest request) {
		// nothing to do
	}

}
