package com.api.api.Records;

import java.time.LocalDate;

public record TransacaoRecord(String cliente, float valor, LocalDate data_transacao, String categoria, String status) {
}
