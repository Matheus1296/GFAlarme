/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Cliente;
import model.ClienteJuridico;
import util.Conexao;
import util.Configurador;

/**
 *
 * @author aluno
 */
public class ClienteJuridicoDAO {

    Configurador config = new Configurador();

    String url;
    String driver;
    String login;
    String senha;

    public ClienteJuridicoDAO() {
        url = config.getUrl();
        driver = config.getDriver();
        login = config.getLogin();
        senha = config.getSenha();
    }

    public static ClienteJuridico inserir(String nome, String telefone, String celular, String email, String cnpj, String nomeDoResponsavel) {

//        cnpj = cnpj.trim();
//        nomeDoResponsavel = nomeDoResponsavel.trim();

        Cliente aux = new Cliente();
        ClienteJuridico clienteJuridico = null;
        ClienteJuridicoDAO cjDAO = new ClienteJuridicoDAO();

        try {
            // Criação do insert
            String sql = "insert into Cliente_Juridico values (?,?,?)";

            // Obter a conexão com o BD
            Conexao conex = new Conexao(cjDAO.url, cjDAO.driver, cjDAO.login, cjDAO.senha);

            // Abrir a conexao
            Connection con = conex.obterConexao();

            // Preparar o comando para ser executado
            PreparedStatement comando = con.prepareStatement(sql);

            comando.setString(1, cnpj);
            comando.setString(2, nomeDoResponsavel);
            comando.setInt(3, aux.getClienteID());

            
            comando.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return clienteJuridico;
    }
    public static ClienteJuridico buscarPorId(int clienteID) {

        ClienteJuridico clienteJuridico = null;

        ClienteFisicoDAO cfDAO = new ClienteFisicoDAO();

        try {
            // Criação do insert
            String sql = "select cliente.nome,cliente_juridico.cnpj,cliente_juridico.nomeDoResponsavel,"
                    + "cliente.telefone,cliente.celular,cliente.email from cliente,cliente_Juridico "
                    + "where cliente.clienteid=cliente_Juridico.clienteid and cliente.clienteid = ? and cliente_Juridico.clienteid = ?";

            // Obter a conexão com o BD
            Conexao conex = new Conexao(cfDAO.url, cfDAO.driver, cfDAO.login, cfDAO.senha);

            // Abrir a conexao
            Connection con = conex.obterConexao();

            PreparedStatement comando = con.prepareStatement(sql);
            
            comando.setInt(1, clienteID);
            comando.setInt(2, clienteID);

            /*
			 * ResultSet - Classe java que monta em memória uma matriz com a
			 * resposta das linhas do BD
             */
            ResultSet rs = comando.executeQuery();

            if (rs.next()) {

                //ClienteFisico
                clienteJuridico = new ClienteJuridico();
                clienteJuridico.setNome(rs.getString("nome"));
                clienteJuridico.setCnpj(rs.getString("cnpj"));
                clienteJuridico.setNomeDoResponsavel(rs.getString("nomeDoResponsavel"));
                clienteJuridico.setTelefone(rs.getString("telefone"));
                clienteJuridico.setCelular(rs.getString("celular"));
                clienteJuridico.setEmail(rs.getString("email"));
                
                
            }

            rs.close();
            comando.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return clienteJuridico;
    }
}
