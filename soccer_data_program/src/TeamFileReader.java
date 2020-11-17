import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamFileReader {
  private BufferedReader source;

  public TeamFileReader() {

  }

  public ArrayList<Player> readTeamFromFile(String sourceFile) throws IOException {
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
