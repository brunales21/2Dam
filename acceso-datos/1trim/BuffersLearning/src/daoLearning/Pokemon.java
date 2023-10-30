package daoLearning;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Field;
import java.util.Objects;

public class Pokemon implements Externalizable {
    private String name;
    private int level;
    private int life;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public Pokemon() {
        this("", 0, 0, 0, 0, 0, 0, 0);
    }

    public Pokemon(String name, int level, int life, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        setName(name);
        setLevel(level);
        setLife(life);
        setAttack(attack);
        setDefense(defense);
        setSpecialAttack(specialAttack);
        setSpecialDefense(specialDefense);
        setSpeed(speed);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name != null) ? name : "";
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level > 100) {
            this.level = 100;
        } else if (level < 0) {
            this.level = 0;
        } else {
            this.level = level;
        }
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        if (life < 0) {
            this.life = 0;
        } else {
            this.life = life;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 0) {
            this.attack = 0;
        } else {
            this.attack = attack;
        }
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        if (defense < 0) {
            this.defense = 0;
        } else {
            this.defense = defense;
        }
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        if (specialAttack < 0) {
            this.specialAttack = 0;
        } else {
            this.specialAttack = specialAttack;
        }
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        if (specialDefense < 0) {
            this.specialDefense = 0;
        } else {
            this.specialDefense = specialDefense;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
        } else {
            this.speed = speed;
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(level);
        out.writeInt(life);
        out.writeInt(attack);
        out.writeInt(defense);
        out.writeInt(specialAttack);
        out.writeInt(specialDefense);
        out.writeInt(speed);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        level = in.readInt();
        life = in.readInt();
        attack = in.readInt();
        defense = in.readInt();
        specialAttack = in.readInt();
        specialDefense = in.readInt();
        speed = in.readInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return name.equals(pokemon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Level: " + level + "\n" +
                "HP: " + life + "\n" +
                "Attack: " + attack + "\n" +
                "Defense: " + defense + "\n" +
                "Special attack: " + specialAttack + "\n" +
                "Special defense: " + specialDefense + "\n" +
                "Speed: " + speed+"\n";
    }


    public static String toStringCsv(Object object) {
        StringBuilder sb = new StringBuilder();
        try {
            Class miClase = Class.forName(object.getClass().getName());
            Field[] campos = miClase.getDeclaredFields();
            for (Field campo: campos) {
                sb.append(campo.get(object)).append(";");
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
