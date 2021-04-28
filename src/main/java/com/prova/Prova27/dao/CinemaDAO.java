package com.prova.Prova27.dao;

import com.prova.Prova27.factory.ConnectionFactory;
import com.prova.Prova27.model.Cinemas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaDAO {

    public static List<Cinemas> cinemalist;
    private Connection connection;

    public CinemaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaCinema() {
        String sql = "CREATE TABLE IF NOT EXISTS cinema (" +
        "idCinema INT PRIMARY KEY AUTO_INCREMENT," +
        "nome VARCHAR(100) NOT NULL,"+
        "qntsalas int ";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Cinema.");
        }catch (SQLException e) {
            throw new RuntimeException(e);
            }
    }

    public void cadastraCinemas(Cinemas c) {
        String sql = "INSERT INTO cinemas" +
                " (nome, qntsalas) " +
                "VALUES (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1,c.getNome());
            stmt.setInt(2,c.getQntSalas());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                c.setNome(resultSet.getString(1));
                c.setIdCinema(resultSet.getInt(2));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cinemas> listaCinemas() {
        String sql = "SELECT * FROM cinemas";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            List<Cinemas> cinemas1 = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery();

            Cinemas cinemas;

            while (resultSet.next()) {
                cinemas = new Cinemas();
                cinemas.setNome(resultSet.getString("nome"));
                cinemas.setQntSalas(resultSet.getInt("qntsalas"));
                cinemas.setIdCinema(resultSet.getInt("IdCinema"));
                cinemas1.add(cinemas);

            }
            return cinemas1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

   