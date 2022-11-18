package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class KotikController {
    @FXML
    private Button buttonchik;
    @FXML
    private Button buttonn;

    @FXML
    private TextField txt;

    @FXML
    private TextField txt2;


    @FXML
    void initialize() {
        buttonchik.setOnAction(event -> {
            System.out.println(txt.getText().trim());
            System.out.println(txt2.getText().trim());

            buttonchik.setOnAction(clik -> {
                buttonchik.setText("Спасибо за регистрацию ");
                System.out.println("Логин: " + txt.getText());
                System.out.println("Пароль: " + txt2.getText());
                buttonchik.getScene().getWindow().hide();
                try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Egor\\IdeaProjects\\demo\\src\\main\\resources\\login.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.equals(txt.getText().trim())) {
                            try {
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("error.fxml"));
                                loader.load();
                                Parent root = loader.getRoot();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root));
                                stage.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.println("Верный логин");
                        } else {
                            System.out.println("Данные введены некорректно");
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Egor\\IdeaProjects\\demo\\src\\main\\resources\\pass.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.equals(txt2.getText().trim())) {
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
                            System.out.println("Верный пароль");
                        } else {

                            System.out.println("Данные введены некорректно");
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        });



            buttonchik.setOnAction(clik -> {

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

                buttonn.setOnAction(Clik -> {
                    buttonn.getScene().getWindow().hide();
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("kotreg.fxml"));
                        loader.load();
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });
            });

        }
    }













