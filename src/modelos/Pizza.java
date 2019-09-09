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

    // Método para cadastrar uma pizza
    public static boolean cadastra(Pizza pizza) {

        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "INSERT INTO pizza (tamanho,preco,excluido) VALUES (?,?,?)";

        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, pizza.getTamanho());
            pst.setDouble(2, pizza.getPreco());
            pst.setBoolean(3, false);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para remover uma pizza
    public boolean remover(Pizza pizza) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "UPDATE pizza set excluido = true where id = " + pizza.getId();

        try {
            pst = conn.prepareStatement(stm);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para buscar todas as pizzas ativas no banco de dados
    public static ArrayList<Pizza> buscaPizzas() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Pizza pizza = new Pizza();
        ArrayList<Pizza> lista = new ArrayList<Pizza>();
        String stm = "select * from pizza where excluido = false";

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

    // Método para buscar uma pizza
    public static String buscaPizzas(Pedido pedido) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();

        String aux = "";
        String stm = "SELECT * from pizza where id = " + pedido.getId_pizza();
        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            aux = rs.getString("tamanho");
        }

        return aux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
