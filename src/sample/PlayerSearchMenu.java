package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PlayerSearchMenu {

    static Font font = new Font(20);


    public static void playerName() throws Exception {
        Stage window = new Stage();
        window.setTitle("Search Player");

        Label label = new Label("  Enter Player's Name:   ");
        label.setFont(font);
        TextField nameText = new TextField();
        nameText.setMaxWidth(250);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-color: ROSYBROWN");
        Button searchButton = new Button("Search");

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        layout.getChildren().addAll(label, nameText, searchButton, backButton);
        Scene scene = new Scene(layout, 800, 600);


        window.setScene(scene);
        window.show();

        searchButton.setOnAction(e -> {
            try {
                search(nameText, scene, layout);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }


    public static void clubCountry() {
        Stage window = new Stage();
        window.setTitle("Search Player");

        Label label = new Label("  Enter Player's Club & Country Name Respectively:   ");
        label.setFont(font);
        Label labelClub = new Label("Club : ");
        labelClub.setFont(font);
        TextField clubText = new TextField();
        clubText.setMaxWidth(250);
        Label labelCountry = new Label("Country : ");
        labelCountry.setFont(font);
        TextField countryText = new TextField();
        countryText.setMaxWidth(250);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-color: ROSYBROWN");
        Button searchButton = new Button("Search");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        layout.getChildren().addAll(label, labelClub, clubText, labelCountry, countryText, searchButton, backButton);
        Scene scene = new Scene(layout, 800, 600);

        window.setScene(scene);
        window.show();

        searchButton.setOnAction(e -> {
            try {
                search3(clubText, countryText, scene, layout);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }

    public static void position() {
        Stage window = new Stage();
        window.setTitle("Search Player");

        Label label = new Label("  Enter Player's Position:   ");
        label.setFont(font);
        TextField positionText = new TextField();
        positionText.setMaxWidth(250);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-color: ROSYBROWN");
        Button searchButton = new Button("Search");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        layout.getChildren().addAll(label, positionText, searchButton, backButton);
        Scene scene = new Scene(layout, 800, 600);

        window.setScene(scene);
        window.show();

        searchButton.setOnAction(e -> {
            try {
                search2(positionText, scene, layout);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }

    public static void salaryRange() {
        Stage window = new Stage();
        window.setTitle("Search Player");

        Label label = new Label("  Enter Player's Salary Range:   ");
        label.setFont(font);
        Label label1 = new Label("  From:   ");
        label1.setFont(font);
        TextField fromText = new TextField();
        fromText.setMaxWidth(250);
        Label label2 = new Label("  To:   ");
        label2.setFont(font);
        TextField toText = new TextField();
        toText.setMaxWidth(250);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-color: ROSYBROWN");
        Button searchButton = new Button("Search");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        layout.getChildren().addAll(label, label1, fromText, label2, toText, searchButton, backButton);
        Scene scene = new Scene(layout, 800, 600);

        window.setScene(scene);
        window.show();

        searchButton.setOnAction(e -> {
            try {
                search4(fromText, toText, scene, layout);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


    }

    public static void playerCount() {
        System.out.println("Player Count");
    }

    public static void playerCount2(VBox layout) throws Exception {

        // System.out.println("Country wise player count : ");
        layout.setStyle("-fx-background-color: ROSYBROWN");

        List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();
        Map<String, Integer> mp = new TreeMap(String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            mp.put(p.getCountry(), mp.getOrDefault(p.getCountry(), 0) + 1);
        }

        for (String name : mp.keySet()) {
            //System.out.println(name + " " + mp.get(name));
            //System.out.println(mp);
            String TC = String.valueOf(mp.get(name));
            Label label1 = new Label(name + " : " + TC);
            label1.setFont(font);
            //Label label2 = new Label(TC);
            //layout.getChildren().addAll(label1,label2);
            layout.getChildren().add(label1);

        }

    }


    static void search(TextField nameText, Scene scene, VBox layout) throws Exception {
        //readFromFile
        List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();

        //SEARCH FOR MATCHED PLAYERS
        List<Player> matchedPlayer = getMatchedPlayer(playerList, nameText.getText()); // ei function matched player gular list retrun korbe


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

        int searchIndex = -1;

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
    }


    static void search2(TextField positionText, Scene scene, VBox layout) throws Exception {
        //readFromFile
        List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();

        //SEARCH FOR MATCHED PLAYERS
        List<Player> matchedPlayer = getMatchedPlayer2(playerList, positionText.getText()); // ei function matched player gular list retrun korbe


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

        int searchIndex = -1;

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getPosition().equalsIgnoreCase(text)) {
                searchIndex = i;
                String msg = p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getJerseyNumber() + "," + p.getSalary();
                //break;
                list.add(p);
            }
        }
        return list;
    }


    static void search3(TextField clubText, TextField countryText, Scene scene, VBox layout) throws Exception {
        //readFromFile
        List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();

        //SEARCH FOR MATCHED PLAYERS
        List<Player> matchedPlayer = getMatchedPlayer3(playerList, clubText.getText(), countryText.getText()); // ei function matched player gular list retrun korbe


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

    private static List<Player> getMatchedPlayer3(List<Player> playerList, String club, String country) {
        List<Player> list = new ArrayList<>();

        int searchIndex = -1;

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(club) && p.getCountry().equalsIgnoreCase(country)) {
                searchIndex = i;
                String msg = p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getJerseyNumber() + "," + p.getSalary();
                //break;
                list.add(p);
            }
        }
        return list;
    }


    static void search4(TextField fromText, TextField toText, Scene scene, VBox layout) throws Exception {
        //readFromFile
        List<Player> playerList = new ArrayList();
        playerList = FileWork.readFromFile();

        //SEARCH FOR MATCHED PLAYERS
        List<Player> matchedPlayer = getMatchedPlayer4(playerList, fromText.getText(), toText.getText()); // ei function matched player gular list retrun korbe


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

    private static List<Player> getMatchedPlayer4(List<Player> playerList, String from, String to) {
        List<Player> list = new ArrayList<>();
        double fromN = Double.parseDouble(from);
        double toN = Double.parseDouble(to);

        int searchIndex = -1;

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getSalary() >= fromN && p.getSalary() <= toN) {
                searchIndex = i;
                String msg = p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getJerseyNumber() + "," + p.getSalary();
                //break;
                list.add(p);
            }
        }
        return list;
    }


}
