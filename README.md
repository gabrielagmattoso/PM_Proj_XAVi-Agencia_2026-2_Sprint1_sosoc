# PM_Proj_XAVi-Agencia_2026-2_Sprint1_sosoc
Sistema de gerenciamento da XAVi (Xulambs Agência de Viagens), desenvolvido como trabalho prático da disciplina de Programação Modular da PUC Minas. Contempla o cadastro e gerenciamento de clientes, rotas, voos e bilhetes, além da consulta de viagens e geração de relatórios.


## Classe 'Rota' e Classe 'Cidade'
**Branch:** 'educreates/Tarefa3'
**Arquivos:** 'Cidade.java' e 'Rota.java'
**Status:** Classes implementadas conforme UML e instruções do professor. Os testes ainda não foram adicionados.

## Classe 'Voo'
### 18/11/2026
**Branch:** 'dudaSilva/Tarefa3'
**Arquivo:** 'Voo.java'
**Status:** classe implementada conforme UML. Os testes ainda não foram adicionados.

## Classe 'VooTest'
### 23/11/2026
**Branch:** 'dudaSilva/Tarefa3'
**Status:** classe `Voo` e testes (`VooTest.java`) concluídos. Os 9 testes passam, mas após ajustar erros pontuais cometidos.
- Primeira execução: 5 testes passaram e 4 falharam (os de getters). A causa estava no próprio teste, e não no `Voo`: os valores usados para criar o voo e a rota eram diferentes dos valores esperados nas verificações. Corrigido, e todos passam.

## Classe 'Agencia'
### 25/11/2026
**Branch:** 'dudaSilva/Agencia'
**Arquivo:** 'Agencia.java'
**Status:** método `cadastrarCliente()` implementado.

**O que foi feito**
- `cadastrarCliente()`: lê nome e sobrenome pelo teclado (`Scanner`), recusa valores vazios, cria o `Cliente` e o guarda numa lista.
- Campos novos em `Agencia`: `private final List<Cliente> clientes;`, `private final List<Voo> voos;` e `private final Scanner entrada;`, que foram inicializados no construtor.

**Pendências**
- `criarBilhete()`