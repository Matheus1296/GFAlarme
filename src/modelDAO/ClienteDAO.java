/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import controller.Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Cliente;
import util.Conexao;
import util.Configurador;

/**
 *
 * @author aluno
 */
public class ClienteDAO {

    Configurador config = new Configurador();

    String url;
    String driver;
    String login;
    String senha;

    public ClienteDAO() {
        url = config.getUrl();
        driver = config.getDriver();
        login = config.getLogin();
        senha = config.getSenha();
    }

    public static Cliente inserir(String nome, String telefone, String celular, String email) {

//        nome = nome.trim();
//        telefone = telefone.trim();
//        celular = celular.trim();
//        email = email.trim();
        Cliente cliente = null;
        ClienteDAO clienteDAO = new ClienteDAO();

        try {

            // Criação do insert
            String sql = "insert into cliente values (?,?,?,?,null)";

            // Obter a conexão com o BD
            Conexao conex = new Conexao(clienteDAO.url, clienteDAO.driver,
                    clienteDAO.login, clienteDAO.senha);

            // Abrir a conexao
            Connection con = conex.obterConexao();

            // Preparar o comando para ser executado
            PreparedStatement comando = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, email);
            comando.setString(2, telefone);
            comando.setString(3, nome);
            comando.setString(4, celular);
            comando.execute();

            ResultSet rs = comando.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);

            }
            Cliente aux = new Cliente();
            aux.setClienteID(id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cliente;
    }
}
