<h1>Microservices</h1>
<p>This project contains three microservices: <strong>order-service</strong>, <strong>inventory-service</strong>, and <strong>product-service</strong>. These microservices are implemented in Java.</p>

<h3>Overview</h3>
<p>The order-service handles all the operations related to placing and managing orders.</p>

<p>The inventory-service is responsible for managing the inventory and keeping track of product availability.</p>

<p>The product-service contains information about different products and their details.</p>

<h3>Requirements</h3>
<ul>
<li>Java 17</li>
<li>Any Java Development Environment (e.g. Eclipse, IntelliJ IDEA)</li>
<li>Maven for building and managing dependencies</li>
</ul>
<h3>Setup</h3>
<p>Clone the repository and navigate to each service directory: <strong>order-service</strong>, <strong>inventory-service</strong>, and <strong>product-service</strong>.</p>

Build each service using Maven:

```mvn clean install```
<p>Run each service using the following command:</p>

```mvn spring-boot:run```

