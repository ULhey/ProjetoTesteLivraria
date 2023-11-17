package comfatecbiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comfatecbiblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
