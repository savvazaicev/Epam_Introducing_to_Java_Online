package com.company.server;

class Dossier {
    private int id;
    private String name;
    private int course;
    private double averageMark;
    private boolean isUnionMember;

    public Dossier(int id, String name, int course, double averageMark, boolean isUnionMember) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.averageMark = averageMark;
        this.isUnionMember = isUnionMember;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public boolean getUnionMember() {
        return isUnionMember;
    }

    public void setUnionMember(boolean unionMember) {
        this.isUnionMember = unionMember;
    }
}