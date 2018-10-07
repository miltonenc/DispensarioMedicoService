package com.mencarnacion.controller;

import com.mencarnacion.service.DispensarioMedicoService;
import com.mencarnacion.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mencarnacion on 8/28/18.
 */
@RestController
@RequestMapping(ConstantesUtil.API)
public class DispensarioMedicoController {

    @Autowired
    private DispensarioMedicoService dispensarioMedicoService;
}
