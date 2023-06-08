package chapter05;

import com.exercies.data.entity.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.exercies.chapter05.Menu.menu;

public class Finding {

    @Test
    @DisplayName("검색과 매칭에 필요한 메서드")
    void find(){
        if (isVegetarianFriendlyMenu() /*isHealthyMenu()*/ /*isHealthyMenu2*/ ) {
            System.out.println("참입니다~");
        }

        Optional<Dish> dish = findVegetarianDish(); // 요소 검색
        dish.ifPresent(d -> System.out.println(d.getName()));

        List<Integer> someNumber = Arrays.asList(1,2,3,4,5);
        Optional<Integer> first = someNumber.stream().map(n -> n * n).filter(n -> n % 3 == 0).findFirst(); // 첫번째 요소 검색 return [9]

    }

    private static boolean isVegetarianFriendlyMenu() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }
}
