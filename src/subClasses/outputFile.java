package subClasses;
import java.io.*;

public class outputFile extends gameVariables {
    /**
     * Write simple game stats to an external text file
     * @throws IOException
     */
    public static void writeStats() throws IOException {
        // Starts BufferedWriter ane opens file
        String difficultyString = "null";
        File outFile = new File("/Users/minh/Documents/Programming/eclipse-workspace/Unit-Six-Assignment/src/textOutput/lastGameStats.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

        // Difficulty selection
        if (difficultyLevel == -3) difficultyString = "Easy";
        if (difficultyLevel == -2.8) difficultyString = "Medium";
        if (difficultyLevel == -2) difficultyString = "Hard";

        // Writes stats to text file
        writer.write("Difficulty: " + difficultyString + "\n"); // Writes last chosen game difficulty
        writer.write("Rally Length: " + rallyLength + "\n");   // Writes last game's rally length
        writer.write("Last Winner: " + lastWinner + "\n");    // Writes the winner of last game
        writer.close();
    }
}
                                