VkProductsAPP
-
Это приложение предназначено для поиска товаров и получения информации по ним
Состоит из двух страниц:

1. Страница со списком всех продуктов
2. Страница отдельного продукта

На странице со списком всех продуктов:
- 

- Отлавливается ошибка отсутствия интернета
- Отображается список продуктов, их цена и описание
- Загрузка страниц (пагинация) осуществляется по 20 айтемов, подгружаясь автоматически при прокрутке

На странице с отдельным фильмом:
-

- Из информации о товаре пердоставяляется: 
      Название
      цена
      скидка
      остаток
      бренд
      категория
      отображаются картинки товара
      рейтинг представлен звездами (RatingBar)
- Реализована кнопка «назад», которая ведет на выдачу. Позиция при этом сохраняется.

Использованные компоненты:
Язык: kotlin
Работа с сетью: Retrofit, OkHttp
Многопоточность: Kotlin Coroutines/Flow
View: XML
Сериализаторы: Kotlinx Serialization, Gson
Навигация: Activity, Fragment, Jetpack Navigation
Архитектура: MVI
Изображение: Glide

Также использованы:
Dagger
Clean Architecture

Приложение поддерживает перевороты

Some screenshots:
-
<img align="center" src="https://github.com/ParsifalRU/VkProductsApp/assets/109204462/0ac9ccd5-0b38-4ee2-a247-17a9bb1b3217.png" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/VkProductsApp/assets/109204462/42a37de2-0264-4ece-bbff-327900f91efd" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/VkProductsApp/assets/109204462/7bb5134e-7ae5-4725-8a7a-3ece690578ff.png" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/VkProductsApp/assets/109204462/e4ab5c96-a3cd-44f9-a247-f86ef75fef2e.png" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/VkProductsApp/assets/109204462/1d57d95a-940b-47b9-ab61-04c77299053b.png" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/VkProductsApp/assets/109204462/31cc0301-baa0-4612-adce-9ec77ac7b8e6.png" height="400" /></a>

<img align="center" src="https://github.com/ParsifalRU/VkProductsApp/assets/109204462/13ee81fd-20a9-4c13-9be5-95521a6e5dff.png" height="400" /></a>

How to install:
-
[apk.zip](https://github.com/ParsifalRU/VkProductsApp/files/15254003/apk.zip)
