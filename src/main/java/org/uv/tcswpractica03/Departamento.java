package org.uv.tcswpractica03;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departamento_seq")
    @SequenceGenerator(name = "departamento_seq", sequenceName = "departamento_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "clave")
    private Long clave;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private Set<Empleados> empleados;

    
    public Long getClave() { return clave; }
    public void setClave(Long clave) { this.clave = clave; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Set<Empleados> getEmpleados() { return empleados; }
    public void setEmpleados(Set<Empleados> empleados) { this.empleados = empleados; }
}
