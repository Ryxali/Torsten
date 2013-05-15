package core.file;
/**
 * An enumeration designed to contain a preset of palette sample values.
 * @author Niklas Lindblad
 * @see UserFileReader
 */
public enum DefaultData {
	GOBLIN_MINION("Lesser Goblin", "userData/img/Creature/goblinMinion.png", "Creature", "Sneaky git. Goblin Tactics"),
	GOBLIN_BOSS("Boss Goblin", "userData/img/Creature/bossGoblin.png", "Creature", "Sneaky boss git. Goblin Tactics"),
	OGRE("Ogre", "userData/img/Creature/ogre.png", "Creature", "Big baddie."),
	GITHYANKI_DRUDGE("Githyanki Drudge", "userData/img/Creature/Githyanki_Drudge.png", "Creature", "34hp. 20AC. 23Will. 25Ref. Atk: +9 vs AC. Hit: 2d6+4"),
	GITHYANKI_BOSS("Githyanki Boss", "userData/img/Creature/Githyanki_Boss.png", "Creature", "46hp. 25AC. 23Will. 20Ref. Atk: +13 vs AC. Hit: 2d6+8"),
	RUBBLE("Rubble", "userData/img/Obstacle/Rubble.png", "Obstacle", "Counts as rough terrain"),
	RUBBLE_BIG("Big Rubble", "userData/img/Obstacle/Big_Rubble.png", "Obstacle", "Currently blocks this square. With some time and effort this can be corrected, though."),
	WALL_DWARVEN("Dwarven wall", "userData/img/Obstacle/Wall_Dwarf.png", "Obstacle", "Is impassable"),
	WALL_Cave("Cave wall", "userData/img/Obstacle/Wall_Cave.png", "Obstacle", "Is impassable"),
	Dawntreader("Dawntreader", "userData/img/Item/dawntreader.png", "Item", "Elky blade"),
	GOLD_PILE("Gold Pile", "userData/img/Item/Treasure_Gold.png", "Item", "A large portion of permanent monetary income. (2d100 gold pieces)");
	
	
	/**
	 * The name of this sample
	 */
	private final String name;
	/**
	 * The image reference of this sample
	 */
	private final String imgRef;
	/**
	 * The sample type
	 */
	private final String type;
	/**
	 * The info text of this sample
	 */
	private final String info;
	/**
	 * Creates a new sample info entry
	 * @param name the name of the sample
	 * @param imgRef the image ref of the sample
	 * @param type the type of the sample
	 * @param info the sample info
	 */
	private DefaultData(String name, String imgRef, String type, String info){
		this.name = name;
		this.imgRef = imgRef;
		this.type = type;
		this.info = info;
	}
	/**
	 * 
	 * @return name, the sample name
	 */
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @return imgRef, the sample image reference
	 */
	public String getImgRef(){
		return imgRef;
	}
	/**
	 * 
	 * @return type, the sample type
	 */
	public String getType(){
		return type;
	}
	/**
	 * 
	 * @return info, the sample info
	 */
	public String getInfo(){
		return info;
	}
	/**
	 * Retrieve all samples that is of specified type
	 * @param type the type of samples you want to fetch
	 * @return an array containing all samples of the specified type.
	 */
	public static DefaultData[] listOfType(String type){
		DefaultData [] temp = values();
		int size = 0;
		for (int i = 0; i < temp.length; i++) {
			if(temp[i].getType().toLowerCase().equals(type.toLowerCase())){
				size++;
			}
		}
		DefaultData [] temp2 = new DefaultData[size];
		size = 0;
		for (int i = 0; i < temp.length; i++) {
			if(temp[i].getType().toLowerCase().equals(type.toLowerCase())){
				temp2[size] = temp[i];
				size++;
			}
		}
		return temp2;
	}
	
}
