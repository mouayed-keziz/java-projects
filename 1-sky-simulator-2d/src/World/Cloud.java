package World;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Cloud {

    Random random = new Random();

    static Image image = new ImageIcon("src/Resources/Images/Cloud.png").getImage();
    int CLOUD_POSITION_X = 0 ;
    int CLOUD_POSITION_Y = 0 ;
    int CLOUD_X_VELOCITY = 0 ;

    Cloud() {
        int x = random.nextInt(2);
        if (x != 1) {
            x = -1;
        }

        do {
            CLOUD_POSITION_X = random.nextInt(world1.PANEL_WIDTH);
        } while (CLOUD_POSITION_X == 0);
        do {
            CLOUD_POSITION_Y = random.nextInt(world1.PANEL_HEIGHT / 2);
        } while (CLOUD_POSITION_Y == 0);
        do {
            CLOUD_X_VELOCITY = random.nextInt(5) * x;
        } while (CLOUD_X_VELOCITY == 0);
    }
}
