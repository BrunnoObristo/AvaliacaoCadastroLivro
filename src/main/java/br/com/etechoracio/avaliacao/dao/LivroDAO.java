package br.com.etechoracio.avaliacao.dao;
import br.com.etechoracio.common.dao.BaseDAO;
import br.com.etechoracio.avaliacao.model.Livro;

public interface LivroDAO extends BaseDAO<Livro>{

	
	public Livro findByNome(String nome);
}
