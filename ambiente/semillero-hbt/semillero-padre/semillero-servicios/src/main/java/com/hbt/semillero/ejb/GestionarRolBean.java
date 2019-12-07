package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.entidad.Rol;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los Roles
 * 
 * @author ccastano
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarRolBean implements IGestionarRolLocal {

	final static Logger logger = Logger.getLogger(GestionarComicBean.class);

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	//metodo para crear un nuevo rol
	@Override
	public void crearRol(RolDTO rolDTO) {
		logger.debug("Se inicia el metodo crear ROl");
		Rol rol = convertirDTOEntidad(rolDTO);
		em.persist(rol);
		logger.debug("Finaliza el metodo crear ROL");

	}

	@Override
	public void modificarRol() {
		logger.debug("Se inicia el metodo modificar rol");

		logger.debug("Finaliza el metodo modificar rol");

	}

	@Override
	public void eliminarRol() {
		logger.debug("Se inicia el metodo eliminarRol");

		logger.debug("Finaliza el metodo eliminarRol");
	}

	@Override
	public RolDTO consultarRol() {
		logger.debug("Se inicia el metodo consultarRol");

		logger.debug("Finaliza el metodo consultarRol");
		return null;
	}

	//metodo para consultar todos los roles en la tabla
	@Override
	public List<RolDTO> consultaRol() {
		logger.debug("Se inicia el metodo consulta Rol");
		String query = "SELECT ROL FROM rol Rol";

		List<Rol> listaRol = em.createQuery(query).getResultList();

		List<RolDTO> listaRolDTO = new ArrayList<>();

		for (Rol rol : listaRol) {
			listaRolDTO.add(convertirEntidadDTO(rol));
		}

		logger.debug("Finaliza el metodo consulta ROl");
		return listaRolDTO;
	}

	//metodo para consultar un rol en especifico
	@Override
	public List<RolDTO> consultaRol(Long idRol) {
		logger.debug("Se inicia el metodo consulta Rol");
		String query = "SELECT ROL FROM rol Rol WHERE ROL.id = : idRol";

		List<Rol> listaRol = em.createQuery(query).setParameter("idRol", idRol).getResultList();

		List<RolDTO> listaRolDTO = new ArrayList<>();

		for (Rol rol : listaRol) {
			listaRolDTO.add(convertirEntidadDTO(rol));
		}

		logger.debug("Finaliza el metodo consulta Rol");
		return listaRolDTO;
	}

	//metodo para convertir un DTO a entidad
	private Rol convertirDTOEntidad(RolDTO rolDTO) {
		logger.debug("Se inicia el metodo convertirDTOEntidad");
		Rol rol = new Rol();
		rol.setId(rolDTO.getId());
		rol.setNombre(rolDTO.getNombre());
		rol.setEstado(rolDTO.getEstado());
		logger.debug("Se inicia el metodo convertirDTOEntidad");
		return rol;
	}

	//metodo para convertir una entidad a un DTO
	private RolDTO convertirEntidadDTO(Rol rol) {
		logger.debug("Se inicia el metodo convertirEntidadDTO");

		RolDTO rolDTO = new RolDTO();
		rolDTO.setId(rol.getId());
		rolDTO.setNombre(rol.getNombre());
		rol.setEstado(rolDTO.getEstado());
		logger.debug("Finaliza el metodo convertirEntidadDTO");
		return rolDTO;
	}

}
