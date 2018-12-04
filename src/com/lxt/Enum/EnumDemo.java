package com.lxt.Enum;

import java.util.Arrays;

public class EnumDemo {
    public static void main(String[] args) {
        Day[] days = new Day[]{Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY};

        for (int i = 0; i < days.length; i++) {
            /**
             * name()方法和ordinal() ordinal()获取的是在枚举类中声明时候的下标
             */
            System.out.println("day.name()=" + days[i].name() + "  day.ordinal()=" + days[i].ordinal());
            /**
             * compareTo() 实际比较的是ordinal的值
             *  -1
             *  1
             *  0
             */
            System.out.println("-----------------------------------------------------");
            System.out.println("days[0].compareTo(days[1])="+days[0].compareTo(days[1]));
            System.out.println("days[4].compareTo(days[1])="+days[4].compareTo(days[1]));
            System.out.println("days[1].compareTo(days[1])="+days[1].compareTo(days[1]));

            /**
             * 获取枚举对象的class
             */
            System.out.println("--------------------class com.lxt.Enum.Day-----class com.lxt.Enum.Day----------------------------------");
            System.out.println(days[0].getClass()+"-----"+days[0].getDeclaringClass());
            /**
             * toString()
             */
            System.out.println("days[1].toString()="+days[1].toString());

            Day d1 = Enum.valueOf(Day.class, days[0].name());
            Day d2 = Enum.valueOf(Day.class, days[1].name());
            System.out.println(d1);
            System.out.println(d2);

            Day[] values = Day.values();
            System.out.println("Arrays.toString(values)="+Arrays.toString(values));
            Day monday = Day.valueOf("MONDAY");
            System.out.println(monday);

        }
    }
}
