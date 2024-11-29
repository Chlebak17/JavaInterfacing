import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cards extends Base {
    public Cards() throws HeadlessException {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel cardPanel = new JPanel(new CardLayout());

        JPanel green = new JPanel();
        green.setBackground(Color.GREEN);
        JPanel red = new JPanel();
        red.setBackground(Color.RED);

        cardPanel.add(red,"red");
        cardPanel.add(green,"green");


        JButton button1 = new JButton("1");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cardPanel.getLayout();
                cl.show(cardPanel, "green");
            }
        });
        JButton button2 = new JButton("2");
        button2.addActionListener(e -> ((CardLayout) cardPanel.getLayout()).show(cardPanel, "red"));

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        add(buttonPanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new Cards().setVisible(true);
    }
}