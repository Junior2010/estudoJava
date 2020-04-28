package ch03;

import javax.swing.JOptionPane;

public class NameDialog 
{
	public static void main(String[] args)
	{
		//
		String name = JOptionPane.showInputDialog("what is your name");
		
		//
//		String message =
//				String.format("Welcome, %s, to Java PRogramming!", name);
		String message =
				"Welcome, " + name + ", to Java PRogramming!";		
		//
		JOptionPane.showMessageDialog(null, message);
	}
}
