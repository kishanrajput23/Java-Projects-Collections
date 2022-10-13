package replit;

import java.lang.Integer;

public abstract class VideoGame
{
  protected String gameName;
  protected double gamePlayTime;
  protected String gamePublisher;
  protected int gameAchievements;
  protected final static String DEFAULTNAME = "Game Title";
  protected final static double DEFAULTPLAYTIME = 0.0;
  protected final static String DEFAULTPUBLISHER = "Publisher";
  protected final static int DEFAULTACHIEVEMENTS = 0;
  protected int placesVisited;
  protected int charactersMet;
  protected int itemsFound;
  protected double speedrunTime;
  protected boolean fullCompletion;
  double mostPlayedStorage = 0;
  protected int friendsThatPlay;
  protected int gamesWon;
  protected String rank;
  protected int level;


  class Items{
    protected String itemName;
    protected int itemRarity;
    protected double itemValue;
    protected final static String DEFAULTITEMNAME = "Item";
    protected final static int DEFAULTRARITY = 0;
    protected final static double DEFAULTVALUE = 0.0;
    public Items(String itemName, int itemRarity, double itemValue){
      this.itemName = itemName;
      this.itemRarity = itemRarity;
      this.itemValue = itemValue; 
    }
    public Items(){
      this(DEFAULTITEMNAME, DEFAULTRARITY, DEFAULTVALUE);
    }
    public String toString(){
      return "Item/Skin name: " + this.itemName + ", Rarity(Steam market) = " + this.itemRarity + ", Item value(Steam market) = " + this.itemValue;
    }
    
  }
  
  protected VideoGame(String name, String publisher, double playtime, int achievements)
  {
    this.gameName = name;
    this.gamePlayTime = playtime;
    this.gamePublisher = publisher;
    this.gameAchievements = achievements;
  }
  protected VideoGame(){
    this.gameName = DEFAULTNAME;
    this.gamePlayTime = DEFAULTPLAYTIME;
    this.gamePublisher = DEFAULTPUBLISHER;
    this.gameAchievements = DEFAULTACHIEVEMENTS;
  }
  VideoGame(VideoGame original){
    gameName = original.gameName;
    gamePlayTime = original.gamePlayTime;
    gamePublisher = original.gamePublisher;
    gameAchievements = original.gameAchievements;
  }
  public void setGameName(String gameName){
    this.gameName = gameName;
  }
  public void setGamePlayTime(double gamePlayTime){
    this.gamePlayTime = gamePlayTime;
  }
  public void setGamePublisher(String gamePublisher){
    this.gamePublisher = gamePublisher;
  }
  public void setGameAchievements(int gameAchievements){
    this.gameAchievements = gameAchievements;
  }
  public String getGameName()
  {
    return gameName;
  }
  public double getPlayTime()
  {
    return gamePlayTime;
  }
  public String getGamePublisher()
  {
    return gamePublisher;
  }
  public int getAchievements()
  {
    return gameAchievements;
  }
    public void setPlacesVisited(int placesVisited){
      this.placesVisited = placesVisited;
    }
    public void setCharactersMet(int charactersMet){
      this.charactersMet = charactersMet;
    }
    public void setItemsFound(int itemsFound){
      this.itemsFound = itemsFound;
    }
    public void setSpeedrunTime(double speedrunTime){
      this.speedrunTime = speedrunTime;
    }
    public void setFullCompletion(boolean fullCompletion){
      this.fullCompletion = fullCompletion;
    }
    public int getPlacesVisited(){
      return this.placesVisited;
    }
    public int getCharactersMet(){
      return this.charactersMet;
    }
    public int getItemsFound(){
      return this.itemsFound;
    }
    public double getSpeedrunTime(){
      return this.speedrunTime;
    }
    public boolean getFullCompletion(){
      return this.fullCompletion;
    }
  public void setFriendsThatPlay(int friendsThatPlay){
    this.friendsThatPlay = friendsThatPlay;
  }
  public void setGameWon(int gamesWon){
    this.gamesWon = gamesWon;
  }
  public void setRank(String rank){
    this.rank = rank;
  }
  public void setLevel(int level){
    this.level = level;
  }
  public int getFriendsThatPlay() {
    return this.friendsThatPlay;
  }
  public int getGamesWon() {
    return this.gamesWon;
  }
  public String getRank() {
    return this.rank;
  }
  public int getLevel() {
    return this.level;
  }
  public String toString(){
    return "Game title: " + this.gameName + ", Game publisher: " + this.gamePublisher + ", Game playtime: " + this.gamePlayTime + "hours, Number of game achievements: " + this.gameAchievements;
  }
  

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        VideoGame that = (VideoGame) o;
        return this.gameName == that.gameName &&
                Double.compare(this.gamePlayTime, that.gamePlayTime) == 0 &&
               this.gameName.equals(that.gameName) && this.gameAchievements == that.gameAchievements && this.gamePublisher.equals(that.gamePublisher);
    }
}