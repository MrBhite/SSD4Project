package BookManageSystem.controller;

import BookManageSystem.MainApp;
import BookManageSystem.tools.SimpleTools;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MainFrameController {

    public Button manageBtn;
    public Button insertBtn;
    public Button aboutBtn;
    public Button exitBtn;
    boolean isManage;
    public Button typeBtn;
    public Button bookBtn;
    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private MenuItem bookManageMenuItem;

    @FXML
    public ImageView mainBookManageImageView;

    @FXML
    private AnchorPane mainFrameAnchorPane;

    @FXML
    private MenuItem bookAddMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem bookTypeManageMenuItem;

    @FXML
    private MenuItem aboutSoftMenuItem;

    @FXML
    private MenuItem bookTypeAddMenuItem;

    @FXML
    private AnchorPane mainPane;
    /**
     * 初始化启动
     */
    public void initialize() {

        // 为菜单项添加图标
        simpleTools.setMenuItemImage(
                new MenuItem[]{bookTypeAddMenuItem, bookTypeManageMenuItem, bookAddMenuItem,
                    bookManageMenuItem, exitMenuItem, aboutSoftMenuItem},
                new String[]{"src/BookManageSystem/images/addB.png", "src/BookManageSystem/images/editB.png",
                        "src/BookManageSystem/images/addB.png", "src/BookManageSystem/images/editB.png",
                        "src/BookManageSystem/images/exitB.png", "src/BookManageSystem/images/aboutB.png"},
                new int[]{20,20,20,20,20,20}
        );
        simpleTools.setLabeledImage(new Labeled[]{manageBtn, insertBtn, aboutBtn,exitBtn, typeBtn, bookBtn},
                new String[]{"src/BookManageSystem/images/edit.png","src/BookManageSystem/images/add.png",
                        "src/BookManageSystem/images/about.png","src/BookManageSystem/images/exit.png",
                        "src/BookManageSystem/images/type.png","src/BookManageSystem/images/book.png"},
                new int[]{20,20,20,20,20,20}
        );
        /*// 设置图片
        mainBookManageImageView.setImage(new Image("file:src/BookManageSystem/images/bookmanagesystem.png"));*/
        //设置两个按钮不可见
        typeBtn.setVisible(false);
        bookBtn.setVisible(false);

        isManage = false;

        addClickEffect(mainPane,0);
        addClickEffect(manageBtn,1);
        addClickEffect(insertBtn,1);
        addClickEffect(aboutBtn,1);
        addClickEffect(exitBtn,1);
        addClickEffect(typeBtn,1);
        addClickEffect(bookBtn,1);


    }

    /**
     * “退出”菜单项的事件处理
     *
     * @param event 事件
     */
    public void do_exitMenuItem_vent(ActionEvent event) {
        // 退出菜单项的事件处理
        System.exit(0);
    }

    public void addClickEffect(Node node ,int i){
        node.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                if (i == 1){
                    System.out.println("02");
                    AudioClip audioClip = new AudioClip(getClass().getResource("/sounds/click.wav").toString());
                    audioClip.play();
                }

//                double x = node.getLayoutX() + mouseEvent.getX();
                double x = mouseEvent.getSceneX();
//                double y = node.getLayoutY()+ mouseEvent.getY();
                double y = mouseEvent.getSceneY();

                Circle circle = new Circle(x,y,5);
                circle.setStroke(Color.rgb(33,84,150));
                circle.setFill(Color.color(0,0,0,0));
                circle.setStrokeWidth(2);
                mainPane.getChildren().add(circle);

                ScaleTransition st = new ScaleTransition();
                st.setNode(circle);
                st.setFromX(0);
                st.setFromY(0);
                st.setToX(3);
                st.setToY(3);
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

    /**
     * “图书类别添加”菜单项的事件处理
     *
     * @param event 事件
     */
    public void do_bookTypeAddMenuItem_event(ActionEvent event) {
        AnchorPane pane = new MainApp().initBookTypeAddFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }

    /**
     * “图书类别维护”菜单项的事件处理
     *
     * @param event 事件
     */
    public void do_bookTypeManageMenuItem_event(ActionEvent event) {
        // 当点击“图书类别维护”菜单项后，加载图书类别维护面板
        AnchorPane pane = new MainApp().initBookTypeManageFrame();
        // 清空界面上原有的控件
        mainFrameAnchorPane.getChildren().clear();
        // 将图书类别维护面板添加到界面上
        mainFrameAnchorPane.getChildren().add(pane);
    }

    /**
     * “图书添加”菜单项的事件处理
     * @param event 事件
     */
    public void do_bookAddMenuItem_event(ActionEvent event) {
        // 当点击“图书添加”菜单项后，加载图书添加面板
        AnchorPane pane = new MainApp().initBookAddFrame();
        // 清空界面上原有的控件
        mainFrameAnchorPane.getChildren().clear();
        // 将图书添加面板添加到界面上
        mainFrameAnchorPane.getChildren().add(pane);
    }

    /**
     * “图书维护”菜单项的事件处理
     * @param event 事件
     */
    public void do_bookManageMenuItem_event(ActionEvent event) {
        // 当点击“图书维护”菜单项后，加载图书维护面板
        AnchorPane pane = new MainApp().initBookManageFrame();
        // 清空界面上原有的控件
        mainFrameAnchorPane.getChildren().clear();
        // 将图书维护面板添加到界面上
        mainFrameAnchorPane.getChildren().add(pane);
    }

    public void do_aboutSoftMenuItem_event(ActionEvent event) {
        // 当点击“关于软件”菜单项后，加载弹出框
        new MainApp().initAboutSoftFrame();
    }

    public void manageBtnDown(ActionEvent actionEvent) {
        typeBtn.setText("Manage Type");
        bookBtn.setText("Manage Book");
        typeBtn.setVisible(true);
        bookBtn.setVisible(true);
        isManage = true;
    }

    public void insertBtnDown(ActionEvent actionEvent) {
        typeBtn.setText("Insert Type");
        bookBtn.setText("Insert Book");
        typeBtn.setVisible(true);
        bookBtn.setVisible(true);
        isManage = false;
    }

    public void aboutBtnDown(ActionEvent actionEvent) {
        do_aboutSoftMenuItem_event(actionEvent);
    }

    public void exitBtnDown(ActionEvent actionEvent) {
        do_exitMenuItem_vent(actionEvent);
    }

    public void typeBtnDown(ActionEvent actionEvent) {
        if(isManage){
            do_bookTypeManageMenuItem_event(actionEvent);
        }else {
            do_bookTypeAddMenuItem_event(actionEvent);
        }
    }

    public void bookBtnDown(ActionEvent actionEvent) {
        if(isManage){
            do_bookManageMenuItem_event(actionEvent);
        }else {
            do_bookAddMenuItem_event(actionEvent);
        }
    }
}
