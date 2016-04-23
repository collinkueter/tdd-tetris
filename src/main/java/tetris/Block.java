// Copyright (c) 2008-2016  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * Created by collinkueter on 4/8/16.
 */
public class Block {

    private final char label;
    private Location location;

    public Block(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location moveDown() {
        this.location.setRow(this.location.getRow()+1);
        return this.location;
    }
}
