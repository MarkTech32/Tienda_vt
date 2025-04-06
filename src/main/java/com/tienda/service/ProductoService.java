package com.tienda.service;

import com.tienda.domain.Producto;
import com.tienda.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoRepository.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());  // Usa el método getter en lugar del campo directo
        }

        return lista;
    }
    
    //Metodo de Get
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto){
        producto = productoRepository.findById(producto.getIdProducto()).orElse(null);
        
        return producto;
    }
    
    //Metodos de Delete
    @Transactional
    public void delete(Producto producto){
        //Si el idProducto pasado existe, se elimina ese registro
         productoRepository.delete(producto);
        
    }
    
    //Metodos de Save
    @Transactional
    public void save(Producto producto){
        //Si el objeto producto tiene info en idProducto, se actualiza el registro
        //Si el objeto producto NO tiene info en idProducto, se inserta un nuevo registro
         productoRepository.save(producto);
        
    }
    
    @Transactional(readOnly=true)
    public List<Producto> consultaAmpliada(double precioInf, double precioSup){
        return productoRepository.findByPrecioBetweenOrderByPrecio(precioInf, precioSup);
    }
    
    @Transactional(readOnly=true)
    public List<Producto> consultaJPQL(double precioInf, double precioSup){
        return productoRepository.consultaJPQL(precioInf, precioSup);
    }
    
    @Transactional(readOnly=true)
    public List<Producto> consultaSQL(double precioInf, double precioSup){
        return productoRepository.consultaSQL(precioInf, precioSup);
    } 
    
    // Metodo para buscar producto por nombre/palabra clave
    @Transactional(readOnly = true)
    public List<Producto> buscarPorPalabraClave(String palabraClave) {
        return productoRepository.findByDescripcionContainingIgnoreCase(palabraClave);
    }
}
