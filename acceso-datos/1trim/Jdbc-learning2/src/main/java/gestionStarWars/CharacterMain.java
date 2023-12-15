package gestionStarWars;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CharacterMain {
    public static void main(String[] args) {
        Path path = Paths.get("PruebasStarWars/people.csv");
        GestorCsvSw cdf = new GestorCsvSw(path, ",");

        Character characterTest = new Character("Bruno");
        try {
            cdf.createCharacter(characterTest);
        } catch (RepeatedCharacterException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(cdf.getCharacterByName(characterTest.getName()));
        } catch (CharacterNoExisteException e) {
            throw new RuntimeException(e);
        }

        System.out.println(cdf.existsCharacter(characterTest));

        Character newCharacterTest = new Character("Bruno", "male");
        //System.out.println(newCharacterTest);

        try {
            cdf.updateCharacter(newCharacterTest);
        } catch (CharacterNoExisteException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(cdf.getCharacterByName(characterTest.getName()));
        } catch (CharacterNoExisteException e) {
            throw new RuntimeException(e);
        }


/*
        try {
            cdf.deleteCharacter("Darth Maul");
        } catch (CharacterNoExisteException e) {
            throw new RuntimeException(e);
        }

 */
    }
}
