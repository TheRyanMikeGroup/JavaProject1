package application;


import java.util.ArrayList;

import javafx.collections.ObservableArray;
import javafx.scene.layout.GridPane;
/**
 * This class represents any displayable shape list
 * @author Ryan
 *
 * @param <T> The type of shape that is stored in the shape display
 */
public class ShapesDisplay<T extends Shape> extends GridPane{

	private ArrayList<T> shape_array;
	
	public ShapesDisplay()
	{
		shape_array = new ArrayList<T>();
	}

}
