const API_URL = Cypress.env('API_BASE_URL')

const authors = '/Authors'

export default class AuthorService{
  getAllAuthors(){
    return cy.request({
      method: 'GET',
      url:`${API_URL}${authors}`,
      failOnStatusCode: false
    })
  }

  getAuthorById(idAuthor){
    return cy.request({
      method: 'GET',
      url:`${API_URL}${authors}/${idAuthor}`,
      failOnStatusCode: false
    })
  }

  getAuthorByBookId(idbook){
    return cy.request({
      method: 'GET',
      url:`${API_URL}${authors}/books/${idbook}`,
      failOnStatusCode: false
    })
  }

  postAuthor(payload){
    return cy.request({
      method: 'POST',
      url:`${API_URL}${authors}`,
      failOnStatusCode: false,
      body: payload
    })
  }

  putUser(idAuthor,payload){
    return cy.request({
      method: 'PUT',
      url:`${API_URL}${authors}/${idAuthor}`,
      failOnStatusCode: false,
      body: payload
    })
  }

  deleteUser(idAuthor){
    return cy.request({
      method: 'DELETE',
      url:`${API_URL}${authors}/${idAuthor}`,
      failOnStatusCode: false
    })
  }
}