User story criada para realizações bancárias (Depósito) (Versão 1.3)

Narrative:
Eu como cooperado 
Preciso realizar operações bancárias de depósito na minha conta
Para que eu possa poupar para comprar minha casa 	 

Scenario:Primeiro Cenário de teste de Depósito
Given Dado que eu possuo minha conta (sem número informado)
When realizar um depósito bancário no valor de 500
Then sistema deverá exibir a mensagem: Você deve informar o número da conta
Scenario:Segundo Cenário de teste de Depósito
Given Dado que eu possuo minha conta 0023-9 o valor de 300
When realizar um depósito bancário de 500
Then sistema exibe: Você possui na conta: 0023-9 o valor de 800
