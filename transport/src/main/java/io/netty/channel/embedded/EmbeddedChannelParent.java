package io.netty.channel.embedded;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelId;

import java.util.ArrayList;
import java.util.Arrays;

public class EmbeddedChannelParent implements IEmbeddedChannelBuilder{
    private ChannelId channelId = EmbeddedChannelId.INSTANCE;
    private boolean hasDisconnect = false;
    private final ArrayList<ChannelHandler> channelHandlers = new ArrayList<>();

    private Channel parent = null;
    private boolean register = true;
    
    @Override
    public void reset() {
        channelId = EmbeddedChannelId.INSTANCE;
        hasDisconnect = false;
        parent = null;
        register = true;
        channelHandlers.clear();
    }

    public void setChannelId(ChannelId channelId) {
        this.channelId = channelId;
      
    }

    public void setParent(Channel parent) {
        this.parent = parent;
      
    }

    public void setRegister(boolean register) {
        this.register = register;
      
    }

    public void setHasDisconnect(boolean hasDisconnect) {
        this.hasDisconnect = hasDisconnect;
      
    }

    @Override
    public void addHandlers(ChannelHandler... handlers) {
        channelHandlers.addAll(Arrays.asList(handlers));
    }

    @Override
    public EmbeddedChannel build() {
        if (channelId == null) {
            throw new IllegalStateException("ChannelId must be set before building the EmbeddedChannel.");
        }
        return new EmbeddedChannel(
                parent,
                channelId,
                register,
                hasDisconnect,
                channelHandlers.toArray(new ChannelHandler[0])
        );
    }
}
