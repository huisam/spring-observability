from time import sleep

from locust import HttpUser, task, tag


class OrderPerformance(HttpUser):
    host = "http://order-application:8080"

    @tag("get order")
    @task
    def get_order(self):
        self.client.get(url="/api/v1/orders/1")
        sleep(0.1)

    @tag("place order")
    @task
    def place_order(self):
        self.client.post(
            url="/api/v1/orders/place-order",
            json={"productId": 2}
        )
        sleep(1)


class ProductPerformance(HttpUser):
    host = "http://product-application:8080"

    @tag("get product")
    @task
    def get_product(self):
        self.client.get(url="/api/v1/products/2")
        sleep(0.1)
