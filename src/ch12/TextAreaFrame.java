package ch12;
//
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextAreaFrame extends JFrame
{
    private final JTextArea textArea1;
    private final JTextArea textArea2;
    private final JButton copyJButton;

    //
    public TextAreaFrame()
    {
        super("TextArea Demo");
        Box box = Box.createHorizontalBox();
        String demo = "Tis is a demo string to \n"+
        "illustrate copying text\nfrom one textarea to \n" +
        "another textarea using an \nexternal event\n";

        textArea1 = new JTextArea(demo, 10, 15);
        box.add(new JScrollPane(textArea1));

        copyJButton = new JButton("Copy>>>");
        box.add(copyJButton);
        copyJButton.addActionListener( 
            new ActionListener()
            {
                //
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    textArea2.setText(textArea1.getSelectedText());
                }
            }
        );

        textArea2 = new JTextArea(10, 15);
        textArea2.setEditable(false);
        box.add(new JScrollPane(textArea2));

        add(box);
    }
}