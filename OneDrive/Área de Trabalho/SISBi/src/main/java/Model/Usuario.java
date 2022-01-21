/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author guilh
 */
public class Usuario {
    
    public Usuario(String nome, String cpf, String nascimento, String endereco, String cidade, String estado, int numero) {
        
        this.nome=nome;
        this.cpf=cpf;
        this.nascimento=nascimento;
        this.endereco=endereco;
        this.cidade=cidade;
        this.estado=estado;
        this.numero=numero;
        
    }
    
    private String nome;
    private String cpf;
    private String nascimento;
    private String endereco;
    private String cidade;
    private String estado;
    private int numero;

    public Usuario() {
        
    }

      
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
