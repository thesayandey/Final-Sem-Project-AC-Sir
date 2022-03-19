import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

class HomeClass{
    
    JFileChooser filechooser;
    JLabel label = new JLabel();

    public HomeClass(){
        JFrame home = new JFrame("College project AC Sir");
        home.setSize(500,500);
        home.setVisible(true);

        //creating new jpanel
        JPanel panel = new JPanel();
        home.add(panel);
        JButton browse = new JButton("Browse");
        JButton save = new JButton("Dummy");
        panel.add(browse);
        panel.add(save);

        //creating filechooser object
        filechooser = new JFileChooser();

        //adding eventlistner
        //browse.addActionListener(this);
        browse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int selected = filechooser.showDialog(null,"Open file");
                if(selected == JFileChooser.APPROVE_OPTION){
                    System.out.println("Selected file path: " + filechooser.getSelectedFile().getAbsolutePath());
                    String path = filechooser.getSelectedFile().getAbsolutePath();
                    label.setIcon(new ImageIcon(path));
                    label.setSize(300,300);
                }
                else{
                    System.out.println("Cancelled");
                }
            }
        });
        //adding the label that contains the pic
        panel.add(label);
    }
}

public class Home{
    public static void main(String args[]) throws IOException
    {
        SwingUtilities.invokeLater(
            new Runnable(){
                public void run()
                {
                    HomeClass obj = new HomeClass();  //running the java file
                }
            }
        );
    }
}