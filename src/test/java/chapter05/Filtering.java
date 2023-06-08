package chapter05;

import com.exercies.data.entity.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.exercies.chapter05.Menu.menu;
import static com.exercies.chapter05.Menu.specialMenu;
import static java.util.stream.Collectors.toList;

public class Filtering {



    @Test
    @DisplayName("filter()")
    void filter(){
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        vegetarianMenu.forEach(System.out::println);
    }

    @Test
    @DisplayName("distinct()")
    void distinct(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("람다 슬라이드(조건에 맞지 않는게 있다면 추가 탐색 종료, 정렬 해놓고 사용하기 좋음) - takeWhile()")
    void takeWhile(){
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList()); // season fruit, prawns
        slicedMenu1.forEach(System.out::println);
    }

    @Test
    @DisplayName("람다 슬라이드(takeWhile()와 정반대) - dropWhile()")
    void dropWhile(){
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        slicedMenu2.forEach(System.out::println); // rice, chicken, french fries
    }


}
