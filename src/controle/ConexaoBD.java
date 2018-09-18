/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author Bernardo Sant' Anna Costa
 */

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexaoBD {
    public Statement stm; //responsavel por fazer uma pesquisa no banco de dados
    public ResultSet rs; //responsavel pelo resultado da pesquisa
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/tiinf2";
    private String usuario = "root";
    private String senha = "vertrigo";
    public Connection con;
    
    public void conexao(){
        System.setProperty("jdbc.Drivers", driver);
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conexão efetuada com Sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados:\n"+ex.getMessage());
        }
    }
    
    public void desconecta(){
        try {
            con.close();
            JOptionPane.showMessageDialog(null, "Banco de dados desconectado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com o Banco de Dados:\n"+ex.getMessage());
        }
    }
    
    public void executaSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro executaSql:\n"+ex.getMessage());
        }
        
    }
}
