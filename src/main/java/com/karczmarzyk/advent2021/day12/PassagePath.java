package com.karczmarzyk.advent2021.day12;

import java.util.*;
import java.util.stream.Collectors;

public class PassagePath {
    private int COUNTER = 1;
    private final Map<String, Cave> caves = new HashMap<>();
    private List<Route> routes = new ArrayList<>();
    private List<Route> routesFinished = new ArrayList<>();

    public PassagePath(List<String> input) {
        input.forEach(this::parseAndCreate);
        routes.add(new Route());

    }

    public void compute(){
        routesFinished.addAll(routes.stream().filter(Route::isFinished).toList());
        routes = routes.stream().filter(r->!r.isFinished()).collect(Collectors.toList());
        routes = routes.stream().map(this::generateRoutes)
                    .flatMap(Collection::stream)
                    .filter(route -> route.getPaths().size()>COUNTER)
                    .collect(Collectors.toList());
        COUNTER++;
    }


    public List<Route> generateRoutes(Route route){
        Cave cave = caves.get(route.getLastPath());
        return cave.getConnections().stream().map(s->{
            Route route1 = new Route(route.getPaths());
            route1.addPathName(s);
            return route1;
        }).collect(Collectors.toList());
    }

    public int getSizeOfRoutes(){
        return routes.size();
    }

    public int numberOfRoutes(){
        return routesFinished.size();
    }

    private void parseAndCreate(String input){
        String[] split = input.split("-");
        createCaveOrAddConnection(split[0], split[1]);
        createCaveOrAddConnection(split[1], split[0]);
    }

    private void createCaveOrAddConnection(String first, String second){
        Cave cave = caves.get(first);
        if(cave != null){
            cave.addConnection(second);
        } else {
            if(Character.isUpperCase(first.charAt(0))){
                caves.put(first, new Cave(first,Cave.Size.BIG, second));
            }else {
                caves.put(first, new Cave(first,Cave.Size.SMALL, second));
            }
        }
    }
}
