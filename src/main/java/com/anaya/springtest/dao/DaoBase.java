package com.anaya.springtest.dao;

import com.anaya.springtest.model.Empresa;

import java.util.List;

public interface DaoBase {

    boolean addEmpresa(Empresa emp);

    List<Empresa> getAll();

    void deleteEmpresa(int id);

    void editEmpresa(Empresa emp);

    Empresa getFindId(int id);
}
