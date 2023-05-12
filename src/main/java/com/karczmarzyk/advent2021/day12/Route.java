package com.karczmarzyk.advent2021.day12;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class Route {
    private List<String> paths;
    private boolean isFinished = false;
    private boolean isNotVisitedTwice = false;

    public Route() {
        this.paths = new ArrayList<>();
        this.paths.add("start");
    }

    public String getLastPath() {
        return paths.get(paths.size() - 1);
    }

    public Route(List<String> paths) {
        this.paths = new ArrayList<>(paths);


    }

    private boolean canAdd(String name) {
        if (Character.isLowerCase(name.charAt(0))) {
            return !name.equals("start");
        }
        return true;
    }

    public void addPathName(String pathName) {
        if (canAdd(pathName)) {
            if (pathName.equals("end")) {
                isFinished = true;
                paths.add(pathName);
                return;
            }
            if (Character.isLowerCase(pathName.charAt(0))) {
                if (paths.contains(pathName)) {
                    long count = countSmall();
                    if (count == 0) {
                        paths.add(pathName);
                        return;
                    }
                } else {
                    paths.add(pathName);
                    return;
                }
            }else {

                paths.add(pathName);
            }

        }
    }

    private long countSmall() {
        return paths.stream().filter(s -> Character.isLowerCase(s.charAt(0)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream().filter(aLong -> aLong == 2).count();
    }

    @Override
    public String toString() {
        return "Route{" +
                "p=" + paths +
                "," + isFinished +
                '}';
    }
}




