package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;

/**
 * Expone los métodos del EJB GestionarPersonaje Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author ccastano
 *
 */
@Local
public interface IGestionarPersonajeLocal {
	/**
	 * 
	 * Metodo encargado de crear un Personaje y persistirlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicNuevo informacion nueva a crear
	 */
	public void crearPersonaje(PersonajeDTO personajeNuevo);

	/**
	 * 
	 * Metodo encargado de consultar un Personaje modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicModificar informacion nueva a modificar
	 */
	public void modificarPersonaje();

	/**
	 * 
	 * Metodo encargado de eliminar un Personaje modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicEliminar informacion a eliminar
	 */
	public void eliminarPersonaje();

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un comic
	 * 
	 * @param idComic identificador del comic a ser consultado
	 * @return comic Resultado de la consulta
	 * @throws Exception si no se recibe idPersonaje
	 */
	public ComicDTO consultarPersonaje();

	/**
	 * 
	 * Metodo encargado de retornar una lista de Personaje
	 * 
	 * @return
	 */
	public List<PersonajeDTO> consultaPersonaje();

	public List<PersonajeDTO> consultaPersonaje(Long idComic);
}
