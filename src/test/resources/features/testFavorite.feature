Feature: Добавление товара

  Background: Переход на главную страницу сайта
    Given Открыт сайт "https://tambov.blizko.ru/"

  Scenario Outline: Добавляем товар в избранное
    When найти в каталоге телефон не дороже <minvalue> рублей
    And добавить его в избранное
    Then  Телефон добавлен в избранное и его стоимость меньше  <minvalue>
    Examples:
      | minvalue |
      | 60000    |
