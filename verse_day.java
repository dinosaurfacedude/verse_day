/*
@author Daniel Jones
@param IDE used: Atom text editor and linux terminal
@param OS: Linux Mint 19 XFCE
@param last edited: 01-28-2019
@param description: This is a personal program for me and my friends.
It reads from a text file to get a randomly generated number from 1-365, and
it then displays a Bible verse based off of that number in JavaFX.
*/

import javafx.scene.image.*;
import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.lang.System;
import javafx.scene.text.*;
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
      Image background = new Image("cross_II.png");

      ImageView iv = new ImageView();
      iv.setImage(background);
      Button exitb = new Button("Go forth");
      exitb.setLayoutX(200);
      exitb.setLayoutY(400);

      iv.setLayoutX(42);
      Pane window = new Pane();
      Text verseShow = new Text(75, 200, theVerse);

      //exit button. Prettier than just having nothing
      exitb.setOnAction(e -> {System.exit(0);
      }
      );

      window.getChildren().add(iv);
      window.getChildren().add(verseShow);
      window.getChildren().add(exitb);

      //window.getChildren().add(myBackground);
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
      output.print(2);


      //close the door for your mama
      output.close();
      System.out.println("finished.");

      //as said, should only run once, thus why I don't read from file.
      //Still a good idea to keep as a method, just in case
      return 1;

    }


    //These are the verses that are used
    private static String whichVerse(int theVerse){
      String verse = new String();
      switch(theVerse){

        case 1:
          verse = "In the beginning, God made the Heavens and the Earth. \nGenesis 1:1 (KJV)";
          break;

        case 2:
          verse = "For unto us a child is born, unto us a son is given.\nAnd the weight of the world shall be on His shoulder. \nAnd His name shall be called Wonderful, Counsellor, \nthe Almighty God, Everlasting Father, Prince of Peace. \nIsaiah 9:6 (KJV)";
        break;

        case 3:
          verse = "Then Peter said unto them, Repent, and be baptized \nevery one of you in the name of Jesus Christ for the \nremission of sins, and ye shall receive the gift of the Holy Ghost. \nActs 2:38 (KJV)";
        break;

        case 4:
          verse = "For God so loved the world, that he gave his only begotten Son, \nthat whosoever believeth in him should not perish, \nbut have everlasting life. \nJohn 3:16 (KJV)";
        break;

        case 5:
          verse = "Let no man despise thy youth; but be thou an example \nof the believers, in word, in conversation, in charity, \nin spirit, in faith, in purity. \n1 Timothy 4:12 (KJV)";
        break;

        case 6:
          verse = "For I know the thoughts that I think toward you, \nsaith the LORD, thoughts of peace, and not of evil, \nto give you an expected end. \nJeremiah 29:11 (KJV)";
        break;
      }

      return verse;
    }


    //This updates to the next day. That way, the program doesn't just show the
    //same verse over and over again. Chosen randomly.
    private static void updateDay(int theDay)throws IOException{
      Random myNewDay = new Random();
      theDay = myNewDay.nextInt(5) + 1;
      File day = new File("days.txt");
      PrintWriter output = new PrintWriter(day);
      output.print(theDay);

      //close the door for your mama
      output.close();

    }
  }
