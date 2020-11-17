import csv_parsing.CSVReader;
import player_team_models.Player;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

  public static ArrayList<Player> manchesterUnited = new ArrayList<Player>();



  public static void main(String[] args) throws IOException {
    String teamName = "";
    String statDescription = "";

    for (int i = 0; i < args.length; i++){
      teamName += args[i];

      if (args[i].lastIndexOf( ',' ) == args[i].length() - 1){
        //at this point we have the team name, still need to do:
        //format the teamName string to fit fileName
        teamName = teamName.substring( 0, teamName.indexOf( ',' ));

        teamName = teamName.toLowerCase();

        // get the "offense/defence" parameter
        try {
          statDescription = args[i + 1];
          System.out.println("the stat description is: " + statDescription);
        } catch (ArrayIndexOutOfBoundsException e){
          System.out.println( "Incorrect run command. Please use the following format: " );
          System.out.println();
          System.out.println("java src.Main 'Team Name', 'stat description' ");
          System.out.println();
          System.out.println( "Example: java src.Main Manchester United, offense" );
          System.exit( 0 );
        }
        // break out of the for loop
        //make the csv reader and read with the correct filepath
      }
    }

    System.out.println("WELCOME TO THE FIRST ITERATION OF GAREN'S SOCCER DATA ANALYSIS PROGRAM");

    CSVReader reader = new CSVReader();

    manchesterUnited = reader.readTeamFromFile("soccer_data_program/team_stats/manchesterunited.csv");

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
