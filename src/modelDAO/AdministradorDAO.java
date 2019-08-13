/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Administrador;
import util.Conexao;
import util.Configurador;

/**
 *
 * @author aluno
 */
public class AdministradorDAO {

    Configurador config = new Configurador();

    String url;
    String driver;
    String login;
    String senha;

    public AdministradorDAO() {

        url = config.getUrl();
        driver = config.getDriver();
        login = config.getLogin();
        senha = config.getSenha();
    }

    public static Administrador inserir(String nome, String login, String senha) {
        
        Administrador adm = null;
        AdministradorDAO admDAO = new AdministradorDAO();

        try {
            // Criação do insert
            String sql = "insert into adm values (null,?,?,?)";

            // Obter a conexão com o BD
            Conexao conex = new Conexao(admDAO.url, admDAO.driver,
                    admDAO.login, admDAO.senha);

            // Abrir a conexao
            Connection con = conex.obterConexao();

            // Preparar o comando para ser executado
            PreparedStatement comando = con.prepareStatement(sql);

            comando.setString(1, nome);
            comando.setString(2, login);
            comando.setString(3, senha);

            // Comando executado
            comando.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return adm;
    }
    
    public static Administrador buscarPorId(int admID) {

        Administrador adm = null;

        ClienteFisicoDAO cfDAO = new ClienteFisicoDAO();

        try {
            // Criação do insert
            String sql = "select * from adm where admid = ?";

            // Obter a conexão com o BD
            Conexao conex = new Conexao(cfDAO.url, cfDAO.driver, cfDAO.login, cfDAO.senha);

            // Abrir a conexao
            Connection con = conex.obterConexao();

            PreparedStatement comando = con.prepareStatement(sql);
            
            comando.setInt(1, admID);

            /*
			 * ResultSet - Classe java que monta em memória uma matriz com a
			 * resposta das linhas do BD
             */
            ResultSet rs = comando.executeQuery();

            if (rs.next()) {

                //ClienteFisico
                adm = new Administrador();
                adm.setNome(rs.getString("nome"));
                adm.setLogin(rs.getString("login"));
                adm.setSenha(rs.getString("senha"));
            }

            rs.close();
            comando.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return adm;
    }
}
