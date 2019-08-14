package com.orange.game.ad.sdk.admob;

import com.orange.game.ad.sdk.common.AdRequest;
import com.orange.game.ad.sdk.common.AdDelegate;
import com.orange.game.ad.sdk.common.AdType;
import com.orange.game.ad.sdk.common.IChannelFactory;

public class AdMobFactory implements IChannelFactory {

  @Override
  public AdDelegate createStrategyByType(AdRequest request) {
    String type = request.getType();
    switch (type) {
      case AdType.BANNER: {
        return new AdMobBannerDelegate();
      }
      case AdType.INTERSTITIAL: {
        return new AdMobInterstitialDelegate();
      }
    }
    throw new RuntimeException("Channel ADMOB not support " + request.getType() + " yet !");
  }
}
