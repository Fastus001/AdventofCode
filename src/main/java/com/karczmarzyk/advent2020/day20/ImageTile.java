package com.karczmarzyk.advent2020.day20;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ImageTile {
    private int number;
    private final Tile tile;
    private boolean lock = false;
    private Pair xy = null;

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
        if ( imageTile.getTile().getAllSides().contains( row )  ) {
            imageTile.attachTo( this, row, true ); ;
            return;
        }
        String col = this.getTile().getColumn( 0, false );
        if ( imageTile.getTile().getAllSides().contains( col ) ) {
            imageTile.attachTo( this, col, false ); ;
        }
    }

    private void attachTo(ImageTile imageTile, String line, boolean row) {
        if ( !this.lock ) {
            for (int i = 0; i < 4; i++) {
                this.getTile().rotateLeft();
                if(!row){
                    if ( checkCol( imageTile, line ) ) {
                        return;
                    }else {
                        this.getTile().flipHorizontally();
                        if ( checkCol( imageTile, line) ) {
                            return;
                        }else {
                            this.getTile().flipHorizontally();
                        }
                    }
                }else{
                    if ( checkRow( imageTile, line) ) {
                        return;
                    }
                    else {
                        this.getTile().flipHorizontally();
                        if ( checkRow( imageTile, line) ) {
                            return;
                        }
                        else {
                            this.getTile().flipHorizontally();
                        }
                    }
                }
            }
        }
    }

    private boolean checkCol(ImageTile tile, String row) {
              if ( this.tile.getColumn( 9, false ).equals( row ) ) {
                this.lock = true;
                if(this.xy==null){
                    this.setXy( new Pair( tile.getXy().getRow(), tile.getXy().getCol()-1 ));
                }
                return true;
            }
        return false;
    }

    private boolean checkRow(ImageTile tile, String row) {
               if ( this.tile.getRow( 9, false ).equals( row ) ) {
                this.lock = true;
                if(this.xy==null){
                    this.setXy( new Pair( tile.getXy().getRow()-1, tile.getXy().getCol() ));
                }
                return true;
            }
        return false;
    }

    public void setNumber(int num) {
        number += num;
    }

    @Override
    public String toString() {
        return "imgTile{" +
                "no.=" + number;
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Pair{
    private int row;
    private int col;

}
