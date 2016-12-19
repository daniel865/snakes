package co.s4n.snakes.domain;

/**
 * Created by daniel-rua on 15/12/16.
 */
public class Snake {

    private String commando;
    private Integer idSnake;
    private String name;
    private String color;
    private String breed;

    public Snake() {
    }

    public Snake(String commando, Integer idSnake, String name, String color, String breed) {
        this.commando = commando;
        this.idSnake = idSnake;
        this.name = name;
        this.color = color;
        this.breed = breed;
    }

    public String getCommando() {
        return commando;
    }

    public void setCommando(String commando) {
        this.commando = commando;
    }

    public Integer getIdSnake() {
        return idSnake;
    }

    public void setIdSnake(Integer idSnake) {
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
