package med.voll.api.domain.paciente;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void registrar(@RequestBody DatosRegistroPaciente datos) {
        repository.save(new Paciente(datos));
    }
    @GetMapping
    public Page<DatosListaPaciente> listar(@PageableDefault(page = 0, size = 10, sort = {"nombre"})Pageable paginacion){
        return repository.findAll(paginacion).map(DatosListaPaciente::new);
    }

    @PutMapping
    @Transactional
    public void actualizar(@RequestBody @Valid DatosActualizacionPaciente datos){
        var paciente = repository.getReferenceById(datos.id());
        paciente.actualizarInformacion(datos);
    }

}
