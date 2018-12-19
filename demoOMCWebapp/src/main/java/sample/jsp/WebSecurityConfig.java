package sample.jsp;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	http
//		.authorizeRequests()
//			.antMatchers("/css/**", "/fonts/**","/images/**","/js/**","/shop.html/**","/index.html").permitAll()		
//			.anyRequest().authenticated().
//         	and()
//         	.csrf().disable()
//	        .formLogin().loginPage("/login.jsp").permitAll();
//    }
//
//	// authentication
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//	
//		auth.inMemoryAuthentication()  
//        .withUser("user")
//         .password("{noop}12345")
//         .roles("USER")
//         .and()
//         .withUser("sysuser")
//         .password("password")
//         .roles("SYSTEM");
//	}
    
	
		// authentication
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
			auth.inMemoryAuthentication()  
            .withUser("user")
             .password("{noop}12345")
             .roles("USER")
             .and()
             .withUser("sysuser")
             .password("password")
             .roles("SYSTEM");
			
		}

		// authorization
		@Override
		public void configure(HttpSecurity http) throws Exception {
//			http
//		    // #1
//		    .formLogin()
//		        // #2
//		        .loginPage("/login.jsp")
//		        .failureUrl("/login.jsp?error")
//		        // #3
//		        .and()
//		    // #4
//		    .authorizeRequests()
//		        // #5
//		        .antMatchers("/css/**", "/fonts/**","/images/**","/js/**","/index.html").permitAll()
//		        .antMatchers("/checkout.html","/shop.html").hasRole("USER")
//		        .anyRequest().authenticated();

			http
            .csrf().disable()
	          .authorizeRequests()
	          .antMatchers("/css/**", "/fonts/**","/images/**","/js/**","/shop.html","/index.html").permitAll()
	          .antMatchers("/**").hasRole("USER")
//	          .antMatchers("/anonymous*").anonymous()
	          .anyRequest().authenticated()
	          .and()
	          .formLogin().loginPage("/login.jsp")
				.failureUrl("/login.jsp?error=1").loginProcessingUrl("/login")
				.permitAll()
			  .and()
			  .logout()
	          .logoutUrl("/perform_logout")
	          .deleteCookies("JSESSIONID").logoutSuccessUrl("/index.html");
	          
				//.logout().logoutSuccessUrl("/index.html");
			
			
		}
			
}