package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="credito")
public class Credito implements Serializable {
    
    //Para utilizarlo en la generacion de la PK autoincremental
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_credito")
    private Long idCredito;
    private double limite;
    

    //constructor default
    public Credito() {
    }

    public Credito(double limite) {
        this.limite = limite;
    }

    
}
