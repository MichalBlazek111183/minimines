package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.game.tiles.Empty;

import sk.stuba.fei.uim.oop.game.tiles.MineRevealedException;
import sk.stuba.fei.uim.oop.game.tiles.Tile;

import java.util.ArrayList;
import java.util.List;


public class Board {

    public static final int BOARD_SIZE = 10;

    private Tile[][] board;

    public Board() {
        this.board = new Tile[BOARD_SIZE][BOARD_SIZE];
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.board[i][j] = new Empty();
            }
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (this.board[i][j] instanceof Empty){
                    Empty empty = (Empty) this.board[i][j];
                    List<Tile> orthogonal = new ArrayList<>();
                    if (i - 1 >= 0) {
                        orthogonal.add(this.board[i - 1][j]);
                    }
                    if (i + 1 < BOARD_SIZE) {
                        orthogonal.add(this.board[i + 1][j]);
                    }
                    if (j - 1 >= 0) {
                        orthogonal.add(this.board[i][j - 1]);
                    }
                    if (j + 1 < BOARD_SIZE) {
                        orthogonal.add(this.board[i][j + 1]);
                    }
                    empty.addOrthogonalNeighbours(orthogonal);

                    List<Tile> diagonal = new ArrayList<>();
                    if (i - 1 >= 0) {
                        orthogonal.add(this.board[i - 1][j]);
                    }
                    if (i + 1 < BOARD_SIZE) {
                        orthogonal.add(this.board[i + 1][j]);
                    }
                    if (j - 1 >= 0) {
                        orthogonal.add(this.board[i][j - 1]);
                    }
                    if (j + 1 < BOARD_SIZE) {
                        orthogonal.add(this.board[i][j + 1]);
                    }
                }
            }
        }
    }

    public String draw() {
        StringBuilder builder = new StringBuilder();

        builder.append("  0123456789\n");

        for (int i = 0; i < BOARD_SIZE; i++) {
            builder.append((char) ('a' + i));
            builder.append(" ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                builder.append(this.board[i][j].draw());
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    public void reveal(Move move) throws MineRevealedException {
        this.board[move.y][move.x].reveal();
    }

}
