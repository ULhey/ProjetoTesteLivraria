package comfatecbiblioteca.model;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Livro {
	@Id
	@Column(name = "isbn", unique = true, nullable = false)
	private Long isbn;

	@Column(name = "titulo", unique = true, length = 700, nullable = false)
	private String titulo;

	@Column(name = "edicao", nullable = false)
	private int edicao;
	
	@Column(name = "dataPublicacao", nullable = false)
	private int dataPub;
	
	@Column(name = "autor", nullable = false)
	private String autor;

	public void setTitulo(String titulo) {
		if (!titulo.isBlank() && !titulo.isEmpty()) {
			this.titulo = titulo;
		} else {
			throw new IllegalArgumentException("Titulo invalido");
		}
	}

	public void setIsbn(String isbn) {
		if (!isbn.isBlank() && !isbn.isEmpty()) {
			Long valor = null;
			try {
				valor = Long.parseLong(isbn);
			} catch (Exception e) {
				throw new IllegalArgumentException("ISBN n pode conter caracteres");
			}

			if (isbn.length() == 15) {
				this.isbn = valor;
			} else {
				throw new IllegalArgumentException("ISBN deve conter 15 caracteres");
			}
		} else {
			throw new IllegalArgumentException("ISBN não pode estar em branco");
		} 
	}

	public void setDataPub(String dataPub) {
		if (!dataPub.isBlank() && !dataPub.isEmpty()) {
			DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY");
			Days d = null;

			try {
				d = Days.daysBetween(fmt.parseDateTime(obtemAnoAtual()), fmt.parseDateTime(dataPub));
			} catch (Exception e) {
				throw new IllegalArgumentException("Data inválida - caracteres inválidos");
			}

			if (d.getDays() > 0) {
				throw new IllegalArgumentException("Data inválida - ano maior que ano atual");
			} else {
				this.dataPub = Integer.parseInt(dataPub);
			}
		} else {
			throw new IllegalArgumentException("Data inválida");
		}
	}

	public String obtemAnoAtual() {
		DateTime anoAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY");
		return anoAtual.toString(fmt);
	}

	public void setAutor(String autor) {
		if (!autor.isBlank() && !autor.isEmpty()) {

			boolean contemCaracteresENumeros = autor.matches(".*[a-zA-Z].*") && autor.matches(".*\\d.*");

			if (!contemCaracteresENumeros) {
				this.autor = autor;
			} else {
				throw new IllegalArgumentException("Nome inválido");
			}

		} else {
			throw new IllegalArgumentException("Nome inválido");
		}
	}

	public void setEdicao(String edicao) {
		if (!edicao.isBlank() || !edicao.isEmpty()) {
			int valor = 0;

			try {
				valor = Integer.parseInt(edicao);
			} catch (Exception e) {
				throw new IllegalArgumentException("Não pode caracteres no campo");
			}

			if (valor > 0) {
				this.edicao = valor;
			} else {
				throw new IllegalArgumentException("Valor invalido");
			}

		} else {
			throw new IllegalArgumentException("Valor invalido");
		}
	}
}
