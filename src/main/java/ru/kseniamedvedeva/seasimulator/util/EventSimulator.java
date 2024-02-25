package ru.kseniamedvedeva.seasimulator.util;

import ru.kseniamedvedeva.seasimulator.entity.Penguin;

public class EventSimulator {
    public void startSimulation(Penguin penguin) throws InterruptedException {
        while (checkStatus(penguin)) {
            int eventNumber = (int) (Math.random() * 100);
            Thread.sleep(1000);
            if (eventNumber >= 0 && eventNumber < 10) {
                sleepEvent(penguin);
            } else if (eventNumber >= 10 && eventNumber < 20) {
                waitEvent(penguin);
            } else if (eventNumber >= 20 && eventNumber < 30) {
                swimEvent(penguin);
            } else if (eventNumber >= 30 && eventNumber < 35) {
                walkEvent(penguin);
            } else if (eventNumber >= 35 && eventNumber < 40) {
                eatFishEvent(penguin);
            } else if (eventNumber >= 40 && eventNumber < 50) {
                eatCrayfishEvent(penguin);
            } else if (eventNumber >= 50 && eventNumber < 70) {
                leopardSealAttacksEvent(penguin);
            } else if (eventNumber >= 70 && eventNumber < 80) {
                furSealAttacksEvent(penguin);
            } else if (eventNumber >= 80 && eventNumber < 90) {
                sharkAttacksEvent(penguin);
            } else if (eventNumber >= 90 && eventNumber < 100) {
                buildNestEvent(penguin);
            }
        }
        System.out.println("Oh no! Penguin is dead!");
        System.out.println("Game over");
    }

    private void sleepEvent(Penguin penguin) {
        int energy = penguin.getEnergy();
        energy = energy + 10;
        penguin.setEnergy(checkEnergy(energy));
        checkEnergyIfHealthZero(penguin);
        System.out.println("Penguin slept! +7 energy");
    }

    private void waitEvent(Penguin penguin) {
        int energy = penguin.getEnergy();
        energy = energy - 10;
        penguin.setEnergy(checkEnergy(energy));
        checkEnergyIfHealthZero(penguin);
        System.out.println("Penguin checked water! -10 energy");
    }

    private void swimEvent(Penguin penguin) {
        int energy = penguin.getEnergy();
        energy = energy - 15;
        penguin.setEnergy(checkEnergy(energy));
        checkEnergyIfHealthZero(penguin);
        System.out.println("Penguin swam! -15 energy");
    }

    private void walkEvent(Penguin penguin) {
        int energy = penguin.getEnergy();
        energy = energy - 5;
        penguin.setEnergy(checkEnergy(energy));
        checkEnergyIfHealthZero(penguin);
        System.out.println("Penguin walked on land! -5 energy");
    }

    private void eatFishEvent(Penguin penguin) {
        int energy = penguin.getEnergy();
        int health = penguin.getHealth();
        energy = energy - 10;
        health = health + (int) (penguin.getBEAK() * 4);
        penguin.setEnergy(checkEnergy(energy));
        penguin.setHealth(checkHealth(health));
        checkEnergyIfHealthZero(penguin);
        System.out.println("Penguin ate fish! -10 energy, +" + ((int) (penguin.getBEAK() * 4)) + " health");
    }

    private void eatCrayfishEvent(Penguin penguin) {
        int energy = penguin.getEnergy();
        int health = penguin.getHealth();
        energy = energy - 7;
        health = health + (int) (penguin.getBEAK() * 2);
        penguin.setEnergy(checkEnergy(energy));
        penguin.setHealth(checkHealth(health));
        checkEnergyIfHealthZero(penguin);
        System.out.println("Penguin ate crayfish! -7 energy, +" + ((int) (penguin.getBEAK() * 2)) + " health");
    }

    private void leopardSealAttacksEvent(Penguin penguin) {
        int health = penguin.getHealth();
        health = health - 20;
        penguin.setHealth(checkHealth(health));
        checkEnergyIfHealthZero(penguin);
        System.out.println("Leopard Seal attacks penguin! -20 health");
    }

    private void furSealAttacksEvent(Penguin penguin) {
        int health = penguin.getHealth();
        health = health - 20;
        penguin.setHealth(checkHealth(health));
        checkEnergyIfHealthZero(penguin);
        System.out.println("Fur Seal attacks penguin! -20 health");
    }

    private void sharkAttacksEvent(Penguin penguin) {
        int health = penguin.getHealth();
        health = health - 15;
        penguin.setHealth(checkHealth(health));
        checkEnergyIfHealthZero(penguin);
        System.out.println("Shark attacks penguin! -15 health");
    }

    private void buildNestEvent(Penguin penguin) {
        int energy = penguin.getEnergy();
        energy = energy - 30;
        penguin.setEnergy(checkEnergy(energy));
        checkEnergyIfHealthZero(penguin);
        System.out.println("Penguin built a nest! -30 energy");
    }

    private boolean checkStatus(Penguin penguin) {
        System.out.println("Health = " + penguin.getHealth() + " Energy = " + penguin.getEnergy());
        if (penguin.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private void checkEnergyIfHealthZero(Penguin penguin) {
        if (penguin.getEnergy() <= 0) {
            int health = penguin.getHealth();
            health = health - 5;
            checkHealth(health);
            penguin.setHealth(health);
        }
    }

    private int checkEnergy(int energy) {
        if (energy < 0) {
            return 0;
        } else if (energy > 100) {
            return 100;
        } else return energy;
    }

    private int checkHealth(int health) {
        if (health < 0) {
            return 0;
        } else if (health > 100) {
            return 100;
        } else return health;
    }
}