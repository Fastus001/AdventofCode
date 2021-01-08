package com.karczmarzyk.advent2020.day20;

import java.util.List;

public class ImageTile {
    private int number = 0;
    private final Tile tile;
    private ImageTile up = null;
    private ImageTile down = null;
    private ImageTile left = null;
    private ImageTile right = null;
    private boolean lock = false;

    public ImageTile(Tile tile) {
        this.tile = tile;
        number = tile.getIdNumber();
    }

    public int checkTile(Tile tile) {
        List<String> allSides = this.tile.getAllSides();
        int counter = 0;
        for (String s : allSides) {
            for (String x : tile.getAllSides()) {
                if ( s.equals( x ) ) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public void joinTiles(ImageTile imageTile) {
        //top
        String row = this.getTile().getRow( 0, false );
        if ( imageTile.getTile().getAllSides().contains( row ) && up == null ) {
            imageTile.attachToRow( this, row, false ) ;
            return;
        }
        row = this.getTile().getRow( 9, false );
        if ( imageTile.getTile().getAllSides().contains( row ) && down == null ) {
            imageTile.attachToRow( this, row, true );
            return;
        }
        String col = this.getTile().getColumn( 0, false );
        if ( imageTile.getTile().getAllSides().contains( col ) && left == null ) {
//            System.out.println("tutaj");
            imageTile.attachToCol( this, col, false ) ;
            return;
        }
        col = this.getTile().getColumn( 9, false );
        if ( imageTile.getTile().getAllSides().contains( col ) && right == null ) {
            System.out.println("tutaj");
            imageTile.attachToCol( this, col, true );
            return;
        }
    }

    private boolean attachToCol(ImageTile imageTile, String col, boolean rightSide) {
        if ( this.lock ) {
            if ( checkCol( imageTile, col, rightSide ) ) {
                return true;
            }
            else {
                System.out.println( "Error tile image Locked!!! - Col" );
            }
        }
        else {
            if ( checkCol( imageTile, col, rightSide ) ) {
                return true;
            }
            else {
                for (int i = 0; i < 5; i++) {
                    this.getTile().rotateLeft();
                    if ( checkCol( imageTile, col, rightSide ) ) {
                        return true;
                    }
                    else {
                        this.getTile().flipHorizontally();
                        if ( checkCol( imageTile, col, rightSide ) ) {
                            return true;
                        }else {
                            this.getTile().flipHorizontally();
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkCol(ImageTile tile, String row, boolean upRow) {
        int num = 0;
        if ( !upRow ) {
            num = 9;
        }
        if ( num == 9 ) {
            if ( this.tile.getColumn( num, false ).equals( row ) ) {
//                System.out.println( "num = " + num );
                this.right = tile;
                tile.left = this;
                this.lock = true;
                return true;
            }
        }
        else {
            if ( this.tile.getColumn( num, false ).equals( row ) ) {
//                System.out.println( "num = " + num );
                this.left = tile;
                tile.right = this;
                this.lock = true;
                return true;
            }
        }
        return false;
    }

    private boolean attachToRow(ImageTile tile, String row, boolean upRow) {
        if ( this.lock ) {
            if ( checkRow( tile, row, upRow ) ) {
                return true;
            }
            else {
                System.out.println( "Error tile image Locked!!!" );
            }
        }
        else {
            if ( checkRow( tile, row, upRow ) ) {
                return true;
            }
            else {
                for (int i = 0; i < 4; i++) {
                    this.getTile().rotateLeft();
                    if ( checkRow( tile, row, upRow ) ) {
                        return true;
                    }
                    else {
                        this.getTile().flipHorizontally();
                        if ( checkRow( tile, row, upRow ) ) {
                            return true;
                        }
                        else {
                            this.getTile().flipHorizontally();
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkRow(ImageTile tile, String row, boolean upRow) {
        int num = 0;
        if ( !upRow ) {
            num = 9;
        }
        if ( num == 9 ) {
            if ( this.tile.getRow( num, false ).equals( row ) ) {
//                System.out.println( "num = " + num );
                this.down = tile;
                tile.up = this;
                this.lock = true;
                return true;
            }
        }
        else {
            if ( this.tile.getRow( num, false ).equals( row ) ) {
//                System.out.println( "num = " + num );
                this.up = tile;
                tile.down = this;
                this.lock = true;
                return true;
            }
        }
        return false;
    }


    public void setNumber(int num) {
        number += num;
    }

    public int getNumber() {
        return number;
    }

    public Tile getTile() {
        return tile;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public boolean isLock() {
        return lock;
    }

    public ImageTile getUp() {
        return up;
    }

    public ImageTile getDown() {
        return down;
    }

    public ImageTile getLeft() {
        return left;
    }

    public ImageTile getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "imgTile{" +
                "no.=" + number;
    }
}
