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
import model.ClienteFisico;
import model.Endereco;
import util.Conexao;
import util.Configurador;

/**
 *
 * @author aluno
 */
public class ClienteFisicoDAO {

    ClienteDAO aux = new ClienteDAO();
    Configurador config = new Configurador();

    String url;
    String driver;
    String login;
    String senha;

    public ClienteFisicoDAO() {
        url = config.getUrl();
        driver = config.getDriver();
        login = config.getLogin();
        senha = config.getSenha();
    }

    public static ClienteFisico inserir(String nome, String telefone, String celular, String email, String cpf, String rg, String orgaoEmissor, String estadoEmissor, String sexo) {

//        cpf = cpf.trim();
//        rg = rg.trim();
//        orgaoEmissor = orgaoEmissor.trim();
//        estadoEmissor = estadoEmissor.trim();
//        sexo = sexo.trim();
        ClienteFisico clienteFisico = null;
        ClienteFisicoDAO cfDAO = new ClienteFisicoDAO();
        Cliente aux = new Cliente();

        try {
            // Criação do insert
            String sql = "insert into cliente_fisico values (?,?,?,?,?,?)";

            // Obter a conexão com o BD
            Conexao conex = new Conexao(cfDAO.url, cfDAO.driver, cfDAO.login, cfDAO.senha);

            // Abrir a conexao
            Connection con = conex.obterConexao();

            // Preparar o comando para ser executado
            PreparedStatement comando = con.prepareStatement(sql);

            comando.setString(1, cpf);
            comando.setString(2, orgaoEmissor);
            comando.setString(3, estadoEmissor);
            comando.setString(4, sexo);
            comando.setString(5, rg);
            comando.setInt(6, aux.getClienteID());

            // não é fklogin, porque aqui a referência é da Classe e não do BD
            // Comando executado
            comando.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return clienteFisico;
    }

    public static List<ClienteFisico> buscarTodos() {

        ClienteFisicoDAO cfDAO = new ClienteFisicoDAO();
        List<ClienteFisico> clientesFisicos = new LinkedList<ClienteFisico>();

        try {

            // criação do select
            String sql = "select ";

            // Obter a conexão com o banco de dados
            Conexao conex = new Conexao(cfDAO.url, cfDAO.driver, cfDAO.login, cfDAO.senha);

            // abrir conexão
            Connection con = conex.obterConexao();

            // Executa a confirmação direta de acesso ao banco pois não são
            // necessárias
            // informações para a query(caracter curinga)
            Statement comando = con.createStatement();

            // ResultSet - Classe java que monta em memória uma matriz com a
            // resposta das linhas do banco de dados
            ResultSet rs = comando.executeQuery(sql);

            // Vetor de objetos
            // Passagem de linha de dados do ResultSet para o vetor de objetos
            // (uma linha de dados da matriz do ResultSet é copiada para um
            // objeto no vetor clientesFisicos)
            while (rs.next()) {
                ClienteFisico c = new ClienteFisico();

                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setOrgaoEmissor(rs.getString("orgaoEmissor"));
                c.setEstadoEmissor(rs.getString("estadoEmissor"));
                c.setSexo(rs.getString("sexo"));
                c.setTelefone(rs.getString("telefone"));
                c.setCelular(rs.getString("celular"));
                c.setEmail(rs.getString("email"));
                clientesFisicos.add(c);
            }

            rs.close();
            comando.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clientesFisicos;
    }

    public static ClienteFisico buscarPorId(int clienteID) {

        ClienteFisico clienteFisico = null;

        ClienteFisicoDAO cfDAO = new ClienteFisicoDAO();

        try {
            // Criação do insert
            String sql = "select cliente.nome,cliente_fisico.cpf,cliente_fisico.rg,cliente_fisico.orgaoemissor,cliente_fisico.estadoemissor,cliente_fisico.sexo,"
                    + "cliente.telefone,cliente.celular,cliente.email from cliente,cliente_fisico "
                    + "where cliente.clienteid=cliente_fisico.clienteid and cliente.clienteid = ? and cliente_fisico.clienteid = ?";

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
                clienteFisico = new ClienteFisico();
                clienteFisico.setNome(rs.getString("nome"));
                clienteFisico.setCpf(rs.getString("cpf"));
                clienteFisico.setRg(rs.getString("rg"));
                clienteFisico.setOrgaoEmissor(rs.getString("orgaoEmissor"));
                clienteFisico.setEstadoEmissor(rs.getString("estadoEmissor"));
                clienteFisico.setSexo(rs.getString("sexo"));
                clienteFisico.setTelefone(rs.getString("telefone"));
                clienteFisico.setCelular(rs.getString("celular"));
                clienteFisico.setEmail(rs.getString("email"));
                System.out.println(clienteFisico.getEmail());
                
            }

            rs.close();
            comando.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return clienteFisico;
    }

}
