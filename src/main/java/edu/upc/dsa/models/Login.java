package edu.upc.dsa.models;

public class Login {

    //Attributes

    String nickname;
    String oldpassword;
    String newpassword;

    //Constructor

    public Login(String nickname, String oldpassword, String newpassword) {
        this.nickname = nickname;
        this.oldpassword = oldpassword;
        this.newpassword = newpassword;
    }

    //Zero-argument constructor

    public Login(){

    }

    //Getters and setters

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
}
