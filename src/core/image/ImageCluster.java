package core.image;

import java.util.ArrayList;
/**
 * 
 * @deprecated we have no need for image arrays at this moment
 */
public enum ImageCluster{
	BACKDROP_FOREST_FAR("forest", "far",
			null);
	
	public static final String FAR = "far";
	public static final String MID = "mid";
	public static final String SHORT = "short";
	public static final String SKY = "sky";
	
	public static final String FOREST = "forest";
	
	private final String name;
	private final String use;
	private DefaultImage[] images;
	private ImageCluster(String name, String use, DefaultImage... images){
		this.images = images;
		this.name = name;
		this.use = use;
	}
	public DefaultImage[] getImages(){
		return images;
	}
	public DefaultImage get(int index){
		return images[index];
	}
	public static ImageCluster getClusterByNameAndUsage(String name, String usage){
		ImageCluster [] clusters = values();
		for (int i = 0; i < clusters.length; i++) {
			if(clusters[i].name.equals(name) &&
					clusters[i].use.equals(usage)){
				return clusters[i];
			}
			
		}
		return null;
	}
}
