import gui.HelloWorld;

public class Program {

  private HelloWorld helloWorld;

  public Program(){
    //init program variables here

    helloWorld = new HelloWorld();
  }
  void run(){
    //execute program commands here

    helloWorld.run();
  }

  public static void main(String args[]){
    (new Program()).run();
  }
}
