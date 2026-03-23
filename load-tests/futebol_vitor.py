from locust import HttpUser, task, between
import random

class TimeUser(HttpUser):
    wait_time = between(2, 4)

    def on_start(self):
        self.headers = {
            "x-api-key": "123456789",
            "Content-Type": "application/json"
        }

    @task
    def criar_e_buscar_time(self):
        nome_time = f"Time_{random.randint(1, 100000)}"

        post_response = self.client.post(
            "/times",
            json={"nome": nome_time},
            headers=self.headers,
            name="POST /times"
        )

        if post_response.status_code == 200:
            data = post_response.json()
            time_id = data.get("id")

            if time_id:
                self.client.get(
                    f"/times/{time_id}",
                    headers=self.headers,
                    name="GET /times/[id]"
                )