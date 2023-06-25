# Simple-ClientBase
CRUD aplication, with back-end only. Uses technologies like: Spring Boot, Meaven, Lombok, Docker, MySqlWorkBench, PostMan. <Still under development>

Data-Structure
---
![image](https://github.com/KaluxikS/Simple-ClientBase/assets/128908183/08301f6a-6820-46f4-923f-a56bb05c3b7c)

Project
---
Project is devided for repositories, enitities, dtos, controllers and config.
Every Entity has its own http requests(all in json). Data base is set up by docker. 

Example of EndPoints
---
Every endpoint with "/admin" must be authorized with login (login = admin, password = password) or it can't be used.
 - /clients - GET that returns list of all Clients, uses ClientDto, to get rid of Ids and changes it to their corresponding data.
 - /addClient - POST adds Client (can be interpreted as registration), also uses ClientDto, to the Repository has to check if city and representative that we want to use exists. Also automatically adds to ClientStatus, that the Client we are adding is Active.
 - /admin/addCity - POST adds City to base and checks if it is already in base.
 - and more.
