package GUI;

import infrastructure.CornerManager;
import infrastructure.TileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameWindow extends Page {
	private JPanel panel1;
	private Board board1;
	private JPanel hand;
	private JPanel sideBar;
	private JLabel palyerName;
	private JButton build;
	private JButton upgrade;

	public GameWindow() {
		super();
		setContentPane(panel1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		TileManager.initTiles();
		CornerManager.createCorners();
		GameWindow gameWindow = new GameWindow();
	}

	private void createUIComponents() {
		// TODO: place custom component creation code here
		board1 = new Board();
	}
}
