package com.company;

import java.util.ArrayList;
import java.util.Scanner;

//Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
//различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
//Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
public class Vouchers {
    private String[] trips = new String[]{"Отдых в Крыму", "Отдых в Сочи", "Отдых в Японии"};
    private int[] tripsCost = new int[]{400, 700, 2000};
    private String[] activities = new String[]{"Экскурсия к водопаду", "Лечение (страховка)",
            "шопинг", "круиз"};
    private int[] activitiesCost = new int[]{100, 200, 300, 500};
    private int amountOfMoney;
    Transport transport;
    Nutrition nutrition;
    Days days;

    public Vouchers(int count, int amountOfMoney) {
        this.days = new Days(count);
        this.transport = new Transport();
        this.nutrition = new Nutrition();
        this.amountOfMoney = amountOfMoney;
    }

    public void offers() {
        int amountOfMoney = getAmountOfMoney();
        String[] trips = getTrips();
        int[] tripsCost = getTripsCost();
        String[] activities = getActivities();
        int[] activitiesCost = getActivitiesCost();
        System.out.println("Выберите путевку: ");
        for (int i = 0; i < trips.length; i++) {
            System.out.println(" " + (i + 1) + "." + trips[i] + " - " + tripsCost[i] + "$");
        }
        Scanner in = new Scanner(System.in);
        int numOfTrip = in.nextInt() - 1;
        if (amountOfMoney - tripsCost[numOfTrip] >= 0) {
            amountOfMoney -= tripsCost[numOfTrip];
            System.out.println("Ваш остаток на балансе: " + amountOfMoney + "$");
            System.out.println("Выберите дополнительные активности/затраты: ");
            for (int i = 0; i < activities.length; i++) {
                System.out.println(" " + (i + 1) + "." + activities[i] + " - " + activitiesCost[i] + "$");
            }
            System.out.println(" " + (activities.length + 1) + "." + "Далее");
            ArrayList<Integer> numsOfActivities = new ArrayList<>();
            while (in.hasNextInt()) {
                int numOfActivity = in.nextInt() - 1;
                if (numOfActivity == 4) {
                    break;
                }
                    if (!numsOfActivities.contains(numOfActivity)) {
                        numsOfActivities.add(numOfActivity);
                        if (amountOfMoney - activitiesCost[numOfActivity] >= 0) {
                            amountOfMoney -= activitiesCost[numOfActivity];
                        } else {
                            System.out.println("Ошибка! Недостаточно денег");
                        }
                    } else {
                        System.out.println("Вы уже выбрали этот пункт!");
                    }
            }
            amountOfMoney -= transport.offers(amountOfMoney);
            amountOfMoney -= nutrition.offers(amountOfMoney);
//            System.out.println("Введите кол-во дней: ");
//            days = new Days(in.nextInt());
            if (amountOfMoney - (getAmountOfMoney() - amountOfMoney) * days.getRatio() >= 0) {
                amountOfMoney -= (getAmountOfMoney() - amountOfMoney) * days.getRatio();
            } else {
                System.out.println("Ошибка! Недостаточно денег для выбранного кол-ва дней");
            }
        } else {
            System.out.println("Ошибка! Недостаточно денег");
        }
        System.out.println("Остаток: " + amountOfMoney);
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String[] getTrips() {
        return trips;
    }

    public int[] getTripsCost() {
        return tripsCost;
    }

    public String[] getActivities() {
        return activities;
    }

    public int[] getActivitiesCost() {
        return activitiesCost;
    }

    public void sort() {
        int[] tripsCost = getTripsCost();
        String temp = " ";
        for (int j = 0; j < tripsCost.length - 1; j++) {
            for (int i = 0; i < tripsCost.length - 1; i++) {
                if (tripsCost[i] < tripsCost[i + 1]) {
                    tripsCost[i] = tripsCost[i] + tripsCost[i + 1] - (tripsCost[i + 1] = tripsCost[i]);
                    temp = this.trips[i];
                    this.trips[i] = this.trips[i + 1];
                    this.trips[i + 1] = temp;
                }
            }
        }
    }
}

class Transport {
    private String[] names = new String[]{"самокат", "велосипед", "скутер", "машина", "поезд", "самолёт"};
    private int[] costs = new int[]{10, 50, 100, 150, 200, 300};

    public int offers(int amountOfMoney) {
        //String[] names = Transport.getNames();
        System.out.println("Выберите транспорт: ");
        for (int i = 0; i < this.names.length; i++) {
            System.out.println(" " + (i + 1) + "." + this.names[i] + " - " + this.costs[i] + "$");
        }
        Scanner in = new Scanner(System.in);
        int numOfTransport = in.nextInt() - 1;
        if (amountOfMoney - this.costs[numOfTransport] >= 0) {
            return this.costs[numOfTransport];
        } else {
            System.out.println("Ошибка! Недостаточно денег");
            return 0;
        }
    }

    public String[] getNames() {
        return names;
    }

    public int[] getCosts() {
        return costs;
    }
}

class Nutrition {
    private String[] names = new String[]{"питьевая вода", "фаст-фуд", "только обед",
            "3-ч разовове питание", "шведский стол"};
    private int[] costs = new int[]{10, 50, 100, 200, 300};

    public int offers(int amountOfMoney) {
        System.out.println("Выберите питание: ");
        for (int i = 0; i < this.names.length; i++) {
            System.out.println(" " + (i + 1) + "." + this.names[i] + " - " + this.costs[i] + "$");
        }
        Scanner in = new Scanner(System.in);
        int numOfNutrition = in.nextInt() - 1;
        if (amountOfMoney - this.costs[numOfNutrition] >= 0) {
            return this.costs[numOfNutrition];
        } else {
            System.out.println("Ошибка! Недостаточно денег");
            return 0;
        }
    }
}

class Days {
    private int count;
    private double ratio;//коэффициент

    Days(int count) {
        setCount(count);
        double ratio = 0;
        for (int i = 5; i < this.count; i++) {
            ratio += 0.2;
        }
        this.ratio = ratio;
    }

    public void setCount(int count) {
        if (count >= 5 && count <= 365) {
            this.count = count;
        } else {
            System.out.println("Минимальное кол-во дней - 5, максимальное - 365");
        }
    }

    public double getRatio() {
        return ratio;
    }
}