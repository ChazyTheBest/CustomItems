package org.custom.items;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RootController extends BorderPane
{
    @FXML private Text title;
    private Stage stage;
    private double x, y;
    private Image logo;
    private ImageCursor mouse;

    RootController()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("root.fxml"));

        loader.setRoot(this);
        loader.setController(this);

        try
        {
            loader.load();
        }

        catch (Exception e)
        {
            System.out.println("Error loading root.fxml.");
            e.printStackTrace();
        }
    }

    public void launchAuth(Stage s) throws IOException
    {
        stage = s;
        mouse = new ImageCursor(new Image(getClass().getResource("cursor.png").openStream()));
        logo = new Image(getClass().getResource("logo.png").openStream());

        Scene scene = new Scene(this);
        scene.setCursor(mouse);
        s.initStyle(StageStyle.UNDECORATED);
        s.getIcons().add(logo);
        s.setTitle(title.getText());
        s.setScene(scene);
        UX.setStage(s);

        new AuthController(this).displayAuthWindow(stage);
    }

    public void launchApp() throws IOException
    {
        new AppController(this).displayAppWindow(stage);
    }

    @FXML
    public void dragged(MouseEvent event)
    {
        stage.setX(event.getScreenX() + x);
        stage.setY(event.getScreenY() + y);
    }

    @FXML
    public void pressed(MouseEvent event)
    {
        x = stage.getX() - event.getScreenX();
        y = stage.getY() - event.getScreenY();
    }

    @FXML
    private void min (MouseEvent event)
    {
        stage.setIconified(true);
    }

    @FXML
    private void max(MouseEvent event)
    {
        stage.setFullScreen(true);
    }

    @FXML
    private void close(MouseEvent event)
    {
        stage.close();
    }

    public void setTitle(String t)
    {
        title.setText(t);
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public Image getLogo()
    {
        return logo;
    }

    public ImageCursor getMouse()
    {
        return mouse;
    }
}
