package com.tienda.controller;


import com.tienda.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//anotacion para poder mandar mensajes a la consola del servidor
@Slf4j
public class IndexController {

     @Autowired
    private ArticuloService articuloService;

    //GetMapping("/") sirve para decirle que ejecute este metodo cuando se mete al localhost
    @GetMapping("/")
    public String inicio(Model model) {
          var articulos = articuloService.getArticulos(true);
        //(nombre del atributo, variable)
        model.addAttribute("articulos", articulos);
        return "index";
    }
}
