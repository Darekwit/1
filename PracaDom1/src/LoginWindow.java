import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginWindow extends JFrame
{
    private JPanel panel;
    private JLabel label;
    private JLabel label1;
    private JTextField text1;
    private JPasswordField password;
    private JButton loginButton;
    private JButton registerButton;

    private String uzytkownik;

    public LoginWindow()
    {
        super("Logowanie");
        setSize(300,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Uzytkownik u = new Uzytkownik();



        panel = new JPanel();

        panel.setLayout(null);

        text1 = new JTextField("Email");
        password = new JPasswordField();
        label = new JLabel("Login:");
        label1 = new JLabel("Haslo:");
        loginButton = new JButton("Login");
        registerButton = new JButton("Zarejsetruj");

        text1.setBounds(45,70,200,50);
        password.setBounds(45,200,200,50);
        label.setBounds(120,10,70,90);
        label1.setBounds(120,140,70,90);
        loginButton.setBounds(150,260,100,50);
        registerButton.setBounds(20,260,100,50);


        panel.add(text1);
        panel.add(password);
        panel.add(label);
        panel.add(label1);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);
        setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginWindow.this.dispose();
                RegisterWindow registerWindow = new RegisterWindow();
            }
        });



        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                {
                    System.out.println("Login:" + text1.getText());
                    System.out.println("Haslo:" + password.getText());
                    try {

                        if(sprawdzPlik(text1.getText(),password.getText()) == true)
                        {
                            System.out.println("Zalogowano");
                            setUzytkownik(text1.getText());
                            LoginWindow.this.dispose();
                            u.setLogin(text1.getText());
                            PanelG panelG = new PanelG(u.getLogin());
                        }
                        else{
                            System.out.println("Nie zalogowano");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });


    }
    private boolean sprawdzPlik(String login, String haslo) throws IOException {
        boolean flaga = false;
        String linijka = login + " " + haslo;
        FileReader fileReader = new FileReader("Login_Haslo.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String line;

        while((line = br.readLine()) != null)
        {
            System.out.println(line);
            if(line.equals(linijka))
            {
                flaga = true;
            }
        }
        return flaga;
    }

    public void setUzytkownik(String uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public String getUzytkownik() {
        return uzytkownik;
    }
}

