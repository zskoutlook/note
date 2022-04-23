package org.example.pojo;

public class Account {
    private int aid;
    private String aname;
    private String acontent;

    public Account() {
    }

    public Account(int aid, String aname, String acontent) {
        this.aid = aid;
        this.aname = aname;
        this.acontent = acontent;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAcontent() {
        return acontent;
    }

    public void setAcontent(String acontent) {
        this.acontent = acontent;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", acontent='" + acontent + '\'' +
                '}';
    }
}
