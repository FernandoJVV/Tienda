package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//anotacion para poder mandar mensajes a la consola del servidor
@Slf4j
public class IndexController {
    //se crea en tiempo de ejecucion, si aun no se ha creado 
    @Autowired
    private ClienteDao clienteDao;

    //GetMapping("/") sirve para decirle que ejecute este metodo cuando se mete al localhost
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");


        var clientes = clienteDao.findAll();
        //(nombre del atributo, variable)
        model.addAttribute("clientes", clientes);
        return "index";
    }
}
