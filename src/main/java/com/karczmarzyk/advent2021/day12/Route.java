package com.karczmarzyk.advent2021.day12;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Route {
    private List<String> paths;
    private boolean isFinished = false;

    public Route() {
        this.paths = new ArrayList<>();
        this.paths.add("start");
    }

    public String getLastPath(){
        return paths.get(paths.size()-1);
    }

    public Route(List<String> paths) {
        this.paths = new ArrayList<>(paths);
    }

    private boolean canAdd(String name){
        if(Character.isUpperCase(name.charAt(0))){
            return true;
        } else {
            return !name.equals("start") && !paths.contains(name);
        }
    }

    public void addPathName(String pathName){
        if(canAdd(pathName)){
            if(pathName.equals("end")){
                isFinished = true;
            }
            paths.add(pathName);
        }
    }

    @Override
    public String toString() {
        return "Route{" +
                "p=" + paths +
                "," + isFinished +
                '}';
    }
}




