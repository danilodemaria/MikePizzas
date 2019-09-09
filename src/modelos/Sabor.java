package modelos;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sabor {

    private int id;
    private String nome;
    private String ingredientes;

    public Sabor() {

    }

    public Sabor(int id, String nome, String ingredientes) {
        this.id = id;
        this.nome = nome;
        this.ingredientes = ingredientes;
    }

    // Méotodo para cadastrar um sabor
    public static boolean cadastra(Sabor sabor) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "INSERT INTO sabor (nome,ingredientes,excluido) VALUES (?,?,?)";

        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, sabor.getNome());
            pst.setString(2, sabor.getIngredientes());
            pst.setBoolean(3, false);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para remover um sabor
    public boolean remover(Sabor sabor) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "UPDATE sabor set excluido = true where id = " + sabor.getId();

        try {
            pst = conn.prepareStatement(stm);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para buscar um sabor
    public static String buscaSabores(int id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();

        String aux = "";
        String stm = "SELECT * from sabor where id = " + id;
        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            aux = rs.getString("nome");
        }

        return aux;
    }

    // Método para buscar todos os sabores ativos
    public static ArrayList<Sabor> buscaSabores() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Sabor sabor = new Sabor();
        ArrayList<Sabor> lista = new ArrayList<Sabor>();
        String stm = "select * from sabor where excluido = false";

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            sabor = new Sabor();
            sabor.setId(Integer.parseInt(rs.getString("id")));
            sabor.setNome(rs.getString("nome"));
            sabor.setIngredientes(rs.getString("ingredientes"));
            lista.add(sabor);
        }

        return lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

}
