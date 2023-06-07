import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class RegisterWindow extends JFrame
{
    private JPanel panel;
    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField text1;
    private JPasswordField password;
    private JPasswordField passwordP;
    private JButton RegisterButton;


    public RegisterWindow() {
        super("Rejestracja");
        setSize(300, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();

        panel.setLayout(null);

        text1 = new JTextField("Email");
        password = new JPasswordField();
        passwordP = new JPasswordField();
        label = new JLabel("Login:");
        label1 = new JLabel("Haslo:");
        label2 = new JLabel("Rejestracja");
        label3 = new JLabel("Potwierdz:");
        RegisterButton = new JButton("Rejestracja");

        text1.setBounds(45, 70, 200, 50);
        password.setBounds(45, 150, 200, 50);
        passwordP.setBounds(45, 220, 200, 50);
        label.setBounds(120, 10, 70, 90);
        label1.setBounds(120, 90, 70, 90);
        label2.setBounds(110,10,70,20);
        label3.setBounds(110,200,70,20);
        RegisterButton.setBounds(90, 300, 100, 50);



        panel.add(text1);
        panel.add(password);
        panel.add(passwordP);
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(RegisterButton);

        add(panel);
        setVisible(true);


        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if(haslowym(password.getText()) == true)
                {
                    if(password.getText().equals(passwordP.getText())){
                        try {
                            if(sprawdzPlik(text1.getText()) == true)
                            {
                                System.out.println("Login:" + text1.getText());
                                System.out.println("Haslo:" + password.getText());
                                try {
                                    FileWriter pisacz = new FileWriter("Login_Haslo.txt" , true);
                                    pisacz.write(text1.getText() + " ");
                                    pisacz.write(password.getText());
                                    pisacz.write("\n");
                                    System.out.println("dodano");
                                    pisacz.close();
                                    RegisterWindow.this.dispose();
                                    LoginWindow loginWindow = new LoginWindow();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                System.out.println("Login:" + text1.getText());
                                try {
                                    FileWriter pisacz = new FileWriter("Loginy.txt" , true);
                                    pisacz.write(text1.getText());
                                    pisacz.write("\n");
                                    pisacz.close();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }else{
                                System.out.println("Juz istnieje uzytkownik o takim loginie");
                            }

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println("Niepoprawnie powturzone haslo");
                    }
                }else{
                    System.out.println("Haslo nie spelnia wymagan 1. min 8 liter nax 16 2. przynajmiej jedna duza litera 3. przynajmiej jedna liczba");
                }


            }
        });

    }
    private boolean sprawdzPlik(String login) throws IOException {
        boolean flaga = true;
        String linijka = login;
        FileReader fileReader = new FileReader("Loginy.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String line;

        while((line = br.readLine()) != null)
        {
            System.out.println(line);
            if(line.equals(linijka))
            {
                flaga = false;
            }
        }
        return flaga;

    }

    private boolean haslowym(String haslo) {
        int licznik1 = 0;
        int licznik2 = 0;
        if (haslo.length() > 7 && haslo.length() < 17) {
            for (int i = 0; i < haslo.length(); i++) {
                if (haslo.charAt(i) > 47 && haslo.charAt(i) < 58) {
                    licznik1++;
                }
                if (haslo.charAt(i) > 64 && haslo.charAt(i) < 91) {
                    licznik2++;
                }
            }
        } else {
            return false;
        }
        if (licznik1 > 0 && licznik2 > 0) {
            return true;
        } else {
            return false;
        }
    }
}

