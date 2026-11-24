**Autora:** dudaSilva (Aluno 3)
**Branch:** `dudaSilva/Tarefa4`
**Data:** 23/11/2026

*Uso de IA: este relatório foi construído com apoio de Claude (Anthropic), versão Claude Sonnet 5.5, que axiliou nos comandos utilizados no terminal e colaborou no significado e análise claro das saídas.* 

## 1. Resumo

Foram mesclados na branch os códigos das quatro branches da Tarefa 3. Os quatro merges foram concluídos. Todas as classes ficaram na raiz do projeto, sem `package`, o que facilitou a junção.

A compilação das classes, feita com `javac Bilhete.java Cliente.java Cidade.java Rota.java Voo.java`, falha com dois erros, ambos ligados ao `Bilhete`: o arquivo está incompleto e o `Cliente` chama um método que ele não tem. Como o `javac` interrompe no erro de sintaxe, outros erros podem aparecer depois que o `Bilhete.java` estiver completo. Por isso o merge na `main` não deve ser feito antes de o projeto compilar.

## 2. Erros de compilação

O primeiro erro está em `Bilhete.java`, linha 55, com a mensagem `reached end of file while parsing`. O arquivo termina no meio do método `voosConsecutivos`, logo após o cálculo da variável `dataValida`. Faltam o `return` e as chaves que fecham o método e a classe. O arquivo já estava assim na branch da Gabriela, então o problema não foi causado pelo merge.

O segundo erro está em `Cliente.java`, linha 41, com a mensagem `cannot find symbol: method precoVenda()` na classe `Bilhete`. O método `totalGasto()` do `Cliente` chama `Bilhete.precoVenda()`, mas o `Bilhete.java` não tem esse método. Esse erro deve desaparecer quando o `Bilhete` estiver completo, desde que `precoVenda()` exista sem parâmetros e retorne um valor numérico compatível com o retorno de `totalGasto()`. Por isso Gabriela e Pedro precisam combinar a assinatura.

## 3. Divergências com a UML

### Bilhete (Gabriela)
Faltam três métodos previstos na UML: `adicionarVoo(v: Voo): boolean`, `temVagas(): boolean` e `precoVenda(): double`. O método `voosConsecutivos` está cortado.

### Cliente (Pedro)

O método `totalGasto()` diverge em dois pontos. A UML prevê retorno `double`, e o código retorna `Double`. O método `relatorio(): String`, previsto na UML, não existe no arquivo. O atributo `registro` está marcado como `{readOnly}` na UML, mas no código é `private int registro;`, sem `final`. O método `getBilhetes()` existe no código sem constar na UML e devolve a lista interna. Por fim, a linha 41 depende do método `precoVenda()` do `Bilhete`, que ainda não existe.

### Rota (Aluno 2)

O construtor previsto era `Rota(origem: Cidade, destino: Cidade)`, e o código tem `Rota(String codigoRota)`, exigindo uma `String` de exatamente quatro caracteres. Origem e destino passam a ser definidos depois da criação, por `DefinirOrigem(Cidade)` e `DefinirDestino(Cidade)`. Os métodos estáticos `validarCodigo(String)` e `deCodigo(String)` previstos na UML não existem.

A classe também tem itens que a UML não prevê: os atributos `codigoRota` e `minutosRota` e os métodos `DefinirMinutosRota`, `ResetarRota` e `getMinutosRota`. Os métodos de definição e de reset começam com letra maiúscula, fora da convenção Java. Os getters de origem e destino lançam `IllegalArgumentException` quando o valor ainda não foi definido, o que obriga quem usa a classe, como o `Voo` nos testes, a definir os dois valores antes de consultá-los.

### Cidade (Aluno 2)

Os valores do enum são diferentes dos da UML. A UML prevê `BELO_HORIZONTE`, `FORTALEZA`, `RECIFE`, `JOAO_PESSOA`, `SAO_LUIS` e `NATAL`. O código tem `BELO_HORIZONTE`, `RIO_DE_JANEIRO`, `SAO_PAULO`, `BRASILIA`, `RECIFE`, `SALVADOR`, `CURITIBA`, `PORTO_ALEGRE`, `MANAUS` e `CUIABA`, de modo que só dois valores coincidem. Também não existem o atributo `codigo: int`, o método `getCodigo()` e o método estático `deCodigo(int)`.

### Voo (dudaSilva)
Há duas observações. A UML não define se o código do voo inclui a data, e a implementação devolve apenas o código da rota. Além disso, `reservarVaga()` em voo lotado imprime uma mensagem e não reserva; porém nasce a decisão entre manter esse comportamento ou lançar uma exceção.

### Inconsistência na própria UML

A UML usa `temVaga()` no `Voo` e `temVagas()` no `Bilhete`. Os nomes são muito parecidos e podem causar chamadas erradas.
