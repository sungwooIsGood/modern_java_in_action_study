package chapter06;

import com.exercies.data.entity.Dish;
import com.exercies.data.enums.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.exercies.chapter05.Menu.menu;
import static java.util.stream.Collectors.*;

public class Partitioning {

    @Test
    @DisplayName("partition을 이용한 두 그룹으로 나누기")
    void partition(){
        System.out.println(partitionByVegeterian());
    }

    @Test
    @DisplayName("partition후 grouping")
    void partitionVegetarianDishesByType(){
        System.out.println(vegetarianDishesByType());
    }

    @Test
    @DisplayName("")

    private static Map<Boolean, List<Dish>> partitionByVegeterian() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian));
    }

    private static Map<Boolean, Map<Type, List<Dish>>> vegetarianDishesByType() {
        return menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,groupingBy(Dish::getType)));
    }

    private static Object mostCaloricPartitionedByVegetarian() {
        return menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(
                                maxBy(Comparator.comparing(Dish::getCalories)),
                                Optional::get
                        )));
    }
}
