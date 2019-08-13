/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Administrador;
import model.Cliente;
import model.ClienteFisico;
import model.ClienteJuridico;
import model.Endereco;
import modelDAO.AdministradorDAO;
import modelDAO.ClienteDAO;
import modelDAO.ClienteFisicoDAO;
import modelDAO.ClienteJuridicoDAO;
import modelDAO.EnderecoDAO;
import view.AlterarBuscarExcluirAdm;
import view.AlterarBuscarExcluirCliente;
import view.CadastroAdm;
import view.CadastroCliente;
import view.Login;

public class Controlador {

    private static Administrador adm;
    private static Cliente cliente;
    private static ClienteFisico clienteFisico;
    private static ClienteJuridico clienteJuridico;
    private static Endereco endereco;
    private boolean logado;
    private static Login telaLogin;

    public static void main(String[] args) {
        new Login();
    }

    public void verifica(String login, String senha) {
        if (login.equals("admin") && (senha.equals("admin")) || login.equals("") && (senha.equals(""))) {
            logado = true;
        } else {
            logado = false;
        }

    }

    public void cadastrarAdm(Administrador adm) {
        if (adm != null) {
            adm = AdministradorDAO.inserir(adm.getNome(), adm.getLogin(), adm.getSenha());
        } else {
            CadastroAdm aux = new CadastroAdm();
            aux.semDados();
        }
    }

    public void cadastrarPessoaFisica(Cliente cliente, ClienteFisico clienteFisico, Endereco endereco) {

        if (cliente != null || clienteFisico != null || endereco != null) {
            cliente = ClienteDAO.inserir(clienteFisico.getNome(), clienteFisico.getTelefone(), clienteFisico.getCelular(), clienteFisico.getEmail());
            clienteFisico = ClienteFisicoDAO.inserir(clienteFisico.getNome(), clienteFisico.getTelefone(), clienteFisico.getCelular(), clienteFisico.getEmail(), clienteFisico.getCpf(),
                    clienteFisico.getRg(), clienteFisico.getOrgaoEmissor(), clienteFisico.getEstadoEmissor(), clienteFisico.getSexo());
            endereco = EnderecoDAO.inserir(endereco.getBairro(), endereco.getCidade(), endereco.getComplemento(), endereco.getEstado(), endereco.getNumero(), endereco.getRua(), endereco.getCep());
        } else {
            CadastroCliente cadastroFisico = new CadastroCliente();
            cadastroFisico.semDados();
        }
    }

    public void cadastrarPessoaJuridica(Cliente cliente, ClienteJuridico clienteJuridico, Endereco endereco) {

        if (cliente != null || clienteJuridico != null || endereco != null) {
            cliente = ClienteDAO.inserir(cliente.getNome(), cliente.getTelefone(), cliente.getCelular(), cliente.getEmail());
            clienteJuridico = ClienteJuridicoDAO.inserir(clienteJuridico.getNome(), clienteJuridico.getTelefone(),
                    clienteJuridico.getCelular(), clienteJuridico.getEmail(), clienteJuridico.getCnpj(), clienteJuridico.getNomeDoResponsavel());
            endereco = EnderecoDAO.inserir(endereco.getBairro(), endereco.getCidade(), endereco.getComplemento(), endereco.getEstado(), endereco.getNumero(), endereco.getRua(), endereco.getCep());
        } else {
            CadastroCliente cadastroJuridico = new CadastroCliente();
            cadastroJuridico.semDados();
        }
    }

    public boolean getLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public void buscarUmClienteFisico(int clienteId) {
        clienteFisico = ClienteFisicoDAO.buscarPorId(clienteId);
        endereco = EnderecoDAO.buscarPorIdFisico(clienteId);
        AlterarBuscarExcluirCliente aux = new AlterarBuscarExcluirCliente();
        aux.dadosClienteFisico(clienteFisico, endereco);
    }

    public void buscarUmAdm(int clienteId) {
        adm = AdministradorDAO.buscarPorId(clienteId);
        AlterarBuscarExcluirAdm aux = new AlterarBuscarExcluirAdm();
        aux.dados(adm);
    }

    public void buscarUmClienteJuridico(int clienteId) {
        clienteJuridico = ClienteJuridicoDAO.buscarPorId(clienteId);
        endereco = EnderecoDAO.buscarPorIdJuridico(clienteId);
        AlterarBuscarExcluirCliente aux = new AlterarBuscarExcluirCliente();
        aux.dadosClienteJuridico(clienteJuridico, endereco);
    }

}
