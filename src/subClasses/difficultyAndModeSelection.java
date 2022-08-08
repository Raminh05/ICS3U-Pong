package subClasses;
import java.awt.*;

public class difficultyAndModeSelection extends gameVariables {

    /**
     * Method to let the player select modes (one vs. two player mode)
     */
    public static void playerMode() {
        // Loads graphical aspects of player mode selection screen
        c.clear();
        c.setBackground(Color.BLACK);
        c.setColor(Color.ORANGE);
        c.setFont(new Font("Courier New", Font.PLAIN, 27));
        c.drawString("Select your Player Mode!", (drawDimensions[1] / 2) - 200, 60);

        c.setColor(Color.WHITE);
        c.setFont(new Font("Courier New", Font.PLAIN, 14)); // Instructions font
        c.drawString("1. Single Player", (drawDimensions[1] / 2) - 70, 100);
        c.drawString("2. Two Players", (drawDimensions[1] / 2) - 70, 120);
        
        // Scans for user input to see which player mode is selected
        while (!playerModeScreenCompleted) {
            if (c.getKeyChar() == '1') {
                playerModeScreenCompleted = true;
                onePlayerModeSelected = true;
            }
            else if (c.getKeyChar() == '2') {
                playerModeScreenCompleted = true;
                onePlayerModeSelected = false;
            }
            else continue;
        }
    }
    
    /**
     * Method that lets player select "AI" difficulty for one player mode
     * @throws InterruptedException
     */
    public static void difficultyScreen() throws InterruptedException {
        // Loads graphical aspects of difficuly selection screen
        c.clear();
        c.setBackground(Color.BLACK);
        c.setColor(Color.ORANGE);
        c.setFont(new Font("Courier New", Font.PLAIN, 27));
        c.drawString("Select your Difficulty!", (drawDimensions[1] / 2) - 200, 60);

        c.setColor(Color.WHITE);
        c.setFont(new Font("Courier New", Font.PLAIN, 14)); // Instructions font
        c.drawString("3. Easy", (drawDimensions[1] / 2) - 70, 100);
        c.drawString("4. Medium", (drawDimensions[1] / 2) - 70, 120);
        c.drawString("5. Hard", (drawDimensions[1] / 2) - 70, 140);

        // Logic to detect which difficulty mode was selected
        while (!difficultyScreenCompleted) {
            if (c.getKeyChar() == '3') {
                difficultyScreenCompleted = true;
                difficultyLevel = -3;
            }
            else if (c.getKeyChar() == '4') {
                difficultyScreenCompleted = true;
                difficultyLevel = -2.8;
            }
            else if (c.getKeyChar() == '5') {
                difficultyScreenCompleted = true;
                difficultyLevel = -2;
            }
            else continue;
        } 
    }
}
