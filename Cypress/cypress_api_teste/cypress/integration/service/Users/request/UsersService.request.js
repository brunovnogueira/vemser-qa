const API_URL = Cypress.env('API_BASE_URL')

const users = '/Users'

export default class UsersService{
  getAllUsers(){
    return cy.request({
      method: 'GET',
      url:`${API_URL}${users}`,
      failOnStatusCode: false
    })
  }

  getUsersById(idUser){
    return cy.request({
      method: 'GET',
      url:`${API_URL}${users}/${idUser}`,
      failOnStatusCode: false
    })
  }

  postUser(payload){
    return cy.request({
      method: 'POST',
      url:`${API_URL}${users}`,
      failOnStatusCode: false,
      body: payload
    })
  }

  putUser(idUser,payload){
    return cy.request({
      method: 'PUT',
      url:`${API_URL}${users}/${idUser}`,
      failOnStatusCode: false,
      body: payload
    })
  }

  deleteUser(idUser){
    return cy.request({
      method: 'DELETE',
      url:`${API_URL}${users}/${idUser}`,
      failOnStatusCode: false
    })
  }
}