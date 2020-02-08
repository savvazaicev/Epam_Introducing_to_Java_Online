package com.company;

class BankAccount {
    private int countOfMoney = 0;
    private boolean isBlocked = false;

    public BankAccount() {
    }

    public BankAccount(int countOfMoney) {
        this.countOfMoney = countOfMoney;
    }

    public int getCountOfMoney() {
        return countOfMoney;
    }

    public void setCountOfMoney(int countOfMoney) {
        this.countOfMoney = countOfMoney;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public static void findBankAcc(String name, int index, Client[] clients) {
        for (Client i : clients) {
            if (name.equals(i.getName())){
                i.getBankAccount(index).output();
            }
        }
    }

    public void output() {
        System.out.println("Количество денег: " + countOfMoney);
        if (isBlocked) {
            System.out.println("Счёт заблокирован");
        } else {
            System.out.println("Счёт не заблокирован");
        }
    }
}
