/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoLearning;

import csvUtils.ObjectToCSVConverter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio Cuesta
 */
public class PokemonDAOFile implements PokemonDAO {
    private Path pokemonsFile;
    private String delimiter;

    public PokemonDAOFile(String pathName) {
        this.pokemonsFile = Paths.get(pathName);
        this.delimiter = ";";
    }

    @Override
    public boolean estaVacio() {
        return leerPokemons().isEmpty();
    }

    @Override
    public boolean estaLLeno() {
        return false;
    }

    @Override
    public void aniadir(Pokemon pokemon) throws NoMasPokemonsException, PokemonDuplicadoException {
        if (estaLLeno()) {
            throw new NoMasPokemonsException();
        }
        if (leerPokemons().contains(pokemon)) {
            throw new PokemonDuplicadoException();
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pokemonsFile.toString()))) {
            out.writeObject(pokemon);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public boolean eliminar(Pokemon pokemon) {
        List<Pokemon> pokemons = leerPokemons();
        if (!pokemons.contains(pokemon)) {
            return false;
        } else {
            pokemons.remove(pokemon);
        }
        pokemons.forEach(p -> pokemonCSV(pokemonsFile.toString(), pokemon));
        return true;

    }

    @Override
    public void pokemonCSV(String ruta, Pokemon pokemon) {
        try (PrintStream out = new PrintStream(new FileOutputStream(ruta, true))) {
            out.println(ObjectToCSVConverter.toStringCsv(pokemon, delimiter));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void imprimirPokemonCSV(String ruta) throws NoSuchFileException {
        leerPokemons().forEach(System.out::println);
    }

    @Override
    public void imprimirPokemon(String nombre) {
        leerPokemons(nombre).forEach(System.out::println);
    }

    @Override
    public List<Pokemon> leerPokemons() {
        //to csv file
        List<Pokemon> pokemons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pokemonsFile.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] campos = line.split(";");
                if (campos.length == 8) {
                    String name = campos[0];
                    int level = Integer.parseInt(campos[1]);
                    int life = Integer.parseInt(campos[2]);
                    int attack = Integer.parseInt(campos[3]);
                    int defense = Integer.parseInt(campos[4]);
                    int specialAttack = Integer.parseInt(campos[5]);
                    int specialDefense = Integer.parseInt(campos[6]);
                    int speed = Integer.parseInt(campos[7]);

                    Pokemon pokemon = new Pokemon(name, level, life, attack, defense, specialAttack, specialDefense, speed);
                    pokemons.add(pokemon);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir datos a números: " + e.getMessage());
        }

        return pokemons;
        /*
        // to binary file
        List<Pokemon> pokemons = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(pokemonsFile.toString()))) {
            Pokemon pokemon;
            while ((pokemon = (Pokemon) in.readObject()) != null) {
                pokemons.add(pokemon);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return pokemons;

         */
    }

    @Override
    public List<Pokemon> leerPokemons(String nombre) {
        return leerPokemons().stream().filter(p -> p.getName().contains(nombre)).toList();
    }

    public Path getPokemonsFile() {
        return pokemonsFile;
    }
}
