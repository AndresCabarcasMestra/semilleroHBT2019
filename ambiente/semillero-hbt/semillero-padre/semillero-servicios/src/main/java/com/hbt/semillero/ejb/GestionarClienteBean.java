package com.hbt.semillero.ejb;

import java.util.ArrayList;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ClienteDTO;
import com.hbt.semillero.entidad.Cliente;
import com.hbt.semillero.entidad.Comic;


@Stateless
public class GestionarClienteBean implements IGestionarClienteLocal {

	final static Logger logger = Logger.getLogger(GestionarClienteBean.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public void crearCliente(ClienteDTO clienteDTO) {
		logger.debug("Inicio del metodo 'crearCliente'");

		try {
			Cliente cliente = convertirDTOEntidad(clienteDTO);
			em.persist(cliente);
			logger.info("Personaje creado correctamente");
		} catch (Exception e) {
			logger.error("Se ha producido en error al crear personaje: " + e.getMessage());
		}

		logger.debug("Fin del metodo 'crearCliente'");

	}

	@Override
	public void modificarPersonaje(Long id, String nombre, ClienteDTO clienteeDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCliente(Long idCliente) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClienteDTO> consultarCliente() {
		logger.debug("Inicio del metodo 'consultarCliente' ");

		List<ClienteDTO> listaClientesDTO = new ArrayList<>();

		List<Cliente> listaClientes = null;

		try {
			String qlString = "SELECT c FROM Cliente c";

			listaClientes = em.createQuery(qlString).getResultList();

			for (Cliente cliente : listaClientes) {
				listaClientesDTO.add(convertirDTOEntidad(cliente));
			}
		} catch (Exception e) {
			logger.debug("Error al consultar cliente: " + e);
		}

		logger.debug("Fin del metodo 'consultarcliente' ");
		return listaClientesDTO;
	}

	@Override
	public List<ClienteDTO> consultarPersonajes(Long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> consultarPersonajes(int index, String cadena) {
		// TODO Auto-generated method stub
		return null;
	}

	private Cliente convertirDTOEntidad(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setTipoDocumento(clienteDTO.getTipoDocumento());
		cliente.setNumDoc(clienteDTO.getNumeroDoc());
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
		cliente.setComic(new Comic());
		cliente.getComic().setId(clienteDTO.getIdComic());
		return cliente;
	}
	
	private ClienteDTO convertirDTOEntidad(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();

		clienteDTO.setId(cliente.getId());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setTipoDocumento(cliente.getTipoDocumento());
		clienteDTO.setNumeroDoc(cliente.getNumDoc());
		clienteDTO.setFechaNacimiento(cliente.getFechaNacimiento());
		clienteDTO.setIdComic(cliente.getComic().getId());

		return clienteDTO;
	}

}
