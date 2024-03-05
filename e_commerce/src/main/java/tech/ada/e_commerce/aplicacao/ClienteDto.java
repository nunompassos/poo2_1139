package tech.ada.e_commerce.aplicacao;

import tech.ada.e_commerce.domain.cliente.objetos.Tipo;

public record ClienteDto(
    String id,
    String nome,
    String email,
    String logradouro,
    String bairro,
    String cep,
    String cidade,
    String estado,
    Tipo tipo
) {
}
