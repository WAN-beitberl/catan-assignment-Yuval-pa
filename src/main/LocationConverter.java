package main;

import GUI.Board;
import GUI.Hexagon;
import infrastructure.Location;
import infrastructure.TileManager;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**
 * converts between screen and backend locations
 */
public class LocationConverter {

	private final Board frame;
	private int height;
	private int width;
	private Location[] loc = TileManager.getLocations();

	private int numRows = 12;
	private int[] numCols = { 3, 4, 4, 5, 5, 6, 6, 5, 5, 4, 4, 3 };
	private int tileSize = Hexagon.HEX_AREA;
	private final int offsetX = 20;
	private final int offsetY = 10;


	public LocationConverter(Board panel) {
		this.frame = panel;
		height = frame.getHeight();
		width = frame.getWidth();
		addHexagons();
	}

	public void resize() {
		height = frame.getHeight();
		width = frame.getWidth();
	}

	private void addHexagons()
	{
		for(Location location: loc){
			frame.addHex(matrixToPixel(location));
		}
	}

	public Point matrixToPixel(@NotNull Location location) {
		int row = location.get_xCor() - 1;
		int col = location.get_yCor() - 1;

		// Compute the X and Y offsets for the current row and column
		int xOff = (numCols[row] - 1) * tileSize / 2;
		int yOff = row * tileSize * 3 / 4;

		// Compute the actual X and Y coordinates by adding the offsets and tile size
		int x = offsetX + col * tileSize + xOff;
		int y = offsetY + col * tileSize / 2 + yOff;

		return new Point(x, y);
	}

	public Location pixelToMatrix(@NotNull Point point) {
		int x = point.x - offsetX;
		int y = point.y - offsetY;

		// Compute the row and column based on the Y coordinate
		int row = y / (tileSize * 3 / 4);
		int col;

		// Compute the X offset for the current row
		int xOff = (numCols[row] - 1) * tileSize / 2;

		if (row % 2 == 0) {
			// Even rows have one fewer column than odd rows
			col = (x - xOff) / tileSize;
		}
		else {
			col = (x - xOff - tileSize / 2) / tileSize;
		}

		// Add 1 to the row and column indices to get the actual matrix location
		return new Location(row + 1, col + 1);
	}


}
