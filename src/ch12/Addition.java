//Figura 12.2: Addition.java
//Programa de adição que utiliza JOptionPane para entrada e saída
package ch12;

import javax.swing.JOptionPane;

public class Addition {
    public static void main(String[] args)
    {
        //obtém a entrada de usuário a partir dos diálogos de entrada JOptionPane
        String firstNumber =
            JOptionPane.showInputDialog("Enter firs integer");
        String secondNumber =
            JOptionPane.showInputDialog("Enter second integer");

            //converte string em vlores int para utilização em um cálculo
            int number1 = Integer.parseInt(firstNumber);
            int number2 = Integer.parseInt(secondNumber);

            int sum = number1 + number2;

            //exibe o resultado em um diálogo de mensagem JOptionPane
            JOptionPane.showMessageDialog(null, "The sum is " + sum, 
            "Sum of two Integers", JOptionPane.PLAIN_MESSAGE);
    }
}