import csv_parsing.CSVReader;
import player_team_models.Player;
import statistics_models.offense.PlayerGoalContribution;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

  public static ArrayList<Player> team = new ArrayList<Player>();

  public static void main(String[] args) throws IOException {
    String teamName = "";
    String statDescription = "";

    for (int i = 0; i < args.length; i++){
      teamName += args[i];

      if (args[i].lastIndexOf( ',' ) == args[i].length() - 1){
        teamName = teamName.substring( 0, teamName.indexOf( ',' ));
        teamName = teamName.toLowerCase();

        try {
          statDescription = args[i + 1];
        } catch (ArrayIndexOutOfBoundsException e){
          displayRunCommand();
        }

        break;
      }
    }

    System.out.println("WELCOME TO THE FIRST ITERATION OF GAREN'S SOCCER DATA ANALYSIS PROGRAM");

    if ( statDescription.equals( "offense" ) ){
      CSVReader reader = new CSVReader();
      team = reader.readTeamFromFile("soccer_data_program/team_stats/" + teamName + ".csv");

      PlayerGoalContribution contribution = new PlayerGoalContribution();

      System.out.println("----- DISPLAYING SIMPLE PLAYER GOAL CONTRIBUTION -----");
      for (Player player: team ){
        System.out.println(player.getName() + " goal contribution: " + contribution.calculateSimpleGoalContribution( player ));
      }

      for (int i = 0; i < 5; i++){
        System.out.println();
      }

      System.out.println("----- DISPLAYING GOAL CONTRIBUTION WITH MINUTES PLAYED -----");
      for (Player player: team ){
        System.out.println(player.getName() + " goal contribution: " + contribution.calculateGoalContributionWithMinutes( player ));
      }
    }
    else if ( statDescription.equals( "defense" ) ){
      System.out.println("Sorry but defensive stats are not being recorded yet");
    }
  }

  private static void displayRunCommand(){
    System.out.println( "Incorrect run command. Please use the following format: " );
    System.out.println();
    System.out.println("java src.Main 'Team Name', 'stat description' ");
    System.out.println();
    System.out.println( "Example: java src.Main Manchester United, offense" );
    System.exit( 0 );
  }

}
