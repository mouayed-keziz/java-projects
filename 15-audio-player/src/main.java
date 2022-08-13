import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.*;

public class main {
    public static void main(String[] args) throws Exception {
        File file1 = new File ("ElGrandeToto - Love Nwantiti (ft Ckay) (s l o w e d + r e v e r b).wav");
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(file1);
        Clip clip = AudioSystem.getClip();
        clip.open(audiostream);


        String response = "";
        Scanner scan = new Scanner(System.in);

        while (!response.equals("Q")) {
            System.out.println("Q : quit\nP : play\nR : reset\nS : stop");
            System.out.print("enter your choise : ");

            response = scan.next();
            response = response.toUpperCase();

            switch (response) {
                case "P":
                    clip.start();
                    break;

                case "S":
                    clip.stop();
                    break;

                case "R":
                    clip.setMicrosecondPosition(0);
                    break;

                case "Q":
                    System.out.println("exit");
                    clip.close();
                    break;

                default:
                    System.out.println("not a valid response");
                    break;
            }
        }
    }
}
