import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator extends JFrame
{
    JPanel panel;
    JButton dodawanie;
    JButton mnozenie;
    JButton dzielenie;
    JButton odejmowanie;
    JLabel wyswietlacz;
    JTextField liczba1;
    JTextField liczba2;




    public Kalkulator()
    {
        super("Kalkulator");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);


        dodawanie = new JButton("+");
        odejmowanie = new JButton("-");
        dzielenie = new JButton("/");
        mnozenie = new JButton("*");
        wyswietlacz = new JLabel("Wynik...");
        liczba1 = new JTextField();
        liczba2 = new JTextField();

        dodawanie.setBounds(20,200,100,100);
        odejmowanie.setBounds(145,200,100,100);
        dzielenie.setBounds(270,200,100,100);
        mnozenie.setBounds(395,200,100,100);
        wyswietlacz.setBounds(375,30,200,100);
        liczba1.setBounds(10,40,150,75);
        liczba2.setBounds(200,40,150,75);



        Font f = new Font("1",1,30);

        mnozenie.setFont(f);
        dzielenie.setFont(f);
        odejmowanie.setFont(f);
        dodawanie.setFont(f);
        wyswietlacz.setFont(f);
        liczba1.setFont(f);
        liczba2.setFont(f);


        panel.add(dodawanie);
        panel.add(dzielenie);
        panel.add(odejmowanie);
        panel.add(mnozenie);
        panel.add(wyswietlacz);
        panel.add(liczba1);
        panel.add(liczba2);

        add(panel);
        setVisible(true);


        dodawanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = Double.valueOf(liczba1.getText());
                double b = Double.valueOf(liczba2.getText());
                double c = a+b;
                wyswietlacz.setText(String.valueOf(c));
            }
        });
        odejmowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = Double.valueOf(liczba1.getText());
                double b = Double.valueOf(liczba2.getText());
                double c = a - b;
                wyswietlacz.setText(String.valueOf(c));
            }
        });
        mnozenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = Double.valueOf(liczba1.getText());
                double b = Double.valueOf(liczba2.getText());
                double c = a * b;
                wyswietlacz.setText(String.valueOf(c));
            }
        });
        dzielenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = Double.valueOf(liczba1.getText());
                double b = Double.valueOf(liczba2.getText());
                double c = a / b;
                wyswietlacz.setText(String.valueOf(c));
            }
        });
    }



}
