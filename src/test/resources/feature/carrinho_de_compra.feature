#language: pt
Funcionalidade: Carrinho de compra
  
  Como um usuário de e-commerce
  Gostaria de encontrar o produto desejado 
  E adicionar no carrinho de compras

  
  Cenário: Deve inserir produto no carrinho com sucesso
    Dado que estou acessando a aplicação
    Quando pesquisar pelo produto "Abajur"
    E selecionar o ícone de busca
    Então visualizo uma lista contendo "Abajur"
    Quando seleciono um produto
    E adiciono ao carrinho
    E abrir carrinho de compras
    Então devo encontrar o produto selecionado

   Cenário: Pesquisar produto fora do catalogo
    Dado que estou acessando a aplicação
    Quando pesquisar pelo produto "Buscopan"
    E selecionar o ícone de busca
    Então é exibido a mensagem "Sua busca por buscopan não encontrou resultado algum :("
 
  @ignore
  Cenário: Não deve permitir adicionar ao carrinho produto indisponível
    Dado que estou acessando a aplicação
    Quando pesquisar pelo produto "Tripé Telescópio"
    E selecionar o ícone de busca
    Então visualizo uma lista contendo "Tripé Telescópio"
    Quando seleciono um produto
    Então visualizo a mensagem de produto indisponível
  
  @ignore
   Cenário: Não deve duplicar itens adicionados mais de uma vez no carrinho
    Dado que estou acessando a aplicação
    E tenha inserido mais de uma vez o produto "Abajur Diamante Dome Branco Com Aramado Preto" no carrinho
    Quando consultar o carrinho
    Então terá apenas um produto listado
 