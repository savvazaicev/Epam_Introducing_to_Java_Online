package com.company;

import java.util.ArrayList;
import java.util.Date;

//Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
//выходных и праздничных днях.
public class Calendar {
    private ArrayList<Weekend> weekends = new ArrayList<>();

    class Weekend {
        private String name;
        private Date date;

        public Weekend(String name, Date date) {
            this.name = name;
            this.date = date;
            weekends.add(this);
        }

        public String getName() {
            return name;
        }

        public Date getDate() {
            return date;
        }
    }

    public Weekend get(int index) {
        return weekends.get(index);
    }

//    public void add(Weekend weekend) {
//        this.weekends = weekends;
//    }
}
