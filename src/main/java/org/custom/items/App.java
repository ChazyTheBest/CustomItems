package org.custom.items;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        new RootController().launchAuth(primaryStage);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
