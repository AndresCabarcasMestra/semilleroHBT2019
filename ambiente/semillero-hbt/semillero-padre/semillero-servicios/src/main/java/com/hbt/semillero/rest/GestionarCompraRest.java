package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.CompraDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarCompraLocal;

@Path("/GestionarCompra")
public class GestionarCompraRest {

	final static Logger logger = Logger.getLogger(GestionarCompraRest.class);

	/**
	 * Atriburo que permite gestionar un personaje
	 */
	@EJB
	private IGestionarCompraLocal gestionarCompraEJB;

	/**
	 * 
	 * Say Hello!
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/saludo
	 * 
	 * @return
	 */
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "Gestionar personajes - Prueba inicial servicios rest en el semillero java hbt";
	}
	
	/**
	 * Crea personajes
	 * http://localhost:8085/semillero-servicios/rest/GestionarCliente/crearCliente
	 * 
	 * @param personajeDTO
	 * @return
	 */
	@POST
	@Path("/crearCliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearCompra(CompraDTO compraDTO) {
		logger.error("iNGRESANDO A CREAR compra");
		ResultadoDTO resultadoDTO = null;
		try {
			gestionarCompraEJB.crearCompra(compraDTO);
			resultadoDTO = new ResultadoDTO(Boolean.TRUE, "compra creado exitosamente");
		} catch (Exception e) {
			logger.error("Se ha producido un error al crear personaje: "+e.getMessage());
		}
		logger.error("FINALIZANDO EL METODO");
		return resultadoDTO;			
	}
	

	/**
	 * 
	 * Metodo encargado de traer todos los personajes
	 * http://localhost:8085/semillero-servicios/rest/GestionarCliente/consultarCliente
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarCompra")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CompraDTO> consultarCompra() {
		logger.error("iNGRESANDO A CONSULTAR PERSONAJE");
		List<CompraDTO> listCompraDTO = null;
		try {
			listCompraDTO =  gestionarCompraEJB.consultarCompras();
		} catch (Exception e) {
			logger.error("Se ha producido un error al consultar personajes: "+e.getMessage());
		}

		return listCompraDTO;
	}

	
	

}
