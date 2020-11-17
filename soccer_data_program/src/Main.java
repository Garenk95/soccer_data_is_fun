import java.io.IOException;
import java.util.ArrayList;

public class Main {

  public static ArrayList<Player> manchesterUnited = new ArrayList<Player>();



  public static void main(String[] args) throws IOException {
    System.out.println("WELCOME TO THE FIRST ITERATION OF GAREN'S SOCCER DATA ANALYSIS PROGRAM");

    TeamFileReader reader = new TeamFileReader();

    manchesterUnited = reader.readTeamFromFile("soccer_data_program/team_stats/ManchesterUnited.csv");

    PlayerGoalContribution contribution = new PlayerGoalContribution();

    System.out.println("----- DISPLAYING SIMPLE PLAYER GOAL CONTRIBUTION -----");
    for (Player player: manchesterUnited){
      System.out.println(player.getName() + " goal contribution: " + contribution.calculateSimpleGoalContribution( player ));
    }

    for (int i = 0; i < 5; i++){
      System.out.println();
    }

    System.out.println("----- DISPLAYING GOAL CONTRIBUTION WITH MINUTES PLAYED -----");
    for (Player player: manchesterUnited){
      System.out.println(player.getName() + " goal contribution: " + contribution.calculateGoalContributionWithMinutes( player ));
    }
  }
}
