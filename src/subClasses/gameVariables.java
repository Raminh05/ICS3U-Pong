package subClasses;
import hsa_ufa.Console;

/**
 * Class to store game variables
 */
public abstract class gameVariables {
    public static Console c = new Console(600, 600, 25, "Pong (beta)");

    // Boolean values
    public static boolean difficultyScreenCompleted = false;
    public static boolean playerModeScreenCompleted = false;
    public static boolean onePlayerModeSelected = false;

    public static double difficultyLevel; // Velocity handicapp for AI throughout the whole game
    public static int isAITurn; // Velocity handicapp for AI if it is not their turn

    // Draw dimensions
    public static int[] drawDimensions = {c.getDrawHeight(), c.getDrawWidth()}; // drawHeight, drawWidth
    
    // 2D array storing information relating to drawing the paddles
    public static int[][] paddleDimensionsAndPositions = {
        {25, drawDimensions[1] - 45}, // paddleOneX, paddleTwoX
        {20, 100}, // paddleWidth, paddleHeight
        {drawDimensions[0] / 2, drawDimensions[0] / 2}, // paddleOneY, paddleTwoY
    };

    public static int[][] ballDimensionsAndPositions = {
        {15, 15},                                                     // ballWidth, ballHeight
        {(drawDimensions[1] / 2) - 10, (drawDimensions[0] / 2) - 10} // ballX, ballY
    };

    // Y Position for Paddles
    public static int paddleOneY = drawDimensions[0] / 2; // Puts paddles halfway at the console height
    public static int paddleTwoY = drawDimensions[0] / 2;

    // Paddle and ball velocity
    public static int velocity = 6; // Paddle velocity
    public static double ballVelocityX = 6;  // Ball's x-direction velocity -- Declared as a double to make it possible to speed up the game in small increments
    public static double ballVelocityY = 1; // Ball's y-direction velocity

    // Scores for both players
    public static int scoreA = 0;
    public static int scoreB = 0;

    // Boost amount remaining
    public static int boostAmount = 300;

    // Boolean to start the loop
    public static boolean running = false;

    // Paddle velocity for the introduction screen
    public static int demoVelocity = 6;

    // How many times ball bounces off paddle (for stats)
    public static int rallyLength = 0;
    public static String lastWinner;

    // Boolean for when to start trackingBall code for the first time
    public static boolean hitPlayerPaddleOnce = false;
    
}
