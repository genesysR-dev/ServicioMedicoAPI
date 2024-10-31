package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")


public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String documentoIdentidad;
    private String telefono;

    @Embedded
    private Direccion direccion;

    public Paciente(DatosRegistroPaciente datos){
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documentoIdentidad = datos.documentoIdentidad();
        this.direccion = new Direccion(datos.direccion());
    }


    public void actualizarInformacion(DatosActualizacionPaciente datosActualizacionPaciente) {
        if (datosActualizacionPaciente.nombre() != null)
            this.nombre = datosActualizacionPaciente.nombre();
        if (datosActualizacionPaciente.telefono() != null)
            this.telefono = datosActualizacionPaciente.telefono();
        if (datosActualizacionPaciente.direccion() != null)
            direccion.actualizarDatos(datosActualizacionPaciente.direccion());
    }
}
