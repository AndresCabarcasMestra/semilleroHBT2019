package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.RolDTO;

public interface IGestionarRolLocal {
	/**
	 * 
	 * Metodo encargado de crear un Rol y persistirlo
	 * 
	 * @author ccastano
	 * 
	 * @param RolNuevo informacion nueva a crear
	 */
	public void crearRol(RolDTO RolNuevo);

	/**
	 * 
	 * Metodo encargado de consultar un Rol modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicModificar informacion nueva a modificar
	 */
	public void modificarRol();

	/**
	 * 
	 * Metodo encargado de eliminar un Rol modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * @param RolEliminar informacion a eliminar
	 */
	public void eliminarRol();

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un comic
	 * 
	 * @param idComic identificador del comic a ser consultado
	 * @return comic Resultado de la consulta
	 * @throws Exception si no se recibe idPersonaje
	 */
	public RolDTO consultarRol();

	/**
	 * 
	 * Metodo encargado de retornar una lista de Personaje
	 * 
	 * @return
	 */
	public List<RolDTO> consultaRol();

	public List<RolDTO> consultaRol(Long idRol);
}
