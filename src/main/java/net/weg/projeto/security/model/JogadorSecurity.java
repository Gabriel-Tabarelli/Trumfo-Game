package net.weg.projeto.security.model;

import lombok.Data;
import net.weg.projeto.model.entity.Jogador;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
public class JogadorSecurity implements UserDetails {

    private List<GrantedAuthority> authorities;

    private Jogador jogador;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public JogadorSecurity(Jogador jogador) {
        this.jogador = jogador;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.enabled = true;
        this.credentialsNonExpired = true;
    }

    @Override
    public String getPassword() {
        return jogador.getSenha();
    }

    @Override
    public String getUsername() {
        return jogador.getNome();
    }
}
