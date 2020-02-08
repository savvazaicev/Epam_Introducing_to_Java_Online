package com.company;

import java.util.ArrayList;

//Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров.
//TODO Число контейнеров, находящихся в текущий момент в порту и на корабле,
// - должно быть неотрицательным и не превышающим заданную грузоподъемность судна и вместимость порта.
//В порту работает несколько причалов. У одного причала может стоять один корабль.
//Корабль может загружаться у причала или разгружаться.
public class Harbor {
    private ArrayList<Pier> piers = new ArrayList<>();
    private int capacity;
    private volatile ArrayList<Container> containers = new ArrayList<>();

    public Harbor(int capacity) {
        this.capacity = capacity;
    }

    public void addPier(Pier pier) {
        piers.add(pier);
    }

    public void addShipToFreePier(Ship ship, Object sync) {
        for (Pier pier : piers) {
            if (!pier.isLoading()) {
                pier.setShip(ship);
                pier.setLoading(true);
                if (ship.getContainers().isEmpty()) {
                    if (containers.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() + ": waiting for new containers...");
                        try {
                            sync.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ": thanks for notify - trying to continue working");
                    }
                    System.out.println("Новый корабль прибыл на загрузку!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int numberOfContainersInHarbor = containers.size();
                    for (int i = 0; i < numberOfContainersInHarbor; i++) {
                        Container container = containers.get(0);
                        if (ship.getCarryingCapacity() - container.getWeight() >= 0) {
                            ship.addContainer(container);
                            containers.remove(container);
                        }
                    }
                    //Уведомляем другие потоки об освободившемся месте
                    pier.setShip(null);
                    pier.setLoading(false);
                    sync.notifyAll();
                    System.out.println("Корабль загружен!");
                    System.out.println(Thread.currentThread().getName() + ": have notified about free place");
                } else {
                    System.out.println("Новый корабль прибыл на разгрузку!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //int numberOfContainers = numberOfContainers(ship);
                    while (capacity - numberOfContainers(ship) < 0) {
                        //System.out.println("Текущее кол-во контейнеров: " + numberOfContainers(ship));
                        System.out.println(Thread.currentThread().getName() + ": waiting for a free place...");
                        try {
                            sync.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ": thanks for notify - trying to continue working");
                    }
                    int numberOfShipContainers = ship.getContainers().size();
                    for (int i = 0; i < numberOfShipContainers; i++) {
                        Container container = ship.getContainers().get(0);
                        if (capacity + numberOfShipContainers - numberOfContainers(ship) > 0) {
                            containers.add(container);
                            ship.removeContainer(container);
                        }
                    }
                    //containers.addAll(ship.getContainers());
                    System.out.println("Корабль разгружен!");
                    pier.setShip(null);
                    pier.setLoading(false);
                    sync.notifyAll();
                    System.out.println(Thread.currentThread().getName() + ": have notified about new containers");
                }
                return;
            }
        }
    }

    public int numberOfContainers(Ship ship) {
        int numberOfContainers = 0;
//        for (Pier pier : piers) {
//            if (pier.isLoading()) {
//                numberOfContainers += pier.getShip().getContainers().size();
//            }
//        }
        numberOfContainers += containers.size();
        //System.out.println("Контейнеров в порту: " + containers.size());
        numberOfContainers += ship.getContainers().size();
        //System.out.println("Контейнеров на корабле: " + ship.getContainers().size());
        return numberOfContainers;
    }
}
