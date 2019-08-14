package com.orange.game.ad.sdk.common;

import androidx.annotation.StringDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({Channel.ADMOB, Channel.FACEBOOK})
@Retention(RetentionPolicy.SOURCE)
public @interface Channel {

  String ADMOB = "ADMOB";
  String FACEBOOK = "FACEBOOK";
}
