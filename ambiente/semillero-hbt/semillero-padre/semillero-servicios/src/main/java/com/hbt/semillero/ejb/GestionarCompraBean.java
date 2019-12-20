package com.hbt.semillero.ejb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ClienteDTO;
import com.hbt.semillero.dto.CompraDTO;
import com.hbt.semillero.entidad.Cliente;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Compra;

public class GestionarCompraBean  implements IGestionarCompraLocal{
	
	final static Logger logger = Logger.getLogger(GestionarClienteBean.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public void crearCompra(CompraDTO compraDTO) {
		logger.debug("Inicio del metodo 'crearCliente'");

		try {
			Compra compra = convertirDTOEntidad(compraDTO);
			em.persist(compra);
			logger.info("Personaje creado correctamente");
		} catch (Exception e) {
			logger.error("Se ha producido en error al crear personaje: " + e.getMessage());
		}

		logger.debug("Fin del metodo 'crearCliente'");
		
	}

	@Override
	public void eliminarCompra(Long idCompra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompraDTO> consultarCompras() {
		logger.debug("Inicio del metodo 'consultarCompra' ");

		List<CompraDTO> listaComprasDTO = new ArrayList<>();

		List<Compra> listaCompras = null;

		try {
			String qlString = "SELECT c FROM Compra c";

			listaCompras = em.createQuery(qlString).getResultList();

			for (Compra compra : listaCompras) {
				listaComprasDTO.add(convertirDTOEntidad(compra));
			}
		} catch (Exception e) {
			logger.debug("Error al consultar Compra: " + e);
		}

		logger.debug("Fin del metodo 'consultarCompra' ");
		return listaComprasDTO;
	}

	@Override
	public List<CompraDTO> consultarCompra(Long idCompra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompraDTO> consultarCompras(int index, String cadena) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Compra convertirDTOEntidad(CompraDTO compraDTO) {
		Compra compra = new Compra();
		compra.setId(compraDTO.getId());
		compra.setCliente((new Cliente()));
		compra.getCliente().setId(compraDTO.getIdCliente());
		compra.setComic(new Comic());
		compra.getComic().setId(compraDTO.getIdComic());
		compra.setFechaNacimiento(getFechaActual());
		return compra;
	}
	
	   public String getFechaActual() {
	        Date ahora = new Date();
	        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
	        return formateador.format(ahora);
	    }
	   
		private CompraDTO convertirDTOEntidad(Compra compra) {
			CompraDTO compraDTO = new CompraDTO();	
			
			compraDTO.setId(compra.getId());
			compraDTO.setIdComic(compra.getComic().getId());
			compraDTO.setIdCliente(compra.getCliente().getId());
			compraDTO.setFechaVenta(getFechaActual());

			return compraDTO;
		}

}
