package logica;

import excepciones.dataBase.consultas.AbstractQueryException;
import excepciones.logica.AbstractLogicException;
import excepciones.logica.PagoException;
import logica.interfaces.Persistencia;
import baseDeDatos.PagoDAO;
import utilidades.DateTime;
import java.math.BigDecimal;
import utilidades.Constantes;

/**
 * Esta clase representa un pago del restaurante a alguno de sus acreedores.
 *
 * @version 2.5
 */
public class Pago implements Persistencia {

    // El id del pago realizado.
    private int idPago;
    // El importe del apgo realizado.
    private BigDecimal importe;
    // La fecha cuando se realizo el pago.
    private DateTime fechaPago;
    // El proveedor al cual se le realizo el pago.
    private Acreedor proveedor;
    // El id de la transaccion que corresponde al pago.
    private int idTransaccion;

    /**
     * El constructor de un objeto de pago con los parametros por default.
     */
    public Pago() {
        this.idPago = 0;
        this.importe = null;
        this.fechaPago = null;
        this.proveedor = null;
        this.idTransaccion = 0;
    }

    /**
     * Funcion utilizada para verificar que el contenido de un pago sea el correcto.
     *
     * @throws AbstractLogicException En caso de que algun campo del objeto sea nulo o incorrecto.
     */
    @Override
    public void verificar() throws AbstractLogicException {
        // Si el importe del pago es nulo.
        if (this.importe == null) {
            throw new PagoException(PagoException.CAMPO_MONTO, PagoException.ERROR_MONTO_NULO);
        }
        // Si el importe es menor a cero.
        if (this.importe.compareTo(BigDecimal.ZERO) == -1) {
            throw new PagoException(PagoException.CAMPO_MONTO, PagoException.ERROR_MONTO_NEGATIVO);
        }
        // Si la fecha del pago es nula.
        if (this.fechaPago == null) {
            throw new PagoException(PagoException.CAMPO_FECHA, PagoException.ERROR_FECHA_NULA);
        }
        // Si la fecha del pago es mayor a la fecha actual.
        if (this.fechaPago.compareTo(new DateTime(), true) >= 1) {
            throw new PagoException(PagoException.CAMPO_FECHA, PagoException.ERROR_FECHA_MAYOR);
        }
        // Si el proveedor es nulo.
        if (this.proveedor == null) {
            throw new PagoException(PagoException.CAMPO_ACREEDOR, PagoException.ERROR_ACREEDOR_NULO);
        }
        // El id del proveedor no puede ser cero.
        if (this.proveedor.getID() == 0) {
            throw new PagoException(PagoException.CAMPO_ACREEDOR, PagoException.ERROR_ACREEDOR_INVALIDO);
        }
    }

    /**
     * Esta funcion se encarga de el guardado de un pago realizado a un proveedor.
     *
     * @throws AbstractLogicException En caso de que algun campo del objeto sea nulo o incorrecto.
     * @throws AbstractQueryException En caso de problemas con la consulta a la base de datos.
     */
    @Override
    public void guardar() throws AbstractQueryException, AbstractLogicException {
        // Verificamos el contenido del pago.
        this.verificar();
        // Lo guardamos solo si el apgo es nuevo.
        if (this.idPago == 0) {
            PagoDAO.guardarPagoAProveedor(this);
        }
    }

    /**
     * Esta funcion no se encuentra implementada actualmente.
     */
    @Override
    public void borrar() {
        // TODO Funcionalidad de borrado de un pago no implementada.
    }

    /**
     * Funcion utilizada para hacer una copia del objeto de pago que recibe el
     * mensaje, para asi no afectar el objeto original.
     *
     * @return La copia del objeto receptor.
     */
    @Override
    public Pago clone() {
        // Creamos un nuevo pago.
        Pago pagoClonado = new Pago();
        // Seteamos los campos para el nuevo pago.
        pagoClonado.setId(this.idPago);
        pagoClonado.setProveedor(this.proveedor);
        pagoClonado.setIdTransaccion(this.idTransaccion);
        pagoClonado.setFecha(this.fechaPago);
        pagoClonado.setImporte(this.importe);
        // Retornamos el pago clonado.
        return pagoClonado;
    }

    /**
     * Funcion utilizada para imprimir el contenido de un objeto de pago, para
     * visualizarlo y corroborar el correcto contenido.
     * 
     * @return El String que contiene el detalle del centenido del objeto.
     */
    @Override
    public String toString() {
        String mensaje = "<<<<<<<<<<<<<<<<<<<<PAGO>>>>>>>>>>>>>>>>>>>>";
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "ID PAgo: " + this.idPago;
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "Fecha pago: " + this.fechaPago.toString();
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "Proveedor: " + this.proveedor.getNombre();
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "ID Transaccion: " + this.idTransaccion;
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "Importe: " + this.importe;
        return mensaje;
    }

    /**
     * Setter del id del pago.
     *
     * @param idPago El id del pago.
     */
    public void setId(int idPago) {
        this.idPago = idPago;
    }

    /**
     * Setter de la fecha del pago.
     *
     * @param fechaPago La fecha del pago.
     */
    public void setFecha(DateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * Setter del id de la transaccion que corresponde con el pago.
     *
     * @param idTransaccion El id de la transaccion que le corresponde.
     */
    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * Setter del proveedor que corresponde con el pago.
     *
     * @param proveedor El proveedor que le corresponde.
     */
    public void setProveedor(Acreedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Setter del importe que corresponde con el pago.
     *
     * @param importe El importe que le corresponde.
     */
    public void setImporte(BigDecimal importe) {
        this.importe = importe.abs();
    }

    /**
     * Getter del id del pago.
     *
     * @return El id del pago.
     */
    public int getId() {
        return idPago;
    }

    /**
     * Getter de la fecha del pago.
     *
     * @return La fecha del pago.
     */
    public DateTime getFecha() {
        return fechaPago;
    }

    /**
     * Getter del id de la transaccion que corresponde con el pago.
     *
     * @return El id de la transaccion que le corresponde.
     */
    public int getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Getter del proveedor que corresponde con el pago.
     *
     * @return El proveedor que le corresponde.
     */
    public Acreedor getProveedor() {
        return proveedor;
    }

    /**
     * Getter del importe que corresponde con el pago.
     *
     * @return El importe que le corresponde.
     */
    public BigDecimal getImporte() {
        return importe;
    }
}
