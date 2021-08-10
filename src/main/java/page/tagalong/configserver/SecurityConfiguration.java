package page.tagalong.configserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
				.ignoringAntMatchers("/encrypt/**")
				.ignoringAntMatchers("/decrypt/**")
				.disable().authorizeRequests()
				.antMatchers("/actuator/health").permitAll()
				.antMatchers("/**").authenticated().and().httpBasic();

		super.configure(http);
	}
}
