package comfatecbiblioteca;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import comfatecbiblioteca.model.Livro;
import comfatecbiblioteca.repository.LivroRepository;

class req01cadastraLivroTeste {
	@Autowired
	private LivroRepository lrep;
	
	@Test
	void ct01_cadastrar_livro_com_sucesso() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setEdicao("1");
			l.setDataPub("2020");
			l.setIsbn("111111111111111");
			l.setTitulo("Harry potter");	
			l.setAutor("cleber");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail("errado");
		}
	}
	
	@Test
	void ct02_cadastrar_livro_com_autor_em_branco() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setAutor("");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct03_cadastrar_livro_com_numero_no_autor() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setAutor("cleber 1");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct04_cadastrar_livro_com_ano_maior_que_atual() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setDataPub("2024");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct05_cadastrar_livro_com__caracteres_no_ano() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setDataPub("a");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct06_cadastrar_livro_com_ano_em_branco() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setDataPub("");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct07_cadastrar_livro_com_edicao_menor_ou_igual_a_zero() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setEdicao("0");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct08_cadastrar_livro_com_caracter_na_edicao() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setEdicao("a");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct9_cadastrar_livro_com_edicao_em_branco() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setEdicao("");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct10_cadastrar_livro_com_isbn_diferente_de_15_caracteres() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setIsbn("1234567891234589123");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct11_cadastrar_livro_com_isbn_em_branco() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setIsbn("");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct12_cadastrar_livro_com_isbn_com_letra() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setIsbn("a");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void ct13_cadastrar_livro_com_titulo_em_branco() {
		try {
			Livro l = new Livro();
			
			// funcionando
			l.setTitulo("");
			
			//lrep.save(l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
