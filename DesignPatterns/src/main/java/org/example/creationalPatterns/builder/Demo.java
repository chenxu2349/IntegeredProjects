package org.example.creationalPatterns.builder;

/**
 * @ClassName Demo
 * @Description
 * @Author chenxu
 * @Date 2024/3/10 15:31
 **/
public class Demo {
    public static void main(String[] args) {
        Car car = new Car.Builder()
                .carId(1002)
                .carName("ford")
                .owner("jack")
                .build();
        System.out.println(car.getCarId() + ", " + car.getCarName() + ", " + car.getOwner());
    }
}
