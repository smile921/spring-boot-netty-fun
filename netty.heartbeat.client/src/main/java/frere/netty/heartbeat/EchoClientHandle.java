/**
 * 
 */
package frere.netty.heartbeat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.XmlWebApplicationContext;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

/**
 * @author frere
 *
 */
public class EchoClientHandle extends SimpleChannelInboundHandler<ByteBuf> {

	private final static Logger LOGGER = LoggerFactory.getLogger(EchoClientHandle.class);

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
			if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
				LOGGER.info("已经 10 秒没有发送信息！");
				// 向服务端发送消息
				CustomProtocol heartBeat = SpringBeanFactoryUtil.getApplicationContext().getBean("heartBeat",
						CustomProtocol.class);
				ctx.writeAndFlush(heartBeat).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
			}
		}
		super.userEventTriggered(ctx, evt);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf in) throws Exception {
		// 从服务端收到消息时被调用
		LOGGER.info("客户端收到消息={}", in.toString(CharsetUtil.UTF_8));
	}

}
