package com.tienda.controller;

import com.tienda.service.CategoriaService;
import com.tienda.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }
    
}