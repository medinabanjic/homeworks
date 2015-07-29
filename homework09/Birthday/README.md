##BirthdayMemoApplication

This is the application for storing birthdays.

It is written in Java as a part of our mini GUI project, after a week of GUI lessons. This app has several classes. All of them, except Files, represent JFrames.

Main functions are:

- Add birthday
- Remove birthday
- Search for birthday

You can add birthday by entering name and date (dd.mm. format).

Search is divided in three functions:

- via name
- via month
- view all

Remove requires name, and then it finds entry and delete it.

Log out exits the application.

Cancel buttons mainly return to previous JFrames.

Log in button on welcome screen opens Choice JFrame. Username you enter is written in file users, but for now it does not have a specific function. In future, if modified, this button would make a new user file so that all users have their own files for storing birthdays.

Note: There is one function, search via month working perfectly in Eclipse, but not in .jar. It lists only one birthday in a given month. In Eclipse it lists all.