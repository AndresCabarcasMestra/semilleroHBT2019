import { ClienteDTO } from '../../dto/cliente.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

/**
 * @description Componenete gestionar cliente, el cual contiene la logica CRUD
 * 
 * @author Andres Cabarcas
 */
@Component({
    selector: 'gestionar-cliente',
    templateUrl: './gestionar-cliente.html'
})

export class GestionarClienteComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarClienteForm: FormGroup;

    /**
     * Atributo que contendra la informacion del cliente
     */
    public cliente: ClienteDTO;

    /**
     * Atributo que indica el ID incrementable al crear un
     * nuevo Cliente
     */
    public idCliente: number = 0;

    /**
  * Atributo que contendra la lista de comics creados
  */
    public listaCliente: Array<ClienteDTO>;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;

    /**
     * Atributo que indica si debe mostrarse el boton para crear un comic
     */
    public showCreateBtn: boolean;

    /**
     * Atributo que indica si debe mostrarse el boton para confirmar 
     * los cambios al editar un cliente
     */
    public showUpdateBtn: boolean;


    /**
     * 
     * @description Este es el constructor del componente GestionarClienteComponent
     * 
     * @param fb 
     * @param router 
     * @param toastr 
     */
    constructor(private fb: FormBuilder, private router: Router, private toastr: ToastrService) {
        this.gestionarClienteForm = this.fb.group({
            id: [null],
            nombre: [null, Validators.required],
            tipoDocumento: [null],
            numeroDoc: [null],
            fechaNacimiento: [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     */
    ngOnInit(): void {
        console.log("Ingreso al evento onInit");
        this.cliente = new ClienteDTO();
        this.listaCliente = new Array<ClienteDTO>();
        this.showCreateBtn = true;
    }



    /**
     * @description Metodo que permite validar el formulario y crear un cliente
     */
    public CreateCliente(): void {
        this.submitted = true;

        if (this.gestionarClienteForm.invalid) {
            return;
        }

        this.idCliente++;
        this.cliente = new ClienteDTO();
        this.cliente.id = this.idCliente + "";
        this.cliente.nombre = this.f.nombre.value;
        this.cliente.tipoDocumento = this.f.tipoDocumento.value;
        this.cliente.numeroDoc = this.f.numeroDoc.value;

        this.listaCliente.push(this.cliente);


        this.limpiarFormulario();

        // Se muestra una notificación confirmando el registro del nuevo cliente
        this.toastr.success('¡Se registró exitosamente el cliente:  "' + this.cliente.nombre + '"!');
    }

    private GuardarDBcliente(){}




    /**
     * @description Metodo que permite validar el formulario y actualizar los 
     * detalles de un comic
     */
    public UpdateCliente(): void {
        this.submitted = true;

        if (this.gestionarClienteForm.invalid) {
            return;
        };

        // Creación de un nuevo Cliente para llenar con nuevos datos
        this.cliente = new ClienteDTO();

        this.cliente.id = this.f.id.value;
        this.cliente = new ClienteDTO();
        this.cliente.id = this.idCliente + "";
        this.cliente.nombre = this.f.nombre.value;
        this.cliente.tipoDocumento = this.f.tipoDocumento.value;
        this.cliente.numeroDoc = this.f.numeroDoc.value;

        // Se ubica el nuevo comic en la posición del comic viejo
        this.listaCliente.splice((this.f.id.value) - 1, 1, this.cliente);
        this.limpiarFormulario();

        // Mostramos el boton para registrar cliente
        this.showCreateBtn = true;

        // Ocultamos el boton para actualizar cliente
        this.showUpdateBtn = false;

        // Se muestra una notificación confirmando la actualización del comic
        this.toastr.info('¡Cliente "' + this.cliente.nombre + '" actualizado exitosamente!');
    }


    /**
     * Metodo que consulta un cliente en la lista y lo elimina
     * 
     * @param index del comic seleccionado en la lista 
     */
    public DeleteCliente(index: number): void {
        // Eliminar elemento ubicado en la posición index de la lista
        let deleted = this.listaCliente.splice(index, 1)[0];

        // Se muestra una notificación confirmando la eliminación del cliente
        this.toastr.warning('¡Cliente "' + deleted.nombre + '" eliminado exitosamente!');
    }


    /**
     * Metodo que permite consultar un cliente de la tabla y sus detalles para 
     * llenar el formulario de edición
     *  
     * @param index en la lista del cliente seleccionado
     */
    public EditCliente(index: number): void {
        let cliente = this.listaCliente[index];
        this.f.id.setValue(cliente.id);
        this.f.nombre.setValue(cliente.nombre);
        this.f.tipoDocumento.setValue(cliente.tipoDocumento);
        this.f.numeroDoc.setValue(cliente.numeroDoc);
        this.f.fechaNacimiento.setValue(cliente.fechaNacimiento);

        // Se oculta el boton para registrar nuevos clientes
        this.showCreateBtn = false;

        // Se muestra el boton para actualizar cliente
        this.showUpdateBtn = true;
    }


    /**
     * Metodo que formatea el formulario
     */
    private limpiarFormulario(): void {
        this.submitted = false;
        this.f.id.setValue(null);
        this.f.nombre.setValue(null);
        this.f.tipoDocumento.setValue(null);
        this.f.numeroDoc.setValue(null);
        this.f.fechaNacimiento.setValue(null);
    }


    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() {
        return this.gestionarClienteForm.controls;
    }
}