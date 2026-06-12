package desafio.cadastroLivros.DTO;


import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class LivroDTO {

    private String titulo;
    private String autor;
    private LocalDate anoPublicado;
    @Size(min = 13, max = 13)
    private String isbn;
    private boolean disponivel;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getAnoPublicado() {
        return anoPublicado;
    }

    public void setAnoPublicado(LocalDate anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
