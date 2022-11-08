import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * CoffeeDriver - The driver for calculating an order's price at Joe's Coffee House
 * @author - 
 */
public class CoffeeDriver extends Application {
    //Global Variables
    //The ones that define any form of user input on the GUI are key for making the calculate event handler work. Everything else is for convienence.
    //For the coffee type
    RadioButton regularCoffee = new RadioButton("Regular");
    RadioButton decafCoffee = new RadioButton("Decaf");
    //For the add-ins
    CheckBox cream = new CheckBox("Cream");
    CheckBox sugar = new CheckBox("Sugar");
    CheckBox artSweetner = new CheckBox("Artifical Sweetner");
    CheckBox cinnamon = new CheckBox("Cinnamon");
    CheckBox caramel = new CheckBox("Caramel");
    //Important muffin fields
    TextField muffinField = new TextField("0");
    
    //Pre-defining the border for use within all of our panes.
    Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

    /**
     * starts the GUI on execution
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        //Define the root, or parent pane that holds all other panes
        //Sets the padding for the root pane, and defines margins for all child panes
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        Insets dividers = new Insets(5);

        //Adding the individual panes, such as the title, the coffee selection, add-ins, etc...
        //Using nodes to properly position things the way I want them within the root borderpane.
        //Title pane
        Node titleNode = new Text("Welcome to Joe's Coffee House");
        root.setTop(titleNode);
        BorderPane.setMargin(titleNode, dividers);
        BorderPane.setAlignment(titleNode, Pos.CENTER);
        //Menu button pane
        Node menuNode = menuButtons();
        root.setBottom(menuNode);
        BorderPane.setMargin(menuNode, dividers);
        BorderPane.setAlignment(menuNode, Pos.CENTER);
        //Coffee selection pane
        Node coffeeNode = getCoffee();
        root.setLeft(coffeeNode);
        BorderPane.setMargin(coffeeNode, dividers);
        BorderPane.setAlignment(coffeeNode, Pos.CENTER);
        //Additive selection pane
        Node additivesNode = getAdditives();
        root.setCenter(additivesNode);
        BorderPane.setMargin(additivesNode, dividers);
        BorderPane.setAlignment(additivesNode, Pos.CENTER);
        //Muffin selection pane
        Node muffinsNode = getMuffins();
        root.setRight(muffinsNode);
        BorderPane.setMargin(additivesNode, dividers);
        BorderPane.setAlignment(additivesNode, Pos.CENTER);

        //Set the primary scene
        Scene scene = new Scene(root, 650, 500);
        primaryStage.setTitle("Order Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * getCoffee lets users pick between regular or decaf coffee
     * @return
     */
    private GridPane getCoffee() {
        //Define the pane attributes such as gaps and size
        GridPane coffeePane = new GridPane();
        coffeePane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        coffeePane.setHgap(5.5);
        coffeePane.setVgap(5.5);
        coffeePane.setBorder(border);

        //Reference our pre-defined global variables as these will determine the price and return the pane.
        coffeePane.add(regularCoffee, 0, 0);
        coffeePane.add(decafCoffee, 0, 2);
        return coffeePane;
    }

    /**
     * getAdditives lets you select multiple additives for your coffee.
     * @return
     */
    private GridPane getAdditives() {
        //Define the pane attributes such as gaps and size
        GridPane toppingPane = new GridPane();
        toppingPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        toppingPane.setHgap(5.5);
        toppingPane.setVgap(5.5);
        toppingPane.setBorder(border);

        //Referencing our pre-defined global variables as these will determine the price and return the pane.
        toppingPane.add(cream, 0, 0);
        toppingPane.add(sugar, 0, 1);
        toppingPane.add(artSweetner, 0, 2);
        toppingPane.add(cinnamon, 0, 3);
        toppingPane.add(caramel, 0, 4);
        return toppingPane;

    }

    /**
     * getMuffins lets you choose if you want a muffin, and what type of muffin
     * @return
     */
    private GridPane getMuffins() {
        //Define the pane attributes such as gaps and size
        GridPane muffinPane = new GridPane();
        muffinPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        muffinPane.setHgap(5.5);
        muffinPane.setVgap(5.5);
        muffinPane.setBorder(border);

        //Define the pieces of the pane
        Label muffins = new Label("Add muffins?"); //This holds no important information, so its not a global
        muffinPane.add(muffins, 0, 0);

        //Referencing the global variable here as the only thing that matters is the number of muffins. Type doesn't impact price.
        muffinPane.add(muffinField, 0, 1);

        //Fluff for the muffin pane, unfinished. Nothing here impacts the price.
        EventHandler<KeyEvent> muffinFieldHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {

                //I'm not sure this is the best way to do this or if its even worth the effort for this to go from the 90 to 100.
                //For perfection sake we would probably need to make these globals and add eventhandler functionality so as each one cannot exceed the total number of muffins ordered.
                Label typeLabel = new Label("How many of each type?");
                TextField typeField = new TextField();
                Label blueBerryLabel = new Label("Blueberry");
                TextField blueBerryField = new TextField();
                Label chocolateChipLabel = new Label("Chocolate Chip");
                TextField chocolateField = new TextField();
                Label bananaNutLabel = new Label("Banana Nut");
                TextField bananaField = new TextField();
                Label branLabel = new Label("Bran");
                TextField branField = new TextField();

                muffinPane.add(typeLabel, 0, 2);
                muffinPane.add(typeField, 0, 3);
                muffinPane.add(blueBerryLabel, 0, 4);
                muffinPane.add(blueBerryField, 0, 5);
                muffinPane.add(chocolateChipLabel, 0, 6);
                muffinPane.add(chocolateField, 0, 7);
                muffinPane.add(bananaNutLabel, 0, 8);
                muffinPane.add(bananaField, 0, 9);
                muffinPane.add(branLabel, 0, 10);
                muffinPane.add(branField, 0, 11);
            }
        };
        muffinField.addEventHandler(KeyEvent.KEY_TYPED, muffinFieldHandler);

        //Return the pane
        return muffinPane;
    }

        /**
     * menuButtons adds the calculate and exit buttons to the main interface.
     * @return
     */
    private GridPane menuButtons() {
        //Define the pane attributes such as gaps and size
        GridPane menuPane = new GridPane();
        menuPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        menuPane.setHgap(5.5);
        menuPane.setVgap(5.5);

        //Define the pieces of the pane
        Button calculate = new Button("Calculate");
        Button exit = new Button("Exit");

        //Add the calculate button and the appropriate functionality
        menuPane.add(calculate, 0, 0);
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                //Set the price of each ingredient
                double coffee = 3.00;
                double addIn = 0.25;
                double muffin = 2.25;
                double price = 0.00;

                //Coffee pane checker
                //If either one is selected, the price is increased by the value of the coffee variable.
                if(regularCoffee.isSelected() || decafCoffee.isSelected()) {
                    price = price + coffee;
                }
                //Add-in pane checker
                //For each one selected, the price is increased by the value of the addin variable.
                if(cream.isSelected()) {
                    price = price + addIn;
                }
                if(sugar.isSelected()) {
                    price = price + addIn;
                }
                if(artSweetner.isSelected()) {
                    price = price + addIn;
                }
                if(cinnamon.isSelected()) {
                    price = price + addIn;
                }
                if(caramel.isSelected()) {
                    price = price + addIn;
                }
                //Muffin checker
                //This parses the string entered into a double, the price is then increased by the muffin variable * the muffin price variable.
                if(!muffinField.getText().equals("0")) {
                    double muffinNum = Double.parseDouble(muffinField.getText());
                    price = price + (muffin*muffinNum);
                }

                double tax = price * 0.07; //Sales Tax
                double total = price + tax; // Total

                //Define the popup window that actually shows our information
                Stage stage = new Stage();
                stage.setTitle("Order Total");
                GridPane calculatePane = new GridPane();
                calculatePane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
                calculatePane.setHgap(5.5);
                calculatePane.setVgap(5.5);

                //Information to go on said popup window
                Label subtotal = new Label("Subtotal: $" + price);
                Label taxLabel = new Label("Tax: $" + tax);
                Label totalLabel = new Label("Total: $" + total);

                //Adds this information to the GUI
                calculatePane.add(subtotal, 0, 0);
                calculatePane.add(taxLabel, 0, 1);
                calculatePane.add(totalLabel, 0, 2);

                //Defines the scene that will popup.
                Scene scene = new Scene(calculatePane, 350, 250);
                stage.setScene(scene);        
                stage.show(); // Display the stage
            }
        });

        //Add the exit button and functionality.
        menuPane.add(exit, 1, 0);
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                Platform.exit(); //Terminates the program on click.
            }
        });

        return menuPane;
    }

    /**
     * Our main method simply launches the application as per the start method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
