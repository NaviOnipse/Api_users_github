package com.estudio.pruebagit.modelo;

public class Getset {
    public String html_url;
    public String login;
    public String avatar_url;
    public String name;

    public String getname() {
        return name;
    }

    public void setname(String name) {  this.name = this.name; }

    public String getlogin() {
        return login;
    }

    public void setlogin(String login) {  this.login = this.login; }

    public String getavatar_url() {
        return avatar_url;
    }

    public void setavatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String geturl() {
        return html_url;
    }

    public void seturl(String url) {
        this.html_url = this.html_url;
    }


}