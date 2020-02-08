package com.company;

class Box {
    private String typeOfMaterial;

    Box(String typeOfMaterial) {
        setTypeOfMaterial(typeOfMaterial);
    }

    String boxToString() {
        return "Тип упаковки: " + typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        if (typeOfMaterial.matches("^[а-яА-Я]+$")) {
            this.typeOfMaterial = typeOfMaterial;
        } else {
            System.out.println("Ошибка! Тип упаковки должен состоять только из русских букв без пробелов.");
        }
    }
}