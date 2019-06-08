package br.com.etechoracio.avaliacao.business;

import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.etechoracio.avaliacao.dao.LivroDAO;
import br.com.etechoracio.avaliacao.model.Livro;
import br.com.etechoracio.common.business.BaseSB;

@Service
public class LivroSB extends BaseSB {

	private LivroDAO livroDAO;
	
	@Override
	protected void postConstructImpl() {
		livroDAO = getDAO(LivroDAO.class);
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Livro livro) throws Exception{
		Livro existe = livroDAO.findByNome(livro.getNome());
		
		if (existe !=null) {
			throw new Exception("Este livro já existe");
		}
		else {
		livroDAO.save(livro);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Livro livro) {
		livroDAO.delete(livro);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Livro> findAll() {
		return livroDAO.findAll();
	}
	
}
