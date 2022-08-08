package subClasses;
import hsa_ufa.Console;

public class paddle extends gameVariables {
    /**
     * Allows player control of left and right paddles
     */
    public static void movePaddle() {
        // Control left paddle if one player mode is deactivated
        if (!onePlayerModeSelected) {
            // Restricts paddle from being moved above the top border of the window
            if (paddleDimensionsAndPositions[2][0] <= 50) { 
                if (c.isKeyDown('S')) {
                    paddleDimensionsAndPositions[2][0] = paddleDimensionsAndPositions[2][0] + velocity; // Move paddle down
                }
            }
            // Restricts paddle from being moved below the bottom border
            else if (paddleDimensionsAndPositions[2][0] >= drawDimensions[0] - 50) { 
                if (c.isKeyDown('W')) {
                    paddleDimensionsAndPositions[2][0] = paddleDimensionsAndPositions[2][0] - velocity; // Move paddle up
                }
            }
            // If it is within the console, move anywhere it wants
            else { 
                // Control left paddle
                if (c.isKeyDown('S')) {
                    paddleDimensionsAndPositions[2][0] = paddleDimensionsAndPositions[2][0] + velocity;
                } 
                else if (c.isKeyDown('W')) {
                    paddleDimensionsAndPositions[2][0] = paddleDimensionsAndPositions[2][0] - velocity;
                }
            }
        }

        // Control right paddle
        if (paddleDimensionsAndPositions[2][1] <= 50) { // Restricts paddle from being moved above the top border of the window
            if (c.isKeyDown(Console.VK_DOWN)) {
                paddleDimensionsAndPositions[2][1] += velocity;
            }
        } 
        else if (paddleDimensionsAndPositions[2][1] >= drawDimensions[0] - 50) { // Restricts paddle from being moved below the bottom border
            if (c.isKeyDown(Console.VK_UP)) {
                paddleDimensionsAndPositions[2][1] -= velocity;
            }
        } 
        else { // If it is within the console, move anywhere it wants 
            // Control left paddle
            if (c.isKeyDown(Console.VK_DOWN)) {
                paddleDimensionsAndPositions[2][1] = paddleDimensionsAndPositions[2][1] + velocity;
            } 
            else if (c.isKeyDown(Console.VK_UP)) {
                paddleDimensionsAndPositions[2][1] = paddleDimensionsAndPositions[2][1] - velocity;
            }
        }

        // Boost your paddle's velocity for a limited amount of time
        if (boostAmount >= 0) {
            if (c.getMouseButton(0)) { // If left click is down, boost is activated
                velocity = velocity + 7;
                boostAmount--;
            }
            else {
                velocity = 6; // Otherwise, normal velocity
            }
        } 
        else {
            velocity = 6;
        }
    }
}
