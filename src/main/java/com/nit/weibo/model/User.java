package com.nit.weibo.model;

import java.util.Date;

public class User extends UserKey {
    private String cname;

    private Integer new_member;

    private Integer member;

    private Date member_endtime;

    private Date resight_time;

    private String cmoney;

    private String cleankey;

    private Date clean_starttime;

    private Date clean_endtime;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getNew_member() {
        return new_member;
    }

    public void setNew_member(Integer new_member) {
        this.new_member = new_member;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public Date getMember_endtime() {
        return member_endtime;
    }

    public void setMember_endtime(Date member_endtime) {
        this.member_endtime = member_endtime;
    }

    public Date getResight_time() {
        return resight_time;
    }

    public void setResight_time(Date resight_time) {
        this.resight_time = resight_time;
    }

    public String getCmoney() {
        return cmoney;
    }

    public void setCmoney(String cmoney) {
        this.cmoney = cmoney == null ? null : cmoney.trim();
    }

    public String getCleankey() {
        return cleankey;
    }

    public void setCleankey(String cleankey) {
        this.cleankey = cleankey == null ? null : cleankey.trim();
    }

    public Date getClean_starttime() {
        return clean_starttime;
    }

    public void setClean_starttime(Date clean_starttime) {
        this.clean_starttime = clean_starttime;
    }

    public Date getClean_endtime() {
        return clean_endtime;
    }

    public void setClean_endtime(Date clean_endtime) {
        this.clean_endtime = clean_endtime;
    }
}