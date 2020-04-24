package ch12;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class ListFrame extends JFrame
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final JList<String> colorJList;
    private static final String[] colorNames = { "Black",
"Blue", "Cyan", "Dark Gray", "Gray", "Green", "Ligth Gray", "Magenta",
"Orange", "Pink", "Red", "White", "Yellow"};
private static final Color[] colors = {Color.BLACK, Color.BLUE,
Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
Color.RED, Color.WHITE, Color.YELLOW};

//
public ListFrame()
{
    super("List Teste");
    setLayout(new FlowLayout());

    colorJList = new JList<String>(colorNames);
    colorJList.setVisibleRowCount(5);

    //
    colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    //adiciona um JScrollPane que contém JList ao Frame
    add(new JScrollPane(colorJList));

    colorJList.addListSelectionListener(
        new ListSelectionListener()//classe interna anônima
        {
            //trata eventos de seleção de lista
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
                getContentPane().setBackground(
                    colors[colorJList.getSelectedIndex()]);
            }
        }
    );
}
}