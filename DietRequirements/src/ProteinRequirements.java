import java.util.*;

public class ProteinRequirements {

    // takes user's weight as input and calculates average protein needed per day
    public static double ProteinNeeded(){
        Scanner sc = new Scanner(System.in);
        double weight = 0.0;
        boolean valid = false;

        while(!valid) {     // ensures user enters a number
            try {
                weight = Double.parseDouble(sc.nextLine());     // takes weight as input from user
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }

        double proteinNeededLower = 1.6 * weight;
        double proteinNeededUpper = 2.2 * weight;
        return (proteinNeededLower + proteinNeededUpper) / 2;

    }

    // allows user to enter the food they ate for breakfast and calculates total protein consumed
    public static double itemsInputBreakfast(int foodNumber) {
        Scanner sc = new Scanner(System.in);
        double breakfastProteinConsumed = 0.0;

        while (foodNumber != 0) {   // once zero entered, method ends
            if(foodNumber < 0 || foodNumber > 4) {      // ensures user enters a number between 0 and 4
                throw new NumberFormatException("Enter a number between 0 and 4");
            } else {
                System.out.println("How many of this item did you eat/ servings");
                int itemAmount = sc.nextInt();
                double proteinAmount = ProteinForBreakfast(foodNumber) * itemAmount;    // calculates how much was consumed for inputted item
                breakfastProteinConsumed += proteinAmount;                              // total protein consumed for breakfast
                System.out.println("Enter the number of the next food or '0' to move on");
                foodNumber = sc.nextInt();
            }
        }

        return breakfastProteinConsumed;
    }

    // allows the user to enter the food they ate for lunch and calculates total protein consumed
    public static double itemInputLunch(int foodNumber){
        Scanner sc = new Scanner(System.in);
        double lunchProteinConsumed = 0.0;

        while (foodNumber != 0) {
            if(foodNumber < 5 || foodNumber > 10) {
                throw new NumberFormatException("Enter a number between 5 and 10");
            } else {
                System.out.println("How many of this item did you eat/ servings");
                int itemAmount = sc.nextInt();
                double proteinAmount = ProteinForLunch(foodNumber) * itemAmount;
                lunchProteinConsumed += proteinAmount;
                System.out.println("Enter the number of the next food or '0' to move on");
                foodNumber = sc.nextInt();
            }
        }
        return lunchProteinConsumed;
    }

    // allows the user to enter the food they ate for dinner and calculates total protein consumed
    public static double itemInputDinner(int foodNumber){
        Scanner sc = new Scanner(System.in);
        double dinnerProteinConsumed = 0.0;

        while (foodNumber != 0) {
            if(foodNumber < 11 || foodNumber > 16) {
                throw new NumberFormatException("Enter a number between 11 and 16");
            } else {
                System.out.println("How many of this item did you eat/ servings");
                int itemAmount = sc.nextInt();
                double proteinAmount = ProteinForDinner(foodNumber) * itemAmount;    // calculates how much was consumed for inputted item
                dinnerProteinConsumed += proteinAmount;      // total protein consumed for dinner
                System.out.println("Enter the number of the next food or '0' to move on");
                foodNumber = sc.nextInt();
            }
        }
        return dinnerProteinConsumed;
    }

    // returns the amount of protein in each piece of food for breakfast
    public static double ProteinForBreakfast(int food){
        double scrambledEgg = 6.0;
        double boiledEgg = 6.0;
        double beans = 8.5;
        double bread = 2.7;

        if (food == 1) {
            return scrambledEgg;
        } else if (food == 2) {
            return boiledEgg;
        } else if (food == 3) {
            return beans;
        } else if (food == 4) {
            return bread;
        }
        return 0.0;
    }

    // returns the amount of protein in each piece of food for lunch
    public static double ProteinForLunch(int food){
        double chickenFillet = 20;
        double chickenGoujon = 14.1;
        double rice = 3.4;
        double honeyChicken = 25;
        double wrap = 72;
        double grilledCheese = 53.4;

        if (food == 5) {
            return chickenFillet;
        } else if (food == 6) {
            return chickenGoujon;
        } else if (food == 7) {
            return rice;
        } else if (food == 8) {
            return honeyChicken;
        } else if (food == 9) {
            return wrap;
        } else if (food == 10) {
            return grilledCheese;
        }
        return 0.0;
    }

    // returns the amount of protein in each piece of food for dinner
    public static double ProteinForDinner(int food){
        double potato = 3;
        double gammon = 22;
        double chicken = 25;
        double spaghettiBolognese = 27.1;
        double beef = 26;
        double steak = 45;

        if (food == 11) {
            return potato;
        } else if (food == 12) {
            return gammon;
        } else if (food == 13) {
            return chicken;
        } else if (food == 14) {
            return spaghettiBolognese;
        } else if (food == 15) {
            return beef;
        } else if (food == 16) {
            return steak;
        }
        return 0.0;
    }

    // checks if user had protein powder or not.
    public static int proteinPowder(String userInput){
        String userInputLowercase = userInput.toLowerCase();    // ensures answer is in lower case

        if(!userInput.equals("yes") && !userInput.equals("no")) {       // ensures user enters the correct word
            throw new NumberFormatException("Please enter a valid answer 'yes' or 'no'");
        } else {
            if (userInputLowercase.equals("yes")) {
                return 20;  // amount of protein in a cup
            } else if (userInputLowercase.equals("no")) {
                return 0;
            }
        }
        return 0;
    }

    // calculates if protein goal met and how much is left to eat
    public static void proteinLeftToConsume(double proteinNeeded, double proteinConsumed){
        if (proteinConsumed >= proteinNeeded){
            System.out.println("You have reached your protein goal. Congratulations");
        } else {
            double proteinLeft = proteinNeeded - proteinConsumed;
            System.out.println("You have " + String.format("%.2f", proteinLeft) + "g of protein left to consume");
        }
    }

    public static void main(String[] args) {
        // Entry to page
        System.out.println("Welcome to the protein requirements app");
        System.out.println("Please enter your weight in kilograms");

        // input for weight and calls method to calculate amount of protein needed
        Scanner sc = new Scanner(System.in);
        double proteinNeeded = ProteinNeeded();
        System.out.println("Your daily protein goal is: " + String.format("%.2f", proteinNeeded) + "g");

        // Presents list to user of food available for breakfast
        System.out.println("\nFrom the list below please enter the corresponding number for an piece of food you had for breakfast");
        System.out.println("1: scrambled egg\n2: boiled egg\n3: beans\n4: bread\n0: Finished entering breakfast details");

        // takes input for food consumed
        int foodNumber = sc.nextInt();
        double proteinConsumed = 0.0;       // initialise total protein consumed
        boolean valid = false;
        while(!valid){
            try {
                proteinConsumed += itemsInputBreakfast(foodNumber);        // adds protein of each item entered onto total
                valid = true;
            } catch (NumberFormatException e){      // catches error if method throws it
                System.out.println(e.getMessage());
                foodNumber = sc.nextInt();
            }
        }

        // Presents list to user of food available for lunch
        System.out.println("\nFrom the list below please enter the corresponding number for an piece of food you had for lunch");
        System.out.println("5: chicken fillet\n6: chicken goujon\n7: rice\n8: honey chicken\n9: wrap\n10: grilled cheese\n0: Finished entering lunch");

        foodNumber = sc.nextInt();
        valid = false;

        while(!valid){
            try {
                proteinConsumed += itemInputLunch(foodNumber);
                valid = true;
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
                foodNumber = sc.nextInt();
            }
        }

        // Presents list to user of food available for dinner
        System.out.println("\nFrom the list below please enter the corresponding number for an piece of food you had for dinner");
        System.out.println("11: potato\n12: gammon\n13: chicken\n14: spaghetti\n15: beef\n16: steak\n0: Finished entering dinner");

        foodNumber = sc.nextInt();
        valid = false;

        while(!valid){
            try {
                proteinConsumed += itemInputDinner(foodNumber);
                valid = true;
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
                foodNumber = sc.nextInt();
            }
        }


        // checks if user had protein powder.
        System.out.println("Have you had protein powder today. Type 'yes' or 'no'.");
        Scanner scNew = new Scanner(System.in);     // new scanner for string input
        String userInput = scNew.nextLine();
        valid = false;

        while(!valid){
            try {
                proteinConsumed += proteinPowder(userInput);   // adds content onto total
                valid = true;
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
                userInput = scNew.nextLine();       // continues to take input until the user enters the correct one.
            }
        }

        // Displays total protein consumed
        System.out.println("You have consumed " + String.format("%.2f", proteinConsumed) + "grams of protein today");

        // calls method that prints if protein goal met or not and how much is left to eat.
        proteinLeftToConsume(proteinNeeded, proteinConsumed);

    }
}