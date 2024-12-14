package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PlayerAddMenu {

    static Font font = new Font(20);


    public static void PlayerAdd() {
        Stage window2 = new Stage();
        window2.setTitle("Add Player");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label headLabel = new Label("Enter Player Details: ");
        headLabel.setFont(font);
        GridPane.setConstraints(headLabel, 0, 0);

        Label nameLabel = new Label("Name: ");
        nameLabel.setFont(font);
        GridPane.setConstraints(nameLabel, 0, 1);

        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput, 1, 1);

        Label countryLabel = new Label("Country: ");
        countryLabel.setFont(font);
        GridPane.setConstraints(countryLabel, 0, 2);

        TextField countryInput = new TextField();
        countryInput.setPromptText("country");
        GridPane.setConstraints(countryInput, 1, 2);

        Label ageLabel = new Label("Age: ");
        ageLabel.setFont(font);
        GridPane.setConstraints(ageLabel, 0, 3);

        TextField ageInput = new TextField();
        ageInput.setPromptText("age");
        GridPane.setConstraints(ageInput, 1, 3);

        Label heightLabel = new Label("Height: ");
        heightLabel.setFont(font);
        GridPane.setConstraints(heightLabel, 0, 4);

        TextField heightInput = new TextField();
        heightInput.setPromptText("height");
        GridPane.setConstraints(heightInput, 1, 4);

        Label clubLabel = new Label("Club: ");
        clubLabel.setFont(font);
        GridPane.setConstraints(clubLabel, 0, 5);

        TextField clubInput = new TextField();
        clubInput.setPromptText("club");
        GridPane.setConstraints(clubInput, 1, 5);

        Label positionLabel = new Label("Position: ");
        positionLabel.setFont(font);
        GridPane.setConstraints(positionLabel, 0, 6);

        TextField positionInput = new TextField();
        positionInput.setPromptText("position");
        GridPane.setConstraints(positionInput, 1, 6);

        Label numberLabel = new Label("Jersey Number: ");
        numberLabel.setFont(font);
        GridPane.setConstraints(numberLabel, 0, 7);

        TextField numberInput = new TextField();
        numberInput.setPromptText("number");
        GridPane.setConstraints(numberInput, 1, 7);

        Label salaryLabel = new Label("Weekly Salary: ");
        salaryLabel.setFont(font);
        GridPane.setConstraints(salaryLabel, 0, 8);

        TextField salaryInput = new TextField();
        salaryInput.setPromptText("salary");
        GridPane.setConstraints(salaryInput, 1, 8);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 12);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window2.close());
        GridPane.setConstraints(backButton, 1, 14);

        grid.setStyle("-fx-background-color: DARKTURQUOISE");
        grid.getChildren().addAll(headLabel, nameLabel, nameInput, countryLabel, countryInput, ageLabel, ageInput, heightLabel, heightInput, clubLabel, clubInput, positionLabel, positionInput, numberLabel, numberInput, salaryLabel, salaryInput, submitButton, backButton);


        Scene sceneX = new Scene(grid, 800, 600);

        Label labelN = new Label("New Added Player");
        labelN.setFont(font);
        Button btn = new Button("Back");
        btn.setOnAction(e -> window2.setScene(sceneX));
        VBox layoutN = new VBox(10);
        layoutN.setPadding(new Insets(10, 10, 10, 10));
        layoutN.setStyle("-fx-background-color: DARKSEAGREEN");
        Scene sceneN = new Scene(layoutN, 900, 600);
        layoutN.getChildren().addAll(labelN, btn);


        submitButton.setOnAction(e -> {
            try {
                window2.setScene(sceneN);
                search(nameInput, countryInput, ageInput, heightInput, clubInput, positionInput, numberInput, salaryInput, sceneN, layoutN);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        window2.setScene(sceneX);
        window2.show();


    }


    static void search(TextField nameI, TextField countryI, TextField ageI, TextField heightI, TextField clubI, TextField positionI, TextField numberI, TextField salaryI, Scene scene, VBox layout) throws Exception {
        //readFromFile
        List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();

        //SEARCH FOR MATCHED PLAYERS
        List<Player> matchedPlayer = getMatchedPlayer(playerList, nameI.getText(), countryI.getText(), ageI.getText(), heightI.getText(), clubI.getText(), positionI.getText(), numberI.getText(), salaryI.getText()); // ei function matched player gular list retrun korbe


        TableView table = new TableView();

        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);


        TableColumn countryColumn = new TableColumn("Country");
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        table.getColumns().add(countryColumn);


        TableColumn ageColumn = new TableColumn("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        table.getColumns().add(ageColumn);


        TableColumn heightColumn = new TableColumn("Height");
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        table.getColumns().add(heightColumn);


        TableColumn clubColumn = new TableColumn("Club");
        clubColumn.setCellValueFactory(new PropertyValueFactory<>("club"));
        table.getColumns().add(clubColumn);


        TableColumn positionColumn = new TableColumn("Position");
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        table.getColumns().add(positionColumn);


        TableColumn numberColumn = new TableColumn("Number");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("jerseyNumber"));
        table.getColumns().add(numberColumn);


        TableColumn salaryColumn = new TableColumn("Salary");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        table.getColumns().add(salaryColumn);


        ObservableList<Player> data = FXCollections.observableArrayList(matchedPlayer);
        table.setItems(data);


        BorderPane bp = new BorderPane();
        bp.setCenter(table);

        layout.getChildren().add(table);
    }

    private static List<Player> getMatchedPlayer(List<Player> playerList, String nameI, String countryI, String ageI, String heightI, String clubI, String positionI, String numberI, String salaryI) throws Exception {
        List<Player> list = new ArrayList<>();

       /* int searchIndex = -1;

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getName().equalsIgnoreCase(text)) {
                searchIndex = i;
                String msg = p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getJerseyNumber() + "," + p.getSalary();
                //break;
                list.add(p);
            }
        }
        return list;

        */

        Player p = new Player();

        p.name = nameI;
        p.country = countryI;
        p.age = Integer.parseInt(ageI);
        p.height = Double.parseDouble(heightI);
        p.club = clubI;
        p.position = positionI;
        p.jerseyNumber = Integer.parseInt(numberI);
        p.salary = Double.parseDouble(salaryI);

        list.add(p);

        //List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();

        for (Player p1 : playerList) {
            list.add(p1);
        }

        return list;

    }

}
