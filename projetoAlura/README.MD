# Objetivo 

Este documento tem como objetivo explicar o motivo da criação deste repositório.

O repositório projetoAlura foi criado com o objetivo de aplicar conhecimento básico
no desenvolvimento web, e logo abaixo você poderá acompanhar todos os detalhes deste 
desafio.


# Case Técnico

As tecnologias que devem ser utilizadas são:
Java 20+
JPA
Maven
Spring Boot
H2, o BD relacional em memória
Flyway, uma ferramenta para versionar nossos scripts sql, que vão ser executados no banco de
dados.
* Qualquer outra tecnologia ou dependência, fica a seu critério.

#Orientações
1. Entre em https://start.spring.io/ e crie seu projeto.
2. Suba o projeto no seu github e deixe o repositório público(Seus commits serão avaliados).
3. Abra o projeto na IDE de sua preferência e divirta-se :)
4. Os requisitos estão em português, mas lembre-se de no código escrever tudo em inglês.
5. O bônus não é obrigatório e não possui ordem, então você pode realizar apenas um dos que
   são citados lá, de acordo com sua preferência.


# O que é esperado? 

Avaliaremos seu desafio de código com base em alguns atributos de qualidade do sistema, como:
Sua organização de commits no github, podem ser de sua preferência ou se quiser uma dica,
existem os conventional commits;
Modelagem das entidades: campos obrigatórios e tipagens ficam ao critério da pessoa
desenvolvedora;
Recursos: quanto as pessoas conhecem das funcionalidades do Framework e dos recursos
mais novos da linguagem;
Correção: seu código deve seguir todos os requisitos obrigatórios apresentados nas próximas
sessões;Testabilidade: quão bem testado é o seu código e quão fácil é adicionar novos testes ao seu
código;
Manutenibilidade: como é fácil adicionar recursos extras ao seu código;
Separação de preocupações: (https://en.wikipedia.org/wiki/Separation_of_concerns)


# Desafios JAVA
O nosso projeto de teste é organizado em duas etapas. Na primeira etapa, definimos os requisitos e as regras a serem seguidas. Na segunda etapa, apresentamos um caso de uso no qual você deve identificar os requisitos necessários e implementar a tarefa solicitada. Em ambas as etapas, avaliaremos cuidadosamente a implementação realizada, incluindo a qualidade do código e a aderência às instruções e requisitos fornecidos. Estamos interessados em observar como você aborda o problema proposto e transforma requisitos em soluções funcionais.

IMPORTANTE: Não se preocupe com a parte visual, toda a interação com os usuários deve ser feita por meio de API. Além disso, na Alura lidamos com muitos cursos, matrículas e avaliações, portanto, pense em uma modelagem que escala para muitos dados.

PRIMEIRA ETAPA
Usuários
Nesta seção, tratamos dos usuários da nossa plataforma, incluindo estudantes, instrutores e administradores.

1.1 Cadastro de Usuário (permissão: aberto)
Atributos:

Nome
Username (máximo de 20 caracteres)
Email
Senha
Role (ESTUDANTE, INSTRUTOR, ADMIN)
Data de criação
Restrições:

O Username deve conter apenas caracteres minúsculos, sem numerais e sem espaços.
O Email precisa estar em um formato válido.
Apenas um usuário pode ser registrado com o mesmo email/username.
1.2 Retorno de Dados de Usuário (permissão: administradores)
Devemos ser capazes de acessar um endpoint informando o username. Caso encontrado, devem ser retornados apenas o nome, email e role do usuário.

Curso
Nesta seção, tratamos dos cursos da nossa plataforma, incluindo cadastro, listagem e inativação.

2.1 Criação de Curso (permissão: administradores)
Atributos:

Nome
Código (máximo de 10 caracteres)
Instrutor
Descrição
Status
Data de criação
Data de inativação
Restrições:

Apenas um curso pode ter o mesmo código.
O código de um curso deve ser textual, sem espaços, numerais ou caracteres especiais, mas pode ser separado por '-'. Exemplo: spring-boot-avancado.
Apenas usuários instrutores podem ser autores de um curso.
A data de inativação deve ser definida apenas quando o curso estiver desativado.
2.2 Inativação de Curso (permissão: administradores)
Devemos acessar um endpoint com o código do curso para desabilitá-lo. Não excluímos cursos, apenas os desativamos.

2.3 Listagem de Cursos (permissão: administradores)
Devemos ser capazes de listar os cursos de forma paginada e filtrada pelo status, retornando os cursos ativos/inativos.

Matrícula
Nesta seção, os usuários podem se matricular em cursos ativos cadastrados na plataforma.

3.1 Matrícula em Curso (permissão: qualquer usuário logado)
Atributos:

Usuário
Curso
Data de matrícula
Restrições:

Um usuário não pode se matricular mais de uma vez em um curso.
As matrículas só podem ser feitas em cursos ativos.
SEGUNDA PARTE
Nosso time recebeu uma demanda para criar uma solução de avaliação de cursos. O diálogo entre Maria e Paulo delineou as seguintes funcionalidades:

Implementação de um sistema de avaliação de cursos pelos alunos, com notificações automáticas para os instrutores.
Notificação por e-mail diretamente para o instrutor quando um aluno avaliar o curso com uma nota inferior a 6, incluindo o motivo da nota.
Disponibilização de um relatório com o Net Promoter Score (NPS) de cada curso que tenha mais de quatro matrículas.
Com base nesse diálogo, implemente uma solução em cima do projeto iniciado na primeira parte.

Para a notificação automática de avaliações insatisfatórias, você pode utilizar a classe abaixo que simula o envio de e-mails:

java
Copy code
public class EmailSender {
public static void send(String recipientEmail, String subject, String body) {
System.out.println("Simulating sending email to [%s]:\n".formatted(recipientEmail));
System.out.println("""
Subject: %s
Body: %s
""".formatted(subject, body));
}
}
Bônus (não obrigatório)
Implementação do Spring Security e o acesso baseado em roles. Em vez do H2, usar o MySQL e executar a aplicação, o banco de dados e outros serviços necessários no Docker.