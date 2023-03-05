package main;

import GUI.HomePage;
import infrastructure.CornerManager;
import infrastructure.TileManager;

public class Main {
	public static void main(String[] args) {
		TileManager.initTiles();
		CornerManager.createCorners();
		System.out.println("Hello world!");
		HomePage hp = new HomePage();
	}
}
