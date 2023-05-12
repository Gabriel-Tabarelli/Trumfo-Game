package net.weg.projeto.model.enuns;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AtaqueEspecialEnum {

    CRESCIMENTOSUPREMO("Crescimento Supremo",
            "Depois de um turno em combate o Rato Pequeno cresce e aumenta seus atributos" +
                    " de vida e ataque em mais um"),
    ESPINHOSJULGAMENTO("Espinhos do julgamento",
            "Sempre que alguém ataca o Porco Espinho, seus espinhos julgam o " +
                    "atacante e então dão um de dano a ele"),
    PEIDOENFRAQUECEDOR("Peido Enfraquecedor",
            "Solta um poderoso gás que incapacita seus oponentes de atacar com 100% de " +
                    "seus poderes");

    public String nome;
    public String descricao;
}
