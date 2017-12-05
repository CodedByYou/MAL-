package com.CodedByYou.MalAPI;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.net.URL;

public class Anime {
    private int id;
    private String animeName,rating,type,status,startDate,endDate,description;
    private URL imageUrl,link;
    private double episodes;
    public Anime(MalAPI api , String animeName) throws Exception{
        this.animeName = animeName;
        animeName = animeName.replaceAll(" ","+");
        String url = "https://myanimelist.net/api/anime/search.xml?q="+animeName;
        Document manga = api.getMalGet().get(url);
        NodeList list = manga.getElementsByTagName("entry");
        NodeList l = list.item(0).getChildNodes();
        this.id = Integer.parseInt(l.item(1).getTextContent());
        this.animeName = l.item(3).getTextContent();
        episodes = Double.parseDouble(l.item(9).getTextContent());
        rating = l.item(11).getTextContent();
        type = l.item(13).getTextContent();
        status = l.item(15).getTextContent();
        startDate = l.item(17).getTextContent();
        endDate = l.item(19).getTextContent();
        description = l.item(21).getTextContent();
        imageUrl = new URL(l.item(23).getTextContent());
        link = new URL("https://www.myanimelist.net/manga/"+id+"/"+this.animeName+"?q="+this.animeName);
    }

    public URL getLink() {
        return link;
    }

    public int getId() {
        return id;
    }

    public URL getImageUrl() {
        return imageUrl;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getEpisodes() {
        return episodes;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getRating() {
        return rating;
    }

    public String getAnimeName() {
        return animeName;
    }
}
