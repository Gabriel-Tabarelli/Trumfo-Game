package net.weg.projeto.model.enuns;

import lombok.AllArgsConstructor;
import net.weg.projeto.model.entity.AtaqueEspecial;

@AllArgsConstructor
public enum CartaPadraoEnum {
    GAMBA(1, 2, "Um animal terrestre e noturno que enfraquace suas vítimas. Atinge seus ápice de poder em uma noite de Lua Cheia", "Gambá", new AtaqueEspecial(AtaqueEspecialEnum.PEIDOENFRAQUECEDOR)),
    PORCOESPINHO(1, 2, "Um animal pequeno e rancoroso. Seu poder aumenta em noites de Lua Minguante", "Porco Espinho", new AtaqueEspecial(AtaqueEspecialEnum.ESPINHOSJULGAMENTO)),
    RATOPEQUENO(1, 1, "Um animal extremamente pequeno e não muito forte, mas que com o tempo se torna forte. Seu verdadeiro potencial é alcançado em noites de Lua Nova", "Rato Pequeno", new AtaqueEspecial(AtaqueEspecialEnum.CRESCIMENTOSUPREMO));

    public int ataque;
    public int vida;
    public String descricao;
    public String nome;
    public AtaqueEspecial ataqueEspecial;
}
