package utility;

public class ConfigPath {
		
	private final static String livingRoomBoardPath = ".\\resources\\Assets\\boards\\livingroom.png";
	private final static String bookshelfPath = "./resources/Assets/boards/bookshelf_orth.png";
	private final static String itemFilePath = ".\\resources\\item.txt";
	private final static String itemTilePath = ".\\resources\\Assets\\itemTiles\\";

	
	public static String getItemFilePath() {
		return itemFilePath;
	}
	
	public static String getBookshelfPath() {
		return bookshelfPath;
	}
	
	public static String getLivingRoomBoardPath() {
		return livingRoomBoardPath;
	}

	public static String getItemTilePath() {
		return itemTilePath;
	}
	
	
}
