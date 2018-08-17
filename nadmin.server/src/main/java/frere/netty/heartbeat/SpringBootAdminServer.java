package frere.netty.heartbeat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * Hello world!
 *
 */
//@EnableWebSecurity
@EnableAdminServer
@EnableAutoConfiguration
@Configuration
public class SpringBootAdminServer {
	private final static Logger LOGGER = LoggerFactory.getLogger(SpringBootAdminServer.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringBootAdminServer.class, args);
		LOGGER.info("启动 Server 成功");
	}

	public void run(String... args) throws Exception {

	}
 
 

}
