package StarWars;

import csvUtils.ObjectToCSVConverter;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CharacterDAOFile implements CharactersDAO {
    private Path csvFile;

    public CharacterDAOFile(Path csvFile) {
        this.csvFile = csvFile;
    }

    @Override
    public void createCharacter(Character character) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(csvFile.toString(), true))) {
            out.write(ObjectToCSVConverter.toStringCsv(character));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Character getCharacterByName(String name) {
        return null;
    }

    @Override
    public void updateCharacter(Character character) {

    }

    @Override
    public void deleteCharacter(String name) {

    }

    @Override
    public List<Character> getAllCharacters() {
        List<Character> characters = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(csvFile.toString()))) {
            ObjectToCSVConverter.getObjectFromCsv(Class.forName("Character"), in.readLine());

        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return characters;
    }
}
