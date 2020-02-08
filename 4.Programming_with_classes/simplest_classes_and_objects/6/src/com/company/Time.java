package com.company;

//Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
//изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
//недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
//заданное количество часов, минут и секунд.
public class Time {
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;

    public Time(int hours) {
        setHours(hours);
    }

    public Time(int hours, int minutes) {
        setHours(hours);
        setMinutes(minutes);
    }

    public Time(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public void changeTime(int hours, int minutes){
        setHours(hours);
        setMinutes(minutes);
    }

    public void changeTime(int hours, int minutes, int seconds){
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public void output() {
        System.out.println(this.hours + " часов " + this.minutes + " минут " + this.seconds + " секунд" + '\n');
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours < 24) {
            this.hours = hours;
        } else {
            System.out.println("Error! Hours out of range. Value changed to zero");
            this.hours = 0;
        }
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes < 60) {
            this.minutes = minutes;
        } else {
            System.out.println("Error! Minutes out of range. Value changed to zero");
            this.minutes = 0;
        }
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds < 60) {
            this.seconds = seconds;
        } else {
            System.out.println("Error! Seconds out of range. Value changed to zero");
            this.seconds = 0;
        }
    }
}
