package solid.substituicao_liskov.invalido;

import java.util.Date;

import solid.substituicao_liskov.ExcecaoFraudeDetetada;
import solid.substituicao_liskov.ExcecaoMeioPagamentoInvalido;
import solid.substituicao_liskov.ExcecaoPagamentoFalhado;

public abstract class MeioDePagamento {
    private String nome;
    private String numeroCartao;
    private String codigoVerificacao;
    private Date dataExpiracao;
    private String impressaoDigital;

    public void validar() throws ExcecaoMeioPagamentoInvalido {
        if (nome == null || nome.isEmpty()) {
            throw new ExcecaoMeioPagamentoInvalido();
        }
        // outras validações
    }

    public void excecutarValidacoesFraude() throws ExcecaoFraudeDetetada {
        // executar validações num serviço externo
    }

    public void enviarParaProcessadorDePagamento() throws ExcecaoPagamentoFalhado {
        // enviar detalhes para processador de pagamento e
        // definir a impressão digital a partir da resposta
    }

    public String buscarImpressaoDigital() {
        return this.impressaoDigital;
    }
}
