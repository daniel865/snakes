package co.s4n.snakes.infrastructure.dao;

/**
 * Created by daniel-rua on 15/12/16.
 */
public class SnakeRecord {

    int idSnake;
    String name;
    String color;
    String breed;

    public SnakeRecord(int idSnake, String name, String color, String breed) {
        this.idSnake = idSnake;
        this.name = name;
        this.color = color;
        this.breed = breed;
    }

    public SnakeRecord() {
    }

    public int getIdSnake() {
        return idSnake;
    }

    public void setIdSnake(int idSnake) {
        this.idSnake = idSnake;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
