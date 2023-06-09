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
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class Grouping {

    @Test
    @DisplayName("메뉴 타입별로 그룹화")
    void doDishTypeGroup(){
        System.out.println(groupDishesByType());
    }

    @Test
    @DisplayName("람다를 이용한 복잡한 그룹화")
    void doRamdasGroup(){
        System.out.println(groupDishesByCaloricLevel());
    }

    @Test
    @DisplayName("그룹화 후 연산")
    void groupAfterFilter(){
        System.out.println(groupCaloricDishesByType());
    }

    @Test
    @DisplayName("그룹화 후 매핑")
    void groupAfterMapping(){
        System.out.println(groupDishNamesByType());
    }

    @Test
    @DisplayName("다수준 그룹화")
    void manyGroup(){
        System.out.println(groupDishedByTypeAndCaloricLevel());
    }

    @Test
    @DisplayName("그룹화 한 후 counting")
    void getCount(){
        System.out.println(countDishesInGroups());
    }

    @Test
    @DisplayName("max 칼로리 구하기")
    void maxCaloric(){
        System.out.println(mostCaloricGroup());
        System.out.println(mostCaloricDishesByTypeWithoutOprionals());
    }

    private static Map<Type, List<Dish>> groupDishesByType() {
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    enum CaloricLevel { DIET, NORMAL, FAT };

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    }
                    else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    }
                    else {
                        return CaloricLevel.FAT;
                    }
                })
        );
    }

    private static Map<Type, List<Dish>> groupCaloricDishesByType(){
//        return menu.stream().filter(d -> d.getCalories() > 500).collect(groupingBy((Dish::getType)));
        return menu.stream().collect(groupingBy(Dish::getType,filtering(d->d.getCalories() > 500,toList())));
    }

    private static Map<Type, List<String>> groupDishNamesByType() {
        return menu.stream().collect(groupingBy(Dish::getType,mapping(Dish::getName,toList())));
    }

    private static Map<Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(d ->{
                            if(d.getCalories() <= 400){
                                return CaloricLevel.DIET;
                            } else if(d.getCalories() <= 700){
                                return CaloricLevel.NORMAL;
                            } else{
                                return CaloricLevel.FAT;
                            }
                        })));
    }

    private static Map<Type, Long> countDishesInGroups() {
        return menu.stream()
                .collect(groupingBy(Dish::getType,counting()));
    }

    private static Map<Type, Optional<Dish>> mostCaloricGroup(){
        return menu.stream()
                .collect(groupingBy(Dish::getType,maxBy(comparingInt(Dish::getCalories))));
    }

    private static Map<Type, Dish> mostCaloricDishesByTypeWithoutOprionals() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        collectingAndThen(
                                reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2),
                                Optional::get)));
    }
}
