package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {

    Stage window;
    Scene loginScene, scene, scene1, scene2, scene3, scene4, sceneCount;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Football Management Software");

        Font font = new Font(20);
        Font font1 = new Font(25);

        // country wise player count scene
        Label labelCount = new Label("Country-wise Player Count : ");
        labelCount.setFont(font1);
        Button backCount = new Button("Back");
        backCount.setFont(font);
        backCount.setOnAction(e -> window.setScene(scene1));
        VBox layoutCount = new VBox(5);
        layoutCount.setPadding(new Insets(10, 10, 10, 10));
        layoutCount.getChildren().addAll(labelCount, backCount);
        sceneCount = new Scene(layoutCount, 800, 700);


        // Login Menu

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label nameLabel = new Label("Username : ");
        nameLabel.setFont(font1);
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField nameText = new TextField("Bucky");
        GridPane.setConstraints(nameText, 1, 0);

        Label passLabel = new Label("Password : ");
        passLabel.setFont(font1);
        GridPane.setConstraints(passLabel, 0, 1);

        PasswordField passText = new PasswordField();
        passText.setPromptText("password");
        GridPane.setConstraints(passText, 1, 1);

        Button loginButton = new Button("Login");
        loginButton.setFont(font);
        loginButton.setStyle("-fx-background-color : LAVENDER");
        GridPane.setConstraints(loginButton, 1, 4);
        //loginButton.setOnAction(e -> window.setScene(scene));


        Button resetButton = new Button("Reset");
        resetButton.setFont(font);
        resetButton.setStyle("-fx-background-color : LIGHTCYAN");
        GridPane.setConstraints(resetButton, 2, 4);
        resetButton.setOnAction(e -> {
            window.setScene(loginScene);
            nameText.setText(null);
            passText.setText(null);
        });


        grid.getChildren().addAll(nameLabel, nameText, passLabel, passText, loginButton, resetButton);
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: PALEVIOLETRED");

        loginScene = new Scene(grid, 800, 400);

        //loginScene.setFill(Color.BROWN);
        //scene.setFill(Color.web("#81c483"));


        // Main Menu
        Label label = new Label("Main Menu");
        label.setFont(font1);
        Button button11 = new Button("Search Players");
        button11.setFont(font);
        //button11.setStyle("-fx-background-color : GAINSBORO");
        button11.setMinWidth(200);
        button11.setOnAction(e -> window.setScene(scene1));

        Button button12 = new Button("Search Clubs");
        button12.setFont(font);
        button12.setMinWidth(200);
        button12.setOnAction(e -> window.setScene(scene2));

        Button button13 = new Button("Add Players");
        button13.setFont(font);
        button13.setMinWidth(200);
        button13.setOnAction(e -> window.setScene(scene3));

        Button button14 = new Button("Exit");
        button14.setFont(font);
        button14.setMinWidth(200);
        button14.setOnAction(e -> window.close());

        Button button15 = new Button("Logout");
        button15.setFont(font);
        button15.setMinWidth(200);
        button15.setOnAction(e -> {
            window.setScene(loginScene);
            nameText.setText(null);
            passText.setText(null);
        });

        VBox layout = new VBox(5);
        layout.getChildren().addAll(label, button11, button12, button13, button14, button15);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: BURLYWOOD");
        scene = new Scene(layout, 800, 400);


        // Player Search Menu
        Label label2A = new Label("Player Search Menu");
        label2A.setFont(font1);
        Button button2A1 = new Button("By Player Name");
        button2A1.setFont(font);
        button2A1.setMinWidth(270);
        button2A1.setOnAction(e -> {
            try {
                PlayerSearchMenu.playerName();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button button2A2 = new Button("By Club & Country");
        button2A2.setFont(font);
        button2A2.setMinWidth(270);
        button2A2.setOnAction(e -> PlayerSearchMenu.clubCountry());

        Button button2A3 = new Button("By Position");
        button2A3.setFont(font);
        button2A3.setMinWidth(270);
        button2A3.setOnAction(e -> PlayerSearchMenu.position());

        Button button2A4 = new Button("By Salary Range");
        button2A4.setFont(font);
        button2A4.setMinWidth(270);
        button2A4.setOnAction(e -> PlayerSearchMenu.salaryRange());

        Button button2A5 = new Button("Country-wise player count");
        button2A5.setFont(font);
        button2A5.setMinWidth(270);
        button2A5.setOnAction(e -> {
            try {
                window.setScene(sceneCount);
                PlayerSearchMenu.playerCount2(layoutCount);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button button2A6 = new Button("Back to Main Menu");
        button2A6.setFont(font);
        button2A6.setMinWidth(270);
        button2A6.setOnAction(e -> window.setScene(scene));

        VBox layout2A = new VBox(5);
        layout2A.getChildren().addAll(label2A, button2A1, button2A2, button2A3, button2A4, button2A5, button2A6);
        layout2A.setAlignment(Pos.CENTER);
        layout2A.setStyle("-fx-background-color: DARKCYAN");
        scene1 = new Scene(layout2A, 800, 500);


        // Club Search Menu
        Label label2B = new Label("Club Search Menu");
        label2B.setFont(font1);
        Button button2B1 = new Button("Player(s) with the maximum salary of a club");
        button2B1.setFont(font);
        button2B1.setMinWidth(420);
        button2B1.setOnAction(e -> ClubSearchMenu.maxSalary());


        Button button2B2 = new Button("Player(s) with the maximum age of a club");
        button2B2.setFont(font);
        button2B2.setMinWidth(420);
        button2B2.setOnAction(e -> ClubSearchMenu.maxAge());

        Button button2B3 = new Button("Player(s) with the maximum height of a club");
        button2B3.setFont(font);
        button2B3.setMinWidth(420);
        button2B3.setOnAction(e -> ClubSearchMenu.maxHeight());

        Button button2B4 = new Button("Total yearly salary of a club");
        button2B4.setFont(font);
        button2B4.setMinWidth(420);
        button2B4.setOnAction(e -> ClubSearchMenu.totalSalary());

        Button button2B5 = new Button("Back to Main Menu");
        button2B5.setFont(font);
        button2B5.setMinWidth(420);
        button2B5.setOnAction(e -> window.setScene(scene));

        VBox layout2B = new VBox(5);
        layout2B.getChildren().addAll(label2B, button2B1, button2B2, button2B3, button2B4, button2B5);
        layout2B.setAlignment(Pos.CENTER);
        layout2B.setStyle("-fx-background-color: SALMON");
        scene2 = new Scene(layout2B, 800, 500);


        // Player Add Menu
        Label label2C = new Label("Player Add Menu");
        label2C.setFont(font1);
        Button button2C1 = new Button("Click to Add a Player");
        button2C1.setFont(font);
        button2C1.setMinWidth(220);
        button2C1.setOnAction(e -> PlayerAddMenu.PlayerAdd());


        Button button2C2 = new Button("Back to Main Menu");
        button2C2.setFont(font);
        button2C2.setMinWidth(220);
        button2C2.setOnAction(e -> window.setScene(scene));

        VBox layout2C = new VBox(5);
        layout2C.getChildren().addAll(label2C, button2C1, button2C2);
        layout2C.setAlignment(Pos.CENTER);
        layout2C.setStyle("-fx-background-color: DARKGRAY");
        scene3 = new Scene(layout2C, 800, 500);


        window.setScene(loginScene);
        window.show();


        loginButton.setOnAction(e -> {
            if (nameText.getText().equals("Sizan") && passText.getText().equals("1234")) {
                window.setScene(scene);
            } else {
                window.setScene(loginScene);
                nameText.setText(null);
                passText.setText(null);
            }
        });

    }

}