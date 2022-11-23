# **Introduction**
   * ## **Background**
      This project is an E-commerce web application that create platform for customer to place an order for products over the internet using the web browser. The administrators (Seller) then respond to orders and deliver the product to the end user. This system tries to provide service similar to existing applications like Amazon, DARAZ to customer as well as conversion of customer’s data to information.
      
   * ## **Objective of study**
      Objective of the project is to create an easy to use website for doing transactions of the products, to keep track of the orders, to know best selling products, to analyze the bestselling brand, to keep track of the price of products.
   * ## **Methodology**
      * ### **Project Framework**
         Reuse-oriented software model (Integration and configuration) is applied to achieve the desire objective with the use of web framework spring boot and JavaScript library react JS. This process model has obvious advantage of reducing the amount of software to be developed hence reducing cost and risks. It also leads to faster delivery of the software with the help of collections of objects that are developed as a package to be integrated with a component framework.
   * ### **Tools and technology used**
      - User Interface Designing using FIGMA
      - Front-end : React JS library along with HTML , CSS , JavaScript
      - Back-end : Spring Boot framework with MYSQL relational database management system
      - Code Editor : Spring tool suite and visual studio


# **Tasks and activities performed**
   * ## **Database design**
      To make a dynamic website, it requires a database to store data about products, orders of products, customer information. For this project relational database MYSQL is used which store data in separate table which is expressed in following ER diagram.

      ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.003.png)

      **Figure 2-3 : ER-diagram of database**

   * ## **Software components:**
      * ### **Product management system**
         Its primary objective is to allow admin to view, insert, delete and update the product information in or from the database. 
      * #### View Product
         As multiple products may belong to same category and to reduce data redundancy category is placed in separate table and foreign key is used by product table. The view page of product displays data as table which by default only displays five distinct products as shown in Figure 2-4. The image column contains anchor tag which display the image associated with image name in database on new tab of browser. To view other product a search bar is designed which on submit search the products by name and display empty table when it found nothing.

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.004.png)

         **Figure 2-4 : Product view page**

      * #### Insert Product
         To insert the data of new product, HTML form is built which takes all required information as shown in Figure 2-5. The drop down menu is used to insert the category of a product which contains the name of only that category having active status. When the form is successfully submitted it saves the data on database and return product view page with only one product, that is recently entered data. It will throw the exception if the image name is already acquired by any other product, to prevent from file being replaced during submission.

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.005.png)

         **Figure 2-5 : product insertion form**


      * #### Update Product
         To update a product admin should follow the link on action column as shown in Figure 2-4 which redirect to update view that contain filled up html form (Figure 2-6) with all previous data from database including existing image. Once the admin replace the data with new one and submit, the previous data will be replaced with new one in database and redirect to the view product page with only recently updated data.

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.006.png)

         **Figure 2-6: product update view**
      * #### Delete Product
         When delete button of action column of product view (Figure 2-7) is pressed, it triggers confirm box of JavaScript when ok button is pressed it delete the product data from the database but if cancel button is pressed it will not delete the product data.

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.007.png)

         **Figure 2-7 : product delete view**


      * ### **Customer UI**
         The objective of customer UI is to create easy to use and understand user interface to provide good user interface. The home page (Figure 2-8) contains card design that contains category link and respective link of best selling product of that category. The category link then takes to product page (Figure 2-9) that contain all products associated with that category where customer can add the item to cart or further filter the product as their desire maximum price. 

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.008.png)

         **Figure 2-8 : Customer home page**

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.009.png)

         **Figure 2-9 : product view page**


      * ### **Product ordering system**
         The ordering process starts when customer began to add the product on cart which can be achieved by help of add to cart button as shown in Figure 2-9. The cart data is stored as react-state which will not be saved if browser or tab is closed. The user can add multiple products at a time; remove from cart before placing order or increase the quantity of a product they added as shown in Figure 2-10. The customer are then required to place email and number to contact during order delivery and name to identify before placing the order. After submit button is clicked the order will be stored in database and user cart will be cleared. Once the order is placed by the customer using customer UI, the customer data will be saved in database, the admin can view all the order as shown in Figure 2-1

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.010.png)

         **Figure 2-10: Customer cart view**

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.01*png)

         **Figure 2-11 : admin order view**

      * ### **Price tracking system**
         The objective or this system if to keep track of all the changes in price of a product at updated timestamp, calculate the timestamp when price or a product is highest, lowest, current price and all the price at updated timestamp and represented in line graph using [*google-linechart*](https://developers.google.com/chart/interactive/docs/gallery/linechart) as shown in Figure 2-12. Whenever the price of product is updated, the updated price with timestamp is maintained on different table through which we can get information like seasonal affect on price of product.

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.012.png)

         **Figure 2-12 : price tracking view**


      * ### **Product analysis**
         With availability of data about order of products on a database, it is now possible to determine the best selling product and bestselling brand of product. This helps the seller for inventory management, where they can add more inventories of best selling product and reduce the inventory of least selling product or exclude them if they don’t provide business value. The admin can easily access this information from admin dashboard. Best selling product is categorized by number of order placed (Figure 2-13) on product or quantity sold (Figure 2-14) and is represented in pre chart with help of [*google-piechart*](https://developers.google.com/chart/interactive/docs/gallery/piechart). Similar activities are performed for brand as well (Figure 2-15).

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.013.png)

         **Figure 2-13 : best product by order view**

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.014.png)

         **Figure 2-14 : best product by quantity view**

         ![](/report_img/Aspose.Words.356b2881-4ded-423e-9a7f-e3e0f6ceb372.015.png)

         **Figure 2-15 : best brand view**


# **Conclusion**
         
   As per the objectives, this application helps the organization to grow on an internet creating platform for seller to manage, and show their products along with generation of information like best product, best brand as well as the changes of price of a product.
