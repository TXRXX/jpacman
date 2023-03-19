package nl.tudelft.jpacman.game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class DBScoreBoard {
    public static  ArrayList<PlayerScore> Ps = new ArrayList<>();
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

    public static ArrayList<PlayerScore> ReturnScoreBoard(){
        try{
            File ReadScoreBoard = new File(pathScoreBoard);
            Scanner myRead = new Scanner(ReadScoreBoard);



            // Read data from database
            while (myRead.hasNextLine()){
                String data = myRead.nextLine();
                String[] playerScore = data.split("\t");
                //System.out.println(playerScore[0] + " : "+ playerScore[1]);
                //System.out.println(data);

                PlayerScore playerScore1 = new PlayerScore(playerScore[0],Integer.parseInt(playerScore[1]));
                Ps.add(playerScore1);
            }

            //sort score
            sortByScore(Ps);

            //show data
//            for (PlayerScore p : Ps) {
//                System.out.println(p.getPlayerName() + " : "+ p.getScore());
//            }

        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return Ps;
    }

    public static void sortByScore(ArrayList<PlayerScore> list){
        Collections.sort(list, new Comparator<PlayerScore>() {
            @Override
            public int compare(PlayerScore o1, PlayerScore o2) {
                return o1.getScore()-o2.getScore();
            }
        });
    }
}
