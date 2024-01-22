package ej1;

import jakarta.persistence.*;

@Entity
@Table(name = "DIRECCIONES")
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DIRECCION_COMPLETA")
    @Convert(converter = ConversorDireccion.class)
    private Direccion direccionCompleta;

}
