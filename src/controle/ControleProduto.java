/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloProduto;

/**
 *
 * @author Bernardo Sant' Anna Costa
 */
public class ControleProduto {
    ConexaoBD conex = new ConexaoBD();
    ModeloProduto prod = new ModeloProduto();
    
    public void inserirProduto(ModeloProduto prod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO produto (descPROD) VALUES (?);");
            pst.setString(1, prod.getDescPROD());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o produto!"+ex.getMessage());
        }
        conex.desconecta();
    }
}
