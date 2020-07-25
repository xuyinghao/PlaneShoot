import bird.FlyBird;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import shoot.ShootGame;
import util.Tool;

public class Main extends Application {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 654;
    private static Image background = Tool.readImg("main2.jpg");

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("shoot/plane.fxml"));
        primaryStage.setTitle("小游戏");
        Pane pane = (Pane) root;
        pane.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        ObservableList<Node> children = ((Pane) root).getChildren();
        Button plane = (Button) children.get(1);
        plane.setOnAction(event -> {
            Stage plane_Main = new Stage();
            ShootGame game = new ShootGame();
            game.start();
            game.setCursor(Cursor.HAND);
            Scene scene = new Scene(game, WIDTH, HEIGHT);
            plane_Main.setScene(scene);
            plane_Main.setTitle("飞机大战");
            plane_Main.getIcons().add(Tool.readImg("own1.png"));
            plane_Main.setWidth(WIDTH);
            plane_Main.setHeight(HEIGHT);
            plane_Main.setResizable(false);
            plane_Main.setAlwaysOnTop(true);
            plane_Main.show();
            primaryStage.hide();
            plane_Main.setOnCloseRequest(event1 -> {
                game.close();
                primaryStage.show();
            });
        });
        Button bird = (Button) children.get(2);
        bird.setOnAction(event -> {
            Stage plane_Main = new Stage();
            FlyBird game = new FlyBird();
            game.start();
            game.setCursor(Cursor.HAND);
            Scene scene = new Scene(game, WIDTH, HEIGHT);
            plane_Main.setScene(scene);
            plane_Main.setTitle("FlyBird");
            plane_Main.getIcons().add(Tool.readImg("0.png"));
            plane_Main.setAlwaysOnTop(true);
            plane_Main.setWidth(WIDTH);
            plane_Main.setHeight(HEIGHT);
            plane_Main.setResizable(false);
            plane_Main.show();
            primaryStage.hide();
            plane_Main.setOnCloseRequest(event1 -> {
                game.close();
                primaryStage.show();
            });
        });
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.getIcons().add(Tool.readImg("game.png"));
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
