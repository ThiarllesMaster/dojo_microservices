User story criada para realizações bancárias (Saque) 

Narrative:
Eu como cooperado 
Preciso realizar operações bancárias de saque na minha conta
Para que eu possa programar minha vida financeira e realizar aplicações 	 

Scenario:Primeiro Cenário de teste de Saque
Given que uma conta possua um saldo de 600
When realizar um saque de 500
Then sistema deverá realizar o saque exibindo a mensagem: Saque realizado com sucesso
Scenario:Segundo Cenário de teste de Saque
When é realizado mais um saque 200
Then sistema exibe a mensagem Saldo indisponível

