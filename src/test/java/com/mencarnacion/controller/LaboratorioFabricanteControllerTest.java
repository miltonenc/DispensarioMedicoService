package com.mencarnacion.controller;

import com.mencarnacion.model.entities.LaboratorioFabricanteEntity;
import com.mencarnacion.model.rest.response.ListadoLaboratorioFabricanteResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.repository.LaboratorioFabricanteRepository;
import com.mencarnacion.service.LaboratorioFabricanteService;
import com.mencarnacion.service.impl.LaboratorioFabricanteServiceImpl;
import com.mencarnacion.util.TipoMensaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mencarnacion on 9/7/18.
 */

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class LaboratorioFabricanteControllerTest {

    @InjectMocks
    LaboratorioFabricanteController laboratorioFabricanteController;

    @InjectMocks
    public LaboratorioFabricanteService laboratorioFabricanteService = new LaboratorioFabricanteServiceImpl();

    @Mock
    private RestTemplate restTemplate;

    @Mock
    public LaboratorioFabricanteRepository laboratorioFabricanteRepository;

    private static final RespuestaType RESPUESTA_OK = new RespuestaType(TipoMensaje.OK);
    private static final RespuestaType RESPUESTA_NO_DATOS = new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS);
    private static final RespuestaType RESPUESTA_ERROR_INSERTANDO_DATOS = new RespuestaType(TipoMensaje.ERROR_INSERTANDO_DATOS);
    private static final RespuestaType RESPUESTA_ERROR_ACTUALIZANDO_DATOS = new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS);


    List<LaboratorioFabricanteEntity> entityListFull;
    List<LaboratorioFabricanteEntity> entityListVacia;
    LaboratorioFabricanteEntity entityFull;
    LaboratorioFabricanteEntity entityVacio;


    @Before
    public void init() {
        laboratorioFabricanteController = new LaboratorioFabricanteController();

        ReflectionTestUtils.setField(laboratorioFabricanteController, "laboratorioFabricanteService", laboratorioFabricanteService);

        fillData();
    }

    private void fillData() {
        this.entityFull = new LaboratorioFabricanteEntity();
        this.entityListFull = new ArrayList<>();

        entityFull.setNombre("Prueba LaboratorioFabricanteController");
        entityFull.setDescripcion(entityFull.getNombre());

        this.entityListFull.add(entityFull);
    }

    @Test
    public void obtenerListadoNoData() throws Exception {
        Mockito.when(laboratorioFabricanteRepository.obtenerListado()).thenReturn(this.entityListVacia);

        ListadoLaboratorioFabricanteResponse response = laboratorioFabricanteController.obtenerListado();

        Assert.assertNotNull(response);
        Assert.assertEquals(response.getRespuesta().getCodigo(), RESPUESTA_NO_DATOS.getCodigo());
        Assert.assertEquals(response.getRespuesta().getDescripcion(), RESPUESTA_NO_DATOS.getDescripcion());
    }

    @Test
    public void obtenerListadoOK() throws Exception {
        Mockito.when(laboratorioFabricanteRepository.obtenerListado()).thenReturn(this.entityListFull);

        List<LaboratorioFabricanteEntity> entityList = laboratorioFabricanteRepository.obtenerListado();

        ListadoLaboratorioFabricanteResponse response = new ListadoLaboratorioFabricanteResponse();
        response.setLaboratorioFabricantes(entityList);
        response.setRespuesta(RESPUESTA_OK);

        Mockito.when(restTemplate.postForObject(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(response);

        laboratorioFabricanteController.obtenerListado();

        Assert.assertNotNull(response);
        Assert.assertEquals(response.getRespuesta().getCodigo(), RESPUESTA_OK.getCodigo());
        Assert.assertEquals(response.getRespuesta().getDescripcion(), RESPUESTA_OK.getDescripcion());
        Assert.assertTrue(!response.getLaboratorioFabricantes().isEmpty());
    }

    @Test
    public void obtener() throws Exception {

    }

    @Test
    public void guardar() throws Exception {

    }

}