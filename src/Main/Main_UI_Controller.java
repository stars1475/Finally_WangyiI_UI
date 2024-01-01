package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URI;

public class Main_UI_Controller {
    File file = new File("resources/music/日光海岸.mp3");
    URI uri = file.toURI();
    Media media = new Media(uri.toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    int i = 0;
    @FXML
    private Button small;
    @FXML
    private Button big;
    @FXML
    private Button close;
    @FXML
    private Button playMusicButton;
    @FXML
    private Button lest;
    @FXML
    private Button next;
    @FXML
    private ImageView musicclose;
    @FXML
    private ImageView musicopen;
    @FXML
    private Slider rolling;

    @FXML
    private Slider sound;
    @FXML
    void bigaction(ActionEvent event) {
        Stage stage = (Stage) big.getScene().getWindow();
        stage.setMaximized(true);
        stage.setFullScreen(true);
    }

    @FXML
    void closeaction(ActionEvent event) {
        Stage oldstage = (Stage) close.getScene().getWindow();
        oldstage.close();
    }

    @FXML
    void smallaction(ActionEvent event) {
        Stage stage = (Stage) small.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void playMusicButtonAction(ActionEvent event) {
        i += 1;
        if (i % 2 == 1) {
            mediaPlayer.play();
            musicclose.setVisible(true);
            musicopen.setVisible(false);
        } else {
            mediaPlayer.pause();
            i = 0;
            musicclose.setVisible(false);
            musicopen.setVisible(true);
        }
    }

    void addEvent() {
        mediaPlayer.currentTimeProperty().addListener(n -> {
            rolling.setValue(mediaPlayer.getCurrentTime().toSeconds());
        });

    }

    @FXML
    void anzhu(MouseEvent event) {
        mediaPlayer.seek(new Duration(rolling.getValue() * 1000));
    }

    @FXML
    void shifang(MouseEvent event) {
        mediaPlayer.seek(new Duration(rolling.getValue() * 1000));
    }

    void soundevent(){
        sound = new Slider(0, 100, 1);
        sound.setShowTickLabels(true);
        sound.setShowTickMarks(true);
        sound.setMajorTickUnit(0.25);
        sound.setMinorTickCount(5);
    }
    @FXML
    void az(MouseEvent event) {
        sound.valueProperty().addListener((observable, oldValue, newValue) -> {
            mediaPlayer.setVolume(newValue.doubleValue());
        });
    }
    @FXML
    void sf(MouseEvent event) {
        sound.valueProperty().addListener((observable, oldValue, newValue) -> {
            mediaPlayer.setVolume(newValue.doubleValue());
        });
    }

    /*
    Slider volumeSlider = new Slider(0, 100, 50);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setMajorTickUnit(25);
        volumeSlider.setMinorTickCount(5);

        volumeSlider.setOnMouseDragged(event -> {
            double value = volumeSlider.getValue();
            // 根据value的值调节音量
            double volume = value / 100.0; // 将0-100的值转换为0-1的值
            System.out.println("Volume: " + volume);
            // 在这里可以调用相应的音量调节逻辑
        });

        VBox root = new VBox(volumeSlider);
        Scene scene = new Scene(root, 300, 150);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Volume Slider Example");
        primaryStage.show();
     */
}
