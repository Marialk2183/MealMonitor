@echo off
echo Building Docker images...

docker build -t mealmontor-mysql ./mysql  # Assuming mysql image, but it's from docker hub

docker build -t mealmontor-eureka-server ./MealMonitor-EurekaServer
docker build -t mealmontor-gateway ./MealMonitor-Gateway
docker build -t mealmontor-user-service ./MealMonitor-UserService
docker build -t mealmontor-canteen-service ./MealMonitor-CanteenService
docker build -t mealmontor-review-service ./MealMonitor-ReviewService
docker build -t mealmontor-notification-service ./MealMonitor-NotificationService
docker build -t mealmontor-poll-service ./MealMonitor-PollService
docker build -t mealmontor-web-app ./MealMonitor-WebApp
docker build -t mealmontor-moderation-service ./MealMonitor-ModerationService
docker build -t mealmontor-frontend ./mealmontor-frontend

echo Images built. Assuming you have a Kubernetes cluster (e.g., minikube) running.

echo Applying Kubernetes manifests...

kubectl apply -f k8s/mysql-pvc.yaml
kubectl apply -f k8s/mysql-deployment.yaml
kubectl apply -f k8s/eureka-deployment.yaml
kubectl apply -f k8s/gateway-deployment.yaml
kubectl apply -f k8s/user-service-deployment.yaml
kubectl apply -f k8s/canteen-service-deployment.yaml
kubectl apply -f k8s/review-service-deployment.yaml
kubectl apply -f k8s/notification-service-deployment.yaml
kubectl apply -f k8s/pollservice-deployment.yaml
kubectl apply -f k8s/web-app-deployment.yaml
kubectl apply -f k8s/moderation-service-deployment.yaml
kubectl apply -f k8s/frontend-deployment.yaml

echo Deployment complete. Check services with kubectl get services
