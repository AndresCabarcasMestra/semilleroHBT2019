import { Component, OnInit } from '@angular/core';

/**
 * @description La clase CrearPersonaComponent permite crear personas
 * @author Andres David Cabarcas Mestra
 */

@Component({
    selector: 'saludar-semillero',
    templateUrl: './saludar-semillero-component.html'
})
export class SaludarSemilleroComponent implements OnInit {

    //declaracion de variables(Variable message de tipo String para almacenar el mensaje a mostrar)
    public saludoSemillero: string;

    //metodo constructor de la clase
    constructor() { }


    ngOnInit(): void {
        //inicializamos la variable con el texto que queremos enviar 
        //en saludar-semillero-component.html llamamos la variable saludo Semillero de la siguente forma
        // {{saludoSemillero}}
        this.saludoSemillero = "Andrés David Cabarcas Mestra - Monteria";
    }

}