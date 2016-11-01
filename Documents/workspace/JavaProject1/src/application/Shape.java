package application;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * This object represents a shape with n-sides.
 * @author Ryan
 *
 */
public class Shape extends AnchorPane{
	
	/**
	 * The number of sides the shape has
	 */
	private final int num_sides;
	private double originalWidth = -1;
	private double originalHeight = -1;
	
	/**
	 * Constructs a shape of n-sides
	 * @param num_sides The number of sides the shape has
	 */
	public Shape(int num_sides)
	{
		//Check that the number of sides is valid
		if(num_sides < 3)
			throw new IllegalArgumentException("The number of sides on a regular polygon must be greater than or equal to 3.");
		
		//Sets the number of sides
		this.num_sides = num_sides;
		
		//Add a listener so that if the pane changes its height then the graphics will change 
		super.heightProperty().addListener(new ChangeListener<Number>() {
			public void changed( ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue)
			{
				if(originalHeight == -1)
					originalHeight = newValue.doubleValue(); 
				for(Node current: getChildren())
				{
					current.setScaleY(newValue.doubleValue() / originalHeight);
					current.setTranslateY(newValue.doubleValue() / 2);
				}

				System.out.println("Height Changed + " + newValue.doubleValue() / oldValue.doubleValue());
			}
		});
		
		//Add a listener so that if the pane changes its height then the graphics will change
		super.widthProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue)
			{
				if(originalWidth == -1)
					originalWidth = newValue.doubleValue(); 
				for(Node current: getChildren())
				{
					current.setScaleX(newValue.doubleValue() / originalWidth);
					current.setTranslateX(newValue.doubleValue() / 2  );
				}
				
				System.out.println("Width Changed " + newValue.doubleValue() / oldValue.doubleValue());
			}
		});
		
		Rectangle rectangle = new Rectangle(0, 0 ,100, 100);
		rectangle.setStrokeWidth(30);
		super.getChildren().add(rectangle);
	}
	
	/**
	 * Compares two shapes to see if they are equal
	 * @param other The shape that will be compared too
	 * @return true if and only if the number of sides of each shape are equivalent.
	 */
	public boolean equals(Object other)
	{
		if(!(other instanceof Shape))
			return false;
		
		Shape otherShape = (Shape) other;
		
		return this.num_sides == otherShape.num_sides;
	}
	
	/**
	 * Creates a string to describe the number of sides on the object.
	 */
	public String toString()
	{
		return "Shape with " + num_sides + " sides.";
	}
	
	/**
	 * @return The number of sides the polygon has
	 */
	public int get_num_sides()
	{
		return num_sides;
	}

	/**
	 * Generates the graphics in the pane when the panes has the specified width and height
	 * @param width The current or new value of width of the pane
	 * @param height The current or new value of the height of the pane
	 */
	private void drawGraphics(double width, double height)
	{
		//Creates the polygon for center of graphic
		Polygon polygon = new Polygon();
		polygon.setStrokeWidth(5);
		
		//Creates all the nodes
		for(int i = 0; i < num_sides; i ++)
		{
			double sinValue = Math.sin(i / num_sides * 2*Math.PI); //Calculates the sin of the point
			polygon.getPoints().add((1 + sinValue)*width/2); //Adds the total width using the sin
			polygon.getPoints().add((1 - sinValue - Math.PI / 2) * height /  2); //Adds the height by phase shifting the sin value and then scaling for the height.
		}
		
		Line line = new Line(0, 0 , width, height);
		//super.getChildren().clear();
		//super.getChildren().add(polygon);
		super.getChildren().add(line);
	}
}
