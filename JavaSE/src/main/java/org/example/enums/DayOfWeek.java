package org.example.enums;

public enum DayOfWeek {
    MONDAY("Monday", 1),
    TUESDAY("Tuesday", 2),
    WEDNESDAY("Wednesday", 3),
    THURSDAY("Thursday", 4),
    FRIDAY("Friday", 5),
    SATURDAY("Saturday", 6),
    SUNDAY("Sunday", 7);

    private String name;
    private int number;

    // 构造函数
    private DayOfWeek(String name, int number) {
        this.name = name;
        this.number = number;
    }

    // 获取名称
    public String getName() {
        return name;
    }

    // 获取序号
    public int getNumber() {
        return number;
    }

    // 检查是否是工作日
    public boolean isWeekday() {
        return this != SATURDAY && this != SUNDAY;
    }

    // 检查是否是周末
    public boolean isWeekend() {
        return !isWeekday();
    }
}
