package org.custom.items;

import javafx.application.Platform;
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
    private ImageCursor mouseCursor, mouseCursorGlow, mouseCursorPreview, mouseCursorPreviewOff, mouseCursorGossip,
                        mouseCursorAttack, mouseCursorCreate, mouseCursorCreateOff, mouseCursorWheel;

    RootController()
    {

    }

    private void loadRoot()
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
            //e.printStackTrace();
        }
    }

    public void launchAuth(Stage s) throws IOException
    {
        loadRoot();

        stage = s;
        mouseCursor = new ImageCursor(new Image(getClass().getResource("Cursors/cursor.png").openStream()));
        mouseCursorGlow = new ImageCursor(new Image(getClass().getResource("Cursors/cursor_glow.png").openStream()));
        mouseCursorPreview = new ImageCursor(new Image(getClass().getResource("Cursors/cursor_preview.png").openStream()));
        mouseCursorPreviewOff = new ImageCursor(new Image(getClass().getResource("Cursors/cursor_preview_off.png").openStream()));
        mouseCursorGossip = new ImageCursor(new Image(getClass().getResource("Cursors/cursor_gossip.png").openStream()));
        mouseCursorAttack = new ImageCursor(new Image(getClass().getResource("Cursors/cursor_attack.png").openStream()));
        mouseCursorCreate = new ImageCursor(new Image(getClass().getResource("Cursors/cursor_create.png").openStream()));
        mouseCursorCreateOff = new ImageCursor(new Image(getClass().getResource("Cursors/cursor_create_off.png").openStream()));
        mouseCursorWheel = new ImageCursor(new Image(getClass().getResource("Cursors/cursor_wheel.png").openStream()));
        logo = new Image(getClass().getResource("logo.png").openStream());

        Scene scene = new Scene(this);
        scene.setCursor(mouseCursor);
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
        Platform.exit();
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

    public ImageCursor getMouseCursor()
    {
        return mouseCursor;
    }

    public ImageCursor getMouseCursorGlow()
    {
        return mouseCursorGlow;
    }

    public ImageCursor getMouseCursorPreview()
    {
        return mouseCursorPreview;
    }

    public ImageCursor getMouseCursorPreviewOff()
    {
        return mouseCursorPreviewOff;
    }

    public ImageCursor getMouseCursorGossip()
    {
        return mouseCursorGossip;
    }

    public ImageCursor getMouseCursorAttack()
    {
        return mouseCursorAttack;
    }

    public ImageCursor getMouseCursorCreate()
    {
        return mouseCursorCreate;
    }

    public ImageCursor getMouseCursorCreateOff()
    {
        return mouseCursorCreateOff;
    }

    public ImageCursor getMouseCursorWheel()
    {
        return mouseCursorWheel;
    }
}
