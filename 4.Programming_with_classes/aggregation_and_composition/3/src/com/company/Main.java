package com.company;

//Создать объект класса Государство, используя классы Область, Район, Город.
//Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
public class Main {

    public static void main(String[] args) {
        District district1 = new District("a");
        District district2 = new District("b");
        District district3 = new District("c");
        District district4 = new District("d");
        District district5 = new District("e");
        District district6 = new District("f");
        District district7 = new District("g");
        District district8 = new District("h");
        District district9 = new District("i");
        District district10 = new District("y");
        District district11 = new District("k");
        District district12 = new District("l");
        City minskCity = new City("Минск", district1);
        City borisovCity = new City("Борисов", district2);
        City brestCity = new City("Брест", district3);
        City pinskCity = new City("Пинск", district4);
        City gomelCity = new City("Гомель", district5);
        City mozyrCity = new City("Мозырь", district6);
        City mogilevCity = new City("Могилёв", district7);
        City bobryiskCity = new City("Бобруйск", district8);
        City vitebskCity = new City("Витебск", district9);
        City polotskCity = new City("Полоцк", district10);
        City grodnoCity = new City("Гродно", district11);
        City lidaCity = new City("Лида", district12);
        Region minsk = new Region("Минская область", new City[]{minskCity, borisovCity}, 0);
        Region brest = new Region("Брестская область", new City[]{brestCity, pinskCity}, 0);
        Region gomel = new Region("Гомельская область", new City[]{gomelCity, mozyrCity}, 0);
        Region mogilev = new Region("Могилёвская область", new City[]{mogilevCity, bobryiskCity}, 0);
        Region vitebsk = new Region("Витебская область", new City[]{vitebskCity, polotskCity}, 0);
        Region grodno = new Region("Гродненская область", new City[]{grodnoCity, lidaCity}, 0);
        State belarus = new State("Беларусь", new Region[]{minsk, brest, gomel, mogilev, vitebsk, grodno}, 0, 207595);
        System.out.println("Столица: ");
        belarus.capital();
        System.out.println("\n" + "Кол-во регионов: ");
        belarus.numOfRegions();
        System.out.println("\n" + "Площадь: ");
        System.out.println(belarus.getArea());
        System.out.println("\n" + "Региональные центры: ");
        Region[] regions = belarus.getRegions();
        for (Region i :
                regions) {
            i.regionalCenter();
        }
    }
}
