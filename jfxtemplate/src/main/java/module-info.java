module com.example.jfxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jfxtemplate to javafx.fxml;
    exports com.example.jfxtemplate;
}