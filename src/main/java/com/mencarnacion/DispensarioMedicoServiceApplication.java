package com.mencarnacion;

import com.mencarnacion.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DispensarioMedicoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DispensarioMedicoServiceApplication.class, args);
    }

    @Bean
    public LaboratorioFabricanteController laboratorioFabricanteController() {
        return new LaboratorioFabricanteController();
    }

    @Bean
    public MedicamentoController medicamentoController() {
        return new MedicamentoController();
    }

    @Bean
    public MedicoController medicoController() {
        return new MedicoController();
    }

    @Bean
    public MedicoEspecialidadController medicoEspecialidadController() {
        return new MedicoEspecialidadController();
    }

    @Bean
    public PacienteController pacienteController() {
        return new PacienteController();
    }

    @Bean
    public RegistroVisitaController registroVisitaController() {
        return new RegistroVisitaController();
    }

    @Bean
    public TipoMedicamentoController tipoMedicamentoController() {
        return new TipoMedicamentoController();
    }

    @Bean
    public TipoPacienteController tipoPacienteController() {
        return new TipoPacienteController();
    }

    @Bean
    public UbicacionController ubicacionController() {
        return new UbicacionController();
    }

    @Bean
    public UsuarioController usuarioController() {
        return new UsuarioController();
    }
}
