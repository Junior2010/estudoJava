package ch12;
import javax.swing.JFrame;

public class MultipleSelectionTest 
{
    public static void main(String[] args){
        MultipleSelectionFrame frame =
        new MultipleSelectionFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 150);
        frame.setVisible(true);
    }
}