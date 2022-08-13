package Main;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class myFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    myFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My clock program");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel.setForeground(new Color(0x00ff00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        //------------day---------------------
        dayFormat = new SimpleDateFormat("EEEE");
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Vardana",Font.PLAIN,35));
        //-------------day-------------------

        //------------date------------
        dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Vardana",Font.PLAIN,25));
        //----------date-----------

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
