package com.orange.game.ad.sdk.common;

public class AdRequest {

  private String pid;
  private @AdType
  String type;
  private @Channel
  String channel;
  private String testDeviceId;

  private AdRequest(Builder builder) {
    pid = builder.pid;
    type = builder.type;
    channel = builder.channel;
    testDeviceId = builder.testDeviceId;
  }

  public String getTestDeviceId() {
    return testDeviceId;
  }

  public void setPid(String mPid) {
    this.pid = mPid;
  }

  public void setType(String mType) {
    this.type = mType;
  }

  public String getPid() {
    return pid;
  }

  public String getType() {
    return type;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public static class Builder {

    String pid;

    String type;

    String channel;

    String testDeviceId;

    public Builder setPid(String pid) {
      this.pid = pid;
      return this;
    }

    public Builder setTestDeviceId(String id) {
      this.testDeviceId = id;
      return this;
    }

    public Builder setType(@AdType String type) {
      this.type = type;
      return this;
    }

    public Builder setChannel(@Channel String channel) {
      this.channel = channel;
      return this;
    }

    public AdRequest build() {
      return new AdRequest(this);
    }
  }

}
