# Product API - basic crud ops 


<div align="center">
A simple api created while preparing to get back into the java world .  

Tech used :  
Spring boot , Mysql & Hibernate .
</div>

# Features

| Features            | status |
| ------------------- | ------ |
| Add Product                   | ✅     |
| Get All Products              | ✅     |
| GetById                       | ✅     |
| Update Product                | ✅     |
| Delete Product                | ✅     |
| Exception handling (basic af) | ✅     |


# End points 

```http
@POST http:localhost:8080/api/v1/product 

@GET http:localhost:8080/api/v1/product

@GET BY ID http:localhost:8080/api/v1/product/:id

@PUT http:localhost:8080/api/v1/product/:id

@DELETE http:localhost:8080/api/v1/product/:id 
```

# Database Schema

|Field 	|Type 	|Null 	|Key 	|Default 	|Extra 	|
|-------|------|-------|-------|-------|-----------|
|id 	|int(11) 	|NO 	|PRI 	|NULL 	|auto_increment
|name 	|varchar(45) 	|NO 		|NULL 	
|price 	|float |	NO 		|NULL 	|

# 
<div align="center">
<strong><p>Made with 🖤 by ZTF - N.EA | 2022 </p> </strong>
</div>