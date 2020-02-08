package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
//выходных и праздничных днях.
public class Main {

    public static void main(String[] args) throws ParseException {
        Calendar calendar = new Calendar();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = ft.parse("2010-12-11");
        Date date2 = ft.parse("2010-12-12");
        Calendar.Weekend weekend1 = calendar.new Weekend("День рождения", date1);
        Calendar.Weekend weekend2 = calendar.new Weekend("Выходной", date2);
        System.out.println(calendar.get(0).getName() + ": " + ft.format(calendar.get(0).getDate()));
        System.out.println(calendar.get(1).getName() + ": " + ft.format(calendar.get(1).getDate()));
    }
}