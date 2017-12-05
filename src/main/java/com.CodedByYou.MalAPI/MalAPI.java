package com.CodedByYou.MalAPI;

public class MalAPI {
    private MalGet malGet;
    private String user,password;
    public MalAPI(String user,String password){
        this.user = user;
        this.password = password;
        malGet = new MalGet(this);
    }

    public Anime getAnime(String name) throws Exception{
        return new Anime(this,name);
    }

    public Manga getManga(String name) throws Exception{
        return new Manga(this,name);
    }

    public MalGet getMalGet() {
        return malGet;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
