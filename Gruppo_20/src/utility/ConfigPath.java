package utility;

public class ConfigPath {
	
	/*private final static String livingRoomBoardPath = ".\\Gruppo_20\\resources\\Assets\\boards\\livingroom.png";
	private final static String bookshelfPath = ".\\Gruppo_20\\resources\\Assets\\boards\\bookshelf.png";
	private final static String itemFilePath = ".\\Gruppo_20\\resources\\item.txt";
	private final static String itemTilePath = ".\\Gruppo_20\\resources\\Assets\\itemTiles\\";*/
	
	private final static String livingRoomBoardPath = ".\\resources\\Assets\\boards\\livingroom.png";
	private final static String bookshelfPath = ".\\resources\\Assets\\boards\\bookshelf.png";
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
