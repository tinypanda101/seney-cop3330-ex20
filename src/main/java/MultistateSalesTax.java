/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Seney
 */

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MultistateSalesTax {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the order amount? ");
        String orderAmount = scanner.next();

        System.out.print("What state do you live in ");
        String state = scanner.next();

        String county = "";
        if (state.equals("Wisconsin")){
            System.out.print("What county do you live in? ");
            county = scanner.next();
        }

        double tax = 0;
        double total;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        if (state.equals("Illinois")){
            tax = Integer.parseInt(orderAmount) * 0.08;
        }

        if (state.equals("Wisconsin")){
            tax = Integer.parseInt(orderAmount) * 0.05;
            if (county.equals("Eau Claire")){
                tax = tax + (Integer.parseInt(orderAmount) * 0.005);
            }
            if (county.equals("Dunn")){
                tax = tax + (Integer.parseInt(orderAmount) * 0.004);
            }
        }

        total = Integer.parseInt(orderAmount) + tax;
        String output = "";

        if (tax > 0){
             output = "The tax is $" + tax + ".\nThe total is $" + total + ".";
        }
        else{
             output = "The total is $" + total + ".";
        }

        System.out.print(output);
    }
}
