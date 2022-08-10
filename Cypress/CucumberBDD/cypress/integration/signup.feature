Feature: Cadastrar usuario

Scenario Outline: Criar usuario com sucesso
    Given que acesso o sistema <sistema>
    And preencho o campo email 
    And clico no botao create an account
    And clico no botao para selecionar o titulo
    And preencho o campo first name 
    And preencho o campo last name 
    And preencho o campo password 
    And seleciono o dia de aniversario
    And seleciono o mes de aniversario
    And seleciono o ano de aniversario
    And preencho o campo address
    And preencho o campo city
    And seleciono o estado
    And preencho o campo zip
    And preencho o campo mobile
    When clico botao register
    Then devo verificar um botao Sign out

    Examples: 
        |sistema|
        |http://automationpractice.com/index.php?controller=authentication&back=my-account|

            