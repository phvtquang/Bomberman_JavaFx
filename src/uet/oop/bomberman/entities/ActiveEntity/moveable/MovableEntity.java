package uet.oop.bomberman.entities.ActiveEntity.moveable;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.ActiveEntity.ActiveEntity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Các vật thể di chuyển được sẽ được kế thừa từ class này
 * Có thêm thuộc tính là tốc độ di chuyển
 * Có thêm 4 arraylist chứa các SPRITE phục vụ cho việc tạo hoạt ảnh: up down left right
 */
public abstract class MovableEntity extends ActiveEntity {

    public int speed;   // tốc độ di chuyển

    protected List<Sprite> animationsUP = new ArrayList<>();    // sprite tạo hoạt ảnh đi lên
    protected List<Sprite> animationsDOWN = new ArrayList<>();  // sprite tạo hoạt ảnh đi xuống
    protected List<Sprite> animationsLEFT = new ArrayList<>();  // sprite tạo hoạt ảnh sang trái
    protected List<Sprite> animationsRIGHT = new ArrayList<>(); // sprite tạo hoạt ảnh đi sang phải

    public MovableEntity(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        this.speed = 1;     // nếu không có gì đặc biệt thì di chuyển với tốc độ 1, có thể thay đổi ở các lớp con
    }

    public void createMoveUpAnimation(Sprite sprite1,Sprite sprite2, Sprite sprite3) {
        animationsUP.add(sprite1);
        animationsUP.add(sprite2);
        animationsUP.add(sprite3);
    }

    public void createMoveDownAnimation(Sprite sprite1,Sprite sprite2, Sprite sprite3) {
        animationsDOWN.add(sprite1);
        animationsDOWN.add(sprite2);
        animationsDOWN.add(sprite3);
    }

    public void createMoveLeftAnimation(Sprite sprite1,Sprite sprite2, Sprite sprite3) {
        animationsLEFT.add(sprite1);
        animationsLEFT.add(sprite2);
        animationsLEFT.add(sprite3);
    }

    public void createMoveRightAnimation(Sprite sprite1,Sprite sprite2, Sprite sprite3) {
        animationsRIGHT.add(sprite1);
        animationsRIGHT.add(sprite2);
        animationsRIGHT.add(sprite3);
    }

    public abstract void moveUP();
    public abstract void moveDOWN();
    public abstract void moveLEFT();
    public abstract void moveRIGHT();

    /**
     * Kiểm tra có đi vào được ô canvas x,y không
     * @param x toạ độ canvas x
     * @param y toạ độ canvas y
     * @param map mảng 2 chiều map
     * @return true nếu đi được, false nếu không
     */
    public static boolean canMove(int x,int y, char[][] map) {
        return map[y/ Sprite.SCALED_SIZE][x/Sprite.SCALED_SIZE] != '#'
                && map[y/ Sprite.SCALED_SIZE][x/Sprite.SCALED_SIZE] != '*'
                && map[y/ Sprite.SCALED_SIZE][x/Sprite.SCALED_SIZE] != '%';
    }

    @Override
    public void update() {

    }
}
