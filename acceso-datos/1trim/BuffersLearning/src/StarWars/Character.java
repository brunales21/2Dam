package StarWars;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Field;
import java.util.Objects;

public class Character {
    private String name;
    private String gender;
    private String birthYear;
    private int height;
    private double mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String planet;
    private String species;

    public Character() {
        this("", "", "", 0, 0, "", "", "", "", "");
    }

    public Character(String name, String gender, String birthYear, int height, double mass, String hairColor, String skinColor, String eyeColor, String planet, String species) {
        setName(name);
        setGender(gender);
        setBirthYear(birthYear);
        setHeight(height);
        setMass(mass);
        setHairColor(hairColor);
        setSkinColor(skinColor);
        setEyeColor(eyeColor);
        setPlanet(planet);
        setSpecies(species);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name != null && !name.isEmpty()) ? name.replaceAll("\"", "") : "Desconocido";
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = (gender != null) ? gender : "";
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = (birthYear != null) ? birthYear : "";
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = (height >= 0) ? height : 0;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = (mass >= 0) ? mass : 0;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = (hairColor != null && !hairColor.isEmpty()) ? hairColor : "Desconocido";
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = (skinColor != null) ? skinColor : "";
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = (eyeColor != null) ? eyeColor : "";
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = (planet != null) ? planet : "";
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = (species != null && !species.isEmpty()) ? species : "Desconocido";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return name.equals(character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Birth Year: " + birthYear + "\n" +
                "Height: " + height + " cm\n" +
                "Mass: " + mass + " kg\n" +
                "Hair Color: " + hairColor + "\n" +
                "Skin Color: " + skinColor + "\n" +
                "Eye Color: " + eyeColor + "\n" +
                "Planet: " + planet + "\n" +
                "Species: " + species + "\n";
    }
}