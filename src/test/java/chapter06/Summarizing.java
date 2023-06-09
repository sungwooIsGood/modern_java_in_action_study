package chapter06;

import com.exercies.data.entity.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BinaryOperator;

import static com.exercies.chapter05.Menu.menu;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;

public class Summarizing {

    @Test
    @DisplayName("갯수 계산")
    void count(){
        howManyDishes();
    }

    @Test
    @DisplayName("reducing을 이용한 최댓값 구하기")
    void max() throws Exception {
        findMostCaloricDishUsingComparator();
    }

    @Test
    @DisplayName("reducing을 이용한 요약 연산")
    void summing() {
        calculateTotalCalories();
    }

    @Test
    @DisplayName("문자열 연결(StringBuilder)")
    void sumString(){
        getShortMenu();
        getShortMenuCommaSeparated();
    }

    private static long howManyDishes() {
//        return menu.stream().collect(counting());
        return menu.stream().count(); // menu.size();
    }

    private static Dish findMostCaloricDishUsingComparator() throws Exception {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
//       menu.stream().collect(reducing(moreCaloricOf)).get();
        return menu.stream().reduce(moreCaloricOf).orElseThrow(() -> new Exception("객체가 없으면 예외를 던집니다."));
    }

    private static int calculateTotalCalories() {
//      menu.stream().collect(summingInt(Dish::getCalories));
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }

    private static String getShortMenu() {
        return menu.stream().map(Dish::getName).collect(joining());
    }

    private static String getShortMenuCommaSeparated() {
        return menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
