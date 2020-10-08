package com.apexSystems.pojo;

public class Puppy {
    String photoPath;
    String name;
    String sex;
    String breed;
    double adoptionFees;

    public Puppy(String photoPath, String name, String sex, String breed) {
        this.photoPath = photoPath;
        this.name = name;
        this.sex = sex;
        this.breed = breed;
    }

    public Puppy(String photoPath, String name, String sex, String breed, double price) {
        this(photoPath, name, sex, breed);
        this.adoptionFees = price;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getAdoptionFees() {
        return adoptionFees;
    }

    public void setAdoptionFees(double adoptionFees) {
        this.adoptionFees = adoptionFees;
    }

    public boolean basicInfoEquals(Puppy two) {
        return this.photoPath.equals(two.getPhotoPath()) &&
                this.name.equals(two.getName()) &&
                this.sex.equals(two.getSex()) &&
                this.breed.equals(two.getBreed());

    }

    public boolean equals(Puppy two) {
        return this.basicInfoEquals(two) &&
                this.adoptionFees == two.getAdoptionFees();
    }
}
