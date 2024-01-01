package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main_UI extends Application {


    public Main_UI() throws IOException {
        URL url = new File("src/Main/Main_UI.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = new Stage();
        Scene scene = new Scene(root, 1277, 837);
        //stage.initStyle(StageStyle.UTILITY);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
    // url(file:/E:/java/idea运行/wangyi/image/return.png)
}
