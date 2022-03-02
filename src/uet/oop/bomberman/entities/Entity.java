package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Entity {

    public boolean show = true; // nếu bằng true thì render ra

    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    //Hình ảnh lấy từ SpriteSheet
    protected Image img;

    //Lấy ra toạ độ x trên Canvas
    public int getX() {
        return x;
    }

    //Set toạ độ x trên canvas
    public void setX(int x) {
        this.x = x;
    }

    //Lấy ra toạ độ y trên canvas
    public int getY() {
        return y;
    }

    //Set toạ độ y trên canvas
    public void setY(int y) {
        this.y = y;
    }

    //Lấy hình ảnh ?? chưa thấy dùng ở đâu cả
    public Image getImg() {
        return img;
    }

    //Set hình ảnh , để tạo ra hoạt ảnh chuyển động cho vật thể
    public void setImg(Image img) {
        this.img = img;
    }

    //Từ toạ độ x trên canvas -> toạ độ đơn vị trên MAP , có vài việc cần làm
    public int getSmallX() {
        return (x+(Sprite.SCALED_SIZE/2))/Sprite.SCALED_SIZE;
    }

    //Từ toạ độ y canvas -> toạ độ đơn vị trên MAP , có vài việc cần làm
    public int getSmallY(){
        return (y+(Sprite.SCALED_SIZE/2))/Sprite.SCALED_SIZE;
    }

    public int getEXSmallX() {
        return (x)/Sprite.SCALED_SIZE;
    }

    //Từ toạ độ y canvas -> toạ độ đơn vị trên MAP , có vài việc cần làm
    public int getEXSmallY(){
        return (y)/Sprite.SCALED_SIZE;
    }

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE; // don vi sang canvas
        this.y = yUnit * Sprite.SCALED_SIZE; // don vi sang canvas
        this.img = img;
    }

    //Render đối tượng lên canvas
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    //Update các thuộc tính của đối tượng theo thời gian
    //được cài đặt khác nhau tuỳ vào đối tượng
    public abstract void update();
}
