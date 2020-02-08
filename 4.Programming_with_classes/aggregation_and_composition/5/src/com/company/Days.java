package com.company;

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