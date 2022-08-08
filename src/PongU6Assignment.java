/*
Name: Minh Nguyen
Final Project -- Classic Pong but ever so slightly quirkier
WARNING: THIS IS AN EDITION WITH SOUNDS!! CAUSES MEMORY LEAK AFTER A SHORT AMOUNT OF TIME 
Date: June 22nd, 2022
Description: The basic foundation of a classic pong game with 1D and 2D arrays to store object positions 
Fonts Used: Courier New
*/

import subClasses.*;
import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;

public class PongU6Assignment extends gameVariables {
    /**
     * Main game method that runs EVERYTHING!!!!
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException {
        // Checks if the instruction screen is completed to start running the game
        running = instructions.instructionScreen();

        // Gets player mode 
        difficultyAndModeSelection.playerMode();
        
        // If one player mode is selected, ask player for computer difficulty level
        if (onePlayerModeSelected) difficultyAndModeSelection.difficultyScreen();
        c.setFont(new Font("Courier New", Font.PLAIN, 40)); // Fonts for everything else
        
        // Main game loop that calls all the game methods
        while (running) {
            Thread.sleep(10);
            synchronized (c) {
                ScreenRefresher.refreshScreen();
                paddle.movePaddle();
                if (onePlayerModeSelected && hitPlayerPaddleOnce) trackingBall.trackBall(); // Tracks ball using terrible mathematics for one player mode
                if (collision.collisionDetection()) { // Collision logic
                    paddleDimensionsAndPositions[2][0] = drawDimensions[0] / 2;
                    ScreenRefresher.refreshScreen(); // Refreshes screen
                    Thread.sleep(50);        // Reasonable delay between serves
                    ballVelocityY = 1;              // Serve ball at reasonable angles
                    continue;
                }
                moveBall(); // Moves the ball around in the window
                score.scoreManager(); // Score manager -> Checks if someone has beaten the game
                quitter.quitGame(); // Scans if escape key is pressed to quit the game              
            }
        }
    }
    
    /**
     * Method to move the ball around on the screen
     */
    public static void moveBall() {
        ballDimensionsAndPositions[1][0] += ballVelocityX;
        ballDimensionsAndPositions[1][1] += ballVelocityY;
    }
}
