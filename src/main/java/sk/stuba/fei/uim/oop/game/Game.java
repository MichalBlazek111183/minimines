package sk.stuba.fei.uim.oop.game;


import sk.stuba.fei.uim.oop.game.tiles.MineRevealedException;
import sk.stuba.fei.uim.oop.utillity.ZKlavesnice;

public class Game {

    private Board board;

     public Game() {
        this.board = new Board();
    }

    public void play(){
         try {
            while(!this.board.isBoardRevealed()) {
                System.out.println(this.board.draw());
                this.board.reveal(getNextMove());
            }
             } catch (MineRevealedException e) {
                System.out.println("You stepped on a mine!");
                System.out.println(this.board.draw());
         }
        System.out.println("You win");
    }

    private Move getNextMove(){
        char row = ZKlavesnice.readChar(String.format("Enter row (a-%s)\n", (char)('a' + Board.BOARD_SIZE -1)));
        int col = ZKlavesnice.readInt(String.format("Enter column (0-%d)", Board.BOARD_SIZE - 1));
        return new Move(col, row);
    }
}
