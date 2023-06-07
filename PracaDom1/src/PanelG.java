import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelG extends JFrame
{
    JPanel panel;
    JButton nowaNotatka;
    JButton kalkulator;
    JLabel twojeNotatki;

    String uzytkownik;

    public PanelG(String uzytkownik){
        super("Panel Glowny");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        nowaNotatka = new JButton("NOWA NOTATKA");
        kalkulator = new JButton("KALKULATOR");
        twojeNotatki = new JLabel("TWOJE NOTATKI");

        nowaNotatka.setBounds(225,250,300,100);
        twojeNotatki.setBounds(115,60,700,160);
        kalkulator.setBounds(225,450,300,100);

        nowaNotatka.setFont(new Font("srednia",1,30));
        kalkulator.setFont(new Font("srednia",1,30));
        twojeNotatki.setFont(new Font("Duza",3,60));


        panel.add(nowaNotatka);
        panel.add(kalkulator);
        panel.add(twojeNotatki);

        add(panel);
        setVisible(true);
        this.uzytkownik = uzytkownik;


        nowaNotatka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelG.this.dispose();
                Notatnik notatnik = new Notatnik(uzytkownik);
            }
        });
        kalkulator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelG.this.dispose();
                Kalkulator kalkulator = new Kalkulator();
            }
        });


    }






}
