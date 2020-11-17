package player_team_models;

public class Player {

  private String name;
  private int goalCount;
  private int assistCount;
  private int minutesPlayed;

  public Player(String playerName, int playerGoalCount, int playerAssistCount, int playerMinutesPlayed){
    name = playerName;
    goalCount = playerGoalCount;
    assistCount = playerAssistCount;
    minutesPlayed = playerMinutesPlayed;
  }

  public String getName(){
    return name;
  }
  public int getGoalCount(){
    return goalCount;
  }
  public int getAssistCount(){
    return assistCount;
  }
  public int getMinutesPlayed(){
    return minutesPlayed;
  }
}
