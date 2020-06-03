package com.nan.weixin.entity;

public class AccessToken {
    private String accessToken;
    private long expireTime;

    public AccessToken(String accessToken, String expireIn) {
        this.accessToken = accessToken;
        this.expireTime = System.currentTimeMillis()+Integer.parseInt(expireIn)*1000;
    }

    public boolean isExpired(){
        if(System.currentTimeMillis()>this.expireTime){
            return true;
        }
        return false;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}
