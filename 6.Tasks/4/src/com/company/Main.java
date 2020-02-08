package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров.
//Число контейнеров, находящихся в текущий момент в порту и на корабле,
//должно быть неотрицательным и не превышающим заданную грузоподъемность судна и вместимость порта.
//В порту работает несколько причалов. У одного причала может стоять один корабль.
//Корабль может загружаться у причала или разгружаться.
public class Main {

    public static void main(String[] args) {
        //В порту 2 свободных места для контейнеров
        int capacity = 2;
        //И 3 пира, к каждому из которых может подплыть корабль на загрузку/разгрузку
        int numberOfPiers = 3;
        Harbor harbor = new Harbor(capacity);
        for (int i = 0; i < numberOfPiers; i++) {
            harbor.addPier(new Pier());
        }
        //Первый корабль заполнит порт полностью
        Ship firstShip = new Ship(10,
                new ArrayList<>(Arrays.asList(new Container(), new Container())));
        //Второму придётся ждать
        Ship secondShip = new Ship(5,
                new ArrayList<>(Arrays.asList(new Container())));
        //Третий полностью освободоит порт
        //Втоорой тут же разгрузит 1 контейнер
        Ship thirdShip = new Ship(10);
        //Четвертый корабль также разгрузит 1 контейнер, порт заполниться
        Ship fourthShip = new Ship(5,
                new ArrayList<>(Arrays.asList(new Container())));
        //Пятый загрузит все контейнеры и освободит порт
        Ship fifthShip = new Ship(10);
        List<Ship> ships = Arrays.asList(firstShip, secondShip, thirdShip, fourthShip, fifthShip);
        Object sync = new Object();
        for (Ship ship : ships) {
            new Thread(() -> {
                synchronized (sync) {
                    harbor.addShipToFreePier(ship, sync);
                }
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        Thread firstThread = new Thread(new Runnable() {
//            public void run() {
//                harbor.addShipToFreePier(firstShip);
//            }
//        });
//        firstThread.start();
//        Thread secondThread = new Thread(new Runnable() {
//            public void run() {
//                harbor.addShipToFreePier(secondShip);
//            }
//        });
//        secondThread.start();
//        Thread ThirdThread = new Thread(new Runnable() {
//            public void run() {
//                harbor.addShipToFreePier(thirdShip);
//            }
//        });
//        ThirdThread.start();
//        Thread fourthThread = new Thread(new Runnable() {
//            public void run() {
//                harbor.addShipToFreePier(fourthShip);
//            }
//        });
//        fourthThread.start();
//        Thread fifthThread = new Thread(new Runnable() {
//            public void run() {
//                harbor.addShipToFreePier(fifthShip);
//            }
//        });
//        fifthThread.start();
    }
}
