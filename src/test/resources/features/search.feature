# 5
Feature: Поиск

  Scenario: Ввести запрос в поиск

    Given Нахожусь на главной странице
    When Вввести код анализа в поле поиска "запрос"
    Then Значение "запрос" указывается в строке поиска