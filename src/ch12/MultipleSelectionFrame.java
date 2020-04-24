//
package ch12;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionFrame extends JFrame
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final JList<String> colorJList;// lista para armazenar nomes de cor
    private final JList<String> copyJList;//lista para armazenar os nomes copiados
    private JButton copyJButton;//botão para copiar nomes selecionados
    private static final String[] colorNames = { "Black", "Blue", "Cyan",
"Dark Gray", "Gray", "Green", "Ligth Gray", "Magenta", "Orange",
"Pink", "Red", "White", "Yellow"};

//construtor
public MultipleSelectionFrame()
{
    super("Multiple SelectionFrame");
    setLayout(new FlowLayout());

    colorJList = new JList<String>(colorNames);
    colorJList.setVisibleRowCount(5);
    colorJList.setSelectionMode( 
ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
add(new JScrollPane(colorJList));

copyJButton = new JButton("Copy >>>");
copyJButton.addActionListener(
    new ActionListener()
    {
        //trata eventos do botão
        @Override
        public void actionPerformed(ActionEvent event)
        {
            //coloca valores selecionados na copyList
            copyJList.setListData(
                colorJList.getSelectedValuesList().toArray( 
                    new String[0]));

        }
    }
);

add(copyJButton);

copyJList = new JList<String>();//lista para armazenar nomes copiados
copyJList.setVisibleRowCount(5);
copyJList.setFixedCellWidth(100);
copyJList.setFixedCellHeight(15);
copyJList.setSelectionMode(
ListSelectionModel.SINGLE_INTERVAL_SELECTION);
add(new JScrollPane(copyJList));
}
}