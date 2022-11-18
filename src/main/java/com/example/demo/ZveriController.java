package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ZveriController {

    @FXML
    private Button drygyy;

    @FXML
    private Button gryzyn;

    @FXML
    private Button koshk;

    @FXML
    private Button sobk;


    @FXML
    void initialize() {
        koshk.setOnAction(Clik -> {
            koshk.getScene().getWindow().hide();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("nekot.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
