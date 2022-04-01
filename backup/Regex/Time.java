package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {

    /**
     * 从"21:05:19"中提取时，分，秒，否则抛出IllegalArgumentException
     */
    public static void main(String[] args) throws IllegalArgumentException {
        String time = "21:05:19";
        Pattern pattern = Pattern.compile("([0-2][0-3])\\:([0-5][0-9])\\:([0-5][0-9])");
//        Pattern pattern = Pattern.compile("(\\d{2})\\:(\\d{2})\\:(\\d{2})");
        Matcher matcher = pattern.matcher(time);
        if (!matcher.matches()){
            throw new IllegalArgumentException();
        }

        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
    }
}
