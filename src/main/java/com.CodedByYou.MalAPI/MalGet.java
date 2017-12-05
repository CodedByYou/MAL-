package com.CodedByYou.MalAPI;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;

public class MalGet {

    private MalAPI api;

    public MalGet(MalAPI api){
        this.api=api;
    }

    public Document get(String url) throws Exception{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        String user = api.getUser();String password = api.getPassword();
        String authStr = user + ":" + password;
        String authEncoded = Base64.encodeBase64String(authStr.getBytes());
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Basic " + authEncoded);
        con.setDoOutput(true);
        DocumentBuilderFactory factoryBuilder = DocumentBuilderFactory.newInstance();
        factoryBuilder.setIgnoringComments(true);
        factoryBuilder.setIgnoringElementContentWhitespace(true);
        return factoryBuilder.newDocumentBuilder().parse(con.getInputStream());
    }
}
