package bird;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import shoot.ShootGame;
import util.Tool;

import java.util.Timer;
import java.util.TimerTask;

//飞扬小鸟的核心类
public class FlyBird extends Group {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 654;
    private static Canvas canvas = new Canvas(ShootGame.WIDTH, ShootGame.HEIGHT);
    private static GraphicsContext gc = canvas.getGraphicsContext2D();
    private static Image background = Tool.readImg("background_b.png");
    private static Image start_b = Tool.readImg("start_b.png");
    private static Image over_b = Tool.readImg("gameover_b.png");
    private Timer timer;
    private Ground ground = new Ground();
    private Column column = new Column(1);
    private Column column2 = new Column(2);
    private Bird bird = new Bird();
    private boolean start = false;
    private boolean gameOver;
    private int score = 0;
    //预先创建声音对象
    static MediaPlayer wing_p = Tool.readMp3("wing.mp3");
    static MediaPlayer scoe_p = Tool.readMp3("point_2.mp3");
    static MediaPlayer over_P = Tool.readMp3("hit_2.mp3");

    public FlyBird() {
        getChildren().add(canvas);
        listener();
    }

    private void listener() {
        canvas.setOnMouseClicked(event -> {
            if (gameOver) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gameOver = false;
                bird = new Bird();
                column = new Column(1);
                column2 = new Column(2);
                ground = new Ground();
                start = false;
                score = 0;
                if (timer == null) {
                    timer();
                }
            } else if (start) {
                bird.v0 = 10;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        wing_p.play();
                        wing_p.seek(Duration.ZERO);
                    }
                }).start();
            } else {
                start = true;
            }
        });
    }

    public void start() {
        timer();
    }

    public void close() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private void timer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (gameOver) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if (over_P != null) {
                                over_P.play();
                                over_P.seek(Duration.ZERO);
                            }
                            gc.drawImage(background, 0, 0);
                            gc.drawImage(over_b, 0, 0);
                            gc.setFont(Font.font("黑体", FontWeight.BOLD, FontPosture.REGULAR, 20));
                            gc.setFill(Color.WHITE);
                            gc.fillText("得分：" + score, 10, 20);
                        }
                    }).start();
                    timer.cancel();
                    timer=null;
                }
                if (start) {
                    ground.move();
                    column.move();
                    column2.move();
                    bird.fly();
                    bird.move();
                    checkScore();
                    if (bird.overFlow(ground) || checkBird()) {
                        gameOver = true;
                        start = false;
                        return;
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //更新JavaFX的主线程的代码放在此处
                            repaint();
                        }
                    });
                } else {
                    gc.drawImage(background, 0, 0);
                    gc.drawImage(start_b, 0, 0);
                    gc.setFont(Font.font("黑体", FontWeight.BOLD, FontPosture.REGULAR, 30));
                    gc.setFill(Color.WHITE);
                    gc.fillText("连续点击鼠标", 120, 410);
                }
            }
        }, 20, 10);
    }

    private void checkScore() {
        if (bird.x == column.x + column.getWidth() || bird.x == column2.x + column2.getWidth()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    scoe_p.play();
                    scoe_p.seek(Duration.ZERO);
                }
            }).start();
            score += 10;
        }
    }

    private boolean checkBird() {
        if (bird.hit(column) || bird.hit(column2)) {
            return true;
        }
        return false;
    }

    private void repaint() {
        gc.drawImage(background, 0, 0);
        gc.drawImage(column.getImage(), column.getX(), column.getY(), column.getWidth(), column.getHeight());
        gc.drawImage(column2.getImage(), column2.getX(), column2.getY(), column2.getWidth(), column2.getHeight());
        gc.drawImage(ground.getImage(), ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());
        gc.drawImage(bird.getImage(), bird.getX(), bird.getY(), 25, 25);
        gc.setFont(Font.font("黑体", FontWeight.BOLD, FontPosture.REGULAR, 20));
        gc.setFill(Color.WHITE);
        gc.fillText("得分：" + score, 10, 20);
    }
}
