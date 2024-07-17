package com.usg.apirest;

import com.usg.apirest.reportes.DatosActualizarReportes;
import com.usg.apirest.reportes.DatosReportes;
import jakarta.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "reportes")
public class SetDatosReportes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String título;
    private String mensaje;
    private String fecha_creación;
    private String status;
    private String autor;
    private String curso;

    public SetDatosReportes(){}

    public SetDatosReportes(long id, String título, String mensaje, String fecha_creación, String status, String autor, String curso) {
        this.id = id;
        this.título = título;
        this.mensaje = mensaje;
        this.fecha_creación = fecha_creación;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
    }

    public SetDatosReportes(DatosReportes datosReportes) {
        this.título = datosReportes.título();
        this.mensaje = datosReportes.mensaje();
        this.autor = datosReportes.autor();
        this.curso = datosReportes.curso();
        this.fecha_creación = fecha();
        this.status = "Activo";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha_creación() {
        return fecha_creación;
    }

    public void setFecha_creación(String fecha_creación) {
        this.fecha_creación = fecha_creación;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String fecha(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void actualizarDatos(DatosActualizarReportes datosActualizarReportes) {
        if (datosActualizarReportes.título() != null){
            this.título = datosActualizarReportes.título();
        }
        if (datosActualizarReportes.mensaje() != null){
            this.mensaje = datosActualizarReportes.mensaje();
        }
        if (datosActualizarReportes.curso() != null){
            this.curso = datosActualizarReportes.curso();
        }
    }
}
