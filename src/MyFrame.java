import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

    private static SimpleDateFormat tFormat;
    private static SimpleDateFormat dayFormat;
    private static SimpleDateFormat dateFormat;

    private static JLabel tlabel;
    private static JLabel dlabel;
    private static JLabel datelabel;

    String time;
    String day;
    String date;
    
    MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("iKEN Clock  😎");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(350, 200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 350, 250);

        tFormat = new SimpleDateFormat("HH:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE,");
        dateFormat = new SimpleDateFormat("dd MMMMM, yyyy\n\n");

        tlabel = new JLabel("", JLabel.CENTER);
        tlabel.setFont(new Font("Verdana", Font.ITALIC,55));
        tlabel.setBounds(0, 0, 350, 50);
        tlabel.setForeground(new Color(0x00FF0000));
        tlabel.setAlignmentX(Component.TOP_ALIGNMENT);
        tlabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        dlabel = new JLabel("", JLabel.CENTER);
        dlabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dlabel.setAlignmentX(Component.TOP_ALIGNMENT);
        dlabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        //dlabel.setBounds(0, 55, 350, 50);
        //dlabel.setForeground(new Color(0x00FF00));

        datelabel = new JLabel("", JLabel.CENTER);
        datelabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        datelabel.setAlignmentX(Component.TOP_ALIGNMENT);
        datelabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        //datelabel.setBounds(0, 105, 350, 50);

        panel.add(dlabel);
        panel.add(datelabel);
        panel.add(tlabel);

        this.add(panel);
        this.setVisible(true);
        
        setTime();
    }

    public void setTime() {
        while(true) {
        time = tFormat.format(Calendar.getInstance().getTime());
        tlabel.setText(time);

        day = dayFormat.format(Calendar.getInstance().getTime());
        dlabel.setText(day);

        date = dateFormat.format(Calendar.getInstance().getTime());
        datelabel.setText(date);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("The thread failed \n");
            e.printStackTrace();
            }
        }
        
    }
}
