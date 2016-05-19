package FirstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
////                .antMatchers("/", "/welcome").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().defaultSuccessUrl("/index.html", true)
//                .loginPage("/signin").permitAll()
//                .and()
//                .logout().permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }
//}


@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsServices.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);//.passwordEncoder(passwordencoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/index.html", true)
                .loginPage("/signin").permitAll()
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();
        }

//    @Bean(name = "passwordEncoder")
//    public PasswordEncoder passwordencoder() {
//        return new BCryptPasswordEncoder();
//    }
}