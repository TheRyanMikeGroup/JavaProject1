package application;


import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 * This class is a pane that controls the game with multiple rounds.
 * @author Ryan
 *
 */
public class Game extends BorderPane{

	
	/**
	 * The possible number of sides the shapes can have
	 */
	private Set<Integer> possibleSides;
	
	/**
	 * The possible Colors the shapes can have
	 */
	private Set<NamedColor> possibleColors;
	
	/**
	 * The number of Shapes they need to reveal
	 */
	private int num_shapes;
	
	/**
	 * The current board for the round
	 */
	private Board board;
	
	/**
	 * The reveal button for the user to lock in thier answer and reveal the next one
	 */
	private Button revealButton = new Button("Reveal");
	
	/**
	 * The quit button for if the user is done playing this sorry excuse for a game
	 */
	private Button quitButton = new Button("Quit");
	
	/**
	 * Button to move the user on to the next round
	 */
	private Button nextRoundButton = new Button("Next Rounds");
	
	/**
	 * The points label to show how awful the user is at the game
	 */
	private Label pointLabel;
	
	/**
	 * The current amount of points the user has for the game
	 */
	private int pointCount = 0;
	
	/**
	 * Creates a game with following traits
	 * @param number_of_trials The number of trials that the game will have
	 * @param possibleSides The set of possible sides the shapes can have
	 * @param possibleColors The set of possible colors the shape can have
	 */
	public Game(int number_of_trials, Set<Integer> possibleSides, Set<NamedColor> possibleColors)
	{
		super();
		
		//Creates an initial board
		board = new Board(number_of_trials, possibleSides, possibleColors);
		
		//Creates a flowpane for the bottom buttons
		FlowPane bottomPane = new FlowPane();
		
		//Disable the next round button because we have not finished the next round
		nextRoundButton.setDisable(true);
		
		//Adds the reveal, next round and quit buttons to the bottom pane
		bottomPane.getChildren().add(revealButton);
		bottomPane.getChildren().add(quitButton);
		bottomPane.getChildren().add(nextRoundButton);
		
		//Initializes the points label to show the number of points
		 pointLabel = new Label("Points: ");
		
		//Adds the bottom pane to the bottom, the board for the first round to the center and the point counter to the top.
		super.setBottom(bottomPane);
		super.setCenter(board);
		super.setTop(pointLabel);
		
		revealButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
				//Reveals the next shape and adds to the point count, finally updating the point count
				pointCount += board.revealNext();
				pointLabel.setText("Points: " + pointCount);
				
				//Checks if the round is over, if it is we disable the next round button and enables the next round button
				if(board.roundOver())
				{
					nextRoundButton.setDisable(false);
					revealButton.setDisable(true);
				}
					
				
			}
			
		});
	}
}
