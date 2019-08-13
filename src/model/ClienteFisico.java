/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class ClienteFisico extends Cliente {

    private String cpf;
    private String rg;
    private String orgaoEmissor;
    private String estadoEmissor;
    private String sexo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getEstadoEmissor() {
        return estadoEmissor;
    }

    public void setEstadoEmissor(String estadoEmissor) {
        this.estadoEmissor = estadoEmissor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ClienteFisico(String cpf, String rg, String orgaoEmissor, String estadoEmissor, String sexo, String nome, String telefone, String celular, String email) {
        super(nome, telefone, celular, email);
        this.cpf = cpf;
        this.rg = rg;
        this.orgaoEmissor = orgaoEmissor;
        this.estadoEmissor = estadoEmissor;
        this.sexo = sexo;
    }

    public ClienteFisico(String cpf, String rg, String orgaoEmissor, String estadoEmissor, String sexo) {
        this.cpf = cpf;
        this.rg = rg;
        this.orgaoEmissor = orgaoEmissor;
        this.estadoEmissor = estadoEmissor;
        this.sexo = sexo;
    }

    public ClienteFisico() {
    }

    
    
}
