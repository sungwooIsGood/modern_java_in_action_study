package chapter02;

import com.exercies.data.entity.Apple;
import com.exercies.data.enums.Color;
import com.exercies.data.strategy.AppleColorPredicate;
import com.exercies.data.strategy.ApplePredicate;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static com.exercies.chapter02.AppleFilter.*;

public class Chapter02Test {

    @Test
    void doFilter(){
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        // 요구사항 1. 녹색 사과만 수집
        List<Apple> apples = filterGreenApples(inventory);

        // 요구사항 2. 색깔별로 수집
        List<Apple> applesByColor = filterApplesByColor(inventory,Color.RED);

        // 요구사항 3. 무게 별로 수정
        int weight = 170;
        List<Apple> applesByWeight = filterApplesByWeight(inventory, weight);

        // 동적 파라미터화 사용 - 전략 디자인 패턴, 요구사항에 맞게 갈아 끼우기.
        ApplePredicate applePredicate = new AppleColorPredicate(); // 색상에 따라 수집
//        ApplePredicate applePredicate = new AppleWeightPredicate(); // 무게에 따라 수집
        List<Apple> applesByStrategy = filterApples(inventory, applePredicate);

        // 익명 클래스
        List<Apple> applesAnonymous = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });

        // 람다
        List<Apple> applesLamda = filterApples(inventory, apple -> Color.RED.equals(apple.getColor()));

    }

}
