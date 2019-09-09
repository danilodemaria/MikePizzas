package modelos;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fisica extends Cliente {

    private String cpf;
    private String rg;

    // Construtor
    public Fisica() {

    }

    // Construtor
    public Fisica(int id, String nome, String cpf, String rg, String endereco, String telefone) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.id = id;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Método para cadastrar pessoa fisica
    public boolean Cadastra(Fisica pessoa) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "INSERT INTO pessoa_fisica (nome,endereco,telefone,rg,cpf,excluido) VALUES (?,?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getEndereco());
            pst.setString(3, pessoa.getTelefone());
            pst.setString(4, pessoa.getRg());
            pst.setString(5, pessoa.getCpf());
            pst.setBoolean(6, false);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para buscar todas pessoas fisicas ativas no banco de dados
    public static ArrayList<Fisica> buscaFisico() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Fisica fisica = new Fisica();
        ArrayList<Fisica> lista = new ArrayList<Fisica>();
        String stm = "select * from pessoa_fisica where excluido = false";

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

    // Método para remover uma pessoa fisica
    public static boolean remover(Fisica pessoa) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "UPDATE pessoa_fisica set excluido = true where id = " + pessoa.getId();

        try {
            pst = conn.prepareStatement(stm);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

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

}
