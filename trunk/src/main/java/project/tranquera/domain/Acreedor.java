package logica;

import excepciones.dataBase.consultas.AbstractQueryException;
import excepciones.logica.AbstractLogicException;
import excepciones.logica.AcreedorException;
import logica.interfaces.Persistencia;
import baseDeDatos.AcreedorDAO;
import java.util.ArrayList;
import java.util.Comparator;
import utilidades.Constantes;
import utilidades.Formatear;
import utilidades.Verificar;

/**
 * Clase destinada a la representacion de un acreedor del restaurante.
 *
 * @version 3.0
 */
public class Acreedor implements Persistencia, Comparator<Acreedor> {

    // El id de un proveedor en particular para su distincion.
    private int id;
    // El nombre del proveedor o su razon social.
    private String nombre;
    // La direccion del proveedor.
    private String direccion;
    // El telefono del proveedor.
    private String telefono;
    // Unas observacines sobre el proveedor.
    private String observacion;
    // Si el proveedor esta todavia vinculado al restaurante.
    private boolean activo;

    /**
     * Constructor por default de un proveedor del restaurante, que se encarga de
     * inicializar todas las variables del objeto de manera predeterminada.
     */
    public Acreedor() {
        this.id = 0;
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.observacion = "";
        this.activo = true;
    }

    /**
     * Funcion estatica que se encarga de retornar el listado de los proveedores
     * del sistema que se encuantran activos.
     * 
     * @return El listado de los proveedores.
     * @throws AbstractQueryException En caso de problemas con la consulta a la base de datos.
     */
    public static ArrayList<Acreedor> getProveedoresActivos() throws AbstractQueryException {
        return AcreedorDAO.getProveedoresActivos();
    }

    /**
     * Funcion que se encarga de verificar que los datos del proveedor esten presente
     * y que los mismos sean correctos.
     *
     * @throws AbstractLogicException En caso de que algun campo del objeto sea nulo o incorrecto.
     */
    @Override
    public void verificar() throws AbstractLogicException {
        // Si el nombre del proveedor es nulo.
        if (this.nombre == null) {
            throw new AcreedorException(AcreedorException.CAMPO_NOMBRE, AcreedorException.ERROR_NOMBRE_NULO);
        }
        // Si el nombre del proveedor es vacio.
        if (this.nombre.isEmpty()) {
            throw new AcreedorException(AcreedorException.CAMPO_NOMBRE, AcreedorException.ERROR_NOMBRE_VACIO);
        }
        // Si el nombre del acreedor no es valido.
        if (!Verificar.esNombreDePersonaJuridicaValido(this.nombre)) {
            throw new AcreedorException(AcreedorException.CAMPO_NOMBRE, AcreedorException.ERROR_NOMBRE_INVALIDO);
        }
        // Si la direccion del proveedor es nula.
        if (this.direccion == null) {
            throw new AcreedorException(AcreedorException.CAMPO_DIRECCION, AcreedorException.ERROR_DIRECCION_NULA);
        }
        // Si la direccion del proveedor es vacia.
        if (this.direccion.isEmpty()) {
            throw new AcreedorException(AcreedorException.CAMPO_DIRECCION, AcreedorException.ERROR_DIRECCION_VACIA);
        }
        // Si la direccion del acreedor no es valida.
        if (!Verificar.esDireccionValida(this.direccion)) {
            throw new AcreedorException(AcreedorException.CAMPO_DIRECCION, AcreedorException.ERROR_DIRECCION_INVALIDA);
        }
        // Si hay telefono asignado, debe ser valido.
        if (this.telefono != null) {
            if (!this.telefono.isEmpty()) {
                if (!Verificar.esNumeroDeTelefonoValido(this.telefono)) {
                    throw new AcreedorException(AcreedorException.CAMPO_TELEFONO, AcreedorException.ERROR_TELEFONO_INVALIDO);
                }
            }
        }
    }

    /**
     * Funcion que se encarga de guardar un proveedor dentro de la base de datos
     * en caso de que su id sea igual a cero, en caso contrario, se modifica el
     * proveedor correspondiente al valor de id correspondiente.
     *
     * @throws AbstractLogicException En caso de que algun campo del objeto sea nulo o incorrecto.
     * @throws AbstractQueryException En caso de problemas con la consulta a la base de datos.
     */
    @Override
    public void guardar() throws AbstractLogicException, AbstractQueryException {
        // Verificamos el contenido del proveedor.
        this.verificar();
        // Guardmos el proveedor si el id del mismo es 0.
        if (this.id != 0) {
            AcreedorDAO.modificarProveedor(this);
        } else {
            AcreedorDAO.guardarProveedor(this);
        }
    }

    /**
     * Funcion encargada de eliminar un proveedor dado de la base de datos.
     *
     * @throws AbstractQueryException En caso de problemas con la consulta a la base de datos.
     */
    @Override
    public void borrar() throws AbstractQueryException {
        AcreedorDAO.borrarProveedor(this);
    }

    /**
     * Funcion que se encarga de hacer una copia de un objeto del tipo proveedor
     * para no afectar los cambios sobre el objeto original.
     *
     * @return Una copia del objeto de proveedor receptor del mensaje.
     */
    @Override
    public Acreedor clone() {
        // Creamos un nuevo acreedor.
        Acreedor acreedorClonado = new Acreedor();
        // Seteamos el acreedor para clonarlo.
        acreedorClonado.setID(this.id);
        acreedorClonado.setNombre(this.nombre);
        acreedorClonado.setDireccion(this.direccion);
        acreedorClonado.setTelefono(this.telefono);
        acreedorClonado.setObservacion(this.observacion);
        acreedorClonado.setActivo(this.activo);
        // Retornamos el acreedor clonado.
        return acreedorClonado;
    }

    /**
     * Funcion que se encarga de visualizar por consola el contenido propio del
     * objeto de proveedor que recibe el mensaje, para corroborar el correcto
     * contenido del mismo.
     * 
     * @return El String que contiene el detalle del centenido del objeto.
     */
    @Override
    public String toString() {
        String mensaje = "<<<<<<<<<<<<<<<<<<<<<PROVEEDOR>>>>>>>>>>>>>>>>>>>>>";
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        System.out.println("ID Proveedor: " + this.id);
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        System.out.println("Nombre: " + this.nombre);
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        System.out.println("Direccion: " + this.direccion);
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        System.out.println("Telefono: " + this.telefono);
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        System.out.println("Obserrvación: " + this.observacion);
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        System.out.println("Activo: " + this.activo);
        return mensaje;
    }

    /**
     * Funcion que se encarga de comparar 2 proveedores para luego poder ordenarlos dentro
     * del arraylist de proveedores para desplegarlos ordenadamente.
     *
     * @param o1 El primer proveedor a comparar.
     * @param o2 El otro proveedor a comparar.
     * @return El valor correspondiente al valor de orden que corresponderia a cada
     * uno de de los objetos a comparar.
     */
    @Override
    public int compare(Acreedor o1, Acreedor o2) {
        return o1.getNombre().compareToIgnoreCase(o2.getNombre());
    }

    /**
     * El setter del id del acreedor.
     * 
     * @param id El id del acreedor.
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * El setter del nombre del acreedor.
     *
     * @param nombre El nombre del acreedor.
     */
    public void setNombre(String nombre) {
        this.nombre = Formatear.formatearCadena(nombre);
    }

    /**
     * El setter de la direccion del acreedor.
     *
     * @param direccion La direccion del acreedor.
     */
    public void setDireccion(String direccion) {
        this.direccion = Formatear.formatearCadena(direccion);
    }

    /**
     * El setter del telefono del acreedor.
     *
     * @param telefono El telefono del acreedor.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * El setter de la observacion del acreedor.
     *
     * @param observacion La observacion del acreedor.
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * El setter del estado del acreedor.
     * 
     * @param activo El valor del estado del acreedor.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     *  El getter del id del acreedor.
     * 
     * @return El id del acreedor.
     */
    public int getID() {
        return id;
    }

    /**
     *  El getter del nombre del acreedor.
     * 
     * @return El nombre del acreedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *  El getter de la direccion del acreedor.
     * 
     * @return La direccion del acreedor.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *  El getter del telefono del acreedor.
     * 
     * @return El telefono del acreedor.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *  El getter de la observacion del acreedor.
     *
     * @return La observacion del acreedor.
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     *  El getter del estado del acreedor.
     *
     * @return El estado del acreedor.
     */
    public boolean getActivo() {
        return activo;
    }
}
