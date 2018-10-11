package com.mencarnacion.model.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mencarnacion on 8/30/18.
 */
@Entity
@Table(name = "REGISTRO_VISITA", schema = "ISO715")
public class RegistroVisitaEntity {

    private Long id;
    private MedicoEntity medico;
    private PacienteEntity paciente;
    private MedicamentoEntity medicamento;
    private String sintoma;
    private String recomendacion;
    private Date fecha;
    private int estado;

    public RegistroVisitaEntity() {
        super();
        this.estado = 1;
        this.fecha = new Date();
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JoinColumn(name = "MEDICO", referencedColumnName = "ID")
    @ManyToOne
    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    @JoinColumn(name = "PACIENTE", referencedColumnName = "ID")
    @ManyToOne
    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    @JoinColumn(name = "MEDICAMENTO", referencedColumnName = "ID")
    @ManyToOne
    public MedicamentoEntity getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(MedicamentoEntity medicamento) {
        this.medicamento = medicamento;
    }

    @Basic
    @Column(name = "SINTOMA")
    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    @Basic
    @Column(name = "RECOMENDACION")
    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    @Basic
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "ESTADO")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistroVisitaEntity that = (RegistroVisitaEntity) o;

        if (id != that.id) return false;
        if (medico != that.medico) return false;
        if (paciente != that.paciente) return false;
        if (estado != that.estado) return false;
        if (medicamento != null ? !medicamento.equals(that.medicamento) : that.medicamento != null) return false;
        if (sintoma != null ? !sintoma.equals(that.sintoma) : that.sintoma != null) return false;
        if (recomendacion != null ? !recomendacion.equals(that.recomendacion) : that.recomendacion != null)
            return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (medico != null ? medico.hashCode() : 0);
        result = 31 * result + (paciente != null ? paciente.hashCode() : 0);
        result = 31 * result + (medicamento != null ? medicamento.hashCode() : 0);
        result = 31 * result + (sintoma != null ? sintoma.hashCode() : 0);
        result = 31 * result + (recomendacion != null ? recomendacion.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }
}
