package Week;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * leetcode
 *
 * @author Chan
 * @since 2021/1/7 15:26
 **/
public class SimpleTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list = list.stream().map(x -> x+1).collect(Collectors.toList());
        for (int x:list) {
            System.out.print(x + "-");
        }

        String str = "hello world";
        System.out.println(str.substring(5));

        System.out.println(new Date());
    }
}
