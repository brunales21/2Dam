/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoLearning;

import java.nio.file.NoSuchFileException;
import java.util.List;

public interface PokemonDAO {


    /**
     * Comprueba si el almac�n est� vacio.
     *
     * @return true si est� vacio.
     */
    public boolean estaVacio();

    /**
     * Comprueba si el almac�n est� lleno.
     *
     * @return true si est� lleno.
     */
    public boolean estaLLeno() ;

    /**
     * A�ade un nuevo elemento al almac�n si hay sitio y no est� ya.
     *
     * @param pokemon a a�adir al almac�n.
     * @throws daoLearning.NoMasPokemonsException si el pokemon no se pudo
     *      escribir.
     * @throws daoLearning.PokemonDuplicadoException si el pokemon ya exist�a
     *      en el almac�n.
     */
    public void aniadir(Pokemon pokemon) throws NoMasPokemonsException,
            PokemonDuplicadoException;

    /**
     * Elimina un elemento del almac�n si est� en �l.
     *
     * @param pokemon
     * @return true si elimina el elemento, false en caso contrario.
     */
    public boolean eliminar(Pokemon pokemon);


    /**
     * Escribe en un fichero de texto �csv" la informaci�n de un pokemon
     * separando los campos por puntos y coma.
     * Nombre;nivel;Vida;ataque;defensa;ataqueEspecial;DefensaEspecial;velocidad
     *
     * En caso de existir el fichero, no se borrar�, se seguir�n a�adiendo
     * pokemons al final.
     *
     *
     * @param ruta fichero de texto.
     * @param name
     * @param life
     * @param atack
     * @param defense
     * @param specialAttack
     * @param specialdefense
     * @param speed
     */
    /*public void pokemonCSV(String ruta, String name, int life, int atack,
          int defense, int specialAttack, int specialdefense, int speed);
     */


    void pokemonCSV(String ruta, Pokemon pokemon);

    /**
     * Imprime por pantalla el contenido del fichero csv con los pokemon de la forma:
     * Name: <Nombre>
     * 		level: <nivel>
     * 		HP: <Vida>
     * 		attack: <Vida>
     * 		defense: <defensa>
     * 		Special attack: <AtaqueEspecial>
     * 		Special defense: <DefensaEspecial>
     * 		speed: <velocidad>
     *
     * @param ruta fichero de texto.
     * @throws java.nio.file.NoSuchFileException si no existe el fichero.
     */
    public void imprimirPokemonCSV (String ruta)throws NoSuchFileException;

    /**
     * Imprime por pantalla los objetos pokemon del almac�n que contengan
     *  esa cadena en el nombre.
     *
     *  Por ejemplo �saur� deber�a de devolver a Bulbasaur, Ivysaur,
     *  Venusaur y Mega Venusaur.
     * Name: <Nombre>
     * 		level: <nivel>
     * 		HP: <Vida>
     * 		attack: <Vida>
     * 		defense: <defensa>
     * 		Special attack: <AtaqueEspecial>
     * 		Special defense: <DefensaEspecial>
     * 		speed: <velocidad>
     *
     * @param nombre texto que debe contener el nombre.
     */
    public void imprimirPokemon(String nombre);

    /**
     * Devuelve una lista de objetos pokemon del almac�n.
     *
     * @return lista con todos los pokemons que haya almacenados.
     * Lista vac�a si no hay ninguno.
     */
    public List<Pokemon> leerPokemons();

    /**
     *  Devuelve una lista de objetos pokemon que contengan esa cadena en el
     *  nombre.
     *
     *  Por ejemplo �saur� deber�a de devolver a Bulbasaur, Ivysaur,
     *  Venusaur y Mega Venusaur.
     *
     * @param nombre texto que debe contener el nombre.
     * @return lista con todos los pokemons que haya almacenados que cumplan
     *  el criterio.
     *  Lista vac�a si no hay ninguno.
     */
    public List<Pokemon> leerPokemons(String nombre);
}

