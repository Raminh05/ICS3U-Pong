package subClasses;
import java.awt.*;

public class ScreenRefresher extends gameVariables {
    /**
     * Method to clear game window and redraw score, paddles, and ball. It is called every game tick.
     */
    public static void refreshScreen() {
        // Clears console with every loop iteration
        c.clear();

        // White paddles
        c.setColor(Color.WHITE);

        // Draws two paddles
        c.fillRect(paddleDimensionsAndPositions[0][0], paddleDimensionsAndPositions[2][0] - 50, paddleDimensionsAndPositions[1][0], paddleDimensionsAndPositions[1][1]); // Left paddle
        c.fillRect(paddleDimensionsAndPositions[0][1], paddleDimensionsAndPositions[2][1] - 50, paddleDimensionsAndPositions[1][0], paddleDimensionsAndPositions[1][1]); // Right paddle

        // Cyan letters for score counter
        c.setColor(Color.CYAN);

        // Displays scores for player A and B
        c.drawString(Integer.toString(scoreA), (drawDimensions[1] / 2) - 130, 50); 
        c.drawString(Integer.toString(scoreB), (drawDimensions[1] / 2) + 130, 50);

        // Orange ball
        c.setColor(Color.ORANGE);

        // Draws the actual ball moving around
        c.fillRect(ballDimensionsAndPositions[1][0], ballDimensionsAndPositions[1][1], ballDimensionsAndPositions[0][0], ballDimensionsAndPositions[0][1]); // Ball

    }
    
}
