package com.anaya.springtest.controller;


import com.anaya.springtest.dao.EmpresaDaoImpl;
import com.anaya.springtest.model.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController()
@RequestMapping("/empresa")
public class EmpresaResource {

    EmpresaDaoImpl empresaDao;

    public EmpresaResource(EmpresaDaoImpl empresaDao) {
        this.empresaDao = empresaDao;
    }

    @GetMapping("/all")
    public List<Empresa> getAll() {
        return empresaDao.getAll();
    }


    @GetMapping("/find/{id}")
    public Empresa getEmpresa(@PathVariable int id) {
        return empresaDao.getFindId(id);
    }

    @GetMapping("/last-three")
    public List<Empresa> getEmpresa() {
        return empresaDao.getLastThree();
    }

    @PostMapping("/")
    public ResponseEntity<Empresa> addEmpresa(@RequestBody Empresa empresa) {
        boolean est = empresaDao.addEmpresa(empresa);
        if (est) {
            return new ResponseEntity<>(empresa, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }

    @PutMapping("/")
    public ResponseEntity<Empresa> editEmpresa(@RequestBody Empresa empresa) {
        empresaDao.editEmpresa(empresa);
        return new ResponseEntity<>(empresa, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteEmpresa(@RequestBody int id) {
        empresaDao.deleteEmpresa(id);
        return new ResponseEntity<>("Empresa eliminado", HttpStatus.OK);
    }

}
