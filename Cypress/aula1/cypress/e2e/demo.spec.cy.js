describe('Registrar sem sucesso', () => {
  it('passes', () => {
    //ir para o site
    cy.visit('https://demoqa.com/register');

    cy.get('#firstname')
      .type('Lucas')
    ;

    cy.get('#lastname')
      .type('Almeida')
    ;

    cy.get('#userName')
      .type('lucas')
    ;
    
    cy.get('#password')
      .type('Lucas123@')
    ;

    cy.get('#register')
      .click()
    ; 

    cy.get('#name')
      .should('contain', 'Please verify reCaptcha to register!')
    ;
  })
})

describe('Logar sem sucesso', () => {
  it('passes', () => {
    //ir para o site
    cy.visit('https://demoqa.com/login');

    cy.get('#userName')
      .type('lucas')
    ;

    cy.get('#password')
      .type('Lucas123@')
    ;    
    
    cy.get('#login')
      .click()
    ;

    cy.get('#name')
      .should('contain','Invalid username or password!')
    ;
  })
})