/***********************************************************************
 Program Name: Index.java
 Programmer's Name: Steven Bennett
 Program Description: Program accepts string of text in text area from
 user. User enters a single character, and the number of occurrences of 
 that character will be displayed.
 ***********************************************************************/ 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index extends JFrame{
	//declare instance variables
	private JFrame mainFrame;
	private JLabel textAreaLabel;
	private JTextArea stringToSearch;
	private JLabel searchCharLabel;
	private JTextField searchCharField;
	private JButton submitButton;
	
	//Index constructor
	public Index()
	{
		//instantiate mainFrame, JTextArea, JLabel, JButton and JTextField objects.
		mainFrame = new JFrame("Index Lab");
		textAreaLabel = new JLabel("Enter text to be searched: ");
		stringToSearch = new JTextArea("Enter text here...", 5, 15);
		searchCharLabel = new JLabel("Enter character to count: ");
		searchCharField = new JTextField(3);
		submitButton = new JButton("Submit");
		
		//create mainframe, set layout for program, add event to close program with "X" window button.
		Container c = mainFrame.getContentPane();
		c.setLayout(new FlowLayout());
		mainFrame.setBounds(800, 300, 400, 200);
		mainFrame.setVisible(true);
		mainFrame.addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						System.exit(0);
					}
				});
		
		//add components to container
		c.add(textAreaLabel);
		c.add(stringToSearch);
		c.add(searchCharLabel);
		c.add(searchCharField);
		c.add(submitButton);
		
		//set properties of JTextArea
		stringToSearch.setLineWrap(true);
		stringToSearch.setWrapStyleWord(true);
		
		//add event handler to searchCharField. Allow user to press Enter submit.
		SubmitButtonHandler sbHandler = new SubmitButtonHandler();
		submitButton.addActionListener(sbHandler);
	}
	
	
	//add event handler to user input JTextField press enter to display results
	
	class SubmitButtonHandler implements ActionListener{
		public void actionPerformed (ActionEvent e)
		{
			String textAreaString = stringToSearch.getText();  //string to hold input from JTextArea.
			String charToCount = searchCharField.getText();    //convert string to char from JTextField.
			int start = 0;     //used to keep track of current index in string.
			int counter = 0;   //used to count number of occurrences of specific character.
			
			textAreaString = textAreaString.toLowerCase();//changes input text to lower case.
			charToCount = charToCount.toLowerCase();//allows user to enter upper or lower case values.
			
			while(true)
			{
				start = textAreaString.indexOf(charToCount.charAt(0), start);
				if(start < 0)
					break;
				start++;
				counter++;
			}
			
			JOptionPane.showMessageDialog(null, "Number of " + charToCount + "'s: " + counter, "Results", JOptionPane.PLAIN_MESSAGE);
		}
	}

}
