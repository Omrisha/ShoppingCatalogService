# ShoppingCatalogService

Microservice build with Java and SpringBoot, with Gradle build tools.

Built for Cloud Programming Course in Afeka College of Management.

## Description

Microservice for saving and querying products and categories.

## Installation

* `git clone https://github.com/Omrisha/ShoppingCatalogService.git`
* Open project in IntelliJ (Open project menu or import from git menu)
* Open project in Eclipse (File -> Import -> Import existing Gradle Project menu)
* after opening let gradle built and make the project.
* Run (Eclipse -> Run as SpringBoot App, IntelliJ -> via Play button)

## Usage

- POST /shopping/categories
 Get category details, saves to system.
 Returns 500 error code if exists.
- POST /shopping/products
 Get new product details with catalog number. If exists returns 500 error code.
 Name is not unique.
 If category of the product doesn't exist returns 500 error code.
 Category details are not being updated when creating new product.

- GET /shopping/categories?sortBy={sortArrt}&sortOrder={order}&page={page}&size={size}
  Get all the categories in the system without products according to specific parameters.

- GET /shopping/products/{productId}
  Returns product by its ID, id not exists return 404 error code.
  
- GET /shopping/products?sortBy={sortAttr}&sortOrder={order}&page={page)&size={size}
  Get all products in the system according to specific parameters.

- GET /shopping/products?filterType=byName&filterValue={productName}&sortBy={sortAttr}&sortOrder={order}&page={page)&size={size}
  Get all products in the system by Name.
  
- GET /shopping/products?filterType=byMinPrice&filterValue={minPrice}&sortBy={sortAttr}&sortOrder={order}&page={page)&size={size}
  Get all products in the system by minimum price.

- GET /shopping/products?filterType=byMaxPrice&filterValue={maxPrice}&sortBy={sortAttr}&sortOrder={order}&page={page)&size={size}
  Get all products in the system by maximum price.

- GET /shopping/products?filterType=byCategoryName&filterValue={categoryName}&sortBy={sortAttr}&sortOrder={order}&page={page)&size={size}
  Get all products in the system by category name.

- DELETE /shopping
  Delete all categories and products in the system.
  
 ## GraphQL Usage
 CREATE:
 mutation {
   writeProduct(
     id: "42",
     name: "Groot", 
     price: 49.99, 
     image: "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.myst.co.il%2Fitems%2F3247553-POP-Marvel-GotG-18-Dancing-Groot-Funko&psig=AOvVaw1BR3BiJM3s3nGdwF9XGz-d&ust=1609833018490000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOjb1bzlge4CFQAAAAAdAAAAABAD", 
     productDetailsEntity: {
       id: 1, 
       parts: 12, 
       manufacturer: "Marvel", 
       collectable: true
     }, 
     categoryEntity: {
       name: "Toys", 
       description: "Marvel"
     }
   ) {
     id,
     image
   }
 }
 
 QUERY:
 {
   getProducts(page: 0, size: 10){
     id,
     name,
     image,
     category {
       name,
       description
     }
   }
 }

## Product JSON Examples
    {
      "id": "42",
      "name": "Tea Set",
      "price": 93.72,
      "image": "tea_set_42.jpg",
      "productDetails": {
        "parts": 12,
        "manufacturer": "Royal Worecester",
        "collectable": true
      },
      "category": {
        "name": "utensils",
        "description":"household and kitchen vessels and instruments"
      }
    }  
    
 ## Category JSON Examples
    {
        "name":"apparels", 
        "description":"personal clothing"
    }
