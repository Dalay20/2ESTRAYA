module ec.edu.espol.era {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens ec.edu.espol.era to javafx.fxml;
    exports ec.edu.espol.era;
}
