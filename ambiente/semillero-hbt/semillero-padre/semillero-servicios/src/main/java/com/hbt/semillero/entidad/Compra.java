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

@Entity
@Table(name = "COMPRA")
public class Compra {
	

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. mediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */

	private static final long serialVersionUID = 1L;

	private Long id;
	private Cliente cliente;
    private Comic comics;
	private String fechaVenta;
	
    public Compra() {}
    
    
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "COMPRA_ID_GENERATOR", sequenceName = "SEQ_COMPRA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPRA_ID_GENERATOR")
	@Column(name = "ID_COMPRA")
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COM_ID_CLIENTE")
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COM_ID_COMIC")
	public Comic getComic() {
		return comics;
	}


	public void setComic(Comic comic) {
		this.comics = comic;
	}
	
	@Column(name = "FECHA_VENTA")
	public String getFechaNacimiento() {
		return fechaVenta;
	}

	public void setFechaNacimiento(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

}
