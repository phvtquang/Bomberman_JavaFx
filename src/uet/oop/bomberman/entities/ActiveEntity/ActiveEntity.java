package uet.oop.bomberman.entities.ActiveEntity;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

// Các entity có animation và thuộc tính đặc biệt nào đó
public abstract class ActiveEntity extends Entity {

    public boolean isDead = false; // ban đầu chưa chết
    public boolean delete = false; // nếu bằng true thì remove entity trong entitylist
    public int animationBeetWeen = 20;    // truyền vào hàm tạo animation
    public Integer scoreValue = 0;

    public ActiveEntity(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public abstract void collide(ActiveEntity entity);
}
