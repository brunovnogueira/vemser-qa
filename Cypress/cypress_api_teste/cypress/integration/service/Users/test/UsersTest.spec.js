import UsersService from "../request/UsersService.request";
const usersService = new UsersService;

const payloadPostUser = require("../payload/post-user-1.json");
const payloadPutUser = require("../payload/put-user-1.json");

context('Users', () => {
  it('GET - Buscar todos os usuários', () => {
    //chamada da service
    usersService.getAllUsers().as('response');

    //validações
    cy.get('@response').should((response) => {
      expect(response.status).to.eq(200);
      expect(response.body).to.be.not.null;
      expect(response.body[1].id).to.eq(2);
      expect(response.body[1].userName).to.eq('User 2');
      expect(response.body[1].password).to.eq('Password2');
    })
  })

  it('GET - Buscar os usuários por id', () => {
    let userId = '1'
    //chamada da service
    usersService.getUsersById(userId).as('response');

    //validações
    cy.get('@response').should((response) => {
      expect(response.status).to.eq(200);
      expect(response.body.id).to.eq(1);
      expect(response.body.userName).to.eq('User 1');
      expect(response.body.password).to.eq('Password1');
    })
  })

  it('GET - Buscar usuário criado por id', () => {
    //chamada da service
    usersService.postUser(payloadPostUser);
    usersService.getUsersById(payloadPostUser.id).as('response');
    usersService.deleteUser(payloadPostUser.id);

    //validações
    cy.get('@response').should((response) => {
      expect(response.status).to.eq(200);
      expect(response.body.id).to.eq(payloadPostUser.id);
      expect(response.body.userName).to.eq(payloadPostUser.userName);
      expect(response.body.password).to.eq(payloadPostUser.password);
    })
  })

  it('POST - Adicionar usuário', () => {
    //chamada da service
    usersService.postUser(payloadPostUser).as('response');
    usersService.deleteUser(payloadPostUser.id).as('deleteResponse');
    //validações
    cy.get('@response').should((response) => {
      expect(response.status).to.eq(200);
      expect(response.body.id).to.eq(payloadPostUser.id);
      expect(response.body.userName).to.eq(payloadPostUser.userName);
      expect(response.body.password).to.eq(payloadPostUser.password);
    })
    cy.get('@deleteResponse').should((deleteResponse) => {
      expect(deleteResponse.status).to.eq(200);
    })
  })

  it('PUT - Atualizar usuário', () => {
    let idUser = '11'
    //chamada da service
    usersService.postUser(payloadPostUser);
    usersService.putUser(idUser,payloadPutUser).as('response');
    usersService.deleteUser(idUser);

    //validações
    cy.get('@response').should((response) => {
      expect(response.status).to.eq(200);
      expect(response.body.id).to.eq(payloadPutUser.id);
      expect(response.body.userName).to.eq(payloadPutUser.userName);
      expect(response.body.password).to.eq(payloadPutUser.password);
    })
  })

  it('PUT - Atualizar usuário inexistente', () => {
    let idUser = '1000'
    //chamada da service
    usersService.putUser(idUser,payloadPutUser).as('response');

    //validações
    cy.get('@response').should((response) => {
      expect(response.status).to.eq(404);
    })
  })

  it('DELETE - Deletar usuário', () => {
    let idUser = '11'
    //chamada da service
    usersService.postUser(payloadPostUser);
    usersService.deleteUser(idUser).as('response');

    //validações
    cy.get('@response').should((response) => {
      expect(response.status).to.eq(200);
    })
  })
})