package subClasses;

import java.io.IOException;
import java.awt.*;

public class score extends gameVariables {
    
    /**
     * Method to manage scores for both players. Also detects a winning player when score reaches 5
     * @throws IOException
     */
    public static void scoreManager () throws IOException {
        if (scoreA >= 5 || scoreB >= 5) {
            running = false;
            c.clear();
            c.setBackgroundColor(Color.WHITE);

            // Logic to detirmine who wins. Stops games and shows winner screen
            if (scoreA > scoreB) {
                c.drawString("Player A Wins!", (drawDimensions[1] / 2) - 170, drawDimensions[0] / 2);
                lastWinner = "Player A";
                outputFile.writeStats();
            }
            else if (scoreB > scoreA) {
                c.drawString("Player B Wins!", (drawDimensions[1] / 2) - 170, drawDimensions[0] / 2);
                lastWinner = "Player B";
                outputFile.writeStats();
            }
        }
    }
}
