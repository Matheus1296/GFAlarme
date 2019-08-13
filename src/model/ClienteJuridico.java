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
public class ClienteJuridico extends Cliente {

    private String cnpj;
    private String nomeDoResponsavel;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public ClienteJuridico(String cnpj, String nomeDoResponsavel, String nome, String telefone, String celular, String email) {
        super(nome, telefone, celular, email);
        this.cnpj = cnpj;
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public ClienteJuridico(String cnpj, String nomeDoResponsavel) {
        this.cnpj = cnpj;
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public ClienteJuridico() {
    }

}
