import BookService from "../request/BookService.request";
const bookService = new BookService;

const payLoadAddBook = require("../payload/Add-book-1.json")
const payLoadPutBook = require("../payload/Add-book-2.json")

context('Books', () => {
  it('GET - Consultar livros', () => {
    //chamada service
    bookService.getAllBook().as('response')

    //validações
    cy.get('@response').should((response)=> {
     expect(response.status).to.eq(200);
     expect(response.body).to.be.not.null;
    }) 
  })

  it('POST - Adicionar livros', () => {
    //chamada service
    bookService.postBook(payLoadAddBook).as('response')

    //validações
    cy.get('@response').should((response)=> {
     expect(response.status).to.eq(200);
     expect(response.body.id).to.eq(230);
     expect(response.body.title).to.eq("Testes automatizados");
    }) 
  })

  it('DELETE - Deletar livros', () => {
    const idBook = '230';
    //chamada service
    bookService.postBook(payLoadAddBook).as('response');
    bookService.deleteBook(idBook).as('response');

    //validações
    cy.get('@response').should((response)=> {
     expect(response.status).to.eq(200);
    }) 
  })

  it('PUT - Atualiza livros', () => {
    const idBook = '230';
    //chamada service
    bookService.postBook(payLoadAddBook).as('response');
    bookService.putBook(payLoadPutBook,idBook).as('response');
    bookService.deleteBook(idBook).as('response');

    //validações
    cy.get('@response').should((response)=> {
     expect(response.status).to.eq(200);
    }) 
  })
})