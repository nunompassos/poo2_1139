package tech.ada.e_commerce.aplicacao.cliente;

import tech.ada.e_commerce.domain.cliente.objetos.Tipo;

public record ClienteDto(
    Tipo tipo,
    String id,
    String nome,
    String email,
    String logradouro,
    String bairro,
    String cep,
    String cidade,
    String estado
) {
}
