package model;

public enum ItemTileType {
	CAT, BOOK, GAME, FRAME, TROPHY, PLANT, NULL;

	public static ItemTileType assignType(String color) {
		if (color.equals("blu")) {
			return ItemTileType.FRAME;
		}
		if (color.equals("bianco")) {
			return ItemTileType.BOOK;
		}
		if (color.equals("verde")) {
			return ItemTileType.CAT;
		}
		if (color.equals("azzurro")) {
			return ItemTileType.TROPHY;
		}
		if (color.equals("rosa")) {
			return ItemTileType.PLANT;
		}
		if (color.equals("arancione")) {
			return ItemTileType.GAME;
		}
		else
			return ItemTileType.NULL;
	}
}