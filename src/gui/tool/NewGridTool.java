package gui.tool;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.xml.sax.SAXException;

import core.xml.QueryXML;
import gui.dialogue.MultipleInputDialogue;
import gui.square.Square;

/**
 * This tool will, when selected, create a new Grid by the size specified by
 * user prompt.
 * 
 * @author Niklas L
 * @see Tool
 * @see gui.square.Grid
 */
public class NewGridTool extends Tool {
	/**
	 * Creates a new Tool with the specified title
	 * 
	 * @param text
	 *            the string to be displayed on top of the button.
	 */
	public NewGridTool(String text) {
		super(text);
	}

	@Override
	public Tool getTool() {
		// TODO add double input window here for grid rows/cols
		// MultipleInputDialogue.get().showMultipleInputDialogue("Text",
		// "texteds");
		QueryXML x = new QueryXML();
		try {
			x.query();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void onUse(Square square) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

}
