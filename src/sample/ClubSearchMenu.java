package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClubSearchMenu {

    static Font font = new Font(20);

    public static void maxSalary() {
        Stage window = new Stage();
        window.setTitle("Search Club");

        Label label = new Label("  Enter Club Name:   ");
        label.setFont(font);
        TextField clubText = new TextField();
        clubText.setMaxWidth(300);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-color: THISTLE");
        Button searchButton = new Button("Search");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        layout.getChildren().addAll(label, clubText, searchButton, backButton);
        Scene scene = new Scene(layout, 800, 600);

        window.setScene(scene);
        window.show();

        searchButton.setOnAction(e -> {
            try {
                search(clubText, scene, layout);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }

    public static void maxAge() {
        Stage window = new Stage();
        window.setTitle("Search Club");

        Label label = new Label("  Enter Club Name:   ");
        label.setFont(font);
        TextField clubText = new TextField();
        clubText.setMaxWidth(300);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-color: THISTLE");
        Button searchButton = new Button("Search");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        layout.getChildren().addAll(label, clubText, searchButton, backButton);
        Scene scene = new Scene(layout, 800, 600);

        window.setScene(scene);
        window.show();

        searchButton.setOnAction(e -> {
            try {
                search2(clubText, scene, layout);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


    }

    public static void maxHeight() {
        Stage window = new Stage();
        window.setTitle("Search Club");

        Label label = new Label("  Enter Club Name:   ");
        label.setFont(font);
        TextField clubText = new TextField();
        clubText.setMaxWidth(300);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-color: THISTLE");
        Button searchButton = new Button("Search");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        layout.getChildren().addAll(label, clubText, searchButton, backButton);
        Scene scene = new Scene(layout, 800, 600);

        window.setScene(scene);
        window.show();

        searchButton.setOnAction(e -> {
            try {
                search3(clubText, scene, layout);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


    }

    public static void totalSalary() {
        Stage window = new Stage();
        window.setTitle("Search Club");

        Label label = new Label("  Enter Club Name:   ");
        label.setFont(font);
        TextField clubText = new TextField();
        clubText.setMaxWidth(300);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-color: THISTLE");
        Button searchButton = new Button("Search");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        layout.getChildren().addAll(label, clubText, searchButton, backButton);
        Scene scene = new Scene(layout, 800, 600);

        window.setScene(scene);
        window.show();

        searchButton.setOnAction(e -> {
            try {
                totalSalaryCount(clubText, scene, layout);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


    }


    static void search(TextField clubText, Scene scene, VBox layout) throws Exception {
        //readFromFile
        List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();

        //SEARCH FOR MATCHED PLAYERS
        List<Player> matchedPlayer = getMatchedPlayer(playerList, clubText.getText()); // ei function matched player gular list retrun korbe


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

    private static List<Player> getMatchedPlayer(List<Player> playerList, String text) {
        List<Player> list = new ArrayList<>();

        List<Player> clubList = new ArrayList();
        for (int i = 0; i < playerList.size(); i++) {

            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(text)) {
                clubList.add(p);
            }

        }
        Player mx = clubList.get(0);
        for (Player p : clubList) {
            if (p.getSalary() > mx.salary) {
                mx = p;
            }
        }
        list.add(mx);
        return list;

    }


    static void search2(TextField clubText, Scene scene, VBox layout) throws Exception {
        //readFromFile
        List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();

        //SEARCH FOR MATCHED PLAYERS
        List<Player> matchedPlayer = getMatchedPlayer2(playerList, clubText.getText()); // ei function matched player gular list retrun korbe


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

    private static List<Player> getMatchedPlayer2(List<Player> playerList, String text) {
        List<Player> list = new ArrayList<>();

        List<Player> clubList = new ArrayList();
        for (int i = 0; i < playerList.size(); i++) {

            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(text)) {
                clubList.add(p);
            }

        }
        Player mx = clubList.get(0);
        for (Player p : clubList) {
            if (p.getAge() > mx.age) {
                mx = p;
            }
        }
        list.add(mx);
        return list;

    }


    static void search3(TextField clubText, Scene scene, VBox layout) throws Exception {
        //readFromFile
        List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();

        //SEARCH FOR MATCHED PLAYERS
        List<Player> matchedPlayer = getMatchedPlayer3(playerList, clubText.getText()); // ei function matched player gular list retrun korbe


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

    private static List<Player> getMatchedPlayer3(List<Player> playerList, String text) {
        List<Player> list = new ArrayList<>();

        List<Player> clubList = new ArrayList();
        for (int i = 0; i < playerList.size(); i++) {

            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(text)) {
                clubList.add(p);
            }

        }
        Player mx = clubList.get(0);
        for (Player p : clubList) {
            if (p.getHeight() > mx.height) {
                mx = p;
            }
        }
        list.add(mx);
        return list;

    }


    static void totalSalaryCount(TextField clubText, Scene scene, VBox layout) throws Exception {

        String text = clubText.getText();

        List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();

        double Total_Salary = 0.0;

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(text)) {
                Total_Salary = Total_Salary + p.getSalary();
            }
        }
        double F_Total_Salary = Total_Salary * 52.0;
        String TS = String.valueOf(F_Total_Salary);

        Label label = new Label("Total Yearly Salary of the Club : ");
        label.setFont(font);
        Label label1 = new Label(TS);
        label1.setFont(font);
        layout.getChildren().addAll(label, label1);

    }


}
