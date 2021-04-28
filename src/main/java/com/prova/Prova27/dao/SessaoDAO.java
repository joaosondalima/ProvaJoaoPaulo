package com.prova.Prova27   .dao;

import com.prova.Prova27.factory.ConnectionFactory;
import com.prova.Prova27.model.Sessao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessaoDAO {

    public static List<Sessao> sessaoList;
    private Connection connection;

    public SessaoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public static void createTableSessao() {
    }

    public static void createTableCinemas() {
    }

    public void criarTabelaSessao() {
        String sql = "CREATE TABLE IF NOT EXIST sessao (" +
                "idSessao INT PRIMARY KEY AUTO_INCREMENT," +
                "film VARCHAR(100) NOT NULL," +
                "numsalas int";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Cinema.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastraSessao(Sessao s) {
        String sql = "INSERT INTO sessao" +
                " (film, numSala) " +
                "VALUES (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, s.getFilm());
            stmt.setInt(2, s.getNumSala());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                s.setFilm(resultSet.getString(1));
                s.setNumSala(resultSet.getInt(2));
                s.setIdSessao(resultSet.getInt(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listaSessao() {
        String sql = "SELECT * FROM sessao";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            List<Sessao> sessaoList = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery();

            Sessao sessao;

            while (resultSet.next()) {
                sessao = new Sessao();
                sessao.setFilm(resultSet.getString("film"));
                sessao.setNumSala(resultSet.getInt("numSala"));
                sessao.setIdSessao(resultSet.getInt("idSessao"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

