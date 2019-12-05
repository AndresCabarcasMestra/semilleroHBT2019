package com.hbt.semillero.ejb;

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

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los Personajes
 * 
 * @author ccastano
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonajeBean implements IGestionarPersonajeLocal{
	
	
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
	public void crearPersonaje(PersonajeDTO personajeNuevo) {
		logger.debug("Se inicia el metodo crear personaje");
		
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
		
		logger.debug("Finaliza el metodo consulta personaje");
		return null;
	}

}
