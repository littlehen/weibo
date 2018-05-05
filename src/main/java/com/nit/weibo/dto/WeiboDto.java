package com.nit.weibo.dto;

import com.nit.weibo.model.Weibo;

public class WeiboDto {
    private Integer weiboId;

    private Integer userId;

    private String username;

    private String password;

    private Integer isMain;

    private Integer isFinish;

    private Integer FUhaoNumber;

    public WeiboDto(){

    }

    public WeiboDto(Integer weiboId,Integer userId,String username,String password,Integer isMain,Integer isFinish,Integer FUhaoNumber){
        this.weiboId=weiboId;
        this.userId=userId;
        this.username=username;
        this.password=password;
        this.isMain=isMain;
        this.isFinish=isFinish;
        this.FUhaoNumber=FUhaoNumber;
    }

    public WeiboDto(Integer userId,String username,String password,Integer isMain,Integer isFinish,Integer FUhaoNumber){
        this.userId=userId;
        this.username=username;
        this.password=password;
        this.isMain=isMain;
        this.isFinish=isFinish;
        this.FUhaoNumber=FUhaoNumber;
    }

    public WeiboDto(Integer userId,String username,String password,Integer isFinish){
        this.userId=userId;
        this.username=username;
        this.password=password;
        this.isFinish=isFinish;
    }

    public Integer getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Integer weiboId) {
        this.weiboId = weiboId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public Integer getFUhaoNumber() {
        return FUhaoNumber;
    }

    public void setFUhaoNumber(Integer FUhaoNumber) {
        this.FUhaoNumber = FUhaoNumber;
    }

    public Weibo toModel(){
        Weibo weibo = new Weibo();
        weibo.setWeiboId(weiboId);
        weibo.setIsMain(isMain);
        weibo.setUserId(userId);
        weibo.setFUhaoNumber(FUhaoNumber);
        weibo.setIsFinish(isFinish);
        weibo.setPassword(password);
        weibo.setUsername(username);
        return weibo;
    }
}
