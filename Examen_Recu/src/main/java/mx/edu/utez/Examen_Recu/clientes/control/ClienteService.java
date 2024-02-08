package mx.edu.utez.Examen_Recu.clientes.control;

import mx.edu.utez.Examen_Recu.clientes.model.ClienteRepository;
import mx.edu.utez.Examen_Recu.clientes.model.ClientesDto;
import mx.edu.utez.Examen_Recu.clientes.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Clientes> listar() {
        return clienteRepository.findAll();
    }

    public Optional<Clientes> findById(long id) {
        return clienteRepository.findById(id);
    }

    public Clientes save(ClientesDto clienteDto) {
        Clientes cliente = modelMapper.map(clienteDto, Clientes.class);
        cliente = clienteRepository.saveAndFlush(cliente);
        return cliente;
    }

    public Clientes update(ClientesDto clienteDto) {
        Optional<Clientes> optional = clienteRepository.findById(clienteDto.getId());
        if (optional.isPresent()) {
            Clientes cliente = optional.get();
            cliente = modelMapper.map(clienteDto, Clientes.class);
            cliente = clienteRepository.saveAndFlush(cliente);
            return cliente;
        }
        return null; // Manejar el caso de cliente no encontrado
    }

    public void delete(long id) {
        Optional<Clientes> optional = clienteRepository.findById(id);
        optional.ifPresent(clienteRepository::delete);
    }
}
