package com.orange.game.ad.sdk.common;

import android.content.Context;
import android.view.ViewGroup;

public class AdProxy extends AdDelegate {

  private AdDelegate mAd;

  public AdProxy(AdDelegate ad) {
    this.mAd = ad;
  }

  private void check() {
    if (mAd == null) {
      throw new RuntimeException("Ad is null, place check the chanel and type! ");
    }
  }

  @Override
  public void loadAd(Context context, AdRequest request) {
    check();
    mAd.loadAd(context, request);
  }

  @Override
  public void showAd() {
    check();
    mAd.showAd();
  }

  @Override
  public void showAd(ViewGroup viewGroup) {
    check();
    mAd.showAd(viewGroup);
  }

  @Override
  public void setAdListener(AdListener adListener) {
    super.setAdListener(adListener);
    check();
    mAd.setAdListener(adListener);
  }

  @Override
  public void destroyAd() {
    check();
    mAd.destroyAd();
  }
}
