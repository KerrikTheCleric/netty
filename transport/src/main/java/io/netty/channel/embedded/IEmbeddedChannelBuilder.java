package io.netty.channel.embedded;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelId;

public interface IEmbeddedChannelBuilder {

    void reset();

    void setChannelId(ChannelId channelId);

    void setHasDisconnect(boolean hasDisconnect);

    void addHandlers(ChannelHandler... handlers);

    EmbeddedChannel build();
}