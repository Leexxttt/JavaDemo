package com.lxt.Enum;

public class TestSwitch {

    private void testSwitch(SeasonEnum seasonEnum){
        switch (seasonEnum){
            case WINTER:
                System.out.println("冬天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
        }
    }

    public static void main(String[] args) {
        TestSwitch test = new TestSwitch();
        test.testSwitch(SeasonEnum.WINTER);

    }
}
