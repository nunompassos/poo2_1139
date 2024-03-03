package tech.ada.e_commerce;

import tech.ada.e_commerce.domain.cliente.Cidade;
import tech.ada.e_commerce.domain.cliente.Cliente;
import tech.ada.e_commerce.domain.cliente.Endereco;
import tech.ada.e_commerce.domain.cliente.objetos.CEP;
import tech.ada.e_commerce.domain.cliente.objetos.CNPJ;
import tech.ada.e_commerce.domain.cliente.objetos.CPF;
import tech.ada.e_commerce.domain.cliente.objetos.Tipo;

public class Main {
    public static void main(String[] args) {
        Cliente c = Cliente.criar(
            CNPJ.criar("11111111111444"),
            Tipo.FISICA,
            "Nuno",
            "nuno@email.com",
            Endereco.criar(
                CEP.criar("88888888"),
                "Logradouro",
                "Bairro",
                Cidade.criar("Cidade", "UF")
            )
        );

        System.out.println(c.toString());
    }
}
