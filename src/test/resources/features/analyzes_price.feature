# 4
Feature: Сравнение цен

  Scenario: Цена на странице с анализами
      совпадает с ценой в Корзине

    Given На странице с анализами
    When Запомнить цену
    And Добавить анализ в корзину
    And Перейти в корзину
    Then Сумма анализа совпадает с сохранённой ценой

