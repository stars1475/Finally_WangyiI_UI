package logon;

import Main.Main_UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Log_UI_Controller {
    @FXML
    private TextField usename;

    @FXML
    private TextField password;

    @FXML
    private Button loginbutton;

    @FXML
    private Label label;

    @FXML
    private Button close;

    @FXML
    void loginbuttonOnAction(ActionEvent event) throws IOException {
        String un = usename.getText();
        String pd = password.getText();
        System.out.println(un);
        Stage oldstage = (Stage) loginbutton.getScene().getWindow();
        if (un.equals("123") && pd.endsWith("123")) {
            oldstage.close();
            Main_UI main_ui = new Main_UI();
        } else {
            label.setVisible(true);
            /*Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("登录失败");
            alert.setHeaderText("用户名或密码错误");
            alert.setContentText("请再尝试");
            alert.showAndWait();*/
            usename.setText("");
            password.setText("");
        }
    }

    @FXML
    void logincolse(ActionEvent event) {
        Stage oldstage = (Stage) close.getScene().getWindow();
        oldstage.close();
    }
}
