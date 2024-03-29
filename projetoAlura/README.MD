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


# Desafios

O nosso teste é dividido em duas etapas. Na primeira, descrevemos os requisitos e as regras que
devem ser seguidas. Em seguida, na segunda etapa, apresentamos um caso de uso no qual você
deve levantar os requisitos necessários e implementar a tarefa solicitada. Em ambas as etapas,
estaremos analisando cuidadosamente a implementação realizada, incluindo a qualidade do código
e a aderência às instruções e requisitos fornecidos. Estamos interessados em observar como você
aborda o problema proposto e transforma requisitos em soluções funcionais.
Importante: Não se preocupe com a parte visual, toda a interação com os usuários devem ser feitas
por API. E lembre-se, na Alura lidamos com muitos cursos, matrículas e avaliações, pense em uma
modelagem que escale para muitos dados.
As partes escritas permissão serão utilizadas apenas no bônus sobre o Spring Security.
PRIMEIRA ETAPA
1. Usuários
   Nesta seção iremos tratar dos usuários de nossa plataforma, ou seja, cadastraremos estudantes,
   instrutores e administradores.
   1.1 Precisamos de um cadastro de usuário (permissão: aberto)
   Atributos:
   Nome
   Username (máximo de caracteres = 20)
   Email
   Senha
   Role(ESTUDANTE, INSTRUTOR, ADMIN)
   Data de criação
   Restrições:
   Username deve conter apenas caracteres minúsculos, sem numerais e sem espaços.
   Precisa ser um endereço de e-mail em um formato válido.
   Pode apenas ter um usuário com o mesmo email/username.1.2 Precisamos retornar os dados de um usuário cadastrado em nossa plataforma
   (permissão: administradores)
   Devemos conseguir acessar um endpoint que passamos o username e caso encontre, retorne
   apenas o nome, e-mail e role daquele usuário.
2. Curso
   Nesta seção iremos tratar dos cursos de nossa plataforma, ou seja, vamos cadastrar, listar e inativar
   um curso.
   2.1 Criação de um curso (permissão: administradores)
   Atributos
   Nome
   Código(máximo de caracteres = 10)
   Instrutor
   Descrição
   Status
   Data de criação
   Data de inativação
   Restrições:
   Pode apenas ter um curso com o mesmo código.
   O código de um curso deve ser textual, sem espaços, nem caracteres numéricos e nem
   caracteres especiais, mas pode ser separado por - , exemplo: spring-boot-avancado .
   Apenas usuários instrutores podem ser autores de um curso.
   A data de inativação deve ser apenas definida quando o curso estiver desativado.
   2.1 Inativação de um curso (permissão: administradores)
   Devemos conseguir acessar um endpoint com o código do curso para desabilitar um curso,
   afinal aquele curso ficou depreciado ou surgiu uma nova versão, nós nunca excluímos cursos.
   2.2 Listagem de cursos (permissão: administradores)
   Devemos conseguir listar os cursos, de forma paginada e podendo ser filtrada pelo campo de
   status , que retorna os cursos ativos/inativos.
3. Matricula
   Aqui é onde nossos usuários podem se matricular em cursos ativos que temos cadastrado em nossa
   plataforma.3.1 Matrícula de um usuário em um curso (permissão: qualquer usuário logado)
   Atributos:
   Usuário
   Curso
   Data de matricula
   Restrições:
   Um usuário não pode matricular-se mais de uma vez em um curso.
   Podemos apenas nos matricular em cursos ativos.
   SEGUNDA PARTE
   Nosso time de desenvolvimento, recebeu uma demanda para criar uma solução de avaliação de
   cursos. Onde nosso time de produto, representado pela Maria, compartilhou um diálogo no qual
   aborda o tema com um de nossos stakeholders, o Paulo.
   Paulo: Olá, Maria. O time de atendimento, me relatou que tem chegado muitos contatos de
   alunos relatando feedbacks aos cursos que estão matriculados, e estamos tendo uma demanda
   muito alta de repassar os feedbacks manualmente para os instrutores, queria entender a
   possibilidade da gente automatizar avaliações na plataforma.
   Maria: Olá, Paulo, faz sentido!
   Podemos implementar um sistema de avaliação de cursos pelos alunos, juntamente com
   notificações automáticas para os instrutores.
   Paulo: Isso! A notificação pode ser um e-mail diretamente para o instrutor quando um aluno
   avaliar o curso com uma nota menor que 6, e seria interessante o motivo da nota também.
   Maria: Perfeito Paulo!
   Paulo: Além disso, seria interessante termos acesso a um relatório com o Net Promoter Score
   (NPS) de cada curso que tenha mais de quatro matrículas. Isso me ajudaria a ter uma visão
   mais clara dos cursos que precisam ser melhorados.
   Maria: Combinado Paulo, vou repassar para nossa equipe de desenvolvimento trabalhar na
   implementação dessas funcionalidades. Acredito que isso nos ajudará a tomar decisões mais
   assertivas sobre nossos cursos.
   Paulo: Ótimo, Maria! Agradeço por considerar minha sugestão. Estou ansioso para ver essas
   features implementadas em breve.
   Com base nesse diálogo, implemente uma solução em cima do projeto que foi iniciado na primeira
   parte.Para a notificação automática de avaliações insatisfatórias, você pode utilizar a classe abaixo que
   simula o envio de um e-mail (fique à vontade para fazer modificações que considerar necessário):
   public class EmailSender {
   public static void send(String recipientEmail, String subject, String body) {
   System.out.println(
   "Simulating sending email to [%s]:\n".formatted(recipientEmail)
   );
   System.out.println("""
   Subject: %s
   Body: %s
   """.formatted(subject, body));
   }
   }
   Bônus (não obrigatório)
   Implementação do Spring Security e o acesso baseado em roles.
   Ao invés do H2, usar o mysql e tanto a aplicação, banco de dados e outros serviços necessários
   devem ser executados no docker.