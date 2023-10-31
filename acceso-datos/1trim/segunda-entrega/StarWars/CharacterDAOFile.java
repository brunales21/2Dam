package StarWars;

import csvUtils.ObjectToCSVConverter;
import daoLearning.Pokemon;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CharacterDAOFile implements CharactersDAO {
    private Path csvFile;
    private String delimiter;

    public CharacterDAOFile(Path csvFile, String delimiter) {
        this.csvFile = csvFile;
        this.delimiter = delimiter;
    }

    @Override
    public void createCharacter(Character character) throws RepeatedCharacterException {
        if (existsCharacter(character)) {
            throw new RepeatedCharacterException();
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(csvFile.toString(), true))) {
            out.write(ObjectToCSVConverter.toStringCsv(character, delimiter));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Character getCharacterByName(String name) throws CharacterNoExisteException {
        try {
            return getAllCharacters().stream().filter(c -> c.getName().equals(name)).toList().get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new CharacterNoExisteException();
        }
    }

    @Override
    public void updateCharacter(Character character) throws CharacterNoExisteException {
        List<Character> characters = getAllCharacters();
        Character oldCharacter = getCharacterByName(character.getName());
        if (oldCharacter == null) {
            throw new CharacterNoExisteException();
        }
        characters.remove(oldCharacter);
        characters.add(character);
        pushToCsv(characters);
    }

    @Override
    public void deleteCharacter(String name) throws CharacterNoExisteException {
        List<Character> characters = getAllCharacters();
        Character character = getCharacterByName(name);
        if (character == null) {
            throw new CharacterNoExisteException();
        }
        characters.remove(character);
        pushToCsv(characters);

    }

    @Override
    public List<Character> getAllCharacters() {
        List<Character> characters = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(csvFile.toString()))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] campos = line.split(",");
                if (campos.length == 10) {
                    String name = campos[0];
                    String gender = campos[1];
                    String birthYear = campos[2];
                    int height = Integer.parseInt(campos[3]);
                    double mass = Double.parseDouble(campos[4]);
                    String hairColor = campos[5];
                    String skinColor = campos[6];
                    String eyeColor = campos[7];
                    String planet = campos[8];
                    String species = campos[9];

                    Character character = new Character(name, gender, birthYear, height, mass, hairColor, skinColor, eyeColor, planet, species);
                    characters.add(character);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir datos a números: " + e.getMessage());
        }
        return characters;
    }

    @Override
    public void pushToCsv(List<Character> characters) {
        try (PrintStream out = new PrintStream(new FileOutputStream(csvFile.toString()))) {
            for (Character character: characters) {
                out.println(ObjectToCSVConverter.toStringCsv(character, delimiter));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public boolean existsCharacter(Character character) {
        try {
            getCharacterByName(character.getName;
        } catch (CharacterNoExisteException e) {
            return false;
        }
        return true;
    }


}
