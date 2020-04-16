package org.custom.items;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class UX
{
    private static Stage stage;

    public static void setStage(Stage s)
    {
        stage = s;
    }

    public static void showAlert(Alert.AlertType alertType, String title, String message)
    {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(stage.getScene().getWindow());
        alert.showAndWait();
    }
}
