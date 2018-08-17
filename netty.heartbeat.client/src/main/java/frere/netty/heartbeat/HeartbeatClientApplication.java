package frere.netty.heartbeat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * HeartbeatClientApplication
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class HeartbeatClientApplication implements CommandLineRunner {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(HeartbeatClientApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(HeartbeatClientApplication.class, args);
		LOGGER.info("启动 Client 成功");
	}

	public void run(String... args) throws Exception {

	}
}
