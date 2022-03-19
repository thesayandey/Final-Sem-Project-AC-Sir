import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

class Home implements ActionListener{
    
    JFileChooser filechooser;
    public String imagePath;

    //overriding actionperformed
    @Override
    public void actionPerformed(ActionEvent e){
        int selected = filechooser.showDialog(null,"Open file");
        if(selected == JFileChooser.APPROVE_OPTION){
            System.out.println("Selected file path: " + filechooser.getSelectedFile().getAbsolutePath());
            String path = filechooser.getSelectedFile().getAbsolutePath();
            imagePath = path;
        }
        else{
            System.out.println("Cancelled");
        }
    }

    public Home(){
        JFrame home = new JFrame("College project AC Sir");
        home.setSize(500,500);
        home.setVisible(true);

        //creating new jpanel
        JPanel panel = new JPanel();
        home.add(panel);
        JButton browse = new JButton("Browse");
        JButton save = new JButton("Save");
        panel.add(browse);
        panel.add(save);

        //creating jlabel
        // JLabel label = new JLabel();
        // label.setIcon(new ImageIcon(imagePath));
        // panel.add(label);
        System.out.println(imagePath);
        //creating textpane


        //creating filechooser object
        filechooser = new JFileChooser();

        //adding eventlistner
        browse.addActionListener(this);
    }

    public static void main(String args[]) throws IOException
    {
        SwingUtilities.invokeLater(
            new Runnable(){
                public void run()
                {
                    new Home();  //running the java file
                }
            }
        );
    }
}