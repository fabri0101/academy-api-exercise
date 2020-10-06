Feature: Api Swagger UI - FinalProyect

  @Examen @Logearse
  Scenario Outline: Me logeo y obtengo token
    When realizo una peticion operacion <operation> al <entity> usando <request>
    Then obtengo el statusCode <statusCode>
    And obtengo el token

    Examples:
      | operation | entity | request      | statusCode |
      | POST      | LOGEAR | request/post | 200        |

  @Examen
  Scenario Outline: obtener la duración promedio de la prueba de categoría sobre los informes
    When realiza una peticion operacion <operation> del entity <entity> utilizando este request <request> y <inputParameters>
    Then se espera obtener un statusCode <statusCode>

    Examples:
      | operation | request | statusCode | entity           | inputParameters |
      | GET       | doToken | 200        | AVERAGE_DURATION | reportsLength:1 |
