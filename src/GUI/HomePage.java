package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HomePage extends JFrame implements ActionListener {
	private JButton start;
	private JButton load;
	private JButton options;

	public HomePage(){
		setupWindow();
		addTitle();
		makeButtons();
		this.pack();
	}

	private void setupWindow(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1280,720));
		this.setMaximumSize(new Dimension(1280,720));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setTitle("Catan Game");
		this.setResizable(true);
	}

	private void addTitle(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.lightGray);
		panel.setPreferredSize(new Dimension(500,200));
		panel.setLayout(new BorderLayout());

		JLabel title = new JLabel();
		title.setVerticalTextPosition(JLabel.CENTER);
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setText("Welcome to The Settlers of Catan");
		title.setFont(coolFont().deriveFont(45f));

		panel.add(title);
		this.add(panel,BorderLayout.NORTH);
	}

	private void makeButtons(){
		JPanel panel = new JPanel();
		start = new JButton("start game");
		load = new JButton("load game");
		options = new JButton("options");
		var lay = new FlowLayout(FlowLayout.CENTER,60,100);
		panel.setLayout(lay);


		start.setVerticalAlignment(JButton.CENTER);
		start.setHorizontalAlignment(JButton.CENTER);
		load.setVerticalAlignment(JButton.CENTER);
		load.setHorizontalAlignment(JButton.CENTER);
		options.setVerticalAlignment(JButton.CENTER);
		options.setHorizontalAlignment(JButton.CENTER);

		start.setFont(coolFont().deriveFont(30f));
		load.setFont(coolFont().deriveFont(30f));
		options.setFont(coolFont().deriveFont(30f));

		start.setFocusable(false);
		load.setFocusable(false);
		options.setFocusable(false);

		start.addActionListener(this);
		load.addActionListener(this);
		options.addActionListener(this);

		panel.add(start);
		panel.add(load);
		panel.add(options);
		this.add(panel,BorderLayout.CENTER);
	}

	private Font coolFont(){
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start){

		}

		if(e.getSource() == load){

		}
		if (e.getSource() == options){

		}
	}
}
