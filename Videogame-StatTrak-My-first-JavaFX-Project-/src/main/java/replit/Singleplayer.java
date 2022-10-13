package replit;

public class Singleplayer extends VideoGame
  {
    protected int placesVisited;
    protected int charactersMet;
    protected int itemsFound;
    protected double speedrunTime;
    protected boolean fullCompletion;
    protected static final int DEFAULTPLACES = 1;
    protected static final int DEFAULTCHARACTERS = 1;
    protected static final int DEFAULTITEMS = 0;
    protected static final double SPEEDRUNTIME = 0.0;
    protected static final boolean DEFAULTCOMPLETION = false;

    public Singleplayer(String gameName, String gamePublisher, double gamePlayTime, int gameAchievements, int placesVisited, int charactersMet, int itemsFound, double speedrunTime, boolean fullCompletion){
      super();
      this.gameName = gameName;
      this.gamePlayTime = gamePlayTime;
      this.gamePublisher = gamePublisher;
      this.gameAchievements = gameAchievements;
      this.placesVisited = placesVisited;
      this.charactersMet = charactersMet;
      this.itemsFound = itemsFound;
      this.speedrunTime = speedrunTime;
      this.fullCompletion = fullCompletion;
    }
    public Singleplayer(){
      this.gameName = DEFAULTNAME;
      this.gamePlayTime = DEFAULTPLAYTIME;
      this.gamePublisher = DEFAULTPUBLISHER;
      this.gameAchievements = DEFAULTACHIEVEMENTS;
      this.placesVisited = DEFAULTPLACES;
      this.charactersMet = DEFAULTCHARACTERS;
      this.itemsFound = DEFAULTITEMS;
      this.speedrunTime = SPEEDRUNTIME;
      this.fullCompletion = DEFAULTCOMPLETION;
    }
    Singleplayer(Singleplayer c){
      gameName = c.gameName;
      gamePlayTime = c.gamePlayTime;
      gamePublisher = c.gamePublisher;
      gameAchievements = c.gameAchievements;
      placesVisited = c.placesVisited;
      charactersMet = c.charactersMet;
      itemsFound = c.itemsFound;
      speedrunTime = c.speedrunTime;
      fullCompletion = c.fullCompletion;
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
    @Override
    public String toString(){
      return "Game type: Singeplayer, Game title: " + this.gameName + ", Game publisher: " + this.gamePublisher + ", Multiplayer, Game playtime: " + this.gamePlayTime + " hours, Number of game achievements: " + this.gameAchievements + ", Places visited In-game: " + this.placesVisited + ", Characters encountered: " + this.charactersMet + ", amount of items found: " + this.itemsFound + ", fasted speedrun: " + this.speedrunTime + " hours, full completion: " + this.fullCompletion;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        Singleplayer that = (Singleplayer) o;
        return this.gameName == that.gameName &&
                Double.compare(this.gamePlayTime, that.gamePlayTime) == 0 &&
               this.gameName.equals(that.gameName) && this.gameAchievements == that.gameAchievements && this.gamePublisher.equals(that.gamePublisher) && this.placesVisited == that.placesVisited && this.charactersMet == that.charactersMet && this.itemsFound == that.itemsFound && this.speedrunTime == that.speedrunTime && this.fullCompletion == that.fullCompletion;
  }
}