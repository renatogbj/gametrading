package br.com.gt;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@SpringBootApplication
@EnableSocial
public class GtApplication {

    public static void main(String[] args) {
        SpringApplication.run(GtApplication.class, args);
    }
    
    @Inject
    private Environment environment;
	
	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        
        registry.addConnectionFactory(new FacebookConnectionFactory(
            environment.getProperty("facebook.clientId"),
            environment.getProperty("facebook.clientSecret")));
        
        return registry;
    }
	
	@Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
        }
        return usersConnectionRepository().createConnectionRepository(authentication.getName());
    }
	
	@Bean
    public UsersConnectionRepository usersConnectionRepository() {
        return new InMemoryUsersConnectionRepository(connectionFactoryLocator());
    }
	
	@PostConstruct
	private void init() {
	    // hack for the facebook login
	    try {
	        String[] fieldsToMap = {
	                "id", "about", "age_range", "address", "bio", "birthday", "context", "cover", "currency", "devices", "education", "email",
	                "favorite_athletes", "favorite_teams", "first_name", "gender", "hometown", "inspirational_people", "installed", "install_type",
	                "is_verified", "languages", "last_name", "link", "locale", "location", "meeting_for", "middle_name", "name", "name_format",
	                "political", "quotes", "payment_pricepoints", "relationship_status", "religion", "security_settings", "significant_other",
	                "sports", "test_group", "timezone", "third_party_id", "updated_time", "verified", "viewer_can_send_gift",
	                "website", "work"
	        };

	        Field field = Class.forName("org.springframework.social.facebook.api.UserOperations")
	                .getDeclaredField("PROFILE_FIELDS");
	        field.setAccessible(true);

	        Field modifiers = field.getClass().getDeclaredField("modifiers");
	        modifiers.setAccessible(true);
	        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
	        field.set(null, fieldsToMap);

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
    
}
