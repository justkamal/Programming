package SnakeAndLadders.model;

public class Snake {
    private final int tail;

    public Snake(int tail) {
        this.tail = tail;
    }

    public void swallow(Player player) {
        System.out.println(player.getName() + " got swallowed from " + player.getPosition() + " to " + tail);
        player.setPosition(tail);
    }
}
