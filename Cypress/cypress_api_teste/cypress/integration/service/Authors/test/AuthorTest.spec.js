import AuthorService from "../request/AuthorService.request";
const authorService = new AuthorService;

const payloadPostAuthor = require("../payload/post-author-1.json");
const payloadPutAuthor = require("../payload/put-author-1.json");

context('Authors', () => {
  it('GET - Buscar todos os autores', () => {
    //chamada da service
    authorService.getAllAuthors().as('response');

    //validações
    cy.get('@response').should((response) => {
      expect(response.status).to.eq(200);
      expect(response.body).to.be.not.null;
      expect(response.body[1].id).to.eq(2);
      expect(response.body[1].idBook).to.eq(1);
      expect(response.body[1].firstName).to.eq('First Name 2');
      expect(response.body[1].lastName).to.eq('Last Name 2');
    })
  })
})