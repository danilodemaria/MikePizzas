package modelos;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sabor {    
    
    private int id;
    private String nome;
    private String ingredientes;
    
    public Sabor(){
        
    }
    
    
    public Sabor(int id, String nome, String ingredientes){
        this.id = id;
        this.nome = nome;
        this.ingredientes = ingredientes;
    }
    
    public static boolean cadastra(Sabor sabor) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "INSERT INTO sabor (nome,ingredientes) VALUES (?,?)";

        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, sabor.getNome());
            pst.setString(2, sabor.getIngredientes());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
    public static ArrayList<Sabor> buscaSabores() throws SQLException{
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Sabor sabor = new Sabor();
        ArrayList<Sabor> lista = new ArrayList<Sabor>();
        String stm = "select * from sabor";        
       
        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        while(rs.next()){
            sabor = new Sabor();
            sabor.setId(Integer.parseInt(rs.getString("id"))); 
            sabor.setNome(rs.getString("nome"));
            sabor.setIngredientes(rs.getString("ingredientes"));            
            lista.add(sabor);                           
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the ingredientes
     */
    public String getIngredientes() {
        return ingredientes;
    }

    /**
     * @param ingredientes the ingredientes to set
     */
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

}
