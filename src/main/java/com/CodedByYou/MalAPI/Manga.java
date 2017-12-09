package com.CodedByYou.MalAPI;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.net.URL;

public class Manga {
    private int id;
    private String mangaName,rating,type,status,startDate,endDate,description;
    private URL imageUrl,link;
    private double chapters,volumes;
    public Manga(MalAPI api , String mangaName) throws Exception{
            this.mangaName = mangaName;
            mangaName = mangaName.replaceAll(" ","+");
            String url = "https://myanimelist.net/api/manga/search.xml?q="+mangaName;
            Document manga = api.getMalGet().get(url);
            NodeList list = manga.getElementsByTagName("entry");
            NodeList l = list.item(0).getChildNodes();
            this.id = Integer.parseInt(l.item(1).getTextContent());
            this.mangaName = l.item(3).getTextContent();
            chapters = Double.parseDouble(l.item(9).getTextContent());
            volumes = Double.parseDouble(l.item(11).getTextContent());
            rating = l.item(13).getTextContent();
            type = l.item(15).getTextContent();
            status = l.item(17).getTextContent();
            startDate = l.item(19).getTextContent();
            endDate = l.item(21).getTextContent();
            description = l.item(23).getTextContent();
            imageUrl = new URL(l.item(25).getTextContent());
            String  n = this.mangaName.replaceAll(" ","+");
            link = new URL("https://www.myanimelist.net/manga/"+id+"/"+n+"?q="+n);
    }

    public URL getLink() {
        return link;
    }

    public URL getImageUrl() {
        return imageUrl;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getChapters() {
        return chapters;
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

    public String getMangaName() {
        return mangaName;
    }

    public double getVolumes() {
        return volumes;
    }
}
