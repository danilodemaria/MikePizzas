package modelos;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Juridica extends Cliente {

    private String cnpj;
    private String inscricaoEstadual;

    public Juridica() {

    }

    public Juridica(int id, String endereco, String nome, String cnpj, String inscricao, String telefone) {
        this.id = id;
        this.endereco = endereco;
        this.nome = nome;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricao;
        this.telefone = telefone;
    }

    // Método para cadastrar uma pessoa juridica no banco
    public boolean Cadastra(Juridica pessoa) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "INSERT INTO pessoa_juridica (nome,endereco,telefone,cnpj,inscricao, excluido) VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getEndereco());
            pst.setString(3, pessoa.getTelefone());
            pst.setString(4, pessoa.getCnpj());
            pst.setString(5, pessoa.getInscricaoEstadual());
            pst.setBoolean(6, false);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para buscar todos os clientes juridicos
    public static ArrayList<Juridica> buscaJuridico() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Juridica juridica = new Juridica();
        ArrayList<Juridica> lista = new ArrayList<Juridica>();
        String stm = "select * from pessoa_juridica where excluido = false";

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            juridica = new Juridica();
            juridica.setId(Integer.parseInt(rs.getString("id")));
            juridica.setNome(rs.getString("nome"));
            juridica.setTelefone(rs.getString("telefone"));
            juridica.setEndereco(rs.getString("endereco"));
            juridica.setCnpj(rs.getString("cnpj"));
            juridica.setInscricaoEstadual(rs.getString("inscricao"));
            lista.add(juridica);
        }

        return lista;
    }

    // Método para remover um cliente juridico
    public boolean remover(Juridica pessoa) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "UPDATE pessoa_juridica set excluido = true where id = " + pessoa.getId();

        try {
            pst = conn.prepareStatement(stm);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

}
