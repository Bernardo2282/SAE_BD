/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloProfessor;

/**
 *
 * @author Bernardo Sant' Anna Costa
 */
public class ControleProfessor {
    ConexaoBD conex = new ConexaoBD();
    ModeloProfessor prof = new ModeloProfessor();
    
    public void Salvar(ModeloProfessor prof){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO professor(nomePROF, sobrenomePROF, perfil) VALUES(?, ?, ?);");
            pst.setString(1, prof.getNome());
            pst.setString(2, prof.getSobrenome());
            pst.setString(3, prof.getPerfil());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o professor!"+ex.getMessage());
        }
        conex.conexao();
    }
}
