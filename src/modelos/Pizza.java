package modelos;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pizza {

    private int id;
    private String tamanho;
    private double preco;

    public Pizza() {

    }

    public Pizza(int id, String tamanho, double preco) {
        this.id = id;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public static boolean cadastra(Pizza pizza) {

        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "INSERT INTO pizza (tamanho,preco) VALUES (?,?)";

        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, pizza.getTamanho());
            pst.setDouble(2, pizza.getPreco());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static ArrayList<Pizza> buscaPizzas() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Pizza pizza = new Pizza();
        ArrayList<Pizza> lista = new ArrayList<Pizza>();
        String stm = "select * from pizza";

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            pizza = new Pizza();
            pizza.setId(Integer.parseInt(rs.getString("id")));
            pizza.setTamanho(rs.getString("tamanho"));
            pizza.setPreco(rs.getDouble("preco"));
            lista.add(pizza);
        }

        return lista;

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

}
