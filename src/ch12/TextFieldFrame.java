//Figura 12.9: textFieldFrame.java //JTextField e JpasswordField
package ch12;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TextFieldFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    private final JTextField textField1;//campo de texto com tamanho configurado
    private final JTextField textField2;//campo de texto com texto
    private final JTextField textField3;//campo de texto com texto e tamano
    private final JPasswordField passwordField;//campo de senha com texto

    //construtor TextFieldFrame adicional JTextFields a JFrame
    public TextFieldFrame()
    {
        super("Testing JTextField and JPasswordField");
        setLayout(new FlowLayout());

        //cria campo de texto com 10 colunas
        textField1 = new JTextField(10);
        add(textField1);//adiciona textField1 ao JFrame

        //cria campo de texto com texto padrão
        textField2 = new JTextField("Enter text here");
        add(textField2);//adiciona textField2 ao JFrame

        //cria campo de texto com texto padrão e 21 colunas
        textField3 = new JTextField("Uneditable text field", 21);
        textField3.setEditable(false);
        add(textField3);//adiciona textField3 ao JFrame

        //cria campo de senha com texto padrão
        passwordField = new JPasswordField("Hiden text");
        add(passwordField);

        //rotinas de tratamento de evento registradoras
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);
    }
        
        //classe interna privada para tratamento de evento
        private class TextFieldHandler implements ActionListener
        {
            //processa eventos de cada campo
            @Override 
            public void actionPerformed(ActionEvent event)
            {
                String string = "";

                //usuário pressionou Enter no JTextfiel textfield1
                if(event.getSource() == textField1)
                    string = String.format("textFielf1: %s",
                        event.getActionCommand());
                
                //usuário pressionou Enter no JTextFiel textField2
                else if (event.getSource() == textField2)
                    string = String.format("textField2: %s",
                        event.getActionCommand());

                //usuario pressionou Enter no JTextField textField3
                else if(event.getSource() == textField3)
                    string = String.format("textField3: %s",
                        event.getActionCommand());

                //usuario pressionou Enter no JTextFiel passwordField
                else if(event.getSource() == passwordField)
                    string = String.format("passwordField: %s",
                        event.getActionCommand());

                //exibe o conteúdo de JTexField
                JOptionPane.showMessageDialog(null, string);
            }
        }
}