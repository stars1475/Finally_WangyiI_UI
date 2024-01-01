package Register;

import Main.Main_UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logon.Log_UI;

import java.io.*;

public class Register_UI_Controller {

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
    private Button RetrunBack;

    @FXML
    void ReturnBackAttion(ActionEvent event) throws IOException {
        Stage oldstage = (Stage) RetrunBack.getScene().getWindow();
        oldstage.close();
        Log_UI logUi = new Log_UI();
    }

    @FXML
    void loginbuttonOnAction(ActionEvent event) throws IOException {
        int iscontinue = 1;
        String un = usename.getText();
        String pd = password.getText();
        FileReader inOne = new FileReader("E:\\java\\idea运行\\wangyi\\usename.txt");
        BufferedReader inTwo = new BufferedReader(inOne);
        String s = null;
        String[] newName = new String[100];
        int i = 0;
        int pos = 0;
        while ((s = inTwo.readLine()) != null) {
            if (s.equals(un))//发现相同的名字给出提示
            {
                label.setVisible(true);
                iscontinue = 0;
                break;
            }
        }
        if (iscontinue == 1) {
            //将用户信息存入文件
            //创建用户姓名文件
            File file = new File("E:\\java\\idea运行\\wangyi\\usename.txt");
            FileOutputStream fos = null;
            OutputStreamWriter osw = null;
            if (!file.exists()) {
                boolean hasFile = file.createNewFile();
                if (hasFile) {
                    System.out.println("file not exists, create new file");
                }
                fos = new FileOutputStream(file);
            } else {
                System.out.println("file exists");
                fos = new FileOutputStream(file, true);
                osw = new OutputStreamWriter(fos, "gbk");
                osw.write(un);
                osw.write("\r\n");
            }
            //创建用户密码文件
            File file2 = new File("E:\\java\\idea运行\\wangyi\\password.txt");
            FileOutputStream fos2 = null;
            OutputStreamWriter osw2 = null;
            if (!file.exists()) {
                boolean hasFile2 = file2.createNewFile();
                if (hasFile2) {
                    System.out.println("file not exists, create new file");
                }
                fos2 = new FileOutputStream(file2);
            } else {
                System.out.println("file exists");

                fos2 = new FileOutputStream(file2, true);
            }
            osw2 = new OutputStreamWriter(fos2, "gbk");
            osw2.write(pd);
            osw2.write("\r\n");
            osw.close();
            fos.close();
            osw2.close();
            fos2.close();
            Stage oldstage = (Stage) loginbutton.getScene().getWindow();
            oldstage.close();
            Log_UI logUi = new Log_UI();
        }
    }

    @FXML
    void logincolse(ActionEvent event) {
        Stage oldstage = (Stage) close.getScene().getWindow();
        oldstage.close();
    }

}
