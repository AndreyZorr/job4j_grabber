package ru.job4j.solid.srp;

public class Car {
    private int power;
    private String size;
    private String driveUnite;

    public Car(int power, String size, String driveUnit) {
        this.power = power;
        this.size = size;
        this.driveUnite = driveUnit;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDriveUnite() {
        return driveUnite;
    }

    public void setDriveUnite(String driveUnite) {
        this.driveUnite = driveUnite;
    }

    public String replacement() {
        return size.replace("900", "500");
    }
}
