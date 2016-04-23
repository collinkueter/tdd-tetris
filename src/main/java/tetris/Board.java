// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import java.util.HashMap;

public class Board {

    private final int rows;
    private final int columns;
    private Location currentBlockLocation;
    private HashMap<Location, Block> blocks;

    private boolean isBlockFalling = false;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.currentBlockLocation = null;
        this.blocks = new HashMap<>();
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Location location = new Location(row, col);
                if(blocks.containsKey(location)) {
                    s += blocks.get(location).getLabel();
                }
                else {
                    s += '.';
                }
            }
            s += "\n";
        }
        return s;
    }

    public boolean hasFalling() {
        return this.isBlockFalling;
    }

    public void drop(Block block) {
        if(!this.isBlockFalling) {
            this.isBlockFalling = true;

            // Add the block to the board
            // Start from the top middle
            int middle = rows / 2;
            Location location = new Location(0, middle);
            this.currentBlockLocation = location;
            block.setLocation(location);
            this.blocks.put(location, block);

        } else {
            throw new IllegalStateException("already falling");
        }

    }

    /**
     * Move the Block down one row
     */
    public void tick() {
        if(this.blocks.containsKey(this.currentBlockLocation)) {

            // Check to make sure the block won't hit another block
            if(!this.blocks.containsKey(new Location(this.currentBlockLocation.getRow()+1, this.currentBlockLocation.getCol()))) {

                // Check to make sure the block isn't falling off the bottom
                if(this.currentBlockLocation.getRow() != (this.columns - 1)) {
                    Block block = this.blocks.get(this.currentBlockLocation);
                    this.currentBlockLocation = block.moveDown();
                    this.blocks.put(block.getLocation(), block);
                } else {
                    this.isBlockFalling = false;
                }
            }
            else {
                this.isBlockFalling = false;
            }

        }
    }
}
