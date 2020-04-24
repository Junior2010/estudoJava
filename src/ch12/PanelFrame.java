package ch12;
//
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelFrame extends JFrame
{
    private final JPanel buttonJPanel;
    private final JButton[] buttons;
    private final JPanel centerJPanel;
    private final JPanel topJPanel;
    private final JButton botaoTeste;

    //
    public PanelFrame()
    {
        super("Panel Demo");

        centerJPanel = new JPanel();
        centerJPanel.setBackground(Color.GREEN);
        add(centerJPanel, BorderLayout.CENTER);
        
        topJPanel = new JPanel();
        topJPanel.setBackground(Color.RED);

        botaoTeste = new JButton("TESTE");
        topJPanel.add(botaoTeste);
        add(topJPanel, BorderLayout.NORTH);

        buttons = new JButton[5];
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(1, buttons.length));

        //cria e adiciona botões
        for (int count = 0; count < buttons.length; count++)
        {
            buttons[count] = new JButton("Button " + (count + 1));
            buttonJPanel.add(buttons[count]);//
        }
        add(buttonJPanel, BorderLayout.SOUTH);
    }
}