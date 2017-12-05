# MAL-
MalApi Java (MyAnimeList java api)
 How to use:
 Create a object of MalApi as Example:
 MalApi api;
public static void main(String[] args){
     api = new MalApi("username","password");//my animelist login info
     Manga manga = api.getManga("Naruto");
     manga.getImageUrl();
     manga.getLink();
     manga.getScore();
     and more and for anime too
     Anime anime = api.getAnime("Naruto");
}
