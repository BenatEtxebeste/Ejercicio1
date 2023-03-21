package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MUsuario extends Conector{
	
	

	public Usuario getUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId(2);
		usuario.setNombre("Benat");
		
		return usuario;
	}
	
	public ArrayList<Usuario> getUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("SELECT * FROM usuarios");
			ResultSet resultado = pst.executeQuery();
			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNombre(resultado.getString("nombre"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	public void eliminarUsuario(int id) {
		try {
			PreparedStatement pst = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
