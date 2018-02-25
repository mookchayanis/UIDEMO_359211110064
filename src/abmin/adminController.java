package admin;

import abmin.StudantData;
import dbUtil.dbconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class adminController implements Initializable{

    private dbconnection db;
    private ObservableList<StudantData> data;


    @FXML
    private TableView<StudantData> studencolum;

    @FXML
    private TableColumn<StudantData, String> idcolum;

    @FXML
    private TableColumn<StudantData, String> firsnamecolum;

    @FXML
    private TableColumn<StudantData, String> lastcolum;

    @FXML
    private TableColumn<StudantData, String> dobcolum;

    @FXML
    private TableColumn<StudantData, String> emailcolum;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.db =new dbconnection();

    }//initialize
    @FXML
    private  void loadStudentSata(ActionEvent event){
        try {
            Connection conn =dbconnection.getConnection();
            this.data = FXCollections.observableArrayList();
            //sql
            String sql ="select * from studen";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.data.add(new StudantData rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5));
            }//while
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //put data to tableview
        this.idcolum.setCellValueFactory(
                new PropertyValueFactory<StudantData,String>("id"));
        this.firsnamecolum.setCellValueFactory(
                new PropertyValueFactory<StudantData,String>("firstname"));
        this.firsnamecolum.setCellValueFactory(
                new PropertyValueFactory<StudantData,String>("lastName"));
        this.emailcolum.setCellValueFactory(
                new PropertyValueFactory<StudantData,String>("email"));
        this.dobcolum.setCellValueFactory(
                new PropertyValueFactory<StudantData,String>("DOB"));
        this.studencolum.setItems(null);
        this.studencolum.setItems(this.data);



    }
}
}//class