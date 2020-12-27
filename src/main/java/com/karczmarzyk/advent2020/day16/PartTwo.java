package com.karczmarzyk.advent2020.day16;

import java.io.IOException;
import java.util.List;

public class PartTwo {

    public static void main(String[] args) throws IOException {
        TicketValidator ticketValidator = new TicketValidator();
        InputDataValidator validator = new InputDataValidator();
        ticketValidator.setRoutes(validator.getListOfRanges("src/main/resources/2020/day16/ticketFields.txt"));
        List<int[]> nearbyTickets = validator.getNearbyTickets("src/main/resources/2020/day16/nearbyTickets.txt");
        List<int[]> validNearbyTickets = TicketValidator.getValidNearbyTickets(nearbyTickets);

        for (int i = 0; i < 20; i++) {
            int[] column = validator.getColumn(validNearbyTickets, i);
            int result = ticketValidator.checkDataColumnWithTheRanges(column);
            System.out.println("column = " + (i+1) +"result = " + result);
        }
    }
}
