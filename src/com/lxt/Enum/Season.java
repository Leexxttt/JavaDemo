package com.lxt.Enum;

/**写代码会考虑代码的安全性 易用性 可读性
 * java没有引入枚举之前表示枚举类型的方法
 * 1，不安,2：可读性差
 */
public class Season {
    public static final int SPRING = 1;
    public static final int SUMMER = 2;
    public static final int AUTUMN = 3;
    public static final int WINTER = 4;


    private String getChineseSeason(int season) {
        StringBuffer sb = new StringBuffer();
        switch (season) {
            case Season.SPRING:
                sb.append("春天");
                break;
            case Season.SUMMER:
                sb.append("夏天");
                break;
            case Season.AUTUMN:
                sb.append("秋天");
                break;
            case Season.WINTER:
                sb.append("冬天");
                break;
            default:
                sb.append("没有的季节");
                break;
        }
        return sb.toString();
    }

    private String getChineseSeason2(SeasonEnum season) {
        StringBuffer sb = new StringBuffer();
        switch (season) {
            case SPRING:
                sb.append("春天");
                break;
            case SUMMER:
                sb.append("夏天");
                break;
            case AUTUMN:
                sb.append("秋天");
                break;
            case WINTER:
                sb.append("冬天");
                break;
            default:
                sb.append("没有的季节");
                break;
        }
        return sb.toString();
    }
    public void doSonething(){
        //安全
        System.out.println(this.getChineseSeason(Season.SPRING));
        //不安全
        System.out.println(this.getChineseSeason(5));
        /**
         * 使用枚举 代码既安全 可读性还好
         */
        System.out.println(this.getChineseSeason2(SeasonEnum.SPRING));
    }
}
