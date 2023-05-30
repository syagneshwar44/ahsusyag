import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class ImageSteganography{

    public static void operate(int key){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

        // file input stream
        try{

            FileInputStream fis = new FileInputStream(file);
            byte []data = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for(byte b:data){

                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Image Encryption is Done");
            JOptionPane.showMessageDialog(null,"To decrypt image use the same key used for encryption in the same place");

        }
        catch(Exception e){

            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
    
    System.out.println("this is testing");

    JFrame f = new JFrame();
    f.setTitle("Image Operation");
    f.setSize(400,400);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto",Font.BOLD,24);
        // creating button
        JButton btn = new JButton();
        btn.setText("Open Image");
        btn.setFont(font);

        // creating text feild
        JTextField textField = new JTextField(10);
        textField.setFont(font);

        // adding action listener
        btn.addActionListener(e->{
            System.out.println("btn clicked and printed on cmdline");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        f.add(btn);
        f.add(textField);
        f.setLayout(new FlowLayout());
    f.setVisible(true);
    }

}