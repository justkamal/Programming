package SnakeAndLadders.model;

public class Ladder {
    private final int head;

    public Ladder(int head){
        this.head = head;
    }

    public void climb(Player player) {
        System.out.println(player.getName() + " climbed from " + player.getPosition() + " to " + head);
        player.setPosition(head);
    }
}
