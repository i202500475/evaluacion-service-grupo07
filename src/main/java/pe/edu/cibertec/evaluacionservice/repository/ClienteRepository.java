package pe.edu.cibertec.evaluacionservice.repository;

import pe.edu.cibertec.evaluacionservice.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.HashMap;

@Repository
public class ClienteRepository {

    private final Map<Long, Cliente> clientes = new HashMap<>();

    public ClienteRepository() {
        clientes.put(2001L, new Cliente(2001L, "Carlos Ramirez", "70123451"));
        clientes.put(2002L, new Cliente(2002L, "Maria Torres", "70234562"));
        clientes.put(2003L, new Cliente(2003L, "Luis Mendoza", "70345673"));
        clientes.put(2004L, new Cliente(2004L, "Ana Flores", "70456784"));
    }

    public Cliente buscarPorId(Long clienteId) {
        return clientes.get(clienteId);
    }
}