package entornos.tonyin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public class Reserva {
        private int numeroHabitacion;
        private String correoUsuario;

        public Reserva(int numeroHabitacion, String correoUsuario) {
            this.numeroHabitacion = numeroHabitacion;
            this.correoUsuario = correoUsuario;
        }

        // Getters y setters
        public int getNumeroHabitacion() {
            return numeroHabitacion;
        }

        public void setNumeroHabitacion(int numeroHabitacion) {
            this.numeroHabitacion = numeroHabitacion;
        }

        public String getCorreoUsuario() {
            return correoUsuario;
        }

        public void setCorreoUsuario(String correoUsuario) {
            this.correoUsuario = correoUsuario;
        }
    }

    public class Habitacion {
        private Integer numero;
        private String tipo;
        private Double precio;

        public Habitacion(Integer numero, String tipo, Double precio) {
            this.numero = numero;
            this.tipo = tipo;
            this.precio = precio;
        }

        public Integer getNumero() {
            return numero;
        }

        public Double getPrecio() {
            return precio;
        }

        public String getTipo() {
            return tipo;
        }

        public void setNumero(Integer numero) {
            this.numero = numero;
        }

        public void setPrecio(Double precio) {
            this.precio = precio;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }

    public class Usuario {
        private String nombreUsuario;
        private String correoElectronico;

        public Usuario(String nombreUsuario, String correoElectronico) {
            this.nombreUsuario = nombreUsuario;
            this.correoElectronico = correoElectronico;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public String getCorreoElectronico() {
            return correoElectronico;
        }
    }

    public class Hotel {

        private HashMap<String, String> usuarios = new HashMap<>();
        public Map<String, List<Reserva>> reservasPorUsuario = new HashMap<>();
        private HashMap<Integer, Habitacion> habitaciones = new HashMap<>();

        public HashMap<Integer, Habitacion> getHabitaciones() {
            return habitaciones;
        }

        public HashMap<String, String> getUsuarios() {
            return usuarios;
        }

        public String registrarUsuario(String usuario, String correo) {
            return usuarios.put(usuario, correo);
        }

        public String eliminarUsuario(String usuario) {
            return usuarios.remove(usuario);
        }

        public void registrarHabitacion(Integer numero, String tipo, Double precio) {
            Habitacion habitacion = new Habitacion(numero, tipo, precio);
            habitaciones.put(numero, habitacion);
        }

        public HashMap<Integer, Habitacion> listarHabitaciones() {
            return habitaciones;
        }

        public Habitacion eliminarHabitacion(Integer numero) {
            return habitaciones.remove(numero);
        }

        public void hacerReserva(int numeroHabitacion, Usuario usuario) {
            // Obtener o inicializar la lista de reservas para el usuario
            List<Reserva> reservasUsuario = reservasPorUsuario.get(usuario.getNombreUsuario());
            if (reservasUsuario == null) {
                reservasUsuario = new ArrayList<>();
                reservasPorUsuario.put(usuario.getNombreUsuario(), reservasUsuario);
            }

            // Crear la reserva y agregarla a la lista de reservas del usuario
            Reserva reserva = new Reserva(numeroHabitacion, usuario.getCorreoElectronico());
            reservasUsuario.add(reserva);
        }

        public List<Reserva> visualizarReservas(String nombreUsuario) {
            return reservasPorUsuario.getOrDefault(nombreUsuario, new ArrayList<>());
        }
    }

}
