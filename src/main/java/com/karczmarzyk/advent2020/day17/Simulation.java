package com.karczmarzyk.advent2020.day17;

import java.util.List;

public class Simulation {
    public static final int SIZE = 30;
    private boolean[][][] cubes = new boolean[SIZE][SIZE][SIZE];

    public void setCubes(boolean[][][] cubes) {
        this.cubes = cubes;
    }

    public boolean[][][] getCubes() {
        boolean[][][] temp = new boolean[SIZE][SIZE][SIZE];
        for (int z = 0; z < SIZE; z++) {
            for (int x = 0; x < SIZE; x++) {
                for (int y = 0; y < SIZE; y++) {
                    checkNeighbors(x,y,z,temp);
                }
            }
        }
        return temp;
    }

    public void checkNeighbors(int x, int y, int z, boolean[][][] temp){
        int sum = 0;
        for (int i = z-1; i < z+2; i++) {
            for (int j = x-1; j < x+2; j++) {
                for (int k = y-1; k < y+2; k++) {
                    sum +=checkCell(j,k,i);
                }
            }
        }
        sum-=checkCell(x,y,z);

        if(cubes[x][y][z] && (sum>1 && sum<4)){
            temp[x][y][z]=true;
        }else{
            temp[x][y][z]=false;
        }
        if(!cubes[x][y][z] && sum==3){
            temp[x][y][z]=true;
        }
    }

    public int checkCell(int x, int y, int z) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE || z < 0 || z >= SIZE) {
            return 0;
        } else {
            return cubes[x][y][z] ? 1 : 0;
        }
    }


    public void initCube(List<String> in) {
        int start = SIZE / 2 - 1;
        for (int x = -1; x < in.size() - 1; x++) {
            for (int y = -1; y < in.get(x + 1).length() - 1; y++) {
                if (in.get(x + 1).charAt(y + 1) == '#') {
                    findCellAndSetActive(start + x, start + y, start);
                }
            }
        }
    }

    public void findCellAndSetActive(int x, int y, int i) {
        cubes[x][y][i] = true;
    }

    public void show(int z) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                showCell(x, y, z);
            }
            System.out.println();
        }
    }

    private void showCell(int x, int y, int z) {
        if (cubes[x][y][z]) {
            System.out.print("#");
        } else {
            System.out.print(".");
        }
    }

    public int getNumberOfActiveCells(){
        int sum = 0;
        for (int z = 0; z < SIZE; z++) {
            for (int x = 0; x < SIZE; x++) {
                for (int y = 0; y < SIZE; y++) {
                    if(cubes[x][y][z]){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
