package logon;

import Main.Main_UI;
import Register.Register_UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
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
    private Button register;

    @FXML
    void loginbuttonOnAction(ActionEvent event) throws IOException {
        String un = usename.getText();
        String pd = password.getText();
        FileReader inOne = new FileReader("E:\\java\\idea运行\\wangyi\\usename.txt");
        BufferedReader inTwo = new BufferedReader(inOne);
        String s = null;
        String[] strName = new String[100];
        int i = 0;
        int pos = 0;
        while ((s = inTwo.readLine()) != null) {
            if (s.equals(un)) {
                pos = i;//定位用户名所在行数
            }
            strName[i] = s;
            i++;
        }
        inOne.close();
        inTwo.close();
        //1、(1)将文件中的密码信息存入数组
        FileReader inOne2 = new FileReader("E:\\java\\idea运行\\wangyi\\password.txt");
        BufferedReader inTwo2 = new BufferedReader(inOne2);
        String s2 = null;
        String[] strPassword = new String[100];
        int j = 0;
        while ((s2 = inTwo2.readLine()) != null) {
            strPassword[j] = s2;
            j++;
        }
        inOne2.close();
        inTwo2.close();

        if (strPassword[pos].equals(pd) && strName[pos].equals(un)) {
            Stage oldstage = (Stage) loginbutton.getScene().getWindow();
            oldstage.close();
            Main_UI main_ui = new Main_UI();
        } else {
            label.setVisible(true);
            usename.setText("");
            password.setText("");
        }

    }

    @FXML
    void logincolse(ActionEvent event) {
        Stage oldstage = (Stage) close.getScene().getWindow();
        oldstage.close();
    }

    @FXML
    void registerAction(ActionEvent event) throws IOException {
        Stage oldstage = (Stage) register.getScene().getWindow();
        oldstage.close();
        Register_UI registerUi = new Register_UI();
    }
}
