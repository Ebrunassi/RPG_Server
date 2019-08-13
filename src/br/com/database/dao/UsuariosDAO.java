package br.com.database.dao;

import br.com.database.model.Usuarios;

public class UsuariosDAO extends GenericDao<Usuarios,String>{
	public UsuariosDAO(){
		super(Usuarios.class);
	}
}
