package com.gepardec.training.microprofile.basic.openapi;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name="Cheetah", description="POJO that represents a cheetah")
public class Cheetah {

    private int age;
    @Schema(required = true)
    private String name;
    private double weight;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Cheetah(int age, String name, double weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }
}
