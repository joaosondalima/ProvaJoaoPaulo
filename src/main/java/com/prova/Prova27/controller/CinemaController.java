package com.prova.Prova27.controller;

import com.prova.Prova27.dao.CinemaDAO;
import com.prova.Prova27.dao.SessaoDAO;
import com.prova.Prova27.model.Cinemas;
import  com.google.gson.Gson;
import com.prova.Prova27.model.Sessao;

import  javax.ws.rs. * ;
import  javax.ws.rs.core.Response ;
import  java.util.List ;

@Path("Sessao" )
public class CinemaController {

    @GET
    @Path("criatabela")
    @Produces("application/json")
    public Response criaTabelaSessao() {
        CinemaDAO cinemaDAO = new CinemaDAO();
        SessaoDAO.createTableCinemas();
        return Response.ok(new Gson().toJson("Tabela Sessao criada com sucesso!")).build();
    }
    @GET
    @Path("list")
    @Produces("application/json")
    public Response listSFilme(){
        CinemaDAO cinemaDAO = new CinemaDAO();
        List<Cinemas> cinemas = CinemaDAO.cinemalist;
        return Response.ok(new Gson().toJson(cinemas)).build();
    }
}