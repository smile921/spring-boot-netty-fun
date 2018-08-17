package frere.netty.heartbeat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class BootNettyServer 
{

	private final static Logger LOGGER = LoggerFactory.getLogger(BootNettyServer.class);

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(BootNettyServer.class, args);
		LOGGER.info("启动 Server 成功");
    }
}
