package core;
/**
 * 
 * @author freetimer
 * @deprecated the loadable interface is incompatible with OpenGL 2.0 or lower as it won't allow dynamic resource references.
 */
public interface Loadable {
	public void reload();
	public void unload();
}
