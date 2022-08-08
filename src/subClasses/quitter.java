package subClasses;
import java.io.IOException;

import hsa_ufa.Console;

public class quitter extends gameVariables {
    /**
     * Method to quit game into end screen and call writeStats method
     * @throws IOException
     */
    public static void quitGame() throws IOException {
        // Activate quit game when escape key is pressed
        if (c.isKeyDown(Console.VK_ESCAPE)) {
            running = false;
            c.clear();
            c.drawString("Exited Game.", (drawDimensions[1] / 2) - 100, drawDimensions[0] / 2);
            outputFile.writeStats();
        }
    }
}
