/**
 * @description Clase ComicsemilleroDTO que contiene la informacion de un comic con los parametros indicados en la actividad
 * 
 * @author Andres David Cabarcas Mestra
 */
export class comicSemilleroDTO {

    /**
    * Declaracion de variable id para guardar numero entero
    */
    public id: number;

    /**
    *  Declaracion de variable nombre para guardar una cadena de texto
    */
    public nombre: string;

    /**
    * Declaracion de variable editorial para guardar una cadena de texto
    */
    public editorial: string;

    /**
    * Declaracion de variable tematica para guardar una cadena de texto
    */
    public tematica: string;

    /**
    * Declaracion de variable number para guardar numero entero
    */
    public numeroPaginas: number;

    /**
    * Declaracion de variable number para guardar numero decimal
    */
    public precio: number;

    /**
    * Declaracion de variable autores para guardar una cadena de texto
    */
    public autores: string;

    /**
    * Declaracion de variable aColor para determinar si es a color = true o blanco y negro = false
    */
    public aColor: boolean;

    /**
    * Declaracion de la variable fechaVenta de tipo Date para guardar la fecha de venta
    */
    public fechaVenta: Date;

    /**
    * Declaracion de variable estado para guardar una cadena de texto
    */
    public estado: string;

  
}