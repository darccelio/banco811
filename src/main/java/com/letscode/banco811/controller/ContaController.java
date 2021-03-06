package com.letscode.banco811.controller;

import com.letscode.banco811.dto.ContaRequest;
import com.letscode.banco811.dto.ContaResponse;

import com.letscode.banco811.model.TipoConta;
import com.letscode.banco811.projections.ContaView;
import com.letscode.banco811.service.ContaService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ContaResponse> getAll() {
        return contaService.getAll();
    }

    @PostMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    @ResponseStatus(HttpStatus.CREATED)
    public ContaResponse create(@RequestBody ContaRequest contaRequest, @PathVariable Integer id) {
        return contaService.create(contaRequest, id);
    }

    @GetMapping("/view")
    public List<ContaView> getAllContaViewByTipoConta( @RequestParam TipoConta tipoConta ) {
        return contaService.getAllViewByTipoConta(tipoConta);
    }


}
