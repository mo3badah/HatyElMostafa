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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Main;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.ResourceBundle;
import java.text.SimpleDateFormat;
import java.util.Date;

public class selling implements Initializable {
    public static int getIdgenerate() {
        return idgenerate;
    }

    public static void setIdgenerate(int idgenerate) {
        selling.idgenerate = idgenerate;
    }

    public static int idgenerate;

    public static int getIdmod() {
        return idmod;
    }

    public static void setIdmod(int idmod1) {
        idmod = idmod1;
    }

    private static int idmod;

    public static boolean isIsmod() {
        return ismod;
    }

    public static void setIsmod(boolean ismod1) {
        ismod = ismod1;
    }

    private static boolean ismod;
    public static String getCashierName() {
        return cashierName;
    }

    public static void setCashierName(String cashierName) {
        selling.cashierName = cashierName;
    }

    public static String cashierName = "admin";

        @FXML
        private AnchorPane selling_bane;

        @FXML
        private ImageView menuPageImage;
    @FXML
    private TableView<moderTabel> sellingTable;
    @FXML
    private TableColumn<moderTabel,String> Ttype;
    @FXML
    private TableColumn<moderTabel,String> Tname;
    @FXML
    private TableColumn<moderTabel,Double> Tno;
    @FXML
    private TableColumn<moderTabel,String> Tquantity;
    @FXML
    private TableColumn<moderTabel,Double> Tprice;
    @FXML
    private TableColumn<moderTabel,Double> Tdisc;
    @FXML
    private TableColumn<moderTabel,Double> Tnetprice;
    ObservableList<moderTabel> oblist = FXCollections.observableArrayList();
        @FXML
        private TextField TallTotal;

        @FXML
        private TextField TallDisc;

        @FXML
        private TextField onePrice;

        @FXML
        private Button addOne;

        @FXML
        private Button ksk;

        @FXML
        private Button kthina;

        @FXML
        private Button kbg;

        @FXML
        private Button kbaz;

        @FXML
        private Button kbm;

        @FXML
        private Button ktorsh;

        @FXML
        private Button tkl;

        @FXML
        private Button tbl;

        @FXML
        private Button kpl;

        @FXML
        private Button kbsl;

        @FXML
        private Button wm;

        @FXML
        private Button wa;

        @FXML
        private Button ws;

        @FXML
        private Button wk;

        @FXML
        private Button wf;

        @FXML
        private Button wmix;

        @FXML
        private Button wkbab;

        @FXML
        private Button hha;

        @FXML
        private Button hhk;

        @FXML
        private Button hhd;

        @FXML
        private Button ham;

        @FXML
        private Button skk;

        @FXML
        private Button stk;

        @FXML
        private Button skd;

        @FXML
        private Button std;

        @FXML
        private Button skbab;

        @FXML
        private Button mrs;

        @FXML
        private Button mrk;

        @FXML
        private Button mmb;

        @FXML
        private Button msl;

        @FXML
        private Button cwa;

        @FXML
        private Button cws;

        @FXML
        private TextField newno;

        @FXML
        private RadioButton mlkbab;

        @FXML
        private ToggleGroup type3;

        @FXML
        private RadioButton mlr;

        @FXML
        private RadioButton mlm;

        @FXML
        private RadioButton mlkb;

        @FXML
        private RadioButton mlkd;

        @FXML
        private RadioButton mls;

        @FXML
        private RadioButton mlkk;

        @FXML
        private RadioButton mln;

        @FXML
        private RadioButton mltb;

        @FXML
        private RadioButton mltd;

        @FXML
        private RadioButton mtft;

        @FXML
        private RadioButton mtfs;

        @FXML
        private RadioButton mtfz;

        @FXML
        private RadioButton mthm;

        @FXML
        private RadioButton mtkq;

        @FXML
        private RadioButton mtbf;

        @FXML
        private RadioButton mtstf;

        @FXML
        private RadioButton added;

        @FXML
        private ChoiceBox comboNew;

        @FXML
        private Button Msmall;

        @FXML
        private TextField smallno;

        @FXML
        private Button Mmid;

        @FXML
        private TextField midno;

        @FXML
        private Button Mbig;

        @FXML
        private TextField bigno;

        @FXML
        private TextField Ediscno;

        @FXML
        private TextField Ediscratio;

        @FXML
        private RadioButton Cdiscno;

        @FXML
        private ToggleGroup type7;

        @FXML
        private RadioButton Cdiscratio;

        @FXML
        private RadioButton Free;

        @FXML
        private CheckBox Orderdisc;

        @FXML
        private Button change;

        @FXML
        private Button clearAll;

        @FXML
        private Button printing2;

        @FXML
        private Button printing1;

    // The main data variables
    public String Otype;
    public String Oname;
    public Double Ono;
    public String Oquantity;
    public String Odescription;
    public Double Oprice;
    public Double Odisc;
    public Double Onetprice;
    public Double allTotal;
    public Double allDisc;


    private ResultSet dbResSell;
    private Main main;



    public void initialize(URL location, ResourceBundle resources) {
        setSellingTable();
        initializeCombo();
    }
    public String checkKlasicTypes(ToggleGroup x){
        RadioButton selectedRadioButton = (RadioButton) x.getSelectedToggle();
        return selectedRadioButton.getId();
    }


    // Form, Cups and Mix Buttons
    public void buttonSmallEnter(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 0.0;
        Double piecesenter = 1.0;
        // to check if there is prices for the others
        Double other1=0.0;
        Double other2=0.0;
        String typeId = null;
        try {
            piecesenter = Double.valueOf(midno.getText());
        } catch (Exception e) {
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

        try {
            typeId = checkKlasicTypes(type3);
        } catch (Exception e) {
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        if (typeId.equals("added")) {
            Oname = (String) comboNew.getValue();
            String sqlscript = "SELECT * from kunafahut.added where name = '" + Oname + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", main.getSqlUser(), main.getSqlPass()).executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oquantity = dbResSell.getString("smallName");
                kilo = Double.valueOf(dbResSell.getString("smallPrice"));
                Odescription = dbResSell.getString("description");

            }


        } else {
            String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", main.getSqlUser(), main.getSqlPass()).executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oname = dbResSell.getString("name");
                kilo = Double.valueOf(dbResSell.getString("small"));
                other1 = Double.valueOf(dbResSell.getString("medium"));
                other2 = Double.valueOf(dbResSell.getString("big"));
                Odescription = dbResSell.getString("description");
            }

                  Oquantity = "ربع";
        }
            Ono = piecesenter;
            Oprice = kilo * piecesenter;
            onePrice.setText(String.valueOf(Oprice));
        }
 // Form, Cups and Mix Buttons
    public void buttonMediumEnter(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 0.0;
        Double piecesenter = 1.0;
        String typeId = null;
        try {
            piecesenter = Double.valueOf(midno.getText());
        } catch (Exception e) {
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

        try {
            typeId = checkKlasicTypes(type3);
        } catch (Exception e) {
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        if (typeId.equals("added")) {
            Oname = (String) comboNew.getValue();
            String sqlscript = "SELECT * from kunafahut.added where name = '" + Oname + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", main.getSqlUser(), main.getSqlPass()).executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oquantity = dbResSell.getString("mediumName");
                kilo = Double.valueOf(dbResSell.getString("mediumPrice"));
            }

        } else {

            String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", main.getSqlUser(), main.getSqlPass()).executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oname = dbResSell.getString("name");
                kilo = Double.valueOf(dbResSell.getString("medium"));
            }

                Oquantity = "نصف";

        }
            Ono = piecesenter;
            Oprice = kilo * piecesenter;
            onePrice.setText(String.valueOf(Oprice));
        }


    public void buttonBigEnter(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 0.0 ;
        Double piecesenter = 1.0 ;
        String typeId = null;
        try {
            piecesenter = Double.valueOf(bigno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

        try {
            typeId = checkKlasicTypes(type3);
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        if (typeId.equals("added")) {
            Oname = (String) comboNew.getValue();
            String sqlscript = "SELECT * from kunafahut.added where name = '" + Oname + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", main.getSqlUser(), main.getSqlPass()).executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oquantity = dbResSell.getString("bigName");
                kilo = Double.valueOf(dbResSell.getString("bigPrice"));
            }
        }
        else {
            String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", main.getSqlUser(), main.getSqlPass()).executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oname = dbResSell.getString("name");
                kilo = Double.valueOf(dbResSell.getString("big"));
            }
            Oquantity = "كيلو";
        }
        Ono = piecesenter;
        Oprice = kilo*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    // New Buttons
    public void buttonsValues(String id){
        Double kilo = 5.0 ;
        Double piecesenter = 1.0 ;
        try {
            piecesenter = Double.valueOf(newno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        try {
            String sqlscript = "SELECT * from kunafahut.types where id = '" + id + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", main.getSqlUser(), main.getSqlPass()).executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oname = dbResSell.getString("name");
                kilo = Double.valueOf(dbResSell.getString("small"));
                Odescription = dbResSell.getString("description");
            }
        }catch (Exception e){
            String selection = "هناك خطأ في معالجة الطلب ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        Ono = piecesenter;
        Oquantity = "";
        Oprice = kilo*piecesenter;
        onePrice.setText(String.valueOf(Oprice));

    }
    public void skk(javafx.event.ActionEvent actionEvent){
        buttonsValues("skk");
    }
    public void stk(javafx.event.ActionEvent actionEvent){
        buttonsValues("stk");
    }
    public void skd(javafx.event.ActionEvent actionEvent){
        buttonsValues("skd");
    }
    public void std(javafx.event.ActionEvent actionEvent){
        buttonsValues("std");
    }
    public void skbab(javafx.event.ActionEvent actionEvent){
        buttonsValues("skbab");
    }
    public void mrs(javafx.event.ActionEvent actionEvent){
        buttonsValues("mrs");
    }
    public void mrk(javafx.event.ActionEvent actionEvent){
        buttonsValues("mrk");
    }
    public void mmb(javafx.event.ActionEvent actionEvent){
        buttonsValues("mmb");
    }
    public void msl(javafx.event.ActionEvent actionEvent){
        buttonsValues("msl");
    }
    public void hha(javafx.event.ActionEvent actionEvent){
        buttonsValues("hha");
    }
    public void hhk(javafx.event.ActionEvent actionEvent){
        buttonsValues("hhk");
    }
    public void hhd(javafx.event.ActionEvent actionEvent){
        buttonsValues("hhd");
    }
    public void ham(javafx.event.ActionEvent actionEvent){
        buttonsValues("ham");
    }
    public void ksk(javafx.event.ActionEvent actionEvent){
        buttonsValues("ksk");
    }
    public void kthina(javafx.event.ActionEvent actionEvent){
        buttonsValues("kthina");
    }
    public void kbg(javafx.event.ActionEvent actionEvent){
        buttonsValues("kbg");
    }
    public void kbaz(javafx.event.ActionEvent actionEvent){
        buttonsValues("kbaz");
    }
    public void kbm(javafx.event.ActionEvent actionEvent){
        buttonsValues("kbm");
    }
    public void ktorsh(javafx.event.ActionEvent actionEvent){
        buttonsValues("ktorsh");
    }
    public void tkl(javafx.event.ActionEvent actionEvent){
        buttonsValues("tkl");
    }
    public void tbl(javafx.event.ActionEvent actionEvent){
        buttonsValues("tbl");
    }
    public void tpl(javafx.event.ActionEvent actionEvent){
        buttonsValues("tpl");
    }
    public void tbsl(javafx.event.ActionEvent actionEvent){
        buttonsValues("tbsl");
    }
    public void cwa(javafx.event.ActionEvent actionEvent){
        buttonsValues("cwa");
    }
    public void cws(javafx.event.ActionEvent actionEvent){
        buttonsValues("cws");
    }
    public void wm(javafx.event.ActionEvent actionEvent){
        buttonsValues("wm");
    }
    public void wa(javafx.event.ActionEvent actionEvent){
        buttonsValues("wa");
    }
    public void ws(javafx.event.ActionEvent actionEvent){
        buttonsValues("ws");
    }
    public void wk(javafx.event.ActionEvent actionEvent){
        buttonsValues("wk");
    }
    public void wf(javafx.event.ActionEvent actionEvent){
        buttonsValues("wf");
    }
    public void wmix(javafx.event.ActionEvent actionEvent){
        buttonsValues("wmix");
    }
    public void wkbab(javafx.event.ActionEvent actionEvent){
        buttonsValues("wkbab");
    }



    public double returnDisc(double price){
        String typeId;
        double afterDisc = price;
        try {
            typeId = checkKlasicTypes(type7);
            if (typeId.equals("Cdiscno")){
                try {
                    afterDisc = price-Double.valueOf(Ediscno.getText());
                }catch (Exception e){
                    String selection = "من فضلك ادخل رقم الخصم اولاً ";
                    Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
                    alert.showAndWait();
                }
            }else if (typeId.equals("Cdiscratio")){
                try {
                    if ((!Double.valueOf(Ediscratio.getText()).equals(0.0))){
                        afterDisc = price*(1-Double.valueOf(Ediscratio.getText())/100);
                    }
                }catch (Exception e){
                    String selection = "من فضلك ادخل نسبة الخصم اولاً ";
                    Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
                    alert.showAndWait();
                }
            }else if (typeId.equals("Free")){
                afterDisc = 0.0;
            }
        }catch (Exception e){
            return afterDisc;
        }
        return afterDisc;
    }
    public void addItem(javafx.event.ActionEvent actionEvent){
        try {
            double price = Double.parseDouble(onePrice.getText());
            Onetprice = returnDisc(price);
            Odisc = Oprice-Onetprice;
            clearDisc();
            // save ItemData in the preorder table
            String sqlscript = "INSERT INTO `kunafahut`.`preorder` (`type`, `name`, `no`, `quantity`, `price`, `disc`, `netPrice`,`description`) VALUES ('"+Otype+"','"+Oname+"',"+Ono+",'"+Oquantity+"',"+Oprice+","+Odisc+","+Onetprice+",'"+Odescription+"')";
            try {
                initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeUpdate(sqlscript);
                System.out.println("updated successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("dosen't updated!");
            }
            sellingTable.getItems().clear();
            setSellingTable();
        }catch (Exception e){
            String selection = "من فضلك ادخل ادخل طلب اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void clearDisc(){
        for (Toggle t : type7.getToggles()) {
            if (t instanceof RadioButton) {
                ((RadioButton) t).setSelected(false);
            }
        }
        Ediscno.setText("");
        Ediscratio.setText("");
    }

    public void clearAllOthers(){
        for (Toggle t : type3.getToggles()) {
            if (t instanceof RadioButton) {
                ((RadioButton) t).setSelected(false);
            }
        }
        onePrice.setText("");
        midno.setText("1");
        bigno.setText("1");
        newno.setText("1");
    }

    public void dropTableRow(){
        int tableRowId = -1;
        int typed = 0;
        tableRowId = sellingTable.getSelectionModel().getSelectedIndex();
        if (!(tableRowId <= -1)){
            typed = sellingTable.getSelectionModel().getSelectedItem().rowNo;
            String sqlscript = "DELETE FROM `kunafahut`.`preorder` WHERE `rowNo` ="+typed+"";
            try {
                initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeUpdate(sqlscript);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sellingTable.getItems().clear();
            setSellingTable();
        }else {
            String selection = "من فضلك حدد الصف المراد حذفة ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void clearAllData(javafx.event.ActionEvent actionEvent){
        clearAllData();
    }
    public  void clearAllData(){
        // clear table data
        String sqlscript = "truncate `kunafahut`.`preorder`";
        try {
            initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeUpdate(sqlscript);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sellingTable.getItems().clear();
        setSellingTable();
        // clear other data
        clearDisc();
        clearAllOthers();
    }


    public void setSellingTable(){
        // DB functions
        ResultSet dbResAllTotal;
        ResultSet dbResAllDisc;
        try {
            String sqlscript = "SELECT * from kunafahut.preorder";
            String sqlAllTotal = "SELECT SUM(netPrice) as totalNetPrice from kunafahut.preorder";
            String sqlAllDisc = "SELECT SUM(disc) AS totalDisc from kunafahut.preorder";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeQuery(sqlscript);
            dbResAllTotal = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeQuery(sqlAllTotal);
            dbResAllDisc = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeQuery(sqlAllDisc);
            while (dbResAllTotal.next()){
                allTotal = (Double) dbResAllTotal.getDouble("totalNetPrice");
            }
            while (dbResAllDisc.next()){
                allDisc = (Double) dbResAllDisc.getDouble("totalDisc");
            }
            while (dbResSell.next()) {
                oblist.add(new moderTabel(dbResSell.getInt("rowNo"), dbResSell.getString("type"),dbResSell.getString("name"),dbResSell.getDouble("no"),dbResSell.getString("quantity"),dbResSell.getDouble("price"),dbResSell.getDouble("disc"),dbResSell.getDouble("netprice")));
            }
            TallDisc.setText(String.valueOf(allDisc));
            TallTotal.setText(String.valueOf(allTotal));
        }catch (SQLException e){
            e.printStackTrace();
        }
        Ttype.setCellValueFactory(new PropertyValueFactory<>("type"));
        Tname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Tno.setCellValueFactory(new PropertyValueFactory<>("no"));
        Tquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        Tprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        Tdisc.setCellValueFactory(new PropertyValueFactory<>("disc"));
        Tnetprice.setCellValueFactory(new PropertyValueFactory<>("netprice"));
        sellingTable.setItems(oblist);
    }

    public static Statement initializeDB(String dburl, String dbuser, String dbpass) throws SQLException {
        // DB parameters
        Connection dbconn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbconn = DriverManager.getConnection(dburl, dbuser, dbpass);
        } catch (ClassNotFoundException | SQLException var2) {
            System.err.println(var2.getMessage());
        }
        return dbconn.createStatement();

    }
    public void initializeCombo(){
        String sqlscript2 = "SELECT * FROM kunafahut.added ;";
        try {
            ResultSet dbResGetId = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", main.getSqlUser(), main.getSqlPass()).executeQuery(sqlscript2);
            while (dbResGetId.next()) {
                comboNew.getItems().addAll(dbResGetId.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printing2(javafx.event.ActionEvent actionEvent){
        if (checkEmpty()==1){
            try {
                printing();
                Parent userview = FXMLLoader.load(getClass().getResource("../fxml/userdata.fxml"));
                Scene userscene = new Scene(userview);
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(userscene);
                window.show();

            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }else {
            String selection = "من فضلك ادخل بيانات الاوردر ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

    }
    public void printing1(javafx.event.ActionEvent actionEvent){
        if (checkEmpty()==1){
            printing();
            userdata.outprint(idgenerate);
        }else {
            String selection = "من فضلك ادخل بيانات الاوردر ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

    }
    public void menuPage(javafx.event.ActionEvent actionEvent){
        if (ismod){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("الخروج اثناء تعديل الاوردر");
            alert.setContentText("هل تريد الخروج من التعديل وحذف الاوردر نهائياً؟");
            ButtonType okButton = new ButtonType("نعم، اخرج", ButtonBar.ButtonData.YES);
            ButtonType cancelButton = new ButtonType("لا، اكمل", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(okButton, cancelButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == okButton) {
                    setIsmod(false);
                    clearAllData();
                } else {
                    System.out.println("say nothing");
                }
            });
        }
        if (!ismod){
            try {
                Parent userview = FXMLLoader.load(menuPage.class.getResource("../fxml/menuPage.fxml"));
                Scene userscene = new Scene(userview);
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(userscene);
                window.show();
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
    }
    public int checkEmpty(){
        int check = 0;
        try {
            String sendOrderDetails = "SELECT EXISTS (SELECT 1 FROM preorder);";
            ResultSet dbResGetId = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", main.getSqlUser(), main.getSqlPass()).executeQuery(sendOrderDetails);
            while (dbResGetId.next()){

               check = dbResGetId.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }
    public void printing(){
        int id;
        String sendOrderDetails;
        // generating
        if (ismod){
            id=idmod;
            setIdgenerate(id);
        }
        else {
            setIdgenerate();
            id =idgenerate;
        }
        // set order disc
        Double price = allTotal+allDisc;
        if (Orderdisc.isSelected()){
            Double x;
            x = returnDisc(allTotal);
            allDisc += allTotal-x;
            allTotal = x;
            price = allTotal+allDisc;
        }
        // coping data to another Field
        String sendOrderData = "insert into ordersdata (orderNo, type, name, no, quantity, price, disc, netPrice, description)\n" +
                "select ("+id+"), type, name, no, quantity, price, disc, netPrice, description from preorder;";
        if (ismod){
             sendOrderDetails = "UPDATE orderdetails set cachierName = '"+cashierName+"',orderTime = CURRENT_TIMESTAMP,price = "+price+", totDisc = "+allDisc+", totPrice = "+allTotal+",totNetPrice = totPrice+delivery where orderNo = "+id+";";

        }else {
             sendOrderDetails = "insert into orderdetails (orderNo, orderTime, cachierName, price, totDisc,totPrice, delivery, totNetPrice,clientName,clientPhone,clientLocation,comment )\n" +
                    "value ("+idgenerate+", CURRENT_TIMESTAMP, '"+cashierName+"', "+price+", "+allDisc+", "+allTotal+",0,totPrice+delivery,'',0,'','');";
        }

        try {
            initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeUpdate(sendOrderData);
            initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true",main.getSqlUser(),main.getSqlPass()).executeUpdate(sendOrderDetails);

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        clearAllData();
        setIsmod(false);
    }
    public void setIdgenerate(){
        // coping data to another Field
        String sqlscript = "SELECT orderNo FROM orderdetails ORDER BY orderNo DESC LIMIT 1;";
        int getId=0;
        try {
            ResultSet dbResGetId = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", main.getSqlUser(), main.getSqlPass()).executeQuery(sqlscript);
            while (dbResGetId.next()){
                getId = (int) dbResGetId.getDouble("orderNo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String lastGetId;
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMdd");
        String datetime = ft.format(dNow);
        lastGetId = String.valueOf(getId).substring(0,6);
        if (lastGetId.equals(datetime)){
            idgenerate = getId+1;
        }else {
            idgenerate = Integer.valueOf(datetime+"001");
        }
    }
}
