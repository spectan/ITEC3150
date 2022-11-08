import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * 
 * Main GUI class - contains ListView and launches additional Stages as needed
 * 
 * @author Dr. Johnson
 * @modified by Samuel Mckinney
 * @version 1.0 Course : ITEC 3150, Fall, 2020 Written: September 9 , 2020
 * 
 * 
 *          Main GUI class - contains ListView and launches additional Stages as
 *          needed
 * 
 *          Purpose: � Methods and attributes needed to display a ListView of
 *          pet objects and popup stage for more detail.
 *
 *
 */
public class MainInterface extends Application
{
	private Library myLibrary = new Library();
	private ObservableList<Pet> items;
	/*
	 * 
	 * 
	 * Method:start()
	 * 
	 * This method adds the parameter m to the libraryItems array list
	 * 
	 * @param Stage primaryStage
	 * 
	 *
	 * (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		// read in file and create library
		myLibrary.readBinaryFile();

		// display list of library items
		VBox mainPane = new VBox();
		Label mainLabel = new Label("Pets on Record");

		mainPane.getChildren().add(mainLabel);
		ListView<Pet> list = new ListView<Pet>();
		items = FXCollections.observableArrayList(myLibrary.getTheList());
		list.setItems(items);

		mainPane.getChildren().add(list);

		// make list selectable and popup info on selected item in a separate
		// stage
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pet>()
		{

			public void changed(ObservableValue<? extends Pet> observable, Pet oldValue, Pet newValue)
			{
				// pop up detail stage of selected Pet object
				Stage newStage = null;
				newStage = createPetStage(newValue);

				newStage.show();
			}
		});

		// create new button for adding the pets and an end button for writing to the binary file.
		Button newDog = new Button("New Dog");
		newDog.setOnAction(e -> getNewDog());
		Button newCat = new Button("New Cat");
		newCat.setOnAction(e -> getNewCat());
		mainPane.getChildren().addAll(newDog, newCat);
		
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> writeAndClose());
		mainPane.getChildren().add(closeButton);

		// Create a scene and place it in the stage
		Scene scene = new Scene(mainPane, 500, 200);
		primaryStage.setTitle("Available Pets"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	/*
	 * Method to create new Stage for details about a Pet object Called by
	 * ListView selection handler
	 * 
	 * @param Media
	 * 
	 * @return Stage
	 */
	private Stage createPetStage(Pet m)
	{
		Stage s = new Stage();
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		Pet b = (Pet) m;
		
		//Place information nodes when a pet's name is selected.
		//Applicable to both cats and dog
		pane.add(new Label("Name:"), 0, 0);
		pane.add(new Label(b.getName()), 1, 0);
		pane.add(new Label("Birthyear:"), 0, 2);
		pane.add(new Label(Integer.toString(b.getYearOfBirth())), 1, 2);
		//Dog specific information
		if (b.isDog) {
		pane.add(new Label("Breed:"), 0, 3);
		pane.add(new Label((((Dog)b).getBreed())), 1, 3);
		pane.add(new Label("Weight:"), 0, 4);
		pane.add(new Label(Double.toString(((Dog)b).getWeight()) + "lbs"), 1, 4);
		}
		//Cat specific information
		if (!b.isDog) {
		pane.add(new Label("Long-hair:"), 0, 3);
		//Parse the boolean
		if (((Cat)b).isLongHair()) {
			pane.add(new Label("Yes"), 1, 3);
		}
		else {
			pane.add(new Label("No"), 1, 3);
		}
		pane.add(new Label("Weight:"), 0, 4);
		pane.add(new Label(Double.toString(((Cat)b).getWeight()) + "lbs"), 1, 4);
		}

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		s.setScene(scene);
		s.setTitle("Pet");
		return s;
	}

	/**
	 * Method: getNewDog
	 * 
	 * Called by event handler for new button Launches a new stage to enter dog's info
	 * 
	 *
	 */
	public void getNewDog()
	{
		// code to launch book form stage

		new NewDogStage(items);
	}

	/**
	 * Method: getNewCat
	 * 
	 * Called by event handler for new button Launches a new stage to enter a new cat's info
	 * 
	 *
	 */
	public void getNewCat()
	{
		// code to launch book form stage

		new NewCatStage(items);
	}

	/*
	 * Called by event handler for close button
	 * 
	 * Writes observable list to original binary file
	 * 
	 *
	 */
	public void writeAndClose()
	{
		// code to write list

		myLibrary.writeListToFile(items);
		System.exit(0);
	}

	/**
	 * Main method and starting point of the program
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);

	}

}
