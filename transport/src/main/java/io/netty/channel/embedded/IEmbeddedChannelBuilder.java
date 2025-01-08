package io.netty.channel.embedded;


import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelId;


import java.util.ArrayList;


public interface IEmbeddedChannelBuilder {
   /*Channel parent = null;
   ChannelId channelId = null;
   boolean register = false;
   boolean hasDisconnect = false;
   final ArrayList<ChannelHandler> handlers = null;*/


    public void setChannelId(ChannelId channelId);


    public void setHasDisconnect(boolean hasDisconnect);


    public void setChannelConfig(ChannelConfig config);


    public void addHandlers(ChannelHandler... handlers);

    public EmbeddedChannel build();
}

