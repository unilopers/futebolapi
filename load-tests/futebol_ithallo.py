from locust import HttpUser, task, between
import random

class TimeUser(HttpUser):
    wait_time = between(1, 3)

    def on_start(self):
        self.api_key = "987654321"

    @task
    def criar_e_buscar_time(self):
        headers = {
            "x-api-key": self.api_key,
            "Content-Type": "application/json"
        }

        # POST - criar time
        nome_time = f"Time_{random.randint(1, 10000)}"
        response = self.client.post("/times", json={
            "nome": nome_time
        }, headers=headers)

        if response.status_code == 200:
            time_id = response.json().get("id")

            # GET - buscar time criado
            self.client.get(f"/times/{time_id}", headers=headers)