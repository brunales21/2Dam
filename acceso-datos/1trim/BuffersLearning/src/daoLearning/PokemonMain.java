/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package daoLearning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergio Cuesta
 */
public class PokemonMain {

    public static void main(String[] args) {
        Pokemon pokemon1 = new Pokemon("Bulbasaur", 10, 45, 49, 49, 65, 65, 45);
        Pokemon pokemon2 = new Pokemon("Charmander", 12, 39, 52, 43, 60, 50, 65);
        Pokemon pokemon3 = new Pokemon("Squirtle", 8, 44, 48, 65, 50, 64, 43);
        Pokemon pokemon4 = new Pokemon("Pidgey", 6, 40, 45, 40, 35, 35, 56);
        Pokemon pokemon5 = new Pokemon("Jigglypuff", 9, 115, 45, 20, 45, 25, 20);
        Pokemon pokemon6 = new Pokemon("Geodude", 7, 40, 80, 100, 30, 30, 20);
        Pokemon pokemon7 = new Pokemon("Machop", 11, 70, 80, 50, 35, 35, 35);
        Pokemon pokemon8 = new Pokemon("Pikachu", 15, 35, 55, 40, 50, 50, 90);
        Pokemon pokemon9 = new Pokemon("Eevee", 12, 55, 55, 50, 55, 65, 55);
        Pokemon pokemon10 = new Pokemon("Mewtwo", 50, 106, 110, 90, 154, 90, 130);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);
        pokemons.add(pokemon3);
        pokemons.add(pokemon4);
        pokemons.add(pokemon5);
        pokemons.add(pokemon6);
        pokemons.add(pokemon7);
        pokemons.add(pokemon8);
        pokemons.add(pokemon9);
        pokemons.add(pokemon10);


        PokemonDAOFile dao = new PokemonDAOFile("PruebasPokemonsDao/pokemonsFile.csv");
        System.out.println(dao.estaVacio());
        dao.pokemonCSV(dao.getPokemonsFile().toString(), pokemon1);
        dao.pokemonCSV(dao.getPokemonsFile().toString(), pokemon2);
        dao.pokemonCSV(dao.getPokemonsFile().toString(), pokemon3);
        dao.pokemonCSV(dao.getPokemonsFile().toString(), pokemon4);
        dao.pokemonCSV(dao.getPokemonsFile().toString(), pokemon5);
        dao.pokemonCSV(dao.getPokemonsFile().toString(), pokemon6);
        dao.pokemonCSV(dao.getPokemonsFile().toString(), pokemon7);
        dao.pokemonCSV(dao.getPokemonsFile().toString(), pokemon8);
        dao.pokemonCSV(dao.getPokemonsFile().toString(), pokemon9);
        dao.pokemonCSV(dao.getPokemonsFile().toString(), pokemon10);
        /*
        try {
            dao.imprimirPokemonCSV(dao.getPokemonsFile().toString());
        } catch (NoSuchFileException e) {
            throw new RuntimeException(e);
        }

        */

        //dao.imprimirPokemon("r");

        //System.out.println(dao.leerPokemons());

        //System.out.println(dao.leerPokemons("r"));

    }

}
