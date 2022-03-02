package uet.oop.bomberman.entities.ActiveEntity.moveable.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.PD.MobEasy;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Kondoria ăn được vật phẩm- nah, bỏ qua
 */
public class Doll extends Enemy {
    private int randomTimeInterval = 60;     // thời gian giữa mỗi lần random hướng

    public Doll(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        this.speed = 1; // tốc độ cố định là 1
        this.direction = 3;
        this.scoreValue = 15;

        //CREATE BALLOOM ANIMATION
        createMoveUpAnimation(Sprite.doll_left1,Sprite.doll_left2,Sprite.doll_left3);
        createMoveDownAnimation(Sprite.doll_right1,Sprite.doll_right2,Sprite.doll_right3);
        createMoveLeftAnimation(Sprite.doll_left1,Sprite.doll_left2,Sprite.doll_left3);
        createMoveRightAnimation(Sprite.doll_right1,Sprite.doll_right2,Sprite.doll_right3);
    }

    public void moveUP() {
        this.setY(this.getY() - 2);
        this.setImg(Sprite.movingSprite(animationsUP.get(0),animationsUP.get(1),animationsUP.get(2),this.getY(), animationBeetWeen).getFxImage());
    }

    public void moveDOWN() {
        this.setY(this.getY() + 2);
        this.setImg(Sprite.movingSprite(animationsDOWN.get(0),animationsDOWN.get(1),animationsDOWN.get(2),this.getY(), animationBeetWeen).getFxImage());
    }

    public void moveLEFT() {
        this.setX(this.getX() - speed);
        this.setImg(Sprite.movingSprite(animationsLEFT.get(0),animationsLEFT.get(1),animationsLEFT.get(2),this.getX(), animationBeetWeen).getFxImage());
    }

    public void moveRIGHT() {
        this.setX(this.getX() + speed);
        this.setImg(Sprite.movingSprite(animationsRIGHT.get(0),animationsRIGHT.get(1),animationsRIGHT.get(2),this.getX(), animationBeetWeen).getFxImage());
    }

    @Override
    public void update() {

        if (isDead) {
            animationTime--;
            if (animationTime < 0) {
                delete = true; // Xoá
            }
            // Animation ballom chết
            if(animationTime>60) {
                setImg(Sprite.doll_dead.getFxImage());
            } else {
                setImg(Sprite.movingSprite(Sprite.mob_dead1,Sprite.mob_dead2,Sprite.mob_dead3,animationTime,20).getFxImage());
            }
        } else {

            if(this.getY()%Sprite.SCALED_SIZE == 0 && this.getX()%Sprite.SCALED_SIZE == 0) {
                direction = MobEasy.calculateDirection(this.getEXSmallY(),this.getSmallX(), BombermanGame.map);
            }




            if (direction == 0) {
                if (BombermanGame.map[getEXSmallY()][getEXSmallX()] == ' ' && BombermanGame.bombmap[getEXSmallY()][getEXSmallX()] == ' ' ) {
                    moveUP();
                }
            }

            if (direction == 1) {
                if (BombermanGame.map[getEXSmallY()+1][getEXSmallX()] == ' '&& BombermanGame.bombmap[getEXSmallY()+1][getEXSmallX()] == ' ' ){
                    moveDOWN();
                }
            }

            if (direction == 2) {
                if (BombermanGame.map[getEXSmallY()][getEXSmallX()] == ' ' && BombermanGame.bombmap[getEXSmallY()][getEXSmallX()] == ' ' ){
                    moveLEFT();
                }
            }

            if (direction == 3) {
                if (BombermanGame.map[getEXSmallY()][getEXSmallX()+1] == ' ' && BombermanGame.bombmap[getEXSmallY()][getEXSmallX()+1] == ' ' ){
                    moveRIGHT();
                }
            }

        }
    }
}
