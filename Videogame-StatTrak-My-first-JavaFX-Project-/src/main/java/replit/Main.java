package replit;

import com.google.errorprone.annotations.ForOverride;

//package name here depending on your IDE

import javafx.application.Application;  //abstract class used for JavaFX GUI's
import javafx.stage.Stage;              //class for GUI window
import javafx.scene.Scene;              //class for specific view in GUI window
import javafx.scene.layout.VBox;        //class for layout pane, organized top-to-bottom
import javafx.scene.control.Label;      //class for label component
import javafx.scene.control.Button;     //class for button component
import javafx.event.EventHandler;       //interface for handling events
import javafx.event.ActionEvent;        //class for type of event for action (like button or key pressed)
import javafx.scene.control.TextField;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;



public class Main extends Application {//implements EventHandler<ActionEvent>  { //inheriting core functionality + this class will handle events
  /*** GUI COMPONENTS ***/
  private Button button, button2, button3, button4, viewGames, goHome, viewMostPlayed, totalPlayed, barChart, speedrunBarChart;
  
  TextField nameText = new TextField();
  TextField playtimeText = new TextField();
  TextField publisherText = new TextField();
  TextField achievementsText = new TextField();
  TextField placesVisitedText = new TextField();
  TextField charactersMetText = new TextField();
  TextField speedrunTimeText = new TextField();
  TextField itemsFoundText = new TextField();
  TextField friendsText = new TextField();
  TextField gamesWonText = new TextField();
  TextField rankText = new TextField();
  TextField levelText = new TextField();
  String gameName, gamePublisher, rank;
  int placesVisited, charactersMet, itemsFound, gameAchievements, friendsThatPlay, gamesWon, level;
  double gamePlayTime, speedrunTime;
  boolean fullCompletion;
  VideoGame[] gameCollection = new VideoGame[2];
  VideoGame[] gameCollectionResize = new VideoGame[1];
  Label[] gameCollectionTextCopy;
  Singleplayer maxSingle = new Singleplayer();
  Singleplayer maxMultiplayer = new Singleplayer();
  Singleplayer use1 = new Singleplayer();
  Multiplayer use2 = new Multiplayer();
  Label mostPlayed = new Label("");
  ArrayList<VideoGame> videogameArraylist = new ArrayList<VideoGame>();
  ArrayList<VideoGame> submitArray = new ArrayList<VideoGame>();
  ArrayList<Label> videogameLabelList = new ArrayList<Label>();

  int count1 = 0;
  int playType = 0;

  //int count2 = 0;
  

  /*** DRIVER main ***/
  public static void main(String[] args) {
    launch(args); //method from Application class, must be called to setup javafx application
  }

  /*** OVERRIDDEN Application METHODS ***/
  @Override
  public void start(Stage primaryStage) throws Exception{ //Application automatically calls this method to run (our) main javafx code. passes in primary stage (main window)
    //SETUP COMPONENTS

    Random rand = new Random();
    Label message = new Label("Hi User!");
    Label button2message = new Label("You are cool!");
    Label button3message = new Label("");
    button3message.setWrapText(true);
    Label totalHoursLabel = new Label("");
    Label nameL = new Label("Enter the game name:");
    Label publisherL = new Label("Enter the game publisher:");
    Label playtimeL = new Label("Total playtime(in hours, ex 5.5):");
    Label achievementsL = new Label("Achievements unlocked:");
    Label placesVisitedL = new Label("# of Places Visited:");
    Label charactersMetL = new Label("# of Characters Met:");
    Label speedrunTimeL = new Label("Fasted speedrun(in hours, ex 5.5):");
    Label itemsFoundL = new Label("# of items found:");
    Label gamePrinter = new Label("");
    Label friendsL = new Label("Enter how many friends play:");
    Label gamesWonL = new Label("Enter how many games have you won:");
    Label rankL = new Label("Enter your current rank:");
    Label levelL = new Label("Enter you current level:");
    Label errorLabel = new Label("Error: no data given for at lest one entry");
    Label sameGameName = new Label("Error: duplicate game data given");
    //Label introTotal = new Label("You have played");
    
    //name.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(5));
    nameText.clear();
    playtimeText.clear();
    publisherText.clear();
    achievementsText.clear();
    placesVisitedText.clear();
    charactersMetText.clear();
    speedrunTimeText.clear();
    itemsFoundText.clear();
    
    button = new Button("Click me for singleplayer"); //or can set text using setText method separately
    //button.setOnAction(this); //who the event handler is (which object/class should handle the event)
    button2 = new Button("Click me for multiplayer");
    //button2.setOnAction(this);
    button3 = new Button("Submit!");
    //button3.setOnAction(this);
    button4 = new Button("Click this if you completed the whole game! (100%)");
    //button4.setOnAction(this);
    viewGames = new Button("View games");
    //viewGames.setOnAction(this);
    goHome = new Button("Go to the home page");
    //goHome.setOnAction(this);
    viewMostPlayed = new Button("View most played game");
    //viewMostPlayed.setOnAction(this);
    totalPlayed = new Button("Total hours spent playing games");
    //bar chart of game hours
    barChart = new Button("Bar Chart of game hours");
    speedrunBarChart = new Button("Bar Chart of speedruns");
    
    //ADD COMPONENTS
    VBox layout = new VBox(); //simple layout, components are stacked on top of each other in added order
    layout.getChildren().add(message);
    layout.getChildren().add(button);
    layout.getChildren().add(button2);
    //layout.getChildren().add(button2);

    //SETUP SCENE AND SHOW
    Scene scene = new Scene(layout, 550, 450); //layout, dimensions of window
    primaryStage.setScene(scene);
    primaryStage.setTitle("Videogame StatTrak"); //setting title of main window
    primaryStage.show();
  

    button.setOnAction(new EventHandler<ActionEvent>(){
      @Override 
      public void handle(ActionEvent event) {
        
      }
    });
    //SINGLEPLAYER BUTTON
    button.setOnAction(new EventHandler<ActionEvent>(){
      @Override 
      public void handle(ActionEvent event) {
        fullCompletion = false;
        layout.getChildren().remove(message);
        layout.getChildren().remove(button);
        layout.getChildren().remove(button2);
        layout.getChildren().remove(viewGames);
        layout.getChildren().remove(barChart);
        layout.getChildren().remove(speedrunBarChart);
        layout.getChildren().add(nameL);
        layout.getChildren().add(nameText);
        layout.getChildren().add(publisherL);
        layout.getChildren().add(publisherText);
        layout.getChildren().add(playtimeL);
        layout.getChildren().add(playtimeText);
        layout.getChildren().add(achievementsL);
        layout.getChildren().add(achievementsText);
        layout.getChildren().add(placesVisitedL);
        layout.getChildren().add(placesVisitedText);
        layout.getChildren().add(charactersMetL);
        layout.getChildren().add(charactersMetText);
        layout.getChildren().add(itemsFoundL);
        layout.getChildren().add(itemsFoundText);
        layout.getChildren().add(speedrunTimeL);
        layout.getChildren().add(speedrunTimeText);
        layout.getChildren().add(button4);
        layout.getChildren().add(button3);
        playType = 1;
        
      }
    });
    //MULTIPLAYER BUTTON
    button2.setOnAction(new EventHandler<ActionEvent>(){
      @Override 
      public void handle(ActionEvent event) {
        fullCompletion = false;
        layout.getChildren().remove(message);
        layout.getChildren().remove(button);
        layout.getChildren().remove(button2);
        layout.getChildren().remove(viewGames);
        layout.getChildren().remove(barChart);
        layout.getChildren().remove(speedrunBarChart);
        layout.getChildren().add(nameL);
        layout.getChildren().add(nameText);
        layout.getChildren().add(publisherL);
        layout.getChildren().add(publisherText);
        layout.getChildren().add(playtimeL);
        layout.getChildren().add(playtimeText);
        layout.getChildren().add(achievementsL);
        layout.getChildren().add(achievementsText);
        layout.getChildren().add(friendsL);
        layout.getChildren().add(friendsText);
        layout.getChildren().add(gamesWonL);
        layout.getChildren().add(gamesWonText);
        layout.getChildren().add(rankL);
        layout.getChildren().add(rankText);
        layout.getChildren().add(levelL);
        layout.getChildren().add(levelText);
        //layout.getChildren().add(button4);
        layout.getChildren().add(button3);
        playType = 2;
        
      }
    });
    //SUBMIT BUTTON
    button3.setOnAction(new EventHandler<ActionEvent>(){
      @Override    
      public void handle(ActionEvent event) {
        layout.getChildren().remove(errorLabel);
        layout.getChildren().remove(sameGameName);
        
        int nameProblem = 0;
        int singleProblem = 0;
        int multiProblem = 0;
        if(playType == 1){
          //layout.getChildren().remove(errorLabel);
          for(int i = 0; i < count1; i++){
            //System.out.println(videogameArraylist.get(i) + "\n\n\n\n" + nameText.getText());
            if(nameText.getText().equals(videogameArraylist.get(i).gameName)){
              layout.getChildren().add(sameGameName);
              nameProblem = 1;
            }
          }
          
        
        if(nameText.getText() == null || publisherText.getText() == null || playtimeText.getText() == null || achievementsText.getText() == null || placesVisitedText.getText() == null || charactersMetText.getText() == null || itemsFoundText.getText() == null || speedrunTimeText.getText() == null){
          
          layout.getChildren().add(errorLabel);
          singleProblem = 1;
        }
        }
        else if(playType == 2){
          //layout.getChildren().remove(errorLabel);
          for(int i = 0; i < count1; i++){
            if(nameText.getText().equals(videogameArraylist.get(i).gameName)){
              layout.getChildren().add(sameGameName);
              nameProblem = 1;
            }
          }
          if(nameText.getText() == null || publisherText.getText() == null || playtimeText.getText() == null || achievementsText.getText() == null || friendsText.getText() == null || gamesWonText.getText() == null || rankText.getText() == null || levelText.getText() == null){
            layout.getChildren().add(errorLabel);
            multiProblem = 1;
          }
        }
        while(nameProblem == 0 && singleProblem == 0 && multiProblem == 0){
        gameName = nameText.getText();
        gamePublisher = publisherText.getText();
        gamePlayTime = Double.parseDouble(playtimeText.getText());
        gameAchievements = Integer.parseInt(achievementsText.getText());
        if(playType == 1) {
        placesVisited = Integer.parseInt(placesVisitedText.getText());
        charactersMet = Integer.parseInt(charactersMetText.getText());
        itemsFound = Integer.parseInt(itemsFoundText.getText());
        speedrunTime = Double.parseDouble(speedrunTimeText.getText());
        //gameCollection[count1++] = new Singleplayer(gameName, gamePublisher, gamePlayTime, gameAchievements, placesVisited, charactersMet, itemsFound, speedrunTime, fullCompletion);
        videogameArraylist.add(new Singleplayer(gameName, gamePublisher, gamePlayTime, gameAchievements, placesVisited, charactersMet, itemsFound, speedrunTime, fullCompletion));
        nameText.clear();
        playtimeText.clear();
        publisherText.clear();
        achievementsText.clear();
        placesVisitedText.clear();
        charactersMetText.clear();
        speedrunTimeText.clear();
        itemsFoundText.clear();
        layout.getChildren().remove(button4);
        layout.getChildren().remove(placesVisitedL);
        layout.getChildren().remove(placesVisitedText);
        layout.getChildren().remove(charactersMetL);
        layout.getChildren().remove(charactersMetText);
        layout.getChildren().remove(itemsFoundL);
        layout.getChildren().remove(itemsFoundText);
        layout.getChildren().remove(speedrunTimeL);
        layout.getChildren().remove(speedrunTimeText);
        layout.getChildren().remove(errorLabel);
        layout.getChildren().remove(sameGameName);
        }
        
        if(playType == 2){
        friendsThatPlay = Integer.parseInt(friendsText.getText());
        gamesWon = Integer.parseInt(gamesWonText.getText());
        rank = rankText.getText();
        level = Integer.parseInt(levelText.getText());
        //gameCollection[count1++] = new Multiplayer(gameName, gamePublisher, gamePlayTime, gameAchievements, friendsThatPlay, gamesWon, rank, level);
        videogameArraylist.add(new Multiplayer(gameName, gamePublisher, gamePlayTime, gameAchievements, friendsThatPlay, gamesWon, rank, level));  
        nameText.clear();
        playtimeText.clear();
        publisherText.clear();
        achievementsText.clear();
        friendsText.clear();
        gamesWonText.clear();
        rankText.clear();
        levelText.clear();
        layout.getChildren().remove(friendsL);
        layout.getChildren().remove(friendsText);
        layout.getChildren().remove(gamesWonL);
        layout.getChildren().remove(gamesWonText);
        layout.getChildren().remove(rankL);
        layout.getChildren().remove(rankText);
        layout.getChildren().remove(levelL);
        layout.getChildren().remove(levelText);
        layout.getChildren().remove(errorLabel);
        layout.getChildren().remove(sameGameName);
        
        }
        gameCollectionResize = Arrays.copyOf(gameCollection, count1);
        layout.getChildren().remove(nameL);
        layout.getChildren().remove(nameText);
        layout.getChildren().remove(publisherL);
        layout.getChildren().remove(publisherText);
        layout.getChildren().remove(playtimeL);
        layout.getChildren().remove(playtimeText);
        layout.getChildren().remove(achievementsL);
        layout.getChildren().remove(achievementsText);
        layout.getChildren().remove(errorLabel);
        layout.getChildren().remove(sameGameName);
        layout.getChildren().remove(barChart);
        layout.getChildren().remove(speedrunBarChart);

        //layout.getChildren().remove(button4);
        layout.getChildren().remove(button3);
        fullCompletion = false;
        layout.getChildren().add(message);
        layout.getChildren().add(button);
        layout.getChildren().add(button2);
        layout.getChildren().add(viewGames);
        layout.getChildren().add(barChart);
        layout.getChildren().add(speedrunBarChart);
        playType = 0;
        break;
        }
      }
    });
    button4.setOnAction(new EventHandler<ActionEvent>(){
      @Override    
      public void handle(ActionEvent event) {
        fullCompletion = true;
      }
    });
    ArrayList<Label> gameTextList = new ArrayList<Label>();

    //VIEW GAMES BUTTON
    viewGames.setOnAction(new EventHandler<ActionEvent>(){
      @Override    
      public void handle(ActionEvent event) {
        
        layout.getChildren().remove(message);
        layout.getChildren().remove(button);
        layout.getChildren().remove(button2);
        layout.getChildren().remove(viewGames);
        layout.getChildren().remove(speedrunBarChart);
        layout.getChildren().remove(barChart);
        //for(int i = 0; i < gameCollection.length; i++){
        int count2 = 0;
        Label gameCollectionText[] = new Label[count1];
        //ArrayList<Label> gameTextList = new ArrayList<Label>();
        layout.getChildren().add(goHome);
        layout.getChildren().add(viewMostPlayed);
        layout.getChildren().add(totalPlayed);
        Label test = new Label();
        /*for (int i = 0; i < videogameArrayList.size(); i++){
        gameTextList.get(i) = videogameArraylist.get(i);
        
        layout.getChildren().add(gameTextList(i));
        }*/
        
          //Label gameCollectionText[] = new Label[count1];
          //gameCollectionText[count2] = new Label(gameCollectionResize[count2].toString() + "\n\n");
          for(int i = 0; i < videogameArraylist.size(); i++){
          Label viewLabeluse = new Label(videogameArraylist.get(i) + "\n\n");
          videogameLabelList.add(viewLabeluse);
          //gameCollectionText[count2].setText(gameCollection[count2].toString());
          videogameLabelList.get(i).setWrapText(true);
          //System.out.println("\n\n\n\n" + videogameLabelList.get(i) + "\n\n\n\n");
          layout.getChildren().add(videogameLabelList.get(i));
          //layout.getChildren().add(gameCollectionText[count2]);
          
        
        
        
        //layout.getChildren().add(gamePrinter);
        }
      }
    });

    //GO HOME BUTTON
    goHome.setOnAction(new EventHandler<ActionEvent>(){
      @Override    
      public void handle(ActionEvent event) {
        int count3 = 0;
      
        for(int i = 0; i < videogameLabelList.size(); i++){
          layout.getChildren().remove(videogameLabelList.get(i));
        }
          //layout.getChildren().remove(gameCollectionTextCopy[count3++]);
          layout.getChildren().remove(goHome);
          layout.getChildren().remove(viewMostPlayed);
          layout.getChildren().remove(mostPlayed);
          layout.getChildren().remove(totalPlayed);
          layout.getChildren().remove(totalHoursLabel);
          layout.getChildren().add(message);
          layout.getChildren().add(button);
          layout.getChildren().add(button2);
          layout.getChildren().add(viewGames);
          layout.getChildren().add(barChart);
          layout.getChildren().add(speedrunBarChart);
          
        //}while(count3 < count1);
      }
    });
    //TOTAL PLAYED
    totalPlayed.setOnAction(new EventHandler<ActionEvent>(){
      
      
      @Override
      public void handle(ActionEvent event) {
        //totalPlayed(videogameArraylist);
        totalHoursLabel.setText("You have played " + String.valueOf(totalPlayed(videogameArraylist)) + " hours worth of videogames!");
        totalHoursLabel.setWrapText(true);
        layout.getChildren().remove(viewMostPlayed);
        layout.getChildren().remove(goHome);
        layout.getChildren().remove(totalPlayed);
        for(int i = 0; i < videogameLabelList.size(); i++){
          layout.getChildren().remove(videogameLabelList.get(i));
        }
        layout.getChildren().add(goHome);
        layout.getChildren().add(totalHoursLabel);
      }
    });

    //VIEW MOST PLAYED BUTTON
    viewMostPlayed.setOnAction(new EventHandler<ActionEvent>(){
      @Override    
      public void handle(ActionEvent event) {
        //System.out.println("\n\n\n\n" + mostPlayedGame(videogameArraylist).toString() + "\n\n\n");
        for(int i = 0; i < videogameLabelList.size(); i++){
          layout.getChildren().remove(videogameLabelList.get(i));
        }
        layout.getChildren().remove(viewMostPlayed);
        layout.getChildren().remove(totalPlayed);
        
        
          mostPlayed = new Label("Your most played game is:\n\n" + mostPlayedGame(videogameArraylist).toString());
          mostPlayed.setWrapText(true);
        //+ mostPlayedGame(gameCollectionResize)
          layout.getChildren().add(mostPlayed);
       
      }
    });
     //BAR CHART
    
        barChart.setOnAction(new EventHandler<ActionEvent>(){
          @Override    
            public void handle(ActionEvent event) {
            
       
            
            Stage stage1 = new Stage();
            stage1.setTitle("Game Time Bar Chart (CLOSE THIS WINDOW TO RETURN)");
            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
            final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
            bc.setTitle("Hours Played");
            xAxis.setLabel("Games"); 
            yAxis.setLabel("Hours played");

          //test
            XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
            for (int i = 0; i < videogameArraylist.size(); i++){
              series1.setName("GAMES");    
              System.out.println(videogameArraylist.get(i).speedrunTime);
              System.out.println(videogameArraylist.get(i).gamePlayTime);
              series1.getData().add(new XYChart.Data<String, Number>(videogameArraylist.get(i).gameName, videogameArraylist.get(i).gamePlayTime));
            }
            
            bc.getData().add(series1);
            stage1.setScene(new Scene(bc,600,600));
            stage1.show();
            

          
       

      }
    });

        speedrunBarChart.setOnAction(new EventHandler<ActionEvent>(){
          @Override    
            public void handle(ActionEvent event) {
            
       
            
            Stage stage2 = new Stage();
            stage2.setTitle("Speedrun Bar Chart (CLOSE THIS WINDOW TO RETURN)");
            final CategoryAxis xAxis2 = new CategoryAxis();
            final NumberAxis yAxis2 = new NumberAxis();
            final BarChart<String,Number> bc1 = new BarChart<String,Number>(xAxis2,yAxis2);
            bc1.setTitle("Hours Played");
            xAxis2.setLabel("Games"); 
            yAxis2.setLabel("Speedrun time");

          //test
            XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
            for (int i = 0; i < videogameArraylist.size(); i++){

              if(videogameArraylist.get(i) instanceof Singleplayer){
                series2.setName("GAMES");    
                //System.out.println(videogameArraylist.get(i).getSpeedrunTime());
                series2.getData().add(new XYChart.Data<String, Number>(videogameArraylist.get(i).gameName, videogameArraylist.get(i).getSpeedrunTime()));
              }
            }
            
            bc1.getData().add(series2);
            stage2.setScene(new Scene(bc1,600,600));
            stage2.show();
            

          
       

      }
    });
    
  

    


  }
    
  
  //MOST PLAYED GAME METHOD
  public VideoGame mostPlayedGame(ArrayList<VideoGame> gameCollectionResize){
    
    double max = 0;
    Singleplayer mostUse = new Singleplayer("M", "M", -1.0, 0, 0, 0, 0, 0.0, false);
    VideoGame[] mostPlayed = new VideoGame[1];
    mostPlayed[0] = mostUse;
    
    //VideoGame blank = new VideoGame();
    Singleplayer use1 = new Singleplayer();
    Multiplayer use2 = new Multiplayer();
    
    for (int i = 0; i < gameCollectionResize.size(); i++) {
      
        max = gameCollectionResize.get(i).gamePlayTime;
        if(gameCollectionResize.get(i).getClass() == use1.getClass()){
          if (mostPlayed[0].gamePlayTime < gameCollectionResize.get(i).gamePlayTime || mostPlayed[0].gamePlayTime == 0.0){
          String sName = gameCollectionResize.get(i).gameName;
          String sPublisher = gameCollectionResize.get(i).gamePublisher;
          double sPlaytime = gameCollectionResize.get(i).gamePlayTime;
          int sAchievements = gameCollectionResize.get(i).gameAchievements;
          int sPlaces = gameCollectionResize.get(i).getPlacesVisited();
          int sCharacters = gameCollectionResize.get(i).getCharactersMet();
          int sItems = gameCollectionResize.get(i).getItemsFound();
          double sSpeedrun = gameCollectionResize.get(i).getSpeedrunTime();
          boolean sCompletion = gameCollectionResize.get(i).getFullCompletion();
          Singleplayer maxSingle = new Singleplayer(sName, sPublisher, sPlaytime, sAchievements, sPlaces, sCharacters, sItems, sSpeedrun, sCompletion);
          mostPlayed[0] = maxSingle;
          
          }
        }//end if 
        else if(gameCollectionResize.get(i).getClass() == use2.getClass()){
          if (mostPlayed[0].gamePlayTime < gameCollectionResize.get(i).gamePlayTime){
          String mName = gameCollectionResize.get(i).gameName;
          String mPublisher = gameCollectionResize.get(i).gamePublisher;
          double mPlaytime = gameCollectionResize.get(i).gamePlayTime;
          int mAchievements = gameCollectionResize.get(i).gameAchievements;
          int mFriends = gameCollectionResize.get(i).getFriendsThatPlay();
          int mGamesWon = gameCollectionResize.get(i).getGamesWon();
          String mRank = gameCollectionResize.get(i).getRank();
          int mLevel = gameCollectionResize.get(i).getLevel();
          Multiplayer maxMultiplayer = new Multiplayer(mName, mPublisher, mPlaytime, mAchievements, mFriends, mGamesWon, mRank, mLevel);
          mostPlayed[0] = maxMultiplayer;
          
          }
        }
       
          //return mostPlayed[0];
      
    
    }//end for
    return mostPlayed[0];
  }

  public double totalPlayed(ArrayList<VideoGame> videogameArraylist){
    double totalHours = 0.0;
    for (int i = 0; i < videogameArraylist.size(); i++){
      totalHours += videogameArraylist.get(i).gamePlayTime;
    }
    System.out.println(totalHours);
    return totalHours;
    
  }
  
}


  

  /*** OVERRIDDEN EventHandler METHODS ***/
//   @Override
//   public void handle(ActionEvent actionEvent) { //generic method used to handle when events occur (like handle button click)

//     //good practice to identify source, in case you have multiple event types/sources


// }

/*TextField1.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(5));
    
AutoControl.setOnMousePressed(new EventHandler<MouseEvent>() {
    
    @Override
    public void handle(MouseEvent event) {
        TextField1.clear();
    }
}*/


/**






handle for submit:
if submitButton:
  temp = name.getText();
  int index = temp.indexOf(":");//int value of index of colon
  if(index == -1){
    index = 0
  }
  gameName = temp.subString(index+1);//take every after colon






*/