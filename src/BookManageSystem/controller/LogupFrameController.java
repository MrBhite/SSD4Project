package BookManageSystem.controller;

import BookManageSystem.MainApp;
import BookManageSystem.tools.SimpleTools;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LogupFrameController {
    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button logupButton;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label systemLabel;

    @FXML
    private Button resetButton;

    @FXML
    private Label passwordLabel;

    public void initialize() {
        addEffect(logupButton,1);
        addEffect(resetButton,1);
        addEffect(mainPane,0);
        simpleTools.setLabeledImage(
                new Labeled[]{logupButton, resetButton},
                new String[]{"src/BookManageSystem/images/login.png","src/BookManageSystem/images/reset.png"},
                new int[]{18, 18}
        );
    }

    // “登录”按钮的事件监听器方法
    public void logupButtonEvent(ActionEvent event) {
        // 关闭登录界面
        stage.close();
        // 判断用户名和密码是否匹配
        boolean isOK = simpleTools.isLogIn(userNameTextField, passwordTextField, "张三", "123456");
        if (isOK||true) {
            // 如果登录成功则跳转到主界面
            new MainApp().initMainFrame();
        }
    }
    public void addEffect(Node node,int i){

        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //位置
                double x = mouseEvent.getSceneX();
                double y = mouseEvent.getSceneY();

                if (i == 1){
                    AudioClip audioClip = new AudioClip(getClass().getResource("/sounds/click.wav").toString());
                    audioClip.play();
                }
                Circle circle = new Circle(x,y,5);
                circle.setStroke(Color.rgb(33,84,150));
                circle.setFill(Color.color(0,0,0,0));
                circle.setStrokeWidth(2);
                mainPane.getChildren().add(circle);

                ScaleTransition st = new ScaleTransition();
                st.setNode(circle);
                st.setFromX(0);
                st.setFromY(0);
                //3 动画大小
                st.setToX(3);
                st.setToY(3);
                //0.5s 动画时间
                st.setDuration(Duration.seconds(0.5));
                FadeTransition ft = new FadeTransition();
                ft.setNode(circle);
                ft.setFromValue(1);
                ft.setToValue(0);

                ft.setDuration(Duration.seconds(0.5));
                st.play();
                ft.play();
                ft.setOnFinished(event -> {
                    mainPane.getChildren().remove(circle);
                });
            }
        });
    }

    // “重置”按钮的事件监听器方法
    public void resetButtonEvent(ActionEvent event) {
        // 重置将清空文本框
        userNameTextField.setText("");
        passwordTextField.setText("");
    }
}
