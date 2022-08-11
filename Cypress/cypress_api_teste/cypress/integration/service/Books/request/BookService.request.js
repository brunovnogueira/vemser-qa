const API_URL = Cypress.env('API_BASE_URL')

const books = '/Books'

export default class BookService{
  getAllBook(){
    return cy.request({
      method:'GET',
      url:`${API_URL}${books}`,
      failOnStausCode: false,
    })
  }

  postBook(payload){
    return cy.request({
      method:'POST',
      url:`${API_URL}${books}`,
      failOnStausCode: false,
      body: payload
    })
  }

  deleteBook(idBook){
    return cy.request({
      method:'DELETE',
      url:`${API_URL}${books}/${idBook}`,
      failOnStausCode: false,
    })
  }

  putBook(payload,idBook){
    return cy.request({
      method:'PUT',
      url:`${API_URL}${books}/${idBook}`,
      failOnStausCode: false,
      body: payload
    })
  }
}