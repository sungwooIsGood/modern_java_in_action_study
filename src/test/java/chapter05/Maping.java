package chapter05;

import com.exercies.data.entity.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.exercies.chapter05.Menu.menu;
import static java.util.stream.Collectors.toList;

public class Maping {

    @Test
    @DisplayName("map() 활용")
    void map(){
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split(""))) // Array.stream -> 문자열을 받아 스트림으로 만드는 메서드
                .distinct()
                .forEach(System.out::println);
    }
}
