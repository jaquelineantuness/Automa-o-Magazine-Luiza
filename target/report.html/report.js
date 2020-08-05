$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/carrinho_de_compra.feature");
formatter.feature({
  "name": "Carrinho de compra",
  "description": "  Como um usuário de e-commerce\n  Gostaria de encontrar o produto desejado \n  E adicionar no carrinho de compras",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "Deve inserir produto no carrinho com sucesso",
  "description": "",
  "keyword": "Cenário"
});
formatter.step({
  "name": "que estou acessando a aplicação",
  "keyword": "Dado "
});
formatter.match({
  "location": "CarrinhoCompraSteps.queEstouAcessandoAAplicação()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pesquisar pelo produto \"Abajur\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "CarrinhoCompraSteps.pesquisarPeloProduto(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selecionar o ícone de busca",
  "keyword": "E "
});
formatter.match({
  "location": "CarrinhoCompraSteps.selecionarOÍconeDeBusca()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "visualizo uma lista contendo \"Abajur\"",
  "keyword": "Então "
});
formatter.match({
  "location": "CarrinhoCompraSteps.visualizoUmaListaContendo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "seleciono um produto",
  "keyword": "Quando "
});
formatter.match({
  "location": "CarrinhoCompraSteps.selecionoUmProduto()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "adiciono ao carrinho",
  "keyword": "E "
});
formatter.match({
  "location": "CarrinhoCompraSteps.adicionoAoCarrinho()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "abrir carrinho de compras",
  "keyword": "E "
});
formatter.match({
  "location": "CarrinhoCompraSteps.abrirCarrinhoDeCompras()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "devo encontrar o produto selecionado",
  "keyword": "Então "
});
formatter.match({
  "location": "CarrinhoCompraSteps.devoEncontrarOProdutoSelecionado()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Pesquisar produto fora do catalogo",
  "description": "",
  "keyword": "Cenário"
});
formatter.step({
  "name": "que estou acessando a aplicação",
  "keyword": "Dado "
});
formatter.match({
  "location": "CarrinhoCompraSteps.queEstouAcessandoAAplicação()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pesquisar pelo produto \"Buscopan\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "CarrinhoCompraSteps.pesquisarPeloProduto(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selecionar o ícone de busca",
  "keyword": "E "
});
formatter.match({
  "location": "CarrinhoCompraSteps.selecionarOÍconeDeBusca()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "é exibido a mensagem \"Sua busca por buscopan não encontrou resultado algum :(\"",
  "keyword": "Então "
});
formatter.match({
  "location": "CarrinhoCompraSteps.éExibidoAMensagem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});