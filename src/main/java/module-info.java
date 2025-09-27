module com.sena.introductionMaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.sena.introductionMaven to javafx.graphics;
    opens com.sena.introductionMaven.CrediSystem to javafx.fxml;

    exports com.sena.introductionMaven;
    exports com.sena.introductionMaven.CrediSystem;
}