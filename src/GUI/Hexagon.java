package GUI;

import infrastructure.Tile;

import javax.swing.*;
import java.awt.*;

/**
 * a class used for drawing the tiles
 */
public class Hexagon extends JPanel {
	public static final int HEX_RADIUS = 300;
	public static final int HEX_SIDE = 50;
	public static final int HEX_AREA = 6495;
	private final Point basePoint;
	private Tile tile;

	public Hexagon(int baseX, int baseY){
			this.basePoint = new Point(baseX,baseY);
	}
	public Hexagon(Point basePoint){
		this.basePoint = basePoint;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int x = basePoint.x - HEX_SIDE / 2;
		int y = basePoint.y - HEX_SIDE / 2;
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, HEX_SIDE, HEX_SIDE);
	}


}
