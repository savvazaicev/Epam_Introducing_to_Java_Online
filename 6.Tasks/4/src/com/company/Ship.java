package com.company;

import java.util.ArrayList;

//Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров.
//Число контейнеров, находящихся в текущий момент в порту и на корабле,
//должно быть неотрицательным и не превышающим заданную грузоподъемность судна и вместимость порта.
//В порту работает несколько причалов. У одного причала может стоять один корабль.
//Корабль может загружаться у причала или разгружаться.
public class Ship {
    private int carryingCapacity;
    private ArrayList<Container> containers = new ArrayList<>();

    public Ship(int carryingCapacity, ArrayList<Container> containers) {
        this.carryingCapacity = carryingCapacity;
        this.containers = containers;
    }

    public Ship(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public void addContainer(Container container) {
        containers.add(container);
    }

    public void removeContainer(Container container) {
        containers.remove(container);
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public int weightOfContainers() {
        int weight = 0;
        for (Container container : containers) {
            weight += container.getWeight();
        }
        return weight;
    }
}
