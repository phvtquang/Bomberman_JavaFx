package uet.oop.bomberman.utils;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uet.oop.bomberman.BombermanGame;

public class Menu {
    private static ImageView statusGame;
    public static Text level, bomb, time;
    public static int bombNumber = 20;
    public static Text Player1, Player2, Player3, Player4;


    public static void createMenu(Group root) {
        level = new Text("Level: 1");
        level.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        level.setFill(Color.WHITE);
        level.setX(100);
        level.setY(22);
//        bomb = new Text("Bombs: 20");
//        bomb.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//        bomb.setFill(Color.WHITE);
//        bomb.setX(512);
//        bomb.setY(20);
        time = new Text("Times: 120");
        time.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        time.setFill(Color.WHITE);
        time.setX(200);
        time.setY(22);

        Player1 = new Text("Player 1:");
        Player1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Player1.setFill(Color.WHITE);
        Player1.setX(400);
        Player1.setY(22);

        Player2 = new Text("Player 2:");
        Player2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Player2.setFill(Color.WHITE);
        Player2.setX(550);
        Player2.setY(22);

        Player3 = new Text("Player 3:");
        Player3.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Player3.setFill(Color.WHITE);
        Player3.setX(700);
        Player3.setY(22);

        Player4 = new Text("Player 4:");
        Player4.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Player4.setFill(Color.WHITE);
        Player4.setX(850);
        Player4.setY(22);

        Image newGame = new Image("images/pause.png");
        Image playGame = new Image("images/resume.png");
        statusGame = new ImageView(newGame);
        statusGame.setX(20);
        statusGame.setY(0);
        statusGame.setFitHeight(32);
        statusGame.setFitWidth(32);

        Pane pane = new Pane();
        pane.getChildren().addAll(level, time, Player1, Player2, Player3, Player4, statusGame);
        pane.setMinSize(992, 30);
        pane.setMaxSize(2000, 2000);
        pane.setStyle("-fx-background-color: #427235");

        root.getChildren().add(pane);

         statusGame.setOnMouseClicked(event -> {
             System.out.println("CLICKED");
             if (BombermanGame.gameState.equals("running")) {
                 BombermanGame.gameState = "pause";
                 statusGame.setImage(newGame);
             } else {
                 BombermanGame.gameState = "running";
                 statusGame.setImage(playGame);
             }
            });

    }

    public static void updateMenu() {
        level.setText("Level: " + BombermanGame.level);
        time.setText("Time: " + BombermanGame.gameTime--/60);
        Player1.setText("Player 1: " + BombermanGame.score.get(0));
        Player2.setText("Player 2: " + BombermanGame.score.get(1));
        Player3.setText("Player 3: " + BombermanGame.score.get(2));
        Player4.setText("Player 4: " + BombermanGame.score.get(3));
    }
}