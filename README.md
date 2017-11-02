# Escalonador-Disco
Trabalho desenvolvido na linguagem java da disciplina de Sistemas Operacionais do curso de Sistemas de Informação PUCRS.

Este trabalho tem como proposta simular os algoritmos escalonamento de disco tais como: FCFS (First Come First Served), SSTF (Shorest Seek Time First), SCAN, C-SCAN, LOOK e C-LOOK.
A aplicação realiza o calculo da quantidade de movimentos que o cabeçote realiza para percorrer determinados cilindros do discos para cada algoritmo, estes cilindros são definidos neste [arquivo](https://github.com/lukzfreitas/Escalonador-Disco/blob/master/Escalonador-disco/arquivo.txt). A primeira linha deste arquivo é informado o número total de cilindros do disco, na segunda linha o cilindro onde o cabeçote estará posicionado inicialmente e na terceira linha uma lista de números correspondentes aos cilindros onde o cabeçote irá percorrer.

Além da mostrar quantidade de movimentos que o cabeçote realiza para percorrer todos os cilidros, esta aplicação gera um gráfico com o trajeto que cabeçote realiza para percorrer todos os cilindros de cada algoritmo.

- **FCFS (First Come First Served)**
  - O algoritmo FCFS (First-Come First Serve), tem como comportamento que o cabeçote passe pelos cilindros pela ordem do array; para isso foi necessário percorrer a partir do cabeçote inicial até o
último elemento do array para gerar o gráfico e fazer a contagem total de movimentos do cabeçote baseado nesta sequência.

- **SSTF (Shortest Seek Time First)**
  - O SSTF (Shortest Seek Time First) tem como objetivo, visitar os cilindros mais próximos de onde o cabeçote estiver no momento. Este algoritmo foi o mais complexo para ordenar a lista de cilindros
visitados, para isso, foi necessário guardar em uma variável local a informação do cilindro que possui a menor diferença em relação ao cilindro que o cabeçote que estiver no momento, e
comparar com os demais, após isso, adicioná-lo na próxima posição do array em ordem crescente.

- **SCAN**
  - Para o algoritmo SCAN foi necessário ordenar a lista em duas partes, uma primeira lista com todos os cilindros menores que o cilindro inicial e uma segunda lista com todos maiores que serão
visitados a partir do cilindro inicial. Após a lista com os menores valores que o cilindro inicial estiver preenchida ela é ordenada de forma decrescente e a lista com os maiores em ordem
crescente. Depois de ordenadas as listas, a de maiores que o cilindro inicial é adicionada no final da lista de menores, com isso é possível calcular o número de movimentos do cabeçote e gerar o
gráfico do escalonamento baseados na ordem desta lista ordenada.

- **C-SCAN**
  - O C-SCAN implementa quase que da mesma forma que o SCAN, a diferença que o cabeçote vai até as posições zero e a posição máxima do número de cilindros, a lista de menores é adicionada no final da lista de maiores e o
percurso do último cilindro do disco até o cilindro zero não é contabilizado no número de movimentos do cabeçote.

- ** LOOK e C-LOOK **
  - Os algoritmos LOOK e C-LOOK, ambos geram o mesmo gráfico, que também são iguais ao do SCAN, com a diferença que o cabeçote não vai até os extremos zero e número total de
cilindros, entretanto vão até o final de cada extremidade do array de cilindros que serão visitados depois de ordenado. A única diferença entre o LOOK e CLOOK é que no segundo algoritmo o
percurso do último cilindro da lista de maiores até o primeiro cilindro da lista de menores que o cilindro inicial não é contabilizado no número de movimentos do cabeçote.

# Exemplos
Tela Inicial

![TELA_INICIAL](https://raw.githubusercontent.com/lukzfreitas/Escalonador-Disco/master/Escalonador-disco/telaInicial.PNG)

Gráfico gerado do trajeto realizado pelo algoritmo FCFS

![FCFS](https://raw.githubusercontent.com/lukzfreitas/Escalonador-Disco/master/Escalonador-disco/FSFC.png)

# Colaboradores
[Camila Moser](https://github.com/CamilaMoser) e [Lucas Freitas](https://github.com/lukzfreitas).

