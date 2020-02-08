package com.company;

//Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров.
//Число контейнеров, находящихся в текущий момент в порту и на корабле,
//должно быть неотрицательным и не превышающим заданную грузоподъемность судна и вместимость порта.
//В порту работает несколько причалов. У одного причала может стоять один корабль.
//Корабль может загружаться у причала или разгружаться.
public class Pier {
    private Ship ship;
    private boolean isLoading;

    public Pier() {
    }

    public Pier(Ship ship, boolean isLoading) {
        this.ship = ship;
        this.isLoading = isLoading;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public Ship getShip() {
        return ship;
    }

    public boolean isLoading() {
        return isLoading;
    }
}