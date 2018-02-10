package us.mattgreen;

import java.util.ArrayList;

/**
 * @author  Nic Crespo
 * @version 2017.3.3
 */
public class MealsArray {
    private ArrayList<Meals> meals = new ArrayList<>();
    //private int i = 0;
    private int calories;

    /**
     *
     * @param arg1  mealtype
     * @param arg2  the actual item from the database
     * @param arg3  matches something?
     */
    public void addElementWithStrings(String arg1, String arg2, String arg3) {
        MealType mealType;
        if (meals != null) {

            switch (arg1) {
                case "Breakfast":
                    mealType = MealType.BREAKFAST;
                    break;
                case "Lunch":
                    mealType = MealType.LUNCH;
                    break;
                case "Dinner":
                    mealType = MealType.DINNER;
                    break;
                case "Dessert":
                    mealType = MealType.DESSERT;
                    break;
                default:
                    mealType = MealType.DINNER;
                    System.out.println("Invalid Meal Type " + arg1 + ", defaulted to Dinner.");
            }

            if (arg3.matches("-?\\d+(\\.\\d+)?")) {
                calories = Integer.parseInt(arg3);
            } else {
                calories = 100;
                System.out.println("Invalid Calories " + arg3 + ", defaulted to 100.");
            }
            //meals[i++] = new Meals(mealType, arg2, calories);
            meals.add(new Meals(mealType, arg2, calories));
        }
    }

    /**
     *
     * @return  returns meals
     */
    public ArrayList<Meals> getMeals() {
        return meals;
    }


    public void printAllMeals() {
        for (Meals item: meals) {
            if (item != null) {
                System.out.println(item);
            }

        }
    }

    /**
     *
     * @param mealType  the meal type
     */
    public void printMealsByType(MealType mealType) {
        for (Meals item: meals) {
            if (item != null && item.getMealType() == mealType) {
                System.out.println(item);
            }

        }
    }

    /**
     *
     * @param s user input of item to search for
     */
    public void printByNameSearch(String s) {
        for (Meals item: meals) {
            if (item != null && item.getItem().contains(s)) {
                System.out.println(item);
            }

        }
    }
}
