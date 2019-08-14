package com.orange.game.ad.sdk.common;

public interface IChannelFactory {

  AdDelegate createStrategyByType(AdRequest request);
}
