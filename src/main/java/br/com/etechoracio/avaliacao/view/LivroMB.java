package br.com.etechoracio.avaliacao.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.etechoracio.avaliacao.model.Livro;
import br.com.etechoracio.avaliacao.business.LivroSB;
import br.com.etechoracio.common.view.BaseMB;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Controller
@Scope("view")
public class LivroMB extends BaseMB{

	
	@Autowired
	private LivroSB livroSB;
	
	private List<Livro> registros;
	
	private Livro edit = new Livro();
	
	protected void postConstruct() {
		registros = livroSB.findAll();
	}
	
	public void onSave() {
		try {
			livroSB.save(edit);
			registros = livroSB.findAll();
			showInsertMessage();
			
		} catch(Exception e) {
			showErrorMessage(e.getMessage());
		}
	}
}
