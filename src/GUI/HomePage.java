package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HomePage extends Page {
	private JButton start;
	private JButton load;
	private JButton options;
	private JPanel master;

	public HomePage(){
		super();
		addTitle();
		makeButtons();
		ImageIcon icon = new ImageIcon("resources/catan background.jpg");

		//this.setBackground(new ImageIcon("resources/catan background.jpg"));
		this.pack();
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
		start = new JButton("Start Game");
		load = new JButton("Load Game");
		options = new JButton("Options");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start){
			// todo get names and colors form users
			this.setVisible(false);
			new GameWindow();
			dispose();
		}

		if(e.getSource() == load){

		}
		if (e.getSource() == options){

		}
	}
}
