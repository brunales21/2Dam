package ultimosejs;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Field;
import java.util.Objects;

public class Pokemon {
    private int id;
    private String name;
    private int level;
    private int life;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private int evolveId;
    private String generation;

    public Pokemon() {
        this(0, "", 0, 0, 0, 0, 0, 0, 0, 0, "");
    }

    public Pokemon(int id, String name, int level, int life, int attack, int defense, int specialAttack, int specialDefense, int speed, int evolveId, String generation) {
        setName(name);
        setLevel(level);
        setLife(life);
        setAttack(attack);
        setDefense(defense);
        setSpecialAttack(specialAttack);
        setSpecialDefense(specialDefense);
        setSpeed(speed);
        setId(id);
        setEvolveId(evolveId);
        setGeneration(generation);
    }

    public int getEvolveId() {
        return evolveId;
    }

    public void setEvolveId(int evolveId) {
        this.evolveId = evolveId;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id == pokemon.id && level == pokemon.level && life == pokemon.life && attack == pokemon.attack && defense == pokemon.defense && specialAttack == pokemon.specialAttack && specialDefense == pokemon.specialDefense && speed == pokemon.speed && evolveId == pokemon.evolveId && Objects.equals(name, pokemon.name) && Objects.equals(generation, pokemon.generation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level, life, attack, defense, specialAttack, specialDefense, speed, evolveId, generation);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", life=" + life +
                ", attack=" + attack +
                ", defense=" + defense +
                ", specialAttack=" + specialAttack +
                ", specialDefense=" + specialDefense +
                ", speed=" + speed +
                ", evolveId=" + evolveId +
                ", generation='" + generation + '\'' +
                '}';
    }
}
