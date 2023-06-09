package chapter06;

import com.exercies.data.entity.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.exercies.chapter05.Menu.menu;
import static java.util.stream.Collectors.reducing;

public class Reducing {

    @Test
    @DisplayName("범용 리듀싱 요약 연산")
    void summarizingReducing(){
        boolean isSame = calculateTotalCalories1() == calculateTotalCalories2() && calculateTotalCalories1() == calculateTotalCaloriesWithMethodReference();
        System.out.println(isSame);
    }

    private static int calculateTotalCalories1() {
        return menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
    }

    private static int calculateTotalCalories2() {
        return menu.stream().collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }
}
