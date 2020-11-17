package csv_parsing;

import player_team_models.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {

  public CSVReader() { }

  public ArrayList<Player> readTeamFromFile( String sourceFile) throws IOException {
    ArrayList<Player> team = new ArrayList<Player>();

    try{
      File testFile = new File(sourceFile);
      Scanner myReader = new Scanner(testFile);

      while(myReader.hasNextLine()){
        String line = myReader.nextLine();
        String splitArray[] = line.split( "," );
        team.add( new Player( splitArray[0], Integer.parseInt( splitArray[1] ), Integer.parseInt( splitArray[2] ), Integer.parseInt( splitArray[3] ) ) );
      }

    } catch ( Exception e ){
      System.out.println(e);
    }
    return team;
  }
}
