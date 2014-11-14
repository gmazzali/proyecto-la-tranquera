package logica;

import excepciones.dataBase.consultas.AbstractQueryException;
import excepciones.logica.AbstractLogicException;
import excepciones.logica.TipoDeTransaccionException;
import excepciones.dataBase.NotFoundException;
import baseDeDatos.TipoDeTransaccionDAO;
import logica.interfaces.Persistencia;
import java.util.ArrayList;
import utilidades.Constantes;
import utilidades.Formatear;
import utilidades.Verificar;

/**
 * Clase que se utiliza para definir u motivo de egreso o ingreso de dinero a la
 * caja del restaurante.
 *
 * @version 3.0
 */
public class TipoDeTransaccion implements Persistencia {

    /** El listado de los ID de los tipos de transacciones que no pueden mostrarse
     * dentro de los combos de eleccion del tipo de transaccion por ser las mismas
     * de uso interno al sistema. */
    public static int[] TRANSACCIONES_OCULTAS = {1, 14, 15, 16, 17};
    
    // Los id de los movimientos que no se modifican.
    /** El id del tipo de transaccion del cobro de una mesa. */
    public static int COBRO_MESA = 1;
    /** El id del tipo de transaccion del ingreso generico de dinero. */
    public static int INGRESO_GENERICO = 5;
    /** El id del tipo de transaccion del egreso generico de dinero. */
    public static int EGRESO_GENERICO = 13;
    /** El id del tipo de transaccion del pago a un acreedor. */
    public static int PAGO_PROVEEDOR = 10;
    /** El id del tipo de transaccion del ingreso de dinero desde la caja grande a la caja chica. */
    public static int INGRESO_DESDE_CAJA_CHICA = 14;
    /** El id del tipo de transaccion del ingreso de dinero desde la caja chica a la caja grande. */
    public static int INGRESO_DESDE_CAJA_GRANDE = 15;
    /** El id del tipo de transaccion del egreso de dinero desde la caja grande a la caja chica. */
    public static int EGRESO_HACIA_CAJA_CHICA = 16;
    /** El id del tipo de transaccion del egreso de dinero desde la caja chica a la caja grande. */
    public static int EGRESO_HACIA_CAJA_GRANDE = 17;
    
    // Las variables de instancia.
    // El id de un tipo de trasaccion.
    private int id;
    // Una descripcion del tipo de transaccion.
    private String descripcion;
    // Si el tipo de transaccion esta activo o no.
    private boolean activo;
    // Si esta permitida la modificacion del tipo de transaccion.
    private boolean permisoDeModificacion;
    // El caracter del tipo de transaccion.
    private CaracterDeTipoDeTransaccion caracter;

    /**
     * Constructor por default de un tipo de transaccion.
     */
    public TipoDeTransaccion() {
        this.id = 0;
        this.descripcion = "";
        this.activo = true;
        this.permisoDeModificacion = true;
        this.caracter = null;
    }

    /**
     * Funcion estatica que se encarga de obtener todos los tipos de transacciones
     * activos para un caracter de tipo de transaccion dado y retornarlos.
     *
     * @param caracter El caracter del tipo de transaccion a sacar de la base de datos.
     * @return El listado de los tipos de transaccion correspondientes al caracter dado.
     * @throws AbstractQueryException En caso de problemas con la consulta a la base de datos.
     */
    public static ArrayList<TipoDeTransaccion> getTiposDeTransacciones(CaracterDeTipoDeTransaccion caracter) throws AbstractQueryException {
        if (caracter.getDescripcion().equals(CaracterDeTipoDeTransaccion.INGRESO)) {
            // Si el tipo de motivo es de ingreso.
            return TipoDeTransaccionDAO.getTipoDeTransaccionIngreso();
        } else if (caracter.getDescripcion().equals(CaracterDeTipoDeTransaccion.EGRESO)) {
            // Si el tipo de motivo es egreso.
            return TipoDeTransaccionDAO.getTipoDeTransaccionEgresos();
        } else {
            return new ArrayList<TipoDeTransaccion>();
        }
    }

    /**
     * Funcion utilizada para obtener un tipo de transaccion en particular, la
     * cual se pide con el id correspondiente.
     *
     * @param idTipo El id del tipo de transaccion que se desea.
     * @return El tipo de transaccion correspondiente al id pasado.
     * @throws AbstractQueryException En caso de problemas con la consulta a la base de datos.
     * @throws NotFoundException En caso de que el tipo de transaccion buscada no se encuentre dentro de la base de datos.
     */
    public static TipoDeTransaccion getTipoDeTransaccion(int idTipo) throws AbstractQueryException, NotFoundException {
        return TipoDeTransaccionDAO.getTipoDeTransaccion(idTipo);
    }

    /**
     * Funcion utilizada para verificar el contenido del tipo de transaccion antes
     * que este pase a ser parte de la base de datos.
     *
     * @throws AbstractLogicException En caso de que algun campo del objeto sea nulo o incorrecto.
     */
    @Override
    public void verificar() throws AbstractLogicException {
        // Si no tiene asigando algun caracter de transaccion.
        if (this.caracter == null) {
            throw new TipoDeTransaccionException(TipoDeTransaccionException.CAMPO_CARACTER, TipoDeTransaccionException.ERROR_CARACTER_NULO);
        }
        // Si tiene asignado un caracter de transaccio por default.
        if (this.caracter.getID() == 0) {
            throw new TipoDeTransaccionException(TipoDeTransaccionException.CAMPO_CARACTER, TipoDeTransaccionException.ERROR_CARACTER_INVALIDO);
        }
        // Si no tiene asignada ninguna descripcion del tipo de transaccion.
        if (this.descripcion == null) {
            throw new TipoDeTransaccionException(TipoDeTransaccionException.CAMPO_DESCRIPCION, TipoDeTransaccionException.ERROR_DESCRIPCION_NULA);
        }
        // Si la descripcion del tipo de transaccion esta vacia.
        if (this.descripcion.isEmpty()) {
            throw new TipoDeTransaccionException(TipoDeTransaccionException.CAMPO_DESCRIPCION, TipoDeTransaccionException.ERROR_DESCRIPCION_VACIA);
        }
        // Si la descripcion del tipo de transaccion es incorrecta.
        if (!Verificar.esDescripcionValida(this.descripcion)) {
            throw new TipoDeTransaccionException(TipoDeTransaccionException.CAMPO_DESCRIPCION, TipoDeTransaccionException.ERROR_DESCRIPCION_INVALIDA);
        }
    }

    /**
     * Funcion utilizada para guardar un tipo de transaccion dentro de la base de
     * datos. Se da de alta un nuevo tipo de transaccion en caso de que el id del
     * tipo sea cero, en caso contrario, se modifica el tipo de transaccion con
     * el id correspondiente.
     *
     * @throws AbstractLogicException En caso de que algun campo del objeto sea nulo o incorrecto.
     * @throws AbstractQueryException En caso de problemas con la consulta a la base de datos.
     */
    @Override
    public void guardar() throws AbstractLogicException, AbstractQueryException {
        // Verificamos el contenido del tipo de transaccion.
        this.verificar();
        // Si el id del tipo de transaccion es distinto de cero se modifica tl tipo
        // de transaccion, sino, se guarda un tipo de transaccion nuevo.
        if (this.id != 0) {
            if (this.permisoDeModificacion) {
                TipoDeTransaccionDAO.modificarTipoDeTransaccion(this);
            } else {
                throw new TipoDeTransaccionException(TipoDeTransaccionException.PERMISO_MODIFICACION, TipoDeTransaccionException.ERROR_TIPO_NATIVO_MODIFICACION);
            }
        } else {
            TipoDeTransaccionDAO.guardarTipoDeTransaccion(this);
        }
    }

    /**
     * Funcion utilizada para eliminar un tipo de transaccion de la base de datos
     * si este tipo de transaccion puede eliminarse, en cao contrario lanza una
     * excepcion indicando el error.
     *
     * @throws AbstractLogicException En caso de que algun campo del objeto sea nulo o incorrecto.
     * @throws AbstractQueryException En caso de problemas con la consulta a la base de datos.
     */
    @Override
    public void borrar() throws AbstractQueryException, AbstractLogicException {
        if (this.permisoDeModificacion) {
            TipoDeTransaccionDAO.borrarTipoDeTransaccion(this);
        } else {
            throw new TipoDeTransaccionException(TipoDeTransaccionException.PERMISO_MODIFICACION, TipoDeTransaccionException.ERROR_TIPO_NATIVO_ELIMINACION);
        }
    }

    /**
     * Funcion que se encarga de hacer una copia de un tipo de transaccion para
     * asi no afectar el objeto original.
     *
     * @return La copia del objeto receptor.
     */
    @Override
    public TipoDeTransaccion clone() {
        // Creamos el tipo de transaccion.
        TipoDeTransaccion tipoClonado = new TipoDeTransaccion();
        // Seteamos los campos del tipo de transaccion.
        tipoClonado.setID(this.id);
        tipoClonado.setCaracter(this.caracter);
        tipoClonado.setDescripcion(this.descripcion);
        tipoClonado.setActivo(this.activo);
        tipoClonado.setPermisosDeModificacion(this.permisoDeModificacion);
        // Retornamos el tipo de transaccion clonado.
        return tipoClonado;
    }

    /**
     * Funcion utilizada para imprimir el contenido de un tipo de transaccion para
     * corroborar el correcto contenido del mismo.
     * 
     * @return El String que contiene el detalle del centenido del objeto.
     */
    @Override
    public String toString() {
        String mensaje = "<<<<<<<<<<<<<<<TIPO TRANSACCION>>>>>>>>>>>>>>>";
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "ID Tipo Transaccion: " + this.id;
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "Caracter: " + this.caracter.getDescripcion();
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "Descripción: " + this.descripcion;
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "Activo: " + this.activo;
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "Permiso de modificación: " + this.permisoDeModificacion;
        return mensaje;
    }

    /**
     * Funcion que se encarga de verificar que el ID de este tipo de transaccion no
     * sea un tipo de transaccion que debe ocultarse al usuario por ser un tipo de
     * transaccion utilizado dentro del sistema.
     *
     * @return <code>true</code> en caso de que el Tipo de transaccion correspondiente
     * a este objeto sea un tipo de transccion que no debe mostrarse al usuario.
     */
    public boolean esOculto() {
        // Recorremos todos los ID que hay dentro del arreglo de IDs de tipos ocultos de transacciones.
        for (int i = 0; i < TipoDeTransaccion.TRANSACCIONES_OCULTAS.length; i++) {
            // Si el ID de este objeto es uno oculto, retornamos true.
            if (this.id == TipoDeTransaccion.TRANSACCIONES_OCULTAS[i]) {
                return true;
            }
        }
        // Si no encontramos este ID dentro del arreglo, retornamos false.
        return false;
    }

    /**
     * Setter del id del tipo de transaccion.
     *
     * @param id El id del tipo de transaccion.
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Setter de la descripcion del tipo de transaccion.
     *
     * @param descripcion La descripcion del tipo de transaccion.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = Formatear.formatearCadena(descripcion);
    }

    /**
     * Setter del caracter del tipo de transaccion.
     *
     * @param caracter El caracter del tipo de transaccion.
     */
    public void setCaracter(CaracterDeTipoDeTransaccion caracter) {
        this.caracter = caracter;
    }

    /**
     * Setter del estado del tipo de transaccion.
     *
     * @param activo El estado del tipo de transaccion.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Setter del permiso de modificacion de este tipo de transaccion.
     *
     * @param modificar El valor booleano que nos indica si puede modificarse o no este tipo de transaccion.
     */
    public void setPermisosDeModificacion(boolean modificar) {
        this.permisoDeModificacion = modificar;
    }

    /**
     * El getter del id del tipo de transaccion.
     * 
     * @return El id del tipo de transaccion.
     */
    public int getID() {
        return id;
    }

    /**
     * El getter de la descripcion del tipo de transaccion.
     *
     * @return La descripcion del tipo de transaccion.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * El getter del caracter del tipo de transaccion.
     *
     * @return El caracter del tipo de transaccion.
     */
    public CaracterDeTipoDeTransaccion getCaracter() {
        return caracter;
    }

    /**
     * El getter del estado del tipo de transaccion.
     *
     * @return El estado del tipo de transaccion.
     */
    public boolean getActivo() {
        return activo;
    }

    /**
     * El getter del permiso de modificacion de este tipo de transaccion.
     *
     * @return El valor booleano que nos indica si puede modificarse o no este tipo de transaccion.
     */
    public boolean getPermisosDeModificacion() {
        return this.permisoDeModificacion;
    }
}
