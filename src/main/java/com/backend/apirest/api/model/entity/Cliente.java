package com.backend.apirest.api.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.backend.apirest.api.validators.uniqueemail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 4, max = 12, message = "el tamaño debe de estar entre 4 y 12 caracteres")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "no puede estar vacio")
    private String apellido;
    
    @NotEmpty(message = "no puede estar vacio")
    @Email(message = "no es una direccion de correo valida")
    @Column(nullable = false, unique = true)
    @uniqueemail
    private String email;

    @ManyToOne
    private Country country;
    
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

}
