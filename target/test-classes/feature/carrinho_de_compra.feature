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
