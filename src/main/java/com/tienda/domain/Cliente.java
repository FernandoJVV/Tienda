package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
    
    //Para utilizarlo en la generacion de la PK autoincremental
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long idCliente;
    
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    
    @JoinColumn(name="id_credito", referencedColumnName="id_credito")
    //Muchos a Uno
    @ManyToOne
    private Credito credito;

    //constructor default
    public Cliente() {
    }


    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }
     
    
    
}
