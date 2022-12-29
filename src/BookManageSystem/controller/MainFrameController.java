package BookManageSystem.controller;

import BookManageSystem.MainApp;
import BookManageSystem.tools.SimpleTools;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
