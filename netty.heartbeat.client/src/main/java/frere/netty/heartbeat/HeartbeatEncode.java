/**
 * 
 */
package frere.netty.heartbeat;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author frere
 *
 */
public class HeartbeatEncode extends MessageToByteEncoder<CustomProtocol> {
	@Override
	protected void encode(ChannelHandlerContext ctx, CustomProtocol msg, ByteBuf out) throws Exception {
		out.writeLong(msg.getId());
		out.writeBytes(msg.getContent().getBytes());
	}

}
