package com.mencarnacion.model.dto;

import com.mencarnacion.model.entities.RegistroVisitaEntity;

import java.util.Date;

/**
 * Created by mencarnacion on 10/16/18.
 */
public class RegistroVisitaDTO {

    private Long id;
    private MedicoDTO medico;
    private PacienteDTO paciente;
    private MedicamentoDTO medicamento;
    private String sintoma;
    private String recomendacion;
    private Date fecha;

    public RegistroVisitaDTO() {
        super();
    }

    public RegistroVisitaDTO(RegistroVisitaEntity registroVisitaEntity) {
        super();
        this.id = registroVisitaEntity.getId();
        this.medico = new MedicoDTO(registroVisitaEntity.getMedico());
        this.paciente = new PacienteDTO(registroVisitaEntity.getPaciente());
        this.medicamento = new MedicamentoDTO(registroVisitaEntity.getMedicamento());
        this.sintoma = registroVisitaEntity.getSintoma();
        this.recomendacion = registroVisitaEntity.getRecomendacion();
        this.fecha = registroVisitaEntity.getFecha();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicoDTO getMedico() {
        return medico;
    }

    public void setMedico(MedicoDTO medico) {
        this.medico = medico;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public MedicamentoDTO getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(MedicamentoDTO medicamento) {
        this.medicamento = medicamento;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistroVisitaDTO that = (RegistroVisitaDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (medico != null ? !medico.equals(that.medico) : that.medico != null) return false;
        if (paciente != null ? !paciente.equals(that.paciente) : that.paciente != null) return false;
        if (medicamento != null ? !medicamento.equals(that.medicamento) : that.medicamento != null) return false;
        if (sintoma != null ? !sintoma.equals(that.sintoma) : that.sintoma != null) return false;
        if (recomendacion != null ? !recomendacion.equals(that.recomendacion) : that.recomendacion != null)
            return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (medico != null ? medico.hashCode() : 0);
        result = 31 * result + (paciente != null ? paciente.hashCode() : 0);
        result = 31 * result + (medicamento != null ? medicamento.hashCode() : 0);
        result = 31 * result + (sintoma != null ? sintoma.hashCode() : 0);
        result = 31 * result + (recomendacion != null ? recomendacion.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }
}
