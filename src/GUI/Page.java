package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * a abstract master class for frames
 */
public abstract class Page  extends JFrame implements ActionListener {

	protected final int WIDTH = 1280;
	protected final int HEIGHT = 720;

	public Page(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("Catan Game");
		this.setResizable(true);
	}

	/**
	 * get the default font for this project, needs to be driven to the wanted size.
	 * @return the default font of this project
	 */
	protected Font coolFont()
	{
		Font font;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("resources\\Sherlock Press.ttf"));
			ge.registerFont(font);
		} catch (FontFormatException | IOException e) {
			throw new RuntimeException(e);
		}
		return font;
	}

	protected Font coolFont(String fontFileName){
		Font font;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("resources\\"+fontFileName));
			ge.registerFont(font);
		} catch (FontFormatException | IOException e) {
			throw new RuntimeException(e);
		}
		return font;
	}

}
