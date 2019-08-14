package com.orange.game.ad.sdk.common;

import androidx.annotation.StringDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({AdType.BANNER, AdType.INTERSTITIAL, AdType.REWARDED, AdType.NATIVE})
@Retention(RetentionPolicy.SOURCE)
public @interface AdType {

  String BANNER = "BANNER";
  String INTERSTITIAL = "INTERSTITIAL";
  String REWARDED = "REWARDED";
  String NATIVE = "NATIVE";

}
