package net.weg.projeto.security.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.projeto.model.entity.Jogador;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class JogadorSecurity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senha;

    private List<GrantedAuthority> authorities;

    @OneToOne
    private Jogador jogador;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public JogadorSecurity(Jogador jogador, String senha) {
        this.jogador = jogador;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.enabled = true;
        this.credentialsNonExpired = true;
        this.senha = new BCryptPasswordEncoder().encode(senha);
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return jogador.getNome();
    }
}
