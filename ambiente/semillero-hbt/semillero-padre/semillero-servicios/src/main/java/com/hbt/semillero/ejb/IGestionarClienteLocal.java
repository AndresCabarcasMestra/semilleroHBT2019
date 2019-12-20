package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ClienteDTO;

@Local
public interface IGestionarClienteLocal {

	/**
	 * @description Metodo encargado de crear un personaje y persistirlo
	 * @param personajeDTO informacion nueva a crear
	 * @return 
	 */
	public void crearCliente(ClienteDTO clienteDTO);

	/**
	 * @description Metodo encargado de consultar un personaje, modificarlo y
	 *              guardarlo
	 * @param personajeDTO informacion nueva a modificar
	 */
	public void modificarPersonaje(Long id, String nombre, ClienteDTO clienteeDTO);

	/**
	 * @description Metodo encargado de eliminar un personaje
	 * @param idPersonaje informacion a eliminar
	 */
	public void eliminarCliente(Long idCliente);

	/**
	 * @description Metodo encargado de retornar una lista de personajes
	 * @return List<PersonajeDTO> Lista de personajes
	 */
	public List<ClienteDTO> consultarCliente();

	/**
	 * @description Metodo encargado de retornar una lista de personajes que
	 *              pertenecen a un comic determinado
	 * 
	 * @return List<PersonajeDTO> Lista de personajes
	 */
	public List<ClienteDTO> consultarPersonajes(Long idCliente);

	/**
	 * @description Metodo para hacer pruebas de excepciones
	 * 
	 * @return List<PersonajeDTO> Lista de personajes
	 */
	public List<ClienteDTO> consultarPersonajes(int index, String cadena);
}
