import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SubCipherGUI extends JPanel implements ActionListener  {
    
    private JFrame F;    
    JLabel L1;
    JLabel L2;
    JLabel L3;
    JLabel L4;
    JTextArea message = new JTextArea(10, 50);
    JTextArea output = new JTextArea(10, 50);
    JButton encrypt;
    JButton decrypt;
    JButton clear;
    JScrollPane s1;
    JScrollPane s2;
    
    //Letters from A . . . Z to use for encryption
    String[] setOfLetters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    
    String encrypted = "";
    String decrypted = "";
    SubCipher ac = new SubCipher();
    
    public SubCipherGUI()    {
        
        F = new JFrame("Substitution Cipher");
        F.setLayout(new BorderLayout());
        F.setSize(1000, 800);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        F.setVisible(true);
        
        //P = new JPanel();
        this.setSize(800, 700);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(null);
        F.add(this);
        
        //Label 1
        L1 = new JLabel("Substitution Cipher");
        L1.setFont(new Font("Cambria", Font.BOLD, 22));
        L1.setForeground(Color.WHITE);
        Dimension size = L1.getPreferredSize();
        L1.setBounds(this.getWidth()/2, 5, size.width, size.height);
        this.add(L1);
        
        //Label 2
        L2 = new JLabel("Developed For Fun With The Logic of Substitution Cipher By ProudlyCoker ");
        L2.setFont(new Font("Cambria", Font.ITALIC | Font.BOLD, 14));
        L2.setForeground(Color.WHITE);
        size = L2.getPreferredSize();
        L2.setBounds(this.getWidth()/2, 40, size.width, size.height);
        this.add(L2);
        
        //Label 3
        L3 = new JLabel("Enter a Message to Encrypt or Decrypt");
        L3.setFont(new Font("Cambria", Font.BOLD, 16));
        L3.setForeground(Color.WHITE);
        size = L3.getPreferredSize();
        L3.setBounds(this.getWidth()/2, 100, size.width, size.height);
        this.add(L3);
        
        //Label 4
        L4 = new JLabel("Output");
        L4.setFont(new Font("Cambria", Font.BOLD, 16));
        L4.setForeground(Color.WHITE);
        size = L4.getPreferredSize();
        L4.setBounds(this.getWidth()/2, 400, size.width, size.height);
        this.add(L4);
        
        //Test Area for Message
        message.setFont(new Font("Cambria", Font.BOLD, 14));
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        s1 = new JScrollPane(message);
        size = message.getPreferredSize();
        s1.setBounds(this.getWidth()/2, 130, size.width, size.height);
        this.add(s1);
        
        //Output
        output.setFont(new Font("Cambria", Font.BOLD, 14));
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        s2 = new JScrollPane(output);
        size = output.getPreferredSize();
        s2.setBounds(this.getWidth()/2, 430, size.width, size.height);
        this.add(s2);
        
        //Encrypt button
        encrypt = new JButton("ENCRYPT");
        encrypt.setBounds(this.getWidth()/2, 320, 100, 30);
        this.add(encrypt);
        encrypt.addActionListener((ActionListener)this);
        
        //Decrypt button
        decrypt = new JButton("DECRYPT");
        decrypt.setBounds((this.getWidth()/2) + 120, 320, 100, 30);
        this.add(decrypt);
        decrypt.addActionListener((ActionListener) this);
        
        //Clear button
        clear = new JButton("CLEAR");
        clear.setBounds((this.getWidth()/2) + 240, 320, 100, 30);
        this.add(clear);
        clear.addActionListener((ActionListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if( ae.getActionCommand().equalsIgnoreCase("ENCRYPT") ) {
            String enc = message.getText();
            encrypted = ac.encrypt(setOfLetters, enc); //Calling the encrypt method in SubCipher class
            output.setText(encrypted);
        }
        
        if( ae.getActionCommand().equalsIgnoreCase("DECRYPT") ) {
            String dec = message.getText();
            decrypted = ac.decrypt(setOfLetters, dec); //Calling the decrypt method in SubCipher class
            output.setText(decrypted);
        }
        
        if( ae.getActionCommand().equalsIgnoreCase("CLEAR") ) { //Clearing Both Text Areas
            message.setText("");
            output.setText("");
        }
    }
}
