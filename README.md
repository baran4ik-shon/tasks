# task_manager
Разработать приложение для ведения списка коллективных задач.
Описание интерфейсов:
1. Список запланированных задач (list.png)
- Страница должна содержать список задач с кнопками для добавления/редактирования/удаления.
- В каждой строке отобразить: название задачи, дата начала задачи, дата окончания задачи, список людей, задействованных в выполнении задачи.
- Отсортировать список по дате начала задачи.
- На странице должна быть кнопка добавления новой задачи, по нажатию - открыть форму для заполнения полей задачи (модальное окно либо роутниг).
2. Форма создания/редактирования задачи (modal.png)
- Поля для редактирования: название задачи, дата начала, окончания, список участников с чекбоксами.
- При создании задачи проверять, чтобы один человек в любой день был выбран только в одной задаче. При попытке создать задачу с человеком, который уже занят в выбранном периоде - выдавать ошибку. Проверять, чтобы дата окончания периода была больше даты начала.
- Список людей задать через конфигурационный файл приложения.