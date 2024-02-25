package ru.kseniamedvedeva.seasimulator._main;

import ru.kseniamedvedeva.seasimulator.entity.Penguin;
import ru.kseniamedvedeva.seasimulator.util.EventSimulator;

public class _Main {

    public static void main(String[] args) {
        Penguin penguin = new Penguin();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(penguin);
    }
}
