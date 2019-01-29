/*
@author Daniel Jones
@param IDE used: Atom text editor and linux terminal
@param OS: Linux Mint 19 XFCE
@param last edited: 01-28-2019
@param description: This is a personal program for me and my friends.
It reads from a text file to get a randomly generated number from 1-365, and
it then displays a Bible verse based off of that number in JavaFX.
*/


import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.control.*;
import java.lang.System;
public class verse_day extends Application{


  //This is my main method
  public static void main(String args[]){
    launch(args);

    }


    //this is the JavaFX method that displays the window.
    @Override
    public void start(Stage primaryStage)throws IOException{

      //day gets the variable
      int day = getDay();
      String theVerse = new String();
      theVerse = whichVerse(day);

      Button exitb = new Button("Go forth");
      exitb.setLayoutX(200);
      exitb.setLayoutY(300);
      Pane window = new Pane();
      Text verseShow = new Text(75, 200, theVerse);
      exitb.setOnAction(e -> {System.exit(0);
      }
      );
      window.getChildren().add(verseShow);
      window.getChildren().add(exitb);
      Scene scene = new Scene(window, 500, 500);
      primaryStage.setTitle("Bible Verse Of The Day");
      primaryStage.setScene(scene);
      primaryStage.show();



    }



    //This method gets the day to read the verse with.
    private static int getDay()throws IOException{

      //This is the day that will decide the Bible verse.
      int dayNum = 0;
      try{
      // Reads from the days.txt to see which day it is
      FileReader day = new FileReader("days.txt");
      Scanner input = new Scanner(day);
      dayNum = input.nextInt();
      input.close();

      //Updates to next day.
      updateDay(dayNum);
      return dayNum;
    }

    //If no file found, goes to makeDay() which creates the file, and returns
    //the number
    catch(Exception E){
      System.out.println("no file found. Creating now...");
      dayNum = makeDay();
    return dayNum;
    }
  }




  //This method creates the file and returns one. Should only run once during
  //product life, but who knows. Rest of the time should read from file.
    private static int makeDay()throws IOException{

      //creats days.txt
      File newDay = new File("days.txt");
      PrintWriter output = new PrintWriter(newDay);
      System.out.println("writing...");
      output.print(1);


      //close the door for your mama
      output.close();
      System.out.println("finished.");

      //as said, should only run once, thus why I don't read from file.
      //Still a good idea to keep as a method, just in case
      return 1;

    }

    private static String whichVerse(int theVerse){
      String verse = new String();
      switch(theVerse){

        case 1:
          verse = "In the beginning, God made the Heavens and the Earth. \nGenesis 1:1 (KJV)";
          break;
        case 2:
          verse = "For unto us a child is born, unto us a son is given.\nAnd the weight of the world shall be on His shoulder. \nAnd His name shall be called Wonderful, Counsellor, \nthe Almighty God, Everlasting Father, Prince of Peace. \nIsaiah 9:6 (KJV)";
      }

      return verse;
    }


    //This updates to the next day. That way, the program doesn't just show the
    //same verse over and over again.
    private static void updateDay(int theDay)throws IOException{

      File day = new File("days.txt");
      PrintWriter output = new PrintWriter(day);
      output.print(theDay + 1);

      //close the door for your mama
      output.close();

    }
  }
