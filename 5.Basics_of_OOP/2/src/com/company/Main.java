package com.company;

//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.
public class Main {

    public static void main(String[] args) {
        Payment payment = new Payment(200);
        Payment.Goods goods = payment.new Goods();
        goods.put("T-Shirt",50);
        goods.put("Boots",100);
        goods.put("Hat",50);
        goods.buy(new String[]{"Hat", "T-Shirt", "Boots"});
    }
}