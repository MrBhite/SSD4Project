package BookManageSystem.controller;

import BookManageSystem.tools.SimpleTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SoftInformationFrameController {
    private Stage dialogStage;

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private Hyperlink hyperlink;

    @FXML
    private ImageView imageView;

    @FXML // 初始化界面
    public void initialize() {

        // 初始化链接组件的超链接
        hyperlink.setText("相关GitHub链接");
        // 设置图片
        imageView.setImage(new Image("file:src/BookManageSystem/images/logo.png"));
    }

    // “关闭”按钮的事件监听器
    public void closeButtonEvent(ActionEvent event) {
        dialogStage.close();
    }

    // 超链接的事件监听器
    public void hyperlinkEvent(ActionEvent event) throws URISyntaxException, IOException {
        // 调用电脑本地的浏览器打开网址
        Desktop.getDesktop().browse(new URI("#"));
    }
}
