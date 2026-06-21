package desafio.cadastroLivros.Model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "username")
    public String username;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "anoPublicado")
    private LocalDate anoPublicado;
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "disponivel")
    private boolean disponivel;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_roles", joinColumns = @JoinColumn(name = "livro_id"))
    @Column(name = "role_id")
    private List<String> roles =new ArrayList<>();
    @Column(name = "passaword")
    public String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
