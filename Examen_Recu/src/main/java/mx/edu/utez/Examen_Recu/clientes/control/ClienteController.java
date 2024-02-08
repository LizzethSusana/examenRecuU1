package mx.edu.utez.Examen_Recu.clientes.control;


import mx.edu.utez.Examen_Recu.clientes.model.ClientesDto;
import mx.edu.utez.Examen_Recu.clientes.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/all")
    public List<Clientes> findAll() {
        return clienteService.listar();
    }

    @GetMapping("/findById/{id}")
    public Optional<Clientes> findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping("/save")
    public Clientes save(@RequestBody ClientesDto dto) {
        return clienteService.save(dto);
    }

    @PutMapping("/update")
    public Clientes update(@RequestBody ClientesDto dto) {
        return clienteService.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
