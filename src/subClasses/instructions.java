package subClasses;
import java.awt.*;

public class instructions extends gameVariables {
    /**
     * Method that loads introduction screen and instruction screen
     * @return
     * @throws InterruptedException
     */
    public static boolean instructionScreen() throws InterruptedException {
        // Enables mouse input
        c.enableMouse();

        // Sets background colour to black
        c.setBackgroundColor(Color.BLACK);
        c.clear();

        // Intro Screen while the main game loop is not running
        while (!running) {
            // Basic Game Intro Screen fonts and title card
            c.setColor(Color.WHITE);
            c.setFont(new Font("Courier New", Font.PLAIN, 20)); // Click prompt font
            c.drawString("Left click anywhere to continue", (drawDimensions[1] / 2) - 185, drawDimensions[0] / 2); // Mouse prompt

            c.setFont(new Font("Courier New", Font.ITALIC, 90)); // Title font
            c.drawString("Pong", (drawDimensions[1] / 2) - 110, 120);   // Title

            if (paddleDimensionsAndPositions[2][0] >= drawDimensions[0] - 50 || paddleDimensionsAndPositions[2][0] <= 50) {
                demoVelocity *= -1;
            }

            // Demo movement of paddles in title screen
            paddleDimensionsAndPositions[2][0] -= demoVelocity;
            paddleDimensionsAndPositions[2][1] += demoVelocity;
            
            // Demo movement loop
            Thread.sleep(10);
            synchronized(c) {
                c.clear();
                // Simulate (demo) paddle movements
                c.setColor(Color.ORANGE);
                c.fillRect(paddleDimensionsAndPositions[0][0], paddleDimensionsAndPositions[2][0] - 50, paddleDimensionsAndPositions[1][0], paddleDimensionsAndPositions[1][1]); // Left paddle
                c.fillRect(paddleDimensionsAndPositions[0][1], paddleDimensionsAndPositions[2][1] - 50, paddleDimensionsAndPositions[1][0], paddleDimensionsAndPositions[1][1]); // Right paddle
                if (c.getMouseButton(0)) {
                    c.clear();
                    running = true; // Left click starts the game2
                }
                else {
                    continue;
                }
            }
        }

        // Each instruction in order
        String[] instructionsSequence = {
            "Use 'W' and 'S' key to move paddle 1 up and down respectively.",
            "Use UP and DOWN arrow to move paddle 2 up and down respectively.",
            "Hold left click to use a grace boost to speed up the paddles.",
            "Whoever gets to a score of 5 first, wins.",
            "To quit the game, press the escape key.",
            "To exit instructions, right click."
        };

        // Width locations of instructions on screen
        int[] instructionsWidthSpacing = {
            drawDimensions[1] / 2 - 255,
            drawDimensions[1] / 2 - 260,
            drawDimensions[1] / 2 - 253,
            drawDimensions[1] / 2 - 172,
            drawDimensions[1] / 2 - 165,
            drawDimensions[1] / 2 - 140
        };

        // Height locations of instructions on screen
        int[] instructionsHeightSpacing = {
            drawDimensions[0] / 2,
            drawDimensions[0] / 2 + 30,
            drawDimensions[0] / 2 + 60,
            drawDimensions[0] / 2 + 90,
            drawDimensions[0] / 2 + 120,
            drawDimensions[0] / 2 + 150
        };
        
        // Instruction screen shows for 6 seconds
        c.setFont(new Font("Courier New", Font.PLAIN, 14)); // Instructions font
        
        c.setColor(Color.WHITE);

        // Display instructions
        for (int i = 0; i < instructionsSequence.length; i++) {
            c.drawString(instructionsSequence[i], instructionsWidthSpacing[i], instructionsHeightSpacing[i]);
        }

        // Holds instruction screen for 6 seconds or, player can quit the instruction screen early by using right click 
        for (int i = 0; i < 6000; i++) {
            Thread.sleep(1);
            synchronized(c) {
                if (c.getMouseButton(2)) {
                    break;
                }
            }
        }
        // Fonts for everything else
        c.setFont(new Font("Courier New", Font.PLAIN, 40)); // Fonts for everything else

        // Returns running to be true to start the game
        return running;
    }
}