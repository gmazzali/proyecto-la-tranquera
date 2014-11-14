package logica;

import excepciones.dataBase.consultas.AbstractQueryException;
import excepciones.dataBase.consultas.UsuarioQueryException;
import excepciones.logica.AbstractLogicException;
import excepciones.logica.UsuarioException;
import logica.interfaces.Persistencia;
import baseDeDatos.UsuarioDAO;
import java.util.ArrayList;
import utilidades.Constantes;
import utilidades.Encriptar;
import utilidades.Verificar;

/**
 * Clase que se encarga de representar a los diferentes usuarios que pueden
 * ejecutar la aplicacion con distintos privilegios.
 *
 * @version 3.0
 */
public class Usuario implements Persistencia {

    // Los diferentes tipos de privilegios.
    /** El privilegio del superusuario. */
    public static final int PRIVILEGIO_SUPERUSUARIO = 100;
    /** El privilegio del usuario por default del sistema. */
    public static final int PRIVILEGIO_DEFAULT = 0;
    /** El privilegio del usuario administrador del sistema. */
    public static final int PRIVILEGIO_ADMINISTRADOR = 1;
    /** El privilegio del usuario comun del sistema. */
    public static final int PRIVILEGIO_USUARIO_COMUN = 2;
    
    // El nombre del usuario.
    private String nombre;
    // La password encriptada del usuario.
    private String passwordEncriptada;
    // El privilegio del usuario.
    private int privilegio;

    /**
     * Constructor de un usuario por default.
     */
    public Usuario() {
        this.nombre = "";
        this.passwordEncriptada = "";
        this.privilegio = Usuario.PRIVILEGIO_DEFAULT;
    }

    /**
     * Funcion estatica que se encarga de crear un objeto del tipo usuario que
     * posee las caracteristicas de un usuario por default, el cual no posee
     * acceso dentro del sistema.
     *
     * @return Un usuario que representa un usuario por default dentro del sistema.
     */
    public static Usuario getUsuarioDefault() {
        // Creamos el usuario por default.
        Usuario usuarioDefault = new Usuario();
        // Seteamos los valores del usuario.
        usuarioDefault.setNombre("DEFAULT");
        usuarioDefault.setPassword("", false);
        usuarioDefault.setPrivilegio(Usuario.PRIVILEGIO_DEFAULT);
        // Retornamos el usuario por default.
        return usuarioDefault;
    }

    /**
     * Funcion que se encarga de retornar el lsitado completo de todos los usuarios
     * que son aceptados dentro del sistema y que se encuentran dentro de la base
     * de datos.
     *
     * @return El listado de todos los usuarios aceptados dentro del sistema.
     * @throws UsuarioQueryException En caso de que algun problema con la consulta se presente.
     */
    public static ArrayList<Usuario> getListadoDeUsuarios() throws UsuarioQueryException {
        return UsuarioDAO.getListadoDeUsuarios();
    }

    /**
     * Funcion que se encarga de verificar que los datos de un usuario del sistema
     * sean los correctos y no sean nulos.
     *
     * @throws AbstractLogicException En caso de que algun campo del objeto sea nulo o incorrecto.
     */
    @Override
    public void verificar() throws AbstractLogicException {
        // Si el nombre no esta asignado.
        if (this.nombre == null) {
            throw new UsuarioException(UsuarioException.CAMPO_NOMBRE, UsuarioException.ERROR_NOMBRE_NULO);
        }
        // Si el nombre asignado esta vacio.
        if (this.nombre.isEmpty()) {
            throw new UsuarioException(UsuarioException.CAMPO_NOMBRE, UsuarioException.ERROR_NOMBRE_VACIO);
        }
        // Si el nombre asignado no es correcto.
        if (!Verificar.esNombreDeUsuarioValido(this.nombre)) {
            throw new UsuarioException(UsuarioException.CAMPO_NOMBRE, UsuarioException.ERROR_NOMBRE_INVALIDO);
        }
        // Si la password asignada es nula.
        if (this.passwordEncriptada == null) {
            throw new UsuarioException(UsuarioException.CAMPO_PASSWORD, UsuarioException.ERROR_PASSWORD_NULA);
        }
        // Si la password encriptada esta fuera de rango.
        if (this.passwordEncriptada.isEmpty()) {
            throw new UsuarioException(UsuarioException.CAMPO_PASSWORD, UsuarioException.ERROR_PASSWORD_VACIA);
        }
        // Si la password encriptada esta fuera de rango.
        if (this.passwordEncriptada.length() > 32) {
            throw new UsuarioException(UsuarioException.CAMPO_PASSWORD, UsuarioException.ERROR_PASSWORD_INVALIDA);
        }
        // Si el privilegio del usuario es por default.
        if (this.privilegio == Usuario.PRIVILEGIO_DEFAULT) {
            throw new UsuarioException(UsuarioException.CAMPO_PRIVILEGIO, UsuarioException.ERROR_PRIVILEGIO_DEFAULT);
        }
    }

    /**
     * Funcion que se encarga de guardar los datos de un usuario dentro de la
     * base de datos, en caso de que el usuario sea el administrador, solo se le
     * actualiza la password.
     *
     * @throws AbstractQueryException En caso de problemas con la consulta a la base de datos.
     * @throws AbstractLogicException En caso de que algun campo del objeto sea nulo o incorrecto.
     */
    @Override
    public void guardar() throws AbstractQueryException, AbstractLogicException {
        // Verificamos el contenido del usuario.
        this.verificar();
        // Solamente guardamos las modificaciones del usuario del tipo administrador.
        UsuarioDAO.guardarUsuario(this);
    }

    /**
     * Funcion no implementada todavia.
     */
    @Override
    public void borrar() {
        // TODO No se implementa nada del borrado de usuarios del sistema.
    }

    /**
     * Funcion que se encarga de hacer una copia del usuario receptor para asi
     * no afectar al objeto original.
     *
     * @return La copia que corresponde con el objeto actual.
     */
    @Override
    public Usuario clone() {
        // Creamos un nuevo usuario.
        Usuario retorno = new Usuario();
        // Seteamos los campos del nuevo usuario.
        retorno.setNombre(this.nombre);
        retorno.setPassword(this.passwordEncriptada, true);
        retorno.setPrivilegio(this.privilegio);
        // Retornamos el usuario clonado.
        return retorno;
    }

    /**
     * Funcion que se encarga de visualizar por consola el contenido propio del
     * objeto de usuario qeu recibe el mensaje, para corroborar el correcto contenido
     * del mismo.
     * 
     * @return El String que contiene el detalle del centenido del objeto.
     */
    @Override
    public String toString() {
        String mensaje = "<<<<<<<<<<<<<<<<<<<<<<USUARIO>>>>>>>>>>>>>>>>>>>>>>";
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "Nombre: " + this.nombre;
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "Password encriptada: " + this.passwordEncriptada;
        mensaje += Constantes.SEPARADOR_DE_TO_STRING;
        mensaje += "Privilegio: " + this.privilegio;
        return mensaje;
    }

    /**
     * Funcion que se encarga de verificar si una password dada corresponde con
     * la password del usuario actualmente seleccionado.
     *
     * @param password La password contra la cual vamos a comparar la password
     * original del usuario.
     * @param encriptada El valor booleano que nos indica si la password detallada 
     * en el parametro anterior es una password encriptada o una password plana.
     * @return <code>true</code> en caso de que la password recibida corresponda
     * con la password del usuario actual, en caso contrario, la funcion
     * retornara <code>false</code>.
     */
    public boolean esPasswordValida(String password, boolean encriptada) {
        if (encriptada) {
            return this.passwordEncriptada.compareToIgnoreCase(password) == 0;
        } else {
            return this.passwordEncriptada.compareToIgnoreCase(Encriptar.encritarTexto(password, Encriptar.MD5)) == 0;
        }
    }

    /**
     * El setter del nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * El setter de la password del usuario.
     *
     * @param password La password del usuario.
     * @param encriptada El valor booleano que nos indica si la password detallada 
     * en el parametro anterior es una password encriptada o una password plana.
     */
    public void setPassword(String password, boolean encriptada) {
        if (encriptada) {
            this.passwordEncriptada = password;
        } else {
            this.passwordEncriptada = Encriptar.encritarTexto(password, Encriptar.MD5);
        }
    }

    /**
     * El setter del privilegio del usuario.
     *
     * @param privilegio El privilegio del usuario.
     */
    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }

    /**
     * El getter del nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * El getter de la password del usuario.
     *
     * @return La password del usuario.
     */
    public String getPasswordEncriptada() {
        return passwordEncriptada;
    }

    /**
     * El getter del privilegio del usuario.
     *
     * @return El privilegio del usuario.
     */
    public int getPrivilegio() {
        return privilegio;
    }
}
