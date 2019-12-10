import { Component, OnInit } from '@angular/core';
import { comicSemilleroDTO } from '../../dto/comicSemillero.dto';

/**
 * @description Esta clase permite enviar un mensaje String a la vista de bienvenida
 * @author Andres David Cabarcas Mestra
 */

@Component({
    selector: 'saludar-semillero',
    templateUrl: './saludar-semillero-component.html'
})
export class SaludarSemilleroComponent implements OnInit {

    /** declaracion de variables(Variable message de tipo String para almacenar el mensaje a mostrar)
     *  */
    public saludoSemillero: string;


    /**
     * declaracion de las variables de tipo comicSemilleroDTO (debemos realizar el importe de la clase)
     * creamos una variable por cada objeto que vayamos a agregar
     */
    public ComicsemilleroDTO: comicSemilleroDTO;
    public ComicsemilleroDTO2: comicSemilleroDTO;
    public ComicsemilleroDTO3: comicSemilleroDTO;
    public ComicsemilleroDTO4: comicSemilleroDTO;
    public ComicsemilleroDTO5: comicSemilleroDTO;

    /**
     * Creamos una variable Array del tipo objeto que utilizaremos
     */
    public arrayComics: Array<comicSemilleroDTO>;

    /**
     * declaramos una variable string para guardar el dato retornado por JSON.stringify
     */
    public imprimirArray: string;

     /**
     * Creamos una variable string para almacenar el nombre del comic a eliminar
     */
    public comicEliminado: string;

     /**
     * Creamos una variable booleana para validar la condificon con ngIf
     */
    public condicion:  boolean;

    /**metodo constructor de la clase
     *  */
    constructor() { }

    /** 
     * 
     * @description Evento angular que se ejecuta para inizializar nuestra variables 
            inicializamos la variable con el texto que queremos enviar 
            en saludar-semillero-component.html llamamos la variable saludo Semillero de la siguente forma
            {{saludoSemillero}}, inicializamos la condicion como false para que el condicional ngIf no muestre
            nada inicialmente, luego inicializamos el vector y llamamos el metodo para cargar los objetos en el array
    */
    ngOnInit(): void {
        // se asigna valor string a nuestra variable
        this.saludoSemillero = "Andrés David Cabarcas Mestra - Monteria";
        
        // se inicializa en false la variable de condicion
        this.condicion = false;

        //Inicializamos nuestro Array
        this.arrayComics = new Array<comicSemilleroDTO>();

        //arrancamos nuestro metodo de cargar y mostrar los elementos del array
        this.cargarObjetosArray();
    }

    /**
     * 
     * @description el metododo deleteItem recibe como parametro el indice a eliminar desde el llamado
     * (click) en nuesto html, luego cambiara el valor de la variable condicion a true para permitir
     * visualizar el mensaje del objeto borrado y mostrar el array actualizado
     */

    public deleteItem(i: any) {
        this.condicion = true;
        this.comicEliminado= "Se ha eliminado el comic : "+this.arrayComics[i].nombre;
        this.arrayComics.splice(i, 1);
        this.imprimirJSON();
    }

     /**
     * 
     * @description con el metodo cargarObjetosArray guardamos los objetos creados manualmente y los listamos
     * utilizando el metodo imprimirJson
     */
    public cargarObjetosArray(): void {
        //para uso parcial creamos una variable tipo Date
        let mifecha = new Date('2019-10-10');

        this.ComicsemilleroDTO = new comicSemilleroDTO();// con la variable declarada anteriormente indicamos que se creara un nuevo comicSemilleroDTO 
        this.ComicsemilleroDTO.id = 1;//Asignamos valores a las variables ingresando atravez de la instancia
        this.ComicsemilleroDTO.nombre = "batman";
        this.ComicsemilleroDTO.editorial = "marvel";
        this.ComicsemilleroDTO.tematica = "accion";
        this.ComicsemilleroDTO.numeroPaginas = 50;
        this.ComicsemilleroDTO.precio = 60, 500.99;
        this.ComicsemilleroDTO.autores = "Pedrito barrera";
        this.ComicsemilleroDTO.aColor = true;
        this.ComicsemilleroDTO.fechaVenta = mifecha;
        this.ComicsemilleroDTO.estado = "activo";


        this.ComicsemilleroDTO2 = new comicSemilleroDTO();//creacion de un segundo objeto
        this.ComicsemilleroDTO2.id = 2;
        this.ComicsemilleroDTO2.nombre = "superman";
        this.ComicsemilleroDTO2.editorial = "marvel";
        this.ComicsemilleroDTO2.tematica = "accion";
        this.ComicsemilleroDTO2.numeroPaginas = 20;
        this.ComicsemilleroDTO2.precio = 40, 500.99;
        this.ComicsemilleroDTO2.autores = "Pedrito barrera";
        this.ComicsemilleroDTO2.aColor = true;
        this.ComicsemilleroDTO2.fechaVenta = mifecha;
        this.ComicsemilleroDTO2.estado = "activo";

        this.ComicsemilleroDTO3 = new comicSemilleroDTO();//creacion de un tercer objeto
        this.ComicsemilleroDTO3.id = 3;
        this.ComicsemilleroDTO3.nombre = "flash";
        this.ComicsemilleroDTO3.editorial = "marvel";
        this.ComicsemilleroDTO3.tematica = "accion";
        this.ComicsemilleroDTO3.numeroPaginas = 20;
        this.ComicsemilleroDTO3.precio = 40, 500.99;
        this.ComicsemilleroDTO3.autores = "Pedrito barrera";
        this.ComicsemilleroDTO3.aColor = false;
        this.ComicsemilleroDTO3.fechaVenta = mifecha;
        this.ComicsemilleroDTO3.estado = "activo";

        this.ComicsemilleroDTO4 = new comicSemilleroDTO();//creacion de un cuarto objeto
        this.ComicsemilleroDTO4.id = 4;
        this.ComicsemilleroDTO4.nombre = "AcuaMan";
        this.ComicsemilleroDTO4.editorial = "marvel";
        this.ComicsemilleroDTO4.tematica = "accion";
        this.ComicsemilleroDTO4.numeroPaginas = 20;
        this.ComicsemilleroDTO4.precio = 40, 500.99;
        this.ComicsemilleroDTO4.autores = "Pedrito barrera";
        this.ComicsemilleroDTO4.aColor = true;
        this.ComicsemilleroDTO4.fechaVenta = mifecha;
        this.ComicsemilleroDTO4.estado = "activo";

        this.ComicsemilleroDTO5 = new comicSemilleroDTO();//creacion de un quinto objeto
        this.ComicsemilleroDTO5.id = 5;
        this.ComicsemilleroDTO5.nombre = "Mujer Maravilla";
        this.ComicsemilleroDTO5.editorial = "marvel";
        this.ComicsemilleroDTO5.tematica = "accion";
        this.ComicsemilleroDTO5.numeroPaginas = 20;
        this.ComicsemilleroDTO5.precio = 40, 500.99;
        this.ComicsemilleroDTO5.autores = "Pedrito barrera";
        this.ComicsemilleroDTO5.aColor = true;
        this.ComicsemilleroDTO5.fechaVenta = mifecha;
        this.ComicsemilleroDTO5.estado = "activo";

        this.arrayComics.push(this.ComicsemilleroDTO);// con el metodo push añadimos los objetos a nuestro Array
        this.arrayComics.push(this.ComicsemilleroDTO2);
        this.arrayComics.push(this.ComicsemilleroDTO3);
        this.arrayComics.push(this.ComicsemilleroDTO4);
        this.arrayComics.push(this.ComicsemilleroDTO5);

        this.imprimirJSON();//llamamos al metodo para listar nuestros objetos 
    }

    /**
     * 
     * @description en este metodo usamos JSON.stringify para convertir a string los objetos del array
     * 
     */
    public imprimirJSON() : string{
        return this.imprimirArray = JSON.stringify(this.arrayComics);
    }


}
