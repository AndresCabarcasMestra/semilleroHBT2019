package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.CompraDTO;




@Local
public interface IGestionarCompraLocal {

	public void crearCompra(CompraDTO compraDTO);

	public void eliminarCompra(Long idCompra);

	/**
	 * @description Metodo encargado de retornar una lista de personajes
	 * @return List<PersonajeDTO> Lista de personajes
	 */
	public List<CompraDTO> consultarCompras();

	/**
	 * @description Metodo encargado de retornar una lista de personajes que
	 *              pertenecen a un comic determinado
	 * 
	 * @return List<PersonajeDTO> Lista de personajes
	 */
	public List<CompraDTO> consultarCompra(Long idCompra);

	/**
	 * @description Metodo para hacer pruebas de excepciones
	 * 
	 * @return List<PersonajeDTO> Lista de personajes
	 */
	public List<CompraDTO> consultarCompras(int index, String cadena);
}
