package GUI;

import main.LocationConverter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel{
	private LocationConverter lc;
	private ArrayList<Point> tiles;
	private static final int HEX_RADIUS = 300;
	private static final int HEX_SIDE = 50;
	private static final int HEX_AREA = 6495;


	public Board() {
		this.setMaximumSize(new Dimension(1280,720));
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1280,790));
		this.setBackground(Color.lightGray);
		tiles = new ArrayList<>();
		lc = new LocationConverter(this);
	}


	public void addHex(Point point)
	{
		tiles.add(point);
		this.add(new Hexagon(point));
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for(Point point : tiles){
			int x = point.x - HEX_SIDE / 2;
			int y = point.y - HEX_SIDE / 2;
			g.setColor(Color.YELLOW);
			g.fillRect(x, y, HEX_SIDE, HEX_SIDE);
		}
	}

}
