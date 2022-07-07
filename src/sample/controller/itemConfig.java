package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static sample.controller.userdata.userphone;

public class itemConfig implements Initializable {

    @FXML
    private TableView<itemTable2> itemTable2;

    @FXML
    private TableColumn<itemTable2, Double> Tbig2;

    @FXML
    private TableColumn<itemTable2, String> Tbigname2;

    @FXML
    private TableColumn<itemTable2, Double> Tmedium2;

    @FXML
    private TableColumn<itemTable2, String> TmediumName2;

    @FXML
    private TableColumn<itemTable2, Double> Tsmall2;

    @FXML
    private TableColumn<itemTable2, String> TsmallName2;

    @FXML
    private TableColumn<itemTable2, String> Tname2;

    @FXML
    private TableColumn<itemTable2, String> Ttype2;

    @FXML
    private TableColumn<itemTable2, String> Tdescription2;

    @FXML
    private TextField insType2;

    @FXML
    private TextField insName2;

    @FXML
    private TextField insMediumName2;

    @FXML
    private TextField insMedium2;

    @FXML
    private TextField insBigName2;

    @FXML
    private TextField insBig2;

    @FXML
    private TextField insSmallName2;

    @FXML
    private TextField insSmall2;

    @FXML
    private TextField insDes2;

    @FXML
    private TableView<itemTable1> itemTabel1;

    @FXML
    private TableColumn<itemTable1, String> Tname1;

    @FXML
    private TableColumn<itemTable1, String> Ttype1;

    @FXML
    private TableColumn<itemTable1, Double> Tsmall1;

    @FXML
    private TableColumn<itemTable1, Double> Tmedium1;

    @FXML
    private TableColumn<itemTable1, Double> Tbig1;

    @FXML
    private TableColumn<itemTable1, String> Tdescription1;


    ObservableList<itemTable1> oblist1 = FXCollections.observableArrayList();
    ObservableList<itemTable2> oblist2 = FXCollections.observableArrayList();

    @FXML
    private TextField insType1;

    @FXML
    private TextField insName1;


    @FXML
    private TextField insSmall1;

    @FXML
    private TextField insMedium1;

    @FXML
    private TextField insBig1;

    @FXML
    private TextField insDes1;

    private Main main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUsersTable();

    }
    public void menuPage(javafx.event.ActionEvent actionEvent){

        try {
            Parent userview = FXMLLoader.load(menuPage.class.getResource("../fxml/selling.fxml"));
            Scene userscene = new Scene(userview);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(userscene);
            window.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    public void update1(javafx.event.ActionEvent actionEvent){
        try {
            String type =insType1.getText();
            String name =insName1.getText();
            String description =insDes1.getText();
            Double big = Double.valueOf(insBig1.getText());
            Double medium = Double.valueOf(insMedium1.getText());
            Double small = Double.valueOf(insSmall1.getText());
            if (type.isEmpty() || name.isEmpty() || big.isNaN() || medium.isNaN()) {
                String selection = "من فضلك ادخل كل الخانات صحيحة اولاً ";
                Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
                alert.showAndWait();
            }
            else {
                // coping data to another Field
                String sendOrderDetails = "UPDATE kunafahut.types SET type = '"+type+"',name = '"+name+"', description = '"+description+"',big = "+big+", medium = "+medium+", small = "+small+" WHERE type ='"+type+"' AND name='"+name+"';";
                try {
                    selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeUpdate(sendOrderDetails);
                } catch (SQLException e) {
                    e.printStackTrace();
                    e.getCause();
                }
                itemTabel1.getItems().clear();
                itemTable2.getItems().clear();
                setUsersTable();
            }
        }catch (Exception e){
            String selection = "من فضلك ادخل كل الخانات صحيحة اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
    }
    public void update2(javafx.event.ActionEvent actionEvent){
        try {
            String type =insType2.getText();
            String name =insName2.getText();
            String description =insDes2.getText();
            String bigName =insBigName2.getText();
            String mediumName =insMediumName2.getText();
            String smallName =insSmallName2.getText();
            Double big = Double.valueOf(insBig2.getText());
            Double medium = Double.valueOf(insMedium2.getText());
            Double small = Double.valueOf(insSmall2.getText());
            if (type.isEmpty() || name.isEmpty() || big.isNaN() || medium.isNaN() || small.isNaN()) {
                String selection = "من فضلك ادخل كل الخانات صحيحة اولاً ";
                Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
                alert.showAndWait();
            }
            else {
                // coping data to another Field
                String sendOrderDetails = "UPDATE kunafahut.added SET type = '"+type+"',name = '"+name+"',description = '"+description+"', smallName = '"+smallName+"',smallPrice = "+small+",mediumName = '"+mediumName+"',bigName = '"+bigName+"',bigPrice = "+big+", mediumPrice = "+medium+" WHERE type ='"+type+"' AND name='"+name+"';";
                try {
                    selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeUpdate(sendOrderDetails);
                } catch (SQLException e) {
                    String selection = "من فضلك ادخل النوع والاسم مطابقاً اولاً ";
                    Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
                    alert.showAndWait();
                }
                itemTabel1.getItems().clear();
                itemTable2.getItems().clear();
                setUsersTable();
            }
        }catch (Exception e){
            String selection = "من فضلك ادخل كل الخانات صحيحة اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void delte2(javafx.event.ActionEvent actionEvent){
        try {
            String type =insType2.getText();
            String name =insName2.getText();
            if (type.isEmpty() || name.isEmpty()) {
                String selection = "من فضلك ادخل النوع والاسم المراد حذفة ";
                Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
                alert.showAndWait();
            }
            else {
                // coping data to another Field
                String sendOrderDetails = "DELETE FROM kunafahut.added WHERE type ='"+type+"' AND name='"+name+"';";
                try {
                    selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeUpdate(sendOrderDetails);
                } catch (SQLException e) {
                    e.printStackTrace();
                    e.getCause();
                }
                itemTabel1.getItems().clear();
                itemTable2.getItems().clear();
                setUsersTable();
            }
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع والاسم المراد حذفة ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void add2(javafx.event.ActionEvent actionEvent){
        try {
            String type =insType2.getText();
            String name =insName2.getText();
            String description =insDes2.getText();
            String bigName =insBigName2.getText();
            String mediumName =insMediumName2.getText();
            String smallName =insSmallName2.getText();
            Double big = Double.valueOf(insBig2.getText());
            Double medium = Double.valueOf(insMedium2.getText());
            Double small = Double.valueOf(insSmall2.getText());
            if (type.isEmpty() || name.isEmpty() || big.isNaN() || medium.isNaN() || small.isNaN() ) {
                String selection = "من فضلك ادخل كل الخانات صحيحة اولاً ";
                Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
                alert.showAndWait();
            }
            else {
                // coping data to another Field
                String sendOrderDetails = "INSERT INTO added (type, name, description, smallName, smallPrice, mediumName, mediumPrice, bigName, bigPrice) values ('"+type+"','"+name+"','"+description+"','"+smallName+"',"+small+" '"+mediumName+"',"+medium+",'"+bigName+"',"+big+");";
                try {
                    selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeUpdate(sendOrderDetails);
                } catch (SQLException e) {
                    String selection = "من فضلك لا تدخل قيم مكررة ً ";
                    Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
                    alert.showAndWait();
                }
                itemTabel1.getItems().clear();
                itemTable2.getItems().clear();
                setUsersTable();
            }
        }catch (Exception e){
            String selection = "من فضلك ادخل كل الخانات صحيحة اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
    }


    public void fetchItem1(MouseEvent actionEvent){
        int tableRowId = -1;
        String type = "";
        String name = "";
        tableRowId = itemTabel1.getSelectionModel().getSelectedIndex();
        if (!(tableRowId <= -1)) {
            type = itemTabel1.getSelectionModel().getSelectedItem().type;
            name = itemTabel1.getSelectionModel().getSelectedItem().name;
            ResultSet dbResAllTotal;
            try {
                String sqlscript = "SELECT * from kunafahut.types where type='"+type+"' And name='"+name+"';";

                dbResAllTotal = (ResultSet) selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeQuery(sqlscript);

                while (dbResAllTotal.next()) {
                    insType1.setText(dbResAllTotal.getString("type"));
                    insName1.setText(dbResAllTotal.getString("name"));
                    insDes1.setText(dbResAllTotal.getString("description"));
                    insBig1.setText(String.valueOf(dbResAllTotal.getDouble("big")));
                    insMedium1.setText(String.valueOf(dbResAllTotal.getDouble("medium")));
                    insSmall1.setText(String.valueOf(dbResAllTotal.getDouble("small")));
                }

            }catch (Exception e){
                e.getCause();
            }
        }
    }
    public void fetchItem2(MouseEvent actionEvent){
        int tableRowId = -1;
        String type = "";
        String name = "";
        tableRowId = itemTable2.getSelectionModel().getSelectedIndex();
        if (!(tableRowId <= -1)) {
            type = itemTable2.getSelectionModel().getSelectedItem().type;
            name = itemTable2.getSelectionModel().getSelectedItem().name;
            ResultSet dbResAllTotal;
            try {
                String sqlscript = "SELECT * from kunafahut.added where type='"+type+"' And name='"+name+"';";

                dbResAllTotal = (ResultSet) selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeQuery(sqlscript);

                while (dbResAllTotal.next()) {
                    insType2.setText(dbResAllTotal.getString("type"));
                    insName2.setText(dbResAllTotal.getString("name"));
                    insDes2.setText(dbResAllTotal.getString("description"));
                    insSmallName2.setText(dbResAllTotal.getString("smallName"));
                    insMediumName2.setText(dbResAllTotal.getString("mediumName"));
                    insBigName2.setText(dbResAllTotal.getString("bigName"));
                    insBig2.setText(String.valueOf(dbResAllTotal.getDouble("bigPrice")));
                    insMedium2.setText(String.valueOf(dbResAllTotal.getDouble("mediumPrice")));
                    insSmall2.setText(String.valueOf(dbResAllTotal.getDouble("smallPrice")));
                }

            }catch (Exception e){
                e.getCause();
            }
        }
    }
    public void setUsersTable(){
        ResultSet dbResAllTotal;
        ResultSet dbResAllTotal2;
        try {
            String sqlscript = "SELECT * from kunafahut.types";
            String sqlscript2 = "SELECT * from kunafahut.added";
            dbResAllTotal = (ResultSet) selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeQuery(sqlscript);
            dbResAllTotal2 = (ResultSet) selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeQuery(sqlscript2);

            while (dbResAllTotal.next()) {
                oblist1.add(new itemTable1(dbResAllTotal.getString("type"),dbResAllTotal.getString("name"),dbResAllTotal.getDouble("small"),dbResAllTotal.getDouble("medium"), dbResAllTotal.getDouble("big"),dbResAllTotal.getString("description")));
            }
            while (dbResAllTotal2.next()) {
                oblist2.add(new itemTable2(dbResAllTotal2.getString("type"),dbResAllTotal2.getString("name"),dbResAllTotal2.getString("smallName"),dbResAllTotal2.getDouble("smallPrice"), dbResAllTotal2.getString("mediumName"), dbResAllTotal2.getDouble("mediumPrice"), dbResAllTotal2.getString("bigName"),dbResAllTotal2.getDouble("bigPrice"),dbResAllTotal.getString("description")));
            }

        }catch (Exception e){
            e.getCause();
        }
        Ttype1.setCellValueFactory(new PropertyValueFactory<>("type"));
        Tname1.setCellValueFactory(new PropertyValueFactory<>("name"));
        Tsmall1.setCellValueFactory(new PropertyValueFactory<>("small"));
        Tmedium1.setCellValueFactory(new PropertyValueFactory<>("medium"));
        Tbig1.setCellValueFactory(new PropertyValueFactory<>("big"));
        Tdescription1.setCellValueFactory(new PropertyValueFactory<>("description"));
        itemTabel1.setItems(oblist1);

        Ttype2.setCellValueFactory(new PropertyValueFactory<>("type"));
        Tname2.setCellValueFactory(new PropertyValueFactory<>("name"));
        TsmallName2.setCellValueFactory(new PropertyValueFactory<>("smallName"));
        Tsmall2.setCellValueFactory(new PropertyValueFactory<>("smallPrice"));
        TmediumName2.setCellValueFactory(new PropertyValueFactory<>("mediumName"));
        Tmedium2.setCellValueFactory(new PropertyValueFactory<>("mediumPrice"));
        Tbigname2.setCellValueFactory(new PropertyValueFactory<>("bigName"));
        Tbig2.setCellValueFactory(new PropertyValueFactory<>("bigPrice"));
        Tdescription2.setCellValueFactory(new PropertyValueFactory<>("description"));
        itemTable2.setItems(oblist2);
    }

}
