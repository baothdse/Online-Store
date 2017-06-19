package com.cos;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.config.JPAConfiguration;


@RestController
@Import(JPAConfiguration.class)
@EnableOAuth2Sso
@SpringBootApplication(scanBasePackages = { "com.cos" })
public class COSMain extends WebSecurityConfigurerAdapter {
	public static void main(String[] args) {
		SpringApplication.run(COSMain.class, args);
	}
	@RequestMapping("/facebook-login")
	public Principal user(Principal principal) {
		
		return principal;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/user/**","/register","/login" ).permitAll()
				.anyRequest().authenticated();
		http.csrf().disable();
	}
//	
//	@Autowired
//	OAuth2ClientContext oauth2ClientContext;
//	
//	@Bean
//	@ConfigurationProperties("facebook")
//	public ClientResources facebook() {
//		return new ClientResources();
//	}
//	
//	private Filter ssoFilter(ClientResources client, String path) {
//		OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(
//				path);
//		OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
//		filter.setRestTemplate(template);
//		UserInfoTokenServices tokenServices = new UserInfoTokenServices(
//				client.getResource().getUserInfoUri(), client.getClient().getClientId());
//		tokenServices.setRestTemplate(template);
//		filter.setTokenServices(tokenServices);
//		return filter;
//	}
////		private Filter ssoFilter() {
//	private Filter ssoFilter() {
//		CompositeFilter filter = new CompositeFilter();
//		List<Filter> filters = new ArrayList<>();
//		filters.add(ssoFilter(facebook(), "/facebook-login"));
//		filter.setFilters(filters);
//		return filter;
//	}
//
//@Bean
//public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
//	FilterRegistrationBean registration = new FilterRegistrationBean();
//	registration.setFilter(filter);
//	registration.setOrder(-100);
//	return registration;
//}
//class ClientResources {
//
//	@NestedConfigurationProperty
//	private AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails();
//
//	@NestedConfigurationProperty
//	private ResourceServerProperties resource = new ResourceServerProperties();
//
//	public AuthorizationCodeResourceDetails getClient() {
//		return client;
//	}
//
//	public ResourceServerProperties getResource() {
//		return resource;
//	}
//}
}
