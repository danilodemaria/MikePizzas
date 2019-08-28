/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrx
 */
public class Fisica extends Cliente {

    

    private String cpf;
    private String rg;
    
    public Fisica(){
        
    }
    
    public Fisica (int id, String nome, String cpf, String rg, String endereco){
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.id  = id;
        this.endereco = endereco;
    }
    
    public boolean Cadastra(Fisica pessoa) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "INSERT INTO pessoa_fisica (nome,endereco,telefone,rg,cpf) VALUES (?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getEndereco());
            pst.setString(3, pessoa.getTelefone());
            pst.setString(4, pessoa.getRg());
            pst.setString(5, pessoa.getCpf());         
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
    }
    
    public static ArrayList<Fisica> buscaFisico() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Fisica fisica = new Fisica();
        ArrayList<Fisica> lista = new ArrayList<Fisica>();
        String stm = "select * from pessoa_fisica";

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            fisica = new Fisica();
            fisica.setId(Integer.parseInt(rs.getString("id")));
            fisica.setNome(rs.getString("nome"));
            fisica.setTelefone(rs.getString("telefone"));
            fisica.setEndereco(rs.getString("endereco"));
            fisica.setRg(rs.getString("rg"));
            fisica.setCpf(rs.getString("cpf"));
            lista.add(fisica);
        }

        return lista;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    
}
