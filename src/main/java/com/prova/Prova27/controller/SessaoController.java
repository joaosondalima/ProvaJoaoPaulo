package com.prova.Prova27.controller;

import com.prova.Prova27.dao.SessaoDAO;
import com.prova.Prova27.model.Sessao;
import  com.google.gson.Gson;

import  javax.ws.rs. * ;
import  javax.ws.rs.core.Response ;
import  java.util.List ;

@Path("Sessao" )
public class SessaoController {

    @GET
    @Path("criatabela")
    @Produces("application/json")
    public Response criaTabelaSessao() {
        SessaoDAO sessaoDAO = new SessaoDAO();
        SessaoDAO.createTableSessao();
        return Response.ok(new Gson().toJson("Tabela Sessao criada com sucesso!")).build();
    }
    @GET
    @Path("list")
    @Produces("application/json")
    public Response listSFilme(){
        SessaoDAO sessaoDAO = new SessaoDAO();
        List<Sessao> sessao = SessaoDAO.sessaoList;
        return Response.ok(new Gson().toJson(sessao)).build();
    }
}
