package com.karczmarzyk.advent2020.day16;

import java.util.ArrayList;
import java.util.List;

public class TicketValidator {
    private static List<Range> ROUTES = new ArrayList<>();

    public void setRoutes(List<Range> routes) {
        TicketValidator.ROUTES = routes;
    }
    
    public static int getNotValidFields(int[] nearbyTickets){
        for (int nearbyTicket : nearbyTickets) {
            if (!isValid(nearbyTicket)) {
                return nearbyTicket;
            }
        }
        return 0;
    }
    
    
    private static boolean isValid(int num){
        for(Range r: ROUTES){
            if(r.isValid(num)){
                return true;
            }
        }
        return false;
    }
    //part two
    public static List<int[]> getValidNearbyTickets(List<int[]> tickets){
        List<int []> temp = new ArrayList<>();
        for(int[] tab:tickets){
            if(getNotValidFields(tab)==0){
                temp.add(tab);
            }
        }
        return temp;
    }

    public int checkDataColumnWithTheRanges(int [] column){
        boolean check = true;
        int counter = 0;
        int test = 0;
        for (int i = 0; i < ROUTES.size(); i+=2) {
            for (int x : column) {
                if (!ROUTES.get(i).isValid(x) && !ROUTES.get(i + 1).isValid(x)) {
                    check = false;
                    break;
                }
            }
            if(check){
                counter++;
                test = i/2;
            }else{
                check = true;
            }
        }
        if(counter==1){
            System.out.println("test = " + (test+1));
        }
        return counter;
    }
    
    
}
