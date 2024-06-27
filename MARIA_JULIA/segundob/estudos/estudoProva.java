// Desenvolver uma aplicação que disponibilize as seguintes funcionalidades em um Menu:
//  - Listagem dos alunos(2,0)
//  - Criar registro de testemunho(3,0)
//  - Sair

// Criação de modais de erro, em caso de erros na comunicação(1.0)
// Respeitar princípios de POO e convenções do Java(1.0)

// Jornada do Usuário:
//  - Ao executar a aplicação, são apresentadas três opções em um menu de um modal.
//  - A primeira opção é a de listar dados dos alunos, onde o sistema busca esses dados externamente e apresenta para o usuário.
//  - A segunda opção é a de criar um novo testemunho, onde o usuário informa a url de sua foto, RA de aluno, texto de testemunho, o sistema recebe esses dados e realiza a criação do testemunho e retorna uma mensagem de sucesso para o usuário em um modal.
// •⁠  ⁠Terceira opção apenas encerra a aplicação.

// ------------------------------

// Questões técnicas/regras de negócio:
// Listagem de alunos consiste em consumir os dados de /api/students.
// Criar registro de testemunho consiste em informar os dados necessários e realizar a requisição em /api/testimonial. !!ATENÇÃO!! Para contabilizar nota obrigatoriamente deve existir um testemunho para seu RA! Lembrando que capturo o IP da requisição, então não adianta pedir para seu colega que finalizou criar um registro para o seu RA.
// Sair encerra o programa.
// Modais de erro devem ser apresentados quando ocorrem erros na comunicação, exemplo, se o usuário tentar criar um testemunho com um RA inválido, isso acarretará um erro de comunicação com API. Esse erro deve ser apresentado para o usuário.

// Swagger da aplicação disponível em: https://poo-exam.vercel.app/swagger
// URL base da API: https://poo-exam.vercel.app/api