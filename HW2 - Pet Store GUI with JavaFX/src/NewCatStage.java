/**
 * Class: NewCatStage
 * @author Dr. Johnson
 * @modified by Samuel Mckinney
 * @version 1.0 Course : ITEC 3150, Fall, 2020 Written: September 9 , 2020
 * 
 * 
 *          This class � This class opens a stage to enter a new Cat object
 * 
 *          Purpose: � Methods and attributes needed to read attributes of a Cat
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
 * NewCatStage
 * Facilitates the GUI that allows the user to add a new Cat
 */
public class NewCatStage extends Stage
{
	// fields shared by methods
	private TextField name = new TextField();
	private TextField birthYear = new TextField();
	private boolean isCat = false;
	private TextField isLongHair = new TextField();
	private TextField weight = new TextField();
	private ObservableList<Pet> obserPet;

	/**
	 * Constructor that creates and makes Stage for Cat entry visible
	 * 
	 * @param list
	 */
	public NewCatStage(ObservableList<Pet> list)
	{
		obserPet = list;
		// Create a pane and set its properties
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);

		//Adds the fields for the Cat and places the nodes in the pane. IsDog is already a given as false.
		pane.add(new Label("Name:"), 0, 0);
		pane.add(name, 1, 0);
		pane.add(new Label("Birthyear:"), 0, 1);
		pane.add(birthYear, 1, 1);
		pane.add(new Label("Long hair? (yes/no):"), 0, 3);
		pane.add(isLongHair, 1, 3);
		pane.add(new Label("Weight:"), 0, 4);
		pane.add(weight, 1, 4);

		//Final button that calls the method to add the pet to the list.
		Button btAdd = new Button("Add New Cat");
		pane.add(btAdd, 1, 5);
		GridPane.setHalignment(btAdd, HPos.RIGHT);
		btAdd.setOnAction(e -> addPet());

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		this.setTitle("Add New Cat"); // Set the stage title
		this.setScene(scene); // Place the scene in the stage
		this.show(); // Display the stage
	}

	/**
	 * Method:addPet()
	 * 
	 * This method reads the entries made by user in textfields and
	 * converts to a cat object.  This object is added to ObservableList 
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
		String isLongHairField = isLongHair.getText();
		Boolean isLongHairBool;

		//Converts users yes or no input to a boolean
		if(isLongHairField.equalsIgnoreCase("yes") || isLongHairField.equalsIgnoreCase("y")) {
			isLongHairBool = true;
		}
		else {
			isLongHairBool = false;
		}

		// create book object
		Cat d = new Cat(nameField, Integer.parseInt(birthField), isCat, isLongHairBool, Double.parseDouble(weightField));
		obserPet.add(d);

		// close stage
		this.close();
	}

}
