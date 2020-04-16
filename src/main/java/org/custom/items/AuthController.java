package org.custom.items;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AuthController
{
    @FXML private GridPane authBody;
    @FXML private TextField

                        hostField,
                        portField,
                        dbField,
                        userField;

    @FXML private PasswordField passwordField;

    private final String fileName = "connection.conf";
    private final Properties config = new Properties();
    private final RootController root;


    AuthController(RootController r)
    {
        root = r;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("auth.fxml"));

        loader.setRoot(root.getCenter());
        loader.setController(this);

        try
        {
            loader.load();
        }

        catch (Exception e)
        {
            System.out.println("Error displaying login window");
            e.printStackTrace();
        }
    }

    public void displayAuthWindow(Stage s)
    {
        root.setCenter(authBody);
        s.show();

        try
        {
            FileManager.loadFile(fileName, config);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        if (!config.isEmpty())
        {
            hostField.setText(config.getProperty("host"));
            portField.setText(config.getProperty("port"));
            dbField.setText(config.getProperty("db"));
            userField.setText(config.getProperty("user"));
            passwordField.setText(config.getProperty("pwd"));
        }
    }

    @FXML
    private void login(ActionEvent event) throws IOException
    {
        String host = hostField.getText();
        String port = portField.getText();
        String db = dbField.getText();
        String user = userField.getText();
        String pwd = passwordField.getText();

        if (host.isEmpty() || port.isEmpty() || db.isEmpty() || user.isEmpty() || pwd.isEmpty())
        {
            UX.showAlert(Alert.AlertType.ERROR, "Form Error!", "Please fill in all fields.");
            return;
        }

        try
        {
            DB.checkConnection(host, port, db, user, pwd);
        }

        catch (SQLException e)
        {
            UX.showAlert(Alert.AlertType.ERROR, "DB Status", "Cannot connect to the database!\n\n" + e.getMessage());
            return;
        }

        //UX.showAlert(Alert.AlertType.INFORMATION, owner, "DB Status", "Connected!");

        if (config.isEmpty() || !config.get("host").equals(host) ||
                                !config.get("port").equals(port) ||
                                !config.get("db").equals(db) ||
                                !config.get("user").equals(user) ||
                                !config.get("pwd").equals(pwd))
        {
            config.put("host", host);
            config.put("port", port);
            config.put("db", db);
            config.put("user", user);
            config.put("pwd", pwd);

            FileManager.writeFile(fileName, config);
        }

        root.launchApp();
    }
}
