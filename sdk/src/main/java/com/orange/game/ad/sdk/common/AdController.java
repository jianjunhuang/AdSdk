package com.orange.game.ad.sdk.common;

public class AdController {

  private static volatile AdController mInstance;

  private AdController() {

  }

  public void init() {

  }

  public static AdController getInstance() {
    if (mInstance == null) {
      synchronized (AdController.class) {
        if (mInstance == null) {
          mInstance = new AdController();
        }
      }
    }
    return mInstance;
  }

  public AdDelegate getAd(AdRequest request) {
    AdDelegate ad = new AdProxy(AdFactory.createAd(request));
    return ad;
  }


}
