package nl.tudelft.jpacman.game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class DBScoreBoard {
    static final String pathScoreBoard = "src/main/resources/DBScoreBoard.txt";
    //create text file for keep playerName and Score
    public static void CreateScoreBoard(){
        try {
            File ScoreBoard = new File(pathScoreBoard);
            if(ScoreBoard.createNewFile()){
                System.out.println("File create: "+ScoreBoard.getName());
            }else{
                System.out.println("File already exists.");
            }
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteScoreBoard(String playerName, int score)  {
        try{
            FileWriter WriterScoreBoard = new FileWriter(pathScoreBoard,true);
            WriterScoreBoard.write("\n"+playerName + "\t" + score);
            WriterScoreBoard.close();
            System.out.println("Save Score");
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
