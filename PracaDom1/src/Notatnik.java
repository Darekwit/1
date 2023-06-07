import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notatnik extends JFrame
{
    JPanel panel;
    JTextArea textNotatki;
    JTextArea title;
    JButton zapisz;
    JButton wyjdz;
    String uzytkownik;

    public Notatnik(String uzytkownik)
    {
        super("Notatnik");
        setSize(1000,1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        textNotatki = new JTextArea();
        title = new JTextArea();
        zapisz = new JButton("zapisz");
        wyjdz = new JButton("wyjdz");

        textNotatki.setBounds(100,130,750,875);
        title.setBounds(220,45,465,80);
        zapisz.setBounds(875,55,100,50);
        wyjdz.setBounds(875,120,100,50);

        textNotatki.setFont(new Font("1",1,18));
        title.setFont(new Font("2",3,30));


        panel.add(zapisz);
        panel.add(wyjdz);
        panel.add(textNotatki);
        panel.add(title);

        add(panel);

        setVisible(true);
        this.uzytkownik = uzytkownik;

        zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try{
                    File f = new File(uzytkownik + "." + title.getText());
                    if(f.createNewFile())
                    {
                        System.out.println("Plik stworzony" + f.getName());
                    }else{
                        System.out.println("Plik o takiej nazwie już istnieje");
                    }
                    FileWriter pisacz = new FileWriter(uzytkownik + "." + title.getText() , true);
                    pisacz.write(textNotatki.getText());
                    pisacz.close();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }

}
