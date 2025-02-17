package tech.dock.Desafio.API.Rest.Java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.dock.Desafio.API.Rest.Java.domain.Transacao;
import tech.dock.Desafio.API.Rest.Java.services.TransacaoService;

/**
 * Classe respnsável por gerar paths na url para operações relacionadas a transações.
 * @author gabrielribeirojb
 *
 */

@RestController
@RequestMapping(value = "/extratos")
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	/**
	 * Retornará um extrato de transações em determinado período.
	 * @param dataMin
	 * @param dataMax
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<Transacao> pesquisaTransacoesPorData(
			@RequestParam (value="dataMin", defaultValue = "") String dataMin,
			@RequestParam (value="dataMax", defaultValue = "") String dataMax,
			Pageable pageable){
			return transacaoService.findTransacoes(dataMin, dataMax, pageable);
	}
}
