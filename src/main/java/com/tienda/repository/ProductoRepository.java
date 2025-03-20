package com.tienda.repository;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
    
    //Consulta Ampliada pra filtrar productos en un rango de precios, ordenados por precio ascendente
    public List<Producto> findByPrecioBetweenOrderByPrecio(double precioInf, double precioSup);
    
    //Consulta JPQL pra filtrar productos en un rango de precios, ordernados por precio ascendente
    @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio")
    public List<Producto> consultaJPQL(
            @Param("precioInf") double precioInf, 
            @Param("precioSup") double precioSup);
    
    //Consulta SQL pra filtrar productos en un rango de precios, ordernados por precio ascendente
    @Query(nativeQuery=true,
            value="SELECT * FROM producto WHERE precio BETWEEN :precioInf AND :precioSup ORDER BY precio")
    public List<Producto> consultaSQL(
            @Param("precioInf") double precioInf, 
            @Param("precioSup") double precioSup);
}