package com.api.api.Controllers;


import com.api.api.Records.TransacaoRecord;
import com.api.api.Services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public ResponseEntity filtroCategoria(@RequestParam(value = "categoria", required = false) String categoria, @RequestParam(value = "status", required = false) String status){

        if(categoria != null && status != null)
            return new ResponseEntity(this.service.buscarPorStatusECategoria(status, categoria), HttpStatus.OK);

        if(categoria != null)
            return new ResponseEntity(this.service.buscarPorCategoria(categoria), HttpStatus.OK);

        return  new ResponseEntity(this.service.buscarPorStatus(status), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity filtroStatus(@RequestParam("status") String status){
//        return new ResponseEntity(this.service.buscarPorStatus(status), HttpStatus.OK);
//    }

    @PostMapping
    public String novaTransacao(@RequestBody  TransacaoRecord record){
        this.service.novaTransacao(record);
        return "Transação criada com sucesso!";
    }
}
