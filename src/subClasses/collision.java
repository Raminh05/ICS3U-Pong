package subClasses;
import java.io.*;
import java.util.Random;
import javax.sound.sampled.*;

import javax.sound.sampled.Clip;

public class collision extends gameVariables {
    static Random rand = new Random();

    // Sets up audio system for sound effect
    static Clip bounceSound;
    static File audioFile = new File("src/bounce.wav");

    /**
     * Splits paddles into 5 hitbox sections to change ball angle reflection depending on where it hits the paddle
     * @param paddleNum
     */ 
    public static void collisionAngleCalculation(int paddleNum) {
        if (!hitPlayerPaddleOnce) hitPlayerPaddleOnce = true; // Activates "AI" mode when ball hits player paddle for the first time

        // Top-most section of paddle
        if (ballDimensionsAndPositions[1][1] < (paddleDimensionsAndPositions[2][paddleNum] - 28)) {
            ballVelocityY = -4;
        }
        // Near the top of paddle
        else if (ballDimensionsAndPositions[1][1] > (paddleDimensionsAndPositions[2][paddleNum] - 28) && ballDimensionsAndPositions[1][1] < (paddleDimensionsAndPositions[2][paddleNum] - 8)) {
            ballVelocityY = -3;
        }
        // Middle of paddle (randomly makes the ball go up or down on a shallow angle)
        else if (ballDimensionsAndPositions[1][1] > (paddleDimensionsAndPositions[2][paddleNum] - 8) && ballDimensionsAndPositions[1][1] < (paddleDimensionsAndPositions[2][paddleNum] + 12)) {
            if (rand.nextInt(50) % 2 == 0) {
                ballVelocityY = -2;
            }
            else {
                ballVelocityY = 2;
            }
        }
        // Near the bottom of the paddle
        else if (ballDimensionsAndPositions[1][1] > (paddleDimensionsAndPositions[2][paddleNum] + 12) && ballDimensionsAndPositions[1][1] < (paddleDimensionsAndPositions[2][paddleNum] + 32)) {
            ballVelocityY = 3;
        }
        // The very bottom of the paddle
        else if (ballDimensionsAndPositions[1][1] > (paddleDimensionsAndPositions[2][paddleNum] + 32) && ballDimensionsAndPositions[1][1] < (paddleDimensionsAndPositions[2][paddleNum] + 52)) {
            ballVelocityY = 4;
        }
    }

    /**
     * Method to check when a collision occurs (ball on paddle, or ball on game borders)
     * @return
     */
    public static boolean collisionDetection() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        boolean someoneScored = false;
        // Border checking
        if (ballDimensionsAndPositions[1][1] <= 0 || ballDimensionsAndPositions[1][1] + ballDimensionsAndPositions[0][1] >= drawDimensions[0]) { // Top and bottom border collision
            // Plays bounce audio
            bounceSound = AudioSystem.getClip();
            bounceSound.open(AudioSystem.getAudioInputStream(audioFile));
            bounceSound.start();

            if (ballDimensionsAndPositions[1][1] <= 0) ballDimensionsAndPositions[1][1] += 5;
            if (ballDimensionsAndPositions[1][1] + ballDimensionsAndPositions[0][1] >= drawDimensions[0]) ballDimensionsAndPositions[1][1] -= 5;
            ballVelocityY *= -1;
        }
        else if (ballDimensionsAndPositions[1][0] + ballDimensionsAndPositions[0][0] > drawDimensions[1]) { // Player A scores
            ballDimensionsAndPositions[1][0] = (drawDimensions[1] / 2) - 10; // Sets the ball's X-axis position in the middle again
            ballDimensionsAndPositions[1][1] = (drawDimensions[0] / 2) - 10; // Same as above but for Y-axis
            c.clear();  // Clears console after the player has scored
            scoreA++;  // Increase score
            ballVelocityX *= -1;
            someoneScored = true;
            isAITurn = 0;
        }
        else if (ballDimensionsAndPositions[1][0] <= 0) { // Player B scores
            ballDimensionsAndPositions[1][0] = (drawDimensions[1] / 2) - 10;
            ballDimensionsAndPositions[1][1] = (drawDimensions[0] / 2) - 10;
            c.clear();
            scoreB++;
            ballVelocityX *= -1;
            someoneScored = true;
        }

        // Ball and paddle collision detection (with "buffer zone" around paddles)
        if (ballDimensionsAndPositions[1][0] + ballDimensionsAndPositions[0][0] >= paddleDimensionsAndPositions[0][1] && ballDimensionsAndPositions[1][1] + ballDimensionsAndPositions[0][1] >= paddleDimensionsAndPositions[2][1] - 40 && ballDimensionsAndPositions[1][1] <= paddleDimensionsAndPositions[2][1] + paddleDimensionsAndPositions[1][1] - 55) { // Paddle Two Collision
            bounceSound = AudioSystem.getClip();
            bounceSound.open(AudioSystem.getAudioInputStream(audioFile));
            bounceSound.start();

            ballDimensionsAndPositions[1][0] = paddleDimensionsAndPositions[0][1] - paddleDimensionsAndPositions[1][0];
            collisionAngleCalculation(1);
            ballVelocityX *= -1; // Inverts X-axis velocity to make the ball go back to the other side
            isAITurn = 0;
            rallyLength++;
        }
        else if (ballDimensionsAndPositions[1][0] <= paddleDimensionsAndPositions[0][0] + paddleDimensionsAndPositions[1][0] && ballDimensionsAndPositions[1][1] + ballDimensionsAndPositions[0][1] >= paddleDimensionsAndPositions[2][0] - 40 && ballDimensionsAndPositions[1][1] <= paddleDimensionsAndPositions[2][0] + paddleDimensionsAndPositions[1][1] - 55) { // Paddle One Collision 
            bounceSound = AudioSystem.getClip();
            bounceSound.open(AudioSystem.getAudioInputStream(audioFile));
            bounceSound.start();
            
            ballDimensionsAndPositions[1][0] = paddleDimensionsAndPositions[0][0] + paddleDimensionsAndPositions[1][0];
            collisionAngleCalculation(0);
            ballVelocityX *= -1;
            isAITurn = -2;
            rallyLength++;
        }
        return someoneScored;
    }
    
}
