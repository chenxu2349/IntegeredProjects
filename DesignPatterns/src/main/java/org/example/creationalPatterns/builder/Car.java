package org.example.creationalPatterns.builder;

/**
 * @ClassName Car
 * @Description
 * @Author chenxu
 * @Date 2024/3/10 15:49
 **/
public class Car {
    private int carId;
    private String carName;
    private String owner;

    public int getCarId() {
        return this.carId;
    }

    public String getCarName() {
        return this.carName;
    }

    public String getOwner() {
        return this.owner;
    }

    private Car(int carId, String carName, String owner) {
        this.carId = carId;
        this.carName = carName;
        this.owner = owner;
    }

    public static class Builder {
        // 默认构建参数
        private int carId = 0;
        private String carName = "null";
        private String owner = "null";

        public Builder carId(int id) {
            this.carId = id;
            return this;
        }

        public Builder carName(String name) {
            this.carName = name;
            return this;
        }

        public Builder owner(String owner) {
            this.owner = owner;
            return this;
        }

        public Car build() {
            return new Car(carId, carName, owner);
        }
    }
}
