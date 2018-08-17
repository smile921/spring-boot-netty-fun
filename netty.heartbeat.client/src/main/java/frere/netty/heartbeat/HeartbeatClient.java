/**
 * 
 */
package frere.netty.heartbeat;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author frere
 *
 */
@Component
public class HeartbeatClient {
	private final static Logger LOGGER = LoggerFactory.getLogger(HeartbeatClient.class);
	private EventLoopGroup group = new NioEventLoopGroup();
	@Value("${netty.server.port}")
	private int nettyPort;
	@Value("${netty.server.host}")
	private String host;
	private SocketChannel channel;

	@PostConstruct
	public void start() throws InterruptedException {
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(group).channel(NioSocketChannel.class).handler(new CustomerHandleInitializer());
		ChannelFuture future = bootstrap.connect(host, nettyPort).sync();
		if (future.isSuccess()) {
			LOGGER.info("启动 Netty 成功");
		}
		channel = (SocketChannel) future.channel();
	}

}
