
package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClienteServiceImpl implements ClienteService {
    
      //se crea en tiempo de ejecucion, si aun no se ha creado 
    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
     public List<Cliente> findByApellidos(String apellidos){
        return clienteDao.findByApellidos(apellidos);
     }
    
}
