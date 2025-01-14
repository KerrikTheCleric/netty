package io.netty.channel.embedded;

import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelId;

import java.util.ArrayList;
import java.util.Arrays;

public class EmbeddedChannelBuilder implements IEmbeddedChannelBuilder{

   private ChannelId channelId = EmbeddedChannelId.INSTANCE;
   private boolean hasDisconnect = false;
   private ArrayList<ChannelHandler> channelHandlers = new ArrayList<>();
   private ChannelConfig channelConfig = null;

    @Override
    public void reset() {
        channelId = EmbeddedChannelId.INSTANCE;
        hasDisconnect = false;
        channelHandlers.clear();
        ChannelConfig channelConfig = null;
    }

    @Override
    public void setChannelId(ChannelId channelId) {
        this.channelId = channelId;
    }

    @Override
    public void setHasDisconnect(boolean hasDisconnect) {
        this.hasDisconnect = hasDisconnect;
    }

    @Override
    public void addHandlers(ChannelHandler... handlers) {
        channelHandlers.addAll(Arrays.asList(handlers));
    }

    public void setConfig(ChannelConfig channelConfig) {
        this.channelConfig = channelConfig;
    }

    @Override
    public EmbeddedChannel build() {
        ChannelHandler[] arr = new ChannelHandler[channelHandlers.size()];
        arr = channelHandlers.toArray(arr);
        return new EmbeddedChannel(channelId, hasDisconnect, channelConfig, arr);
    }
}
