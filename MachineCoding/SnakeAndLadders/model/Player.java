package SnakeAndLadders.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private int position;

    public Player(String name){
        this.name = name;
        position = 0;
    }
}
