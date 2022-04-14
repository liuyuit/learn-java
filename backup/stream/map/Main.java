package stream.map;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * java src/stream/map/Main.java
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) {
        String[] array = new String[] { " 2019-12-31 ", " 2020 - 01-09 ", "2020- 05 - 01 ", "2022 - 02 - 01",
                " 2025-01 -01" };
        // 请使用map把String[]转换为LocalDate并打印:
         Arrays.stream(array).map((s)->s.replaceAll("\\s", "")).map(String::trim).map(LocalDate::parse).forEach(System.out::println);
    }

//    public static toLocalDate
}
