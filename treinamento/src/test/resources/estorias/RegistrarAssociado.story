Sample story

Narrative:
Eu como usuario do sistema 
Preciso realizar um cadastro de um associado
Para que eu possa gerenciar meus clientes 
					 
Scenario:  Cadastro de um associado
Given Dado que eu decida cadastrar um associado com 1 Jose da Silva e 97599214054
When Quando resolver cadastrar um associado
Then Se o cadastro ocorreu com sucesso a resposta deverá possui código 201
Then O associado deverá ter o CPF 97599214054 cadastrado	
Then Na base de dados deverá haver 1 elemento		 
