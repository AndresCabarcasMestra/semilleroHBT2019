package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Personaje;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los Personajes
 * 
 * @author ccastano
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonajeBean implements IGestionarPersonajeLocal {

	final static Logger logger = Logger.getLogger(GestionarComicBean.class);

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersonaje(PersonajeDTO personajeDTO) {
		logger.debug("Se inicia el metodo crear personaje");
		Personaje personaje = convertirDTOEntidad(personajeDTO);
		em.persist(personaje);
		logger.debug("Finaliza el metodo crear personaje");

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void modificarPersonaje() {
		logger.debug("Se inicia el metodo modificar personaje");

		logger.debug("Finaliza el metodo modificar personaje");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void eliminarPersonaje() {
		logger.debug("Se inicia el metodo eliminar personaje");

		logger.debug("Finaliza el metodo eliminar personaje");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ComicDTO consultarPersonaje() {
		logger.debug("Se inicia el metodo consultar personaje");

		logger.debug("Finaliza el metodo consultar personaje");
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<PersonajeDTO> consultaPersonaje() {
		logger.debug("Se inicia el metodo consulta personaje");
		String query = "SELECT personaje FROM Personaje personaje";

		List<Personaje> listaPersonaje = em.createQuery(query).getResultList();

		List<PersonajeDTO> listaPersonajeDTO = new ArrayList<>();

		for (Personaje personaje : listaPersonaje) {
			listaPersonajeDTO.add(convertirEntidadDTO(personaje));
		}

		logger.debug("Finaliza el metodo consulta personaje");
		return listaPersonajeDTO;
	}

	@Override
	public List<PersonajeDTO> consultaPersonaje(Long idComic) {
		logger.debug("Se inicia el metodo consulta personaje");
		String query = "SELECT personaje FROM Personaje personaje WHERE personaje.comic.id = : idComic";

		List<Personaje> listaPersonaje = em.createQuery(query).setParameter("idComic", idComic).getResultList();

		List<PersonajeDTO> listaPersonajeDTO = new ArrayList<>();

		for (Personaje personaje : listaPersonaje) {
			listaPersonajeDTO.add(convertirEntidadDTO(personaje));
		}

		logger.debug("Finaliza el metodo consulta personaje");
		return listaPersonajeDTO;
	}

	private Personaje convertirDTOEntidad(PersonajeDTO personajeDTO) {
		Personaje personaje = new Personaje();
		personaje.setId(personajeDTO.getId());
		personaje.setNombre(personajeDTO.getNombre());
		personaje.setComic(new Comic());
		personaje.getComic().setId(personajeDTO.getIdComic());
		personaje.setEstado(personajeDTO.getEstado());
		personaje.setSuperpoder(personajeDTO.getSuperpoder());
		return personaje;
	}

	private PersonajeDTO convertirEntidadDTO(Personaje personaje) {
		PersonajeDTO personajeDTO = new PersonajeDTO();
		personajeDTO.setId(personaje.getId());
		personajeDTO.setNombre(personaje.getNombre());
		personajeDTO.setIdComic(personaje.getComic().getId());
		personajeDTO.setEstado(personaje.getEstado());
		personajeDTO.setSuperpoder(personaje.getSuperpoder());
		return personajeDTO;
	}

}
