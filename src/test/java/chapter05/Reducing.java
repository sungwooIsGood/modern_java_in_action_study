package chapter05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.exercies.chapter05.Menu.menu;

public class Reducing {

    @Test
    @DisplayName("reducing")
    void reducing(){
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum); //(a, b) -> a + b) 사용

        int sum2 = numbers.stream().reduce(0, Integer::sum); // Integer::sum -> Integer 지원 메서드 사용, Integer.sum(a,b);
        System.out.println(sum2);

        menu.stream().map(d -> 1).collect(Collectors.toList());
        menu.size();

        int count = menu.stream().map(d -> 1).reduce(0,(a,b)->a+b); // 음식 갯수 구하기
    }
}
