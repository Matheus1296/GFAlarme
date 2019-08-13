/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.Cliente;
import model.Endereco;
import util.Conexao;
import util.Configurador;

/**
 *
 * @author aluno
 */
public class EnderecoDAO {

    Configurador config = new Configurador();

    String url;
    String driver;
    String login;
    String senha;

    public EnderecoDAO() {
        url = config.getUrl();
        driver = config.getDriver();
        login = config.getLogin();
        senha = config.getSenha();
    }

    public static Endereco inserir(String bairro, String cidade, String complemento, String estado, int numero, String rua, String cep) {

//        cep = cep.trim();
//        rua = rua.trim();
//        bairro = bairro.trim();
//        cidade = cidade.trim();
//        estado = estado.trim();
//        complemento = complemento.trim();
        Endereco endereco = null;
        EnderecoDAO endDAO = new EnderecoDAO();
        Cliente aux = new Cliente();

        try {
            // Criação do insert
            String sql = "insert into Endereco values (?,?,?,?,?,?,?,null,?)";

            // Obter a conexão com o BD
            Conexao conex = new Conexao(endDAO.url, endDAO.driver, endDAO.login, endDAO.senha);

            // Abrir a conexao
            Connection con = conex.obterConexao();

            // Preparar o comando para ser executado
            PreparedStatement comando = con.prepareStatement(sql);

            comando.setString(1, bairro);
            comando.setString(2, cidade);
            comando.setString(3, complemento);
            comando.setString(4, estado);
            comando.setInt(5, numero);
            comando.setString(6, rua);
            comando.setString(7, cep);
            comando.setInt(8, aux.getClienteID());

            // Comando executado
            comando.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return endereco;
    }
    public static Endereco buscarPorIdFisico(int clienteID) {
        
        Endereco endereco = null;

        ClienteFisicoDAO cfDAO = new ClienteFisicoDAO();

        try {
            // Criação do insert
            String sql = "select endereco.cep,endereco.rua,endereco.numero,endereco.complemento,"
                    + "endereco.bairro,endereco.cidade,endereco.estado from endereco,cliente,cliente_fisico where "
                    + "endereco.clienteid = cliente.clienteid and cliente.clienteid = cliente_fisico.clienteid "
                    + "and endereco.clienteid = ?";

            // Obter a conexão com o BD
            Conexao conex = new Conexao(cfDAO.url, cfDAO.driver, cfDAO.login, cfDAO.senha);

            // Abrir a conexao
            Connection con = conex.obterConexao();

            PreparedStatement comando = con.prepareStatement(sql);
            
            comando.setInt(1, clienteID);

            /*
			 * ResultSet - Classe java que monta em memória uma matriz com a
			 * resposta das linhas do BD
             */
            ResultSet rs = comando.executeQuery();

            if (rs.next()) {

                //Endereco
                endereco = new Endereco();
                endereco.setCep(rs.getString("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
            }

            rs.close();
            comando.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return endereco;
    }
    
    public static Endereco buscarPorIdJuridico(int clienteID) {
        
        Endereco endereco = null;

        ClienteFisicoDAO cfDAO = new ClienteFisicoDAO();

        try {
            // Criação do insert
            String sql = "select endereco.cep,endereco.rua,endereco.numero,endereco.complemento,"
                    + "endereco.bairro,endereco.cidade,endereco.estado from endereco,cliente,cliente_Juridico where "
                    + "endereco.clienteid = cliente.clienteid and cliente.clienteid = cliente_juridico.clienteid "
                    + "and endereco.clienteid = ?";

            // Obter a conexão com o BD
            Conexao conex = new Conexao(cfDAO.url, cfDAO.driver, cfDAO.login, cfDAO.senha);

            // Abrir a conexao
            Connection con = conex.obterConexao();

            PreparedStatement comando = con.prepareStatement(sql);
            
            comando.setInt(1, clienteID);

            /*
			 * ResultSet - Classe java que monta em memória uma matriz com a
			 * resposta das linhas do BD
             */
            ResultSet rs = comando.executeQuery();

            if (rs.next()) {

                //Endereco
                endereco = new Endereco();
                endereco.setCep(rs.getString("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
            }

            rs.close();
            comando.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return endereco;
    }
}
