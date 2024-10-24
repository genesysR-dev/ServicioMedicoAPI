package med.voll.api.paciente;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @PostMapping
    public void registrar(@RequestBody DatosRegistroPaciente datos) {
        System.out.println("datos recebidos: " +datos);
    }

}
