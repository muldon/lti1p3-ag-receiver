package cl.services.lti1p3.ag.receiver.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record SolicitacaoEmprestimoListagemResponse(
        UUID codigoEmprestimo,
        BigDecimal valor,
        Integer quantidadeParcela) {
}
