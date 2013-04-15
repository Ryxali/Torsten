package file;

public enum DefaultData {
	//TODO fill this shit out.
	GOBLIN("Goblin", "userData/img/Creature/goblin.png", "Creature", "Sneaky git. Goblin Tactics"),
	OGRE("Ogre", "userData/img/Creature/ogre.png", "Creature", "Big baddie.");
	
	
	
	private final String name;
	private final String imgRef;
	private final String type;
	private final String info;
	private DefaultData(String name, String imgRef, String type, String info){
		this.name = name;
		this.imgRef = imgRef;
		this.type = type;
		this.info = info;
	}
	
	public String getName(){
		return name;
	}
	public String getImgRef(){
		return imgRef;
	}
	public String getType(){
		return type;
	}
	public String getInfo(){
		return info;
	}
	
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
