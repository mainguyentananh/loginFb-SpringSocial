package demo.spring.service;

import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class facebookService {

	private final String app_id = "?";

	private final String app_secret = "?";

	private FacebookConnectionFactory factory = new FacebookConnectionFactory(app_id, app_secret);

	public String facebookLogin() {
		System.out.println("inside fb login");
		OAuth2Operations operations = factory.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri("http://localhost:8080/demo/doLogin");
		params.setScope("email, public_profile");
		String authUrl = operations.buildAuthenticateUrl(params);
		System.out.println("Generated url is= " + authUrl);
		return authUrl;
	}

	public AccessGrant createAccessToken(String code) {
		OAuth2Operations operations = factory.getOAuthOperations();
		AccessGrant accessToken = operations.exchangeForAccess(code, "http://localhost:8080/demo/doLogin", null);
		System.out.println("code............. " + code); 
		System.out.println("accessToken......... " + accessToken.getAccessToken());
		
		return accessToken;
	}

	public Connection<Facebook> connection(AccessGrant accessToken) {
		return factory.createConnection(accessToken);
	}

	

}
