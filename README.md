# Event Example

This is a project to demonstrate how to use Events in distributed systems/modules.

The project is divided into 3 modules:
- Orders
- Mail
- Stock

The Orders module is responsible for receiving orders and sending them to the Stock module. The Stock module is responsible for managing the stock and sending the stock status to the Mail module. The Mail module is responsible for sending emails to the customers.
For the example we are going to use Modulith to publish the events, store it at database, handle retries and listen events.

The orders and product information will be stored in a postgres database that can be started using `docker-compose`.

> ⚠️ This NOT represent a **domain event system**.

> ⚠️ This NOT **event sourcing system**.

> ✅ This is a simple example of how to use events in a distributed system.

## Running the project

To run the project, you will need to have `docker` and `docker-compose` installed.

To start the project, run the following command:

```bash
docker-compose up
```

Once the container you can run the application using the following command:

```bash
./gradlew bootRun
```

At startup, the application will create the necessary tables in the database and start listening to the events.

To send an order, you can look at the `OrderController` and use the `POST /orders` endpoint.

If you use JetBrain's IntelliJ, you can use the HTTP client to send the request. The file `http/orders.http` contains the requests to be sent.

## Testing the project

> ⚠️ The tests are not implemented yet.