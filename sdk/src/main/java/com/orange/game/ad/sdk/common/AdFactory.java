package com.orange.game.ad.sdk.common;

import com.orange.game.ad.sdk.admob.AdMobFactory;

class AdFactory {

  public static AdDelegate createAd(AdRequest request) {
    String adChannel = request.getChannel();
    switch (adChannel) {
      case Channel.ADMOB: {
        return new AdMobFactory().createStrategyByType(request);
      }
      case Channel.FACEBOOK: {
        break;
      }
    }
    throw new RuntimeException(
        "we not support channel " + adChannel + " yet! Please use other channel.");
  }

}
