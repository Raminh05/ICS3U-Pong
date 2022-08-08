package subClasses;

/**
 * Tracking code for "AI" paddle on one-player mode
 */
public class trackingBall extends gameVariables {
    public static void trackBall() throws InterruptedException {    
        // If paddle below ball, move paddle up 
        if (paddleDimensionsAndPositions[2][0] > ballDimensionsAndPositions[1][1] && !(paddleDimensionsAndPositions[2][0] <= 50)) {
            paddleDimensionsAndPositions[2][0] -= (velocity + (difficultyLevel + isAITurn));
            return;
        }
        // If paddle above ball, move paddle down
        if (paddleDimensionsAndPositions[2][0] < ballDimensionsAndPositions[1][1] && !(paddleDimensionsAndPositions[2][0] >= drawDimensions[0] - 50)) {
            paddleDimensionsAndPositions[2][0] += (velocity + (difficultyLevel + isAITurn));
            return;
        }
        // If paddle level with ball, stay.
        if (paddleDimensionsAndPositions[2][0] == ballDimensionsAndPositions[1][1]) {
            paddleDimensionsAndPositions[2][0] += 0;
            return;
        }   
            // If AI paddle collides with top of bottom border, stop moving it
            paddleDimensionsAndPositions[2][0] += 0;
    }
}

