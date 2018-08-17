/**
 * 
 */
package frere.netty.heartbeat;

import java.net.InetSocketAddress;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author frere
 *
 */
@Component
public class HeartBeatServer {
	private final static Logger LOGGER = LoggerFactory.getLogger(HeartBeatServer.class);
	private EventLoopGroup boss = new NioEventLoopGroup();
	private EventLoopGroup work = new NioEventLoopGroup();
	@Value("${netty.server.port}")
	private int nettyPort;

	/**
	 * 启动 Netty
	 *
	 * @return
	 * @throws InterruptedException
	 */
	@PostConstruct
	public void start() throws InterruptedException {
		ServerBootstrap bootstrap = new ServerBootstrap().group(boss, work).channel(NioServerSocketChannel.class)
				.localAddress(new InetSocketAddress(nettyPort))
				// 保持长连接
				.childOption(ChannelOption.SO_KEEPALIVE, true).childHandler(new HeartbeatInitializer());
		ChannelFuture future = bootstrap.bind().sync();
		if (future.isSuccess()) {
			LOGGER.info("启动 Netty 成功");
		}
	}

	/**
	 * 销毁
	 */
	@PreDestroy
	public void destroy() {
		boss.shutdownGracefully().syncUninterruptibly();
		work.shutdownGracefully().syncUninterruptibly();
		LOGGER.info("关闭 Netty 成功");
	}
}
