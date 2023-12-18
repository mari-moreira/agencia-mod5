package com.mmtrip.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmtrip.model.Cliente;
import com.mmtrip.services.ClienteService;

@Controller
@RequestMapping("/clientes")

public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	// Listar os clientes
	@GetMapping
	public String listClientes(Model model) {
		List<Cliente> clientes = clienteService.getAllClientes();
		model.addAttribute("clientes", clientes);
		return "ListarClientes";
	}

	// Formulário de criação
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "clienteForm";
	}

	// Persistencia da criação
	@PostMapping("/save")
	public String saveCliente(@ModelAttribute("cliente") @DateTimeFormat(pattern = "yyyy-MM-dd") Cliente cliente) {
		// Convertendo a data para o formato brasileiro antes de salvar no banco de
		// dados
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String dataFormatada = formatador.format(cliente.getDtNasc());
			cliente.setDtNasc(formatador.parse(dataFormatada));
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.print("ERRO" + e.getMessage());

		}
		clienteService.saveCliente(cliente);
		return "redirect:/clientes";
	}

	// Formulário de edição
	@GetMapping("/editar/{idCliente}")
	public String showFormForUpdate(@PathVariable Long idCliente, Model model) {
		Cliente cliente = clienteService.getClienteById(idCliente);
		model.addAttribute("cliente", cliente);
		return "editarCliente";
	}

	// Persistencia da edição
	@PostMapping("/editar/{idCliente}")
	public String updateCliente(@PathVariable Long idCliente, @ModelAttribute("cliente") Cliente cliente) {
		clienteService.updateCliente(idCliente, cliente);
		return "redirect:/clientes";
	}

	// Excluir cliente
	@GetMapping("/deletar/{idCliente}")
	public String deleteCliente(@PathVariable Long idCliente) {
		clienteService.deleteCliente(idCliente);
		return "redirect:/clientes";
	}

}
