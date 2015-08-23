package br.com.gt.controller;

import java.security.Principal;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//public class LoginController extends ConnectController {
@Controller
public class LoginController {

//	@Autowired
//	private Facebook facebook;
	
//	@Autowired
//	private FacebookConnectionInterceptor facebookConnInterceptor;
	
//	@Inject
//	public LoginController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
//		super(connectionFactoryLocator, connectionRepository);
//	}
	
	
//	@PostConstruct
//	public void addInterceptor() {
//		this.addInterceptor(facebookConnInterceptor);
//	}
	
	private final Provider<ConnectionRepository> connectionRepositoryProvider;
	
	@Inject
	public LoginController(Provider<ConnectionRepository> connectionRepositoryProvider) {
		this.connectionRepositoryProvider = connectionRepositoryProvider;
	}

	@RequestMapping("/")
	public String home(Principal currentUser, Model model) {
		model.addAttribute("connectionsToProviders", connectionRepositoryProvider.get().findAllConnections());
		return "home";
	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String home(Model model) {
//		Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
//		if (connection == null) {
//			return "redirect:/connect/facebook";
//		}
//		model.addAttribute("profile", connection.getApi().userOperations().getUserProfile());
//		return "facebook/profile";
//	}
	
//	@Override
//    protected String connectedView(String providerId) {
//        return "redirect:/";
//    }
}