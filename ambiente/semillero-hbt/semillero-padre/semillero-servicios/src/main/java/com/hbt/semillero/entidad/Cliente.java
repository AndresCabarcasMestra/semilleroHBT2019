package com.hbt.semillero.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase que determina la entidad que permite representar la tabla
 * "DB_SEMILLERO"."CLIENTE"
 * 
 * @author ANDRES CABARCAS
 *
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente {

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. mediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	private String tipoDocumento;
	private Long numeroDoc;
	private String fechaNacimiento;
    private Comic comics;
	
    public Cliente() {}
    
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "CLIENTE_ID_GENERATOR", sequenceName = "SEQ_CLIENTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_ID_GENERATOR")
	@Column(name = "CLI_ID")
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * 
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "CLI_NOMBRE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "CLI_TIPODOC")
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "CLI_NUMDOC")
	public Long getNumDoc() {
		return numeroDoc;
	}

	public void setNumDoc(Long numero) {
		this.numeroDoc = numero;
	}
	
	@Column(name = "CLI_FECHANAC")
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLI_ID_COMIC")
	public Comic getComic() {
		return comics;
	}

	/**
	 * @param comic the comic to set
	 */
	public void setComic(Comic comic) {
		this.comics = comic;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() 
	 * Metodo que permite asociar al objeto un texto representativo
	 */
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", numeroDoc=" + numeroDoc
				+ ", fechaNacimiento=" + fechaNacimiento + ", comics=" + comics + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 * Este método viene a complementar al método
	 * equals y sirve para comparar objetos de una forma más rápida en estructuras
	 * Hash ya que únicamente nos devuelve un número entero. Cuando Java compara dos
	 * objetos en estructuras de tipo hash (HashMap, HashSet etc) primero invoca al
	 * método hashcode y luego el equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comics == null) ? 0 : comics.hashCode());
		result = prime * result + ((numeroDoc == null) ? 0 : numeroDoc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object) 
	 * Metodo que permite comparar objetos
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroDoc == null) {
			if (other.numeroDoc != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		return true;
	}

}
