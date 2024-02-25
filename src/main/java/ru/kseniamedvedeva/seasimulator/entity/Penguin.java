package ru.kseniamedvedeva.seasimulator.entity;

public class Penguin {
    private int health = 100;
    private int energy = 100;
    private final float BEAK = 2.5f;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public float getBEAK() {
        return this.BEAK;
    }
}