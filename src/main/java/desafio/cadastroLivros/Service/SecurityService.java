package desafio.cadastroLivros.Service;


import desafio.cadastroLivros.Model.Livro;
import desafio.cadastroLivros.Repository.LivroRepository;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

public class SecurityService implements UserDetailsService {

    @Autowired
    public LivroRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Livro livroEntity = repository.findByUsername(username);

        if(livroEntity == null) {
            throw new UsernameNotFoundException("Este username não existe!");
        }
        Set<GrantedAuthority> authorities =new HashSet<GrantedAuthority>();
        livroEntity.getRoles().forEach(roles -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roles));
        });
        return new User(livroEntity.getTitulo(), livroEntity.getPassword(), authorities);
    }
}
