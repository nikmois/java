package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.*;

import java.io.IOException;
import java.net.URL;

public class Main extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        /*GridPane pane = new GridPane();

        Text text = new Text("Hello KTA-20V");
        //text.setLayoutX(300);
        //text.setLayoutY(230);

        Button btn = new Button("Click me");

        CheckBox cbox = new CheckBox("Check!");

        TextField textField = new TextField("1234");

        pane.add(text, 0, 0);
        pane.add(btn, 0, 1);
        pane.add(cbox, 1, 0);
        pane.add(textField, 1, 1);

        for(int i=0; i<=1; i++)
        {
            RowConstraints rc = new RowConstraints();
            rc.setValignment(VPos.CENTER);
            rc.setVgrow(Priority.SOMETIMES);
            pane.getRowConstraints().add(i, rc);

            ColumnConstraints cc = new ColumnConstraints();
            cc.setHalignment(HPos.CENTER);
            cc.setHgrow(Priority.SOMETIMES);
            pane.getColumnConstraints().add(i,cc);
        }



        pane.setHgap(10);
        pane.setVgap(10);
        //pane.setMinWidth(150);
        //pane.setMinHeight(100);

        AnchorPane anchor = new AnchorPane();

        AnchorPane.setTopAnchor(pane, 0.0);
        AnchorPane.setRightAnchor(pane, 0.0);
        AnchorPane.setBottomAnchor(pane, 0.0);
        AnchorPane.setLeftAnchor(pane, 0.0);

        anchor.getChildren().addAll(pane);

        //Group group = new Group(pane);*/

        Parent n = (Parent)FXMLLoader.load(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(n);

        stage.setScene(scene);
        stage.setTitle("Main window");
        stage.setWidth(640);
        stage.setHeight(480);

        stage.show();

    }
}
