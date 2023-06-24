package com.anaya.springtest;

import com.anaya.springtest.model.Empresa;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersistenceData {

    private final List<Empresa> data;

    public PersistenceData() {
        data = new ArrayList<>();
    }

    public List<Empresa> getData() {
        return data;
    }

    public List<Empresa> getLastThree() {
        if (data.size() >= 3) {
            return data.subList(data.size() - 3, data.size());
        }

        return data;
    }

    public boolean addEmpresa(Empresa empresa) {

        Optional<Empresa> emp = getEmpresa(empresa.getIdEmpresa());
        if (!emp.isPresent()) {
            data.add(empresa);

            return true;
        }
        return false;
    }

    public void editEmpresa(Empresa empEdit) {

        Optional<Empresa> emp = getEmpresa(empEdit.getIdEmpresa());
        emp.ifPresent(data::remove);
        data.add(empEdit);
    }

    public void removeEmpresa(int id) {
        Optional<Empresa> emp = getEmpresa(id);
        emp.ifPresent(data::remove);

    }

    public Optional<Empresa> getEmpresa(int id) {
        return data.stream()
                .filter(data -> data.getIdEmpresa() == id)
                .findFirst();
    }

}
