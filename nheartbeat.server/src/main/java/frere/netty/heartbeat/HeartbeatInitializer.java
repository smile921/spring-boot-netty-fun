/**
 * 
 */
package frere.netty.heartbeat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author frere
 *
 */
public class HeartbeatInitializer extends ChannelInitializer<Channel> {
	@Override
	protected void initChannel(Channel ch) throws Exception {
		ch.pipeline()
				// 五秒没有收到消息 将IdleStateHandler 添加到 ChannelPipeline 中
				.addLast(new IdleStateHandler(5, 0, 0)).addLast(new HeartbeatDecoder())
				.addLast(new HeartBeatSimpleHandle());
	}

}
