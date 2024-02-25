package ru.kseniamedvedeva.seasimulator.util;

import ru.kseniamedvedeva.seasimulator.entity.Penguin;

public class EventSimulator {

    // всего должно быть 10 событий

    // 0 - 40   40% пингвин поспал +7 энергии
    // 40 - 70   30% пингвин проплыл -5 энергии
    // пингвин съел раков -7 energy; +8 здоровья
    // 70 - 80    10% пингвин съел рыбу -10 energy; coef * 4 здоровья
    // 80 - 100   20% на пингвина напал морской леопард -20 здоровья
    // энергия = 0 то -5 здоровья

    public void startSimulation(Penguin penguin) {
        while (checkStatus(penguin)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 40) {
                sleepEvent(penguin);
            } else if (eventNumber >= 40 && eventNumber < 70) {
                swimEvent(penguin);
            } else if (eventNumber >= 70 && eventNumber < 80) {
                eatFishEvent(penguin);
            } else if (eventNumber >= 80 && eventNumber < 100) {
                leopardSealAttacksEvent(penguin);
            }
        }
        System.out.println("Oh no! Penguin is dead!");
        System.out.println("Game over");
    }

    private void sleepEvent(Penguin penguin) {
        int energy = penguin.getEnergy();
        energy = energy + 7;
        if (energy > 100) {
            energy = 100;
        }
        penguin.setEnergy(energy);
        checkEnergy(penguin);
        System.out.println("Penguin slept! +7 energy");
        System.out.println("Energy = " + penguin.getEnergy());
    }

    private void swimEvent(Penguin penguin) {
        int energy = penguin.getEnergy();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        penguin.setEnergy(energy);
        checkEnergy(penguin);
        System.out.println("Penguin swam! -5 energy");
        System.out.println("Energy = " + penguin.getEnergy());
    }

    private void eatFishEvent(Penguin penguin) {
        int energy = penguin.getEnergy();
        int health = penguin.getHealth();
        energy = energy - 10;
        health = health + (int) (penguin.getBEAK() * 4);
        if (energy < 0) {
            energy = 0;
        }
        if (health > 100) {
            health = 100;
        }
        penguin.setEnergy(energy);
        penguin.setHealth(health);
        checkEnergy(penguin);
        System.out.println("Penguin ate fish! -10 energy, +8 health");
        System.out.println("Energy = " + penguin.getEnergy() + "; Health = " + penguin.getHealth());
    }

    private void leopardSealAttacksEvent(Penguin penguin) {
        int health = penguin.getHealth();
        health = health - 20;
        if (health < 0) {
            health = 0;
        }
        penguin.setHealth(health);
        checkEnergy(penguin);
        System.out.println("Leopard Seal attacks penguin! -20 health");
        System.out.println("Health = " + penguin.getHealth());
    }

    private boolean checkStatus(Penguin penguin) {
        System.out.println("HP = " + penguin.getHealth() + " Energy = " + penguin.getEnergy());
        if (penguin.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }

    }

    private void checkEnergy(Penguin penguin) {
        if (penguin.getEnergy() <= 0) {
            int health = penguin.getHealth();
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
            penguin.setHealth(health);
        }
    }
}