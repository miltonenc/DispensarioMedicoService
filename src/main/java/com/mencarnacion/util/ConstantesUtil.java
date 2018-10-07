package com.mencarnacion.util;

import java.io.Serializable;

/**
 * Created by mencarnacion on 8/28/18.
 */
public class ConstantesUtil implements Serializable {
    private static final long serialVersionUID = 5748855167834329625L;

    public static final String API = "DispensarioMedicoService/api";
    public static final String CROSS_ORIGIN = "*";
    public static final String APPLICATION_PDF = "application/pdf";
    public static final String APPLICATION_JSON = "application/json";


    /**
     * OPERACIONES
     */
    public static final String LISTADO_TIPO_MEDICAMENTOS = "/TipoMedicamento/ObtenerListado";
    public static final String OBTENER_TIPO_MEDICAMENTOS = "/TipoMedicamento/Obtener";
    public static final String GUARDAR_TIPO_MEDICAMENTOS = "/TipoMedicamento/Guardar";

    public static final String LISTADO_TIPO_PACIENTE = "/TipoPaciente/ObtenerListado";
    public static final String OBTENER_TIPO_PACIENTE = "/TipoPaciente/Obtener";
    public static final String GUARDAR_TIPO_PACIENTE = "/TipoPaciente/Guardar";

    public static final String LISTADO_MEDICAMENTO = "/Medicamento/ObtenerListado";
    public static final String OBTENER_MEDICAMENTO = "/Medicamento/Obtener";
    public static final String GUARDAR_MEDICAMENTO = "/Medicamento/Guardar";

    public static final String LISTADO_MEDICO_ESPECIALIDAD = "/MedicoEspecialidad/ObtenerListado";
    public static final String OBTENER_MEDICO_ESPECIALIDAD = "/MedicoEspecialidad/Obtener";
    public static final String GUARDAR_MEDICO_ESPECIALIDAD = "/MedicoEspecialidad/Guardar";

    public static final String LISTADO_MEDICO = "/Medico/ObtenerListado";
    public static final String OBTENER_MEDICO = "/Medico/Obtener";
    public static final String GUARDAR_MEDICO = "/Medico/Guardar";

    public static final String LISTADO_PACIENTE = "/Paciente/ObtenerListado";
    public static final String OBTENER_PACIENTE = "/Paciente/Obtener";
    public static final String GUARDAR_PACIENTE = "/Paciente/Guardar";

    public static final String LISTADO_REGISTRO_VISITA = "/RegistroVisita/ObtenerListado";
    public static final String OBTENER_REGISTRO_VISITA = "/RegistroVisita/Obtener";
    public static final String GUARDAR_REGISTRO_VISITA = "/RegistroVisita/Guardar";

    public static final String LISTADO_LABORATORIO_FABICANTE = "/LaboratorioFabricante/ObtenerListado";
    public static final String OBTENER_LABORATORIO_FABICANTE = "/LaboratorioFabricante/Obtener";
    public static final String GUARDAR_LABORATORIO_FABICANTE = "/LaboratorioFabricante/Guardar";

    public static final String LISTADO_UBICACION = "/Ubicacion/ObtenerListado";
    public static final String OBTENER_UBICACION = "/Ubicacion/Obtener";
    public static final String OBTENER_UBICACION_CODIGO = "/Ubicacion/ObtenerPorCodigo";
    public static final String GUARDAR_UBICACION = "/Ubicacion/Guardar";

    public static final String LISTADO_USUARIO = "/Usuario/ObtenerListado";
    public static final String LISTADO_USUARIO_USUARIO = "/Usuario/ObtenerListadoPorUsuario";
    public static final String OBTENER_USUARIO = "/Usuario/Obtener";
    public static final String LOGIN = "/Usuario/Login";

}