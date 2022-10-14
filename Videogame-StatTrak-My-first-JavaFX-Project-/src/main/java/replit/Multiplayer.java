package replit;

public class Multiplayer extends VideoGame
{
  protected int friendsThatPlay;
  protected int gamesWon;
  protected String rank;
  protected int level;
  protected static final int DEFAULTFRIENDS = 0;
  protected static final int DEFAULTGAMESWON = 0;
  protected static final String DEFAULTRANK = "Bronze";
  protected static final int DEFAULTLEVEL = 0;
  int friendsStarter;


  public Multiplayer(String gameName, String gamePublisher, double gamePlayTime, int gameAchievements, int friendsThatPlay, int gamesWon, String rank, int level){
    super();
    this.gameName = gameName;
    this.gamePlayTime = gamePlayTime;
    this.gamePublisher = gamePublisher;
    this.gameAchievements = gameAchievements;
    this.friendsThatPlay = friendsThatPlay;
    this.gamesWon = gamesWon;
    this.rank = rank;
    this.level = level;
  }
  public Multiplayer(){
    super();
    this.gameName = DEFAULTNAME;
    this.gamePlayTime = DEFAULTPLAYTIME;
    this.gamePublisher = DEFAULTPUBLISHER;
    this.gameAchievements = DEFAULTACHIEVEMENTS;
    this.friendsThatPlay = DEFAULTFRIENDS;
    this.gamesWon = DEFAULTGAMESWON;
    this.rank = DEFAULTRANK;
    this.level = DEFAULTLEVEL;
  }
  Multiplayer(Multiplayer c){
    super();
    gameName = c.gameName;
    gamePlayTime = c.gamePlayTime;
    gamePublisher = c.gamePublisher;
    gameAchievements = c.gameAchievements;
    friendsThatPlay = c.friendsThatPlay;
    gamesWon = c.gamesWon;
    rank = c.rank;
    level = c.level;
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
    return "Game type: Multiplayer, Game title: " + this.gameName + ", Game publisher: " + this.gamePublisher + ", Multiplayer, Game playtime: " + this.gamePlayTime + " hours, Number of game achievements: " + this.gameAchievements + ", How many friends play: " + this.friendsThatPlay + ", Total games won: " + this.gamesWon + ", Current rank: " + this.rank + ", Current level: " + this.level;
  }
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        Multiplayer that = (Multiplayer) o;
        return this.gameName == that.gameName &&
                Double.compare(this.gamePlayTime, that.gamePlayTime) == 0 &&
               this.gameName.equals(that.gameName) && this.gameAchievements == that.gameAchievements && this.gamePublisher.equals(that.gamePublisher) && this.friendsThatPlay == that.friendsThatPlay && this.gamesWon == that.gamesWon && this.rank.equals(that.rank) && this.level == that.level;
    }




  
}