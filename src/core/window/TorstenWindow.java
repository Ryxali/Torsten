package core.window;

import java.awt.Frame;
import java.awt.Window;


public class TorstenWindow extends Window{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TorstenFrame tFrame;
	public TorstenWindow(TorstenFrame tFrame) {
		super(tFrame);
		this.tFrame = tFrame;
		tFrame.setBounds(200, 200, 200, 200);
	}
	
	public void start(){
		boolean running = true;
		setVisible(true);
		tFrame.setVisible(true);
		while(running){
			tFrame.update(getGraphics());
		}
	}

}
