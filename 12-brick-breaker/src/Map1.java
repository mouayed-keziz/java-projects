public class Map1 {
    simpleBrick[] map1 = new simpleBrick[200];
    
    Map1() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 50; i++) {
            map1[i] = new simpleBrick();
            map1[i].x = x;
            map1[i].y = y;
            x = x + simpleBrick.width;
            if (x == Game.WIDTH) {
                y = y + simpleBrick.height;
                x = 0;
            }
        }
    }

}
