package src;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas{
	private static final long serialVersionUID = -665052142382657214L;
	
	public Window(int width, int height, String title, GameMain game)
	{
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //the app stops on exit
		frame.setResizable(false); //user is unable to resize the window
		frame.setLocationRelativeTo(null); //starts in the middle instead of upper left
		frame.add(game); //adds the rendered game into the JFrame Window
		frame.setVisible(true); //makes the window visible
		game.start(); //starts and loops the added rendered game
	}
}




