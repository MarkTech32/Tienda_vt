package com.tienda.repository;

import com.tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    //Se usa para el proceso de login...
    Usuario findByUsername(String username);
    
    //Se usa para el buscar un registro de usuario en el proceso de activacion de un nuevo usuario
    Usuario findByUsernameAndPassword(String username, String Password);

    //Se utiliza para validar si dentro de la tabla usuario ya existe un registro con el username o el correo indicados...
    Usuario findByUsernameOrCorreo(String username, String correo);

    //Se utiliza para validar si dentro de la tabla usuario ya existe un registro con el username o el correo indicado...
    boolean existsByUsernameOrCorreo(String username, String correo);
}
