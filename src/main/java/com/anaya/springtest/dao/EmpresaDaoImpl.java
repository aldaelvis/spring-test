package com.anaya.springtest.dao;

import com.anaya.springtest.model.Empresa;
import com.anaya.springtest.PersistenceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class EmpresaDaoImpl implements DaoBase {

    private final PersistenceData d;

    @Autowired
    public EmpresaDaoImpl(PersistenceData d) {
        this.d = d;
    }

    @Override
    public boolean addEmpresa(Empresa emp) {
        return d.addEmpresa(emp);
    }

    @Override
    public List<Empresa> getAll() {
        return d.getData();
    }

    @Override
    public void deleteEmpresa(int id) {
        d.removeEmpresa(id);
    }

    @Override
    public void editEmpresa(Empresa emp) {
        d.editEmpresa(emp);
    }

    @Override
    public Empresa getFindId(int id) {
        if (d.getEmpresa(id).isPresent()) {
            return d.getEmpresa(id).get();
        }

        return null;
    }

    public List<Empresa> getLastThree() {
        return d.getLastThree();
    }
}
