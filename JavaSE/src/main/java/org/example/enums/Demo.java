package org.example.enums;

public class Demo {
    public static void main(String[] args) {
        // 使用枚举常量
        CarType car1 = CarType.SEDAN;
        CarType car2 = CarType.TRUCK;

        // 输出枚举常量
        System.out.println("Car 1 Type: " + car1);
        System.out.println("Car 2 Type: " + car2);

        // 枚举常量比较
        if (car1 == CarType.SEDAN) {
            System.out.println("Car 1 is a sedan.");
        }

        // Switch语句中使用枚举
        switch (car2) {
            case SEDAN:
                System.out.println("Car 2 is a sedan.");
                break;
            case TRUCK:
                System.out.println("Car 2 is a truck.");
                break;
            case MOTORBIKE:
                System.out.println("Car 2 is a motorbike.");
                break;
            default:
                System.out.println("Car 2 is an unknown type.");
                break;
        }

        // 遍历枚举类
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day.getName() + day.getNumber());
        }
    }

    public class Sub {
        public Sub(int i) {
        }
    }
}

