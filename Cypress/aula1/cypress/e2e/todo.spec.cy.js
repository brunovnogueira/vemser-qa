describe('Adicionar item na lista', () => {
  it('passes', () => {
    //ir para o site
    cy.visit('https://todomvc.com/examples/react/#/');
    
    //digitar em um campo
    cy.get('body > section > div > header > input')
    .type('vemser qa')
    .type('{enter}');

    //validações
    cy.get('body > section > div > section > ul > li').should('have.length',1)
    cy.get('body > section > div > section > ul > li').should('contain','vemser qa')
  })
})