package medium;

import java.util.*;

class FoodRatings {
    public class FoodInfo {
        String food;
        String cuisine;
        int rates;

        public FoodInfo(String food, String cuisine, int rates) {
            this.food = food;
            this.cuisine = cuisine;
            this.rates = rates;
        }

        public void setRates(int rates) {
            this.rates = rates;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FoodInfo foodInfo = (FoodInfo) o;
            return Objects.equals(food, foodInfo.food);
        }

        @Override
        public int hashCode() {
            return Objects.hash(food);
        }
    }

    Map<String, PriorityQueue<FoodInfo>> cuisineMap = new HashMap<>();
    Map<String, FoodInfo> foodInfoMap = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i=0; i<foods.length; i++){
            FoodInfo curFood = new FoodInfo(foods[i],cuisines[i], ratings[i]);
            foodInfoMap.put(foods[i], curFood);
            if (!cuisineMap.containsKey(cuisines[i])){
                PriorityQueue<FoodInfo> foodRatings = new PriorityQueue<>(new Comparator<FoodInfo>() {
                    @Override
                    public int compare(FoodInfo o1, FoodInfo o2) {
                        if (o2.rates == o1.rates) {
                            return o1.food.compareTo(o2.food);
                        }
                        return o2.rates-o1.rates;
                    }
                });

                foodRatings.add(curFood);
                cuisineMap.put(cuisines[i], foodRatings);
            }
            else{
                PriorityQueue<FoodInfo> foodRatings = cuisineMap.get(cuisines[i]);
                foodRatings.add(curFood);
            }
        }

    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodInfoMap.get(food).cuisine;
        FoodInfo foodInfo = foodInfoMap.get(food);
        PriorityQueue<FoodInfo> foodRatings = cuisineMap.get(cuisine);
        foodRatings.remove(foodInfo);
        foodInfo.setRates(newRating);
        foodRatings.add(foodInfo);
        cuisineMap.put(cuisine,foodRatings);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).peek().food;
    }

    public static void main(String[] args) {
        String[] foods = new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisine = new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = new int[]{9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(foods,cuisine,ratings);
        System.out.print(foodRatings.highestRated("korean")); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.
        System.out.print(foodRatings.highestRated("japanese")); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        System.out.print(foodRatings.highestRated("japanese")); // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        System.out.print(foodRatings.highestRated("japanese"));
    }
}
