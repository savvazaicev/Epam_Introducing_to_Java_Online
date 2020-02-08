package com.company;

import java.util.HashMap;
import java.util.Map;

//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.
public class Payment {
    private int amountOfMoney;

    public Payment(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    class Goods {
        Map<String, Integer> goods = new HashMap<>();

        public Goods() {
        }

        public void put(String name, Integer cost) {
            this.goods.put(name, cost);
        }

        public void buy(String[] names) {
            for (int i = 0; i < names.length; i++) {
                amountOfMoney -= this.goods.get(names[i]);
            }
            if (amountOfMoney >= 0) {
                System.out.println("Покупка совершена успешно!" + "\n" + "Остаток на балансе: " + amountOfMoney);
            } else {
                System.out.println("Ошибка! Недостаточно денег.");
            }
        }
    }
}