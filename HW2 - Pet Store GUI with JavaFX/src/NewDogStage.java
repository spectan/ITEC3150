/**
 * Class: NewDogStage
 * 
 * @author Dr. Johnson
 * @modified by Samuel Mckinney
 * @version 1.0 Course : ITEC 3150, Fall, 2020 Written: September 9 , 2020
 * 
 * 
 *          This class � This class opens a stage to enter a new dog object
 * 
 *          Purpose: � Methods and attributes needed to read attributes of a Dog
 *          object from the user, create object and add to passed over ObservableList
 *
 */

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * NewDogStage
 * Facilitates the GUI that allows the user to add a new dog
 */
public class NewDogStage extends Stage
{
	// fields shared by methods
	private TextField name = new TextField();
	private TextField birthYear = new TextField();
	private boolean isDog = true;
	private TextField breed = new TextField();
	private TextField weight = new TextField();
	private ObservableList<Pet> obserPet;

	/**
	 * Constructor that creates and makes Stage for Dog entry visible
	 * 
	 * @param list
	 */
	public NewDogStage(ObservableList<Pet> list)
	{
		obserPet = list;
		// Create a pane and set its properties
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);

		//Adds the fields for the dog and places the nodes in the pane. Isdog is already a given as true.
		pane.add(new Label("Name:"), 0, 0);
		pane.add(name, 1, 0);
		pane.add(new Label("Birthyear:"), 0, 1);
		pane.add(birthYear, 1, 1);
		pane.add(new Label("Breed:"), 0, 3);
		pane.add(breed, 1, 3);
		pane.add(new Label("Weight:"), 0, 4);
		pane.add(weight, 1, 4);

		//Final button that calls the method to add the pet to the list.
		Button btAdd = new Button("Add New Dog");
		pane.add(btAdd, 1, 5);
		GridPane.setHalignment(btAdd, HPos.RIGHT);
		btAdd.setOnAction(e -> addPet());

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		this.setTitle("Add New Dog"); // Set the stage title
		this.setScene(scene); // Place the scene in the stage
		this.show(); // Display the stage
	}

	/**
	 * Method:addPet()
	 * 
	 * This method reads the entries made by user in textfields and
	 * converts to dog object.  This object is added to ObservableList 
	 * in attributes.
	 * 
	 * 
	 */
	public void addPet()
	{
		// gets name, birthyear, weight, and breed and passes it to create a book object.
		String nameField = name.getText();
		String birthField = birthYear.getText();
		String weightField = weight.getText();
		String breedField = breed.getText();

		// create book object
		Dog d = new Dog(nameField, Integer.parseInt(birthField), isDog, breedField, Double.parseDouble(weightField));
		obserPet.add(d);

		// close stage
		this.close();
	}

}
