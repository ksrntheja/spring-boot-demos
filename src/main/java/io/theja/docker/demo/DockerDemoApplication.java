package io.theja.docker.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerDemoApplication.class, args);
    }

}

/*

-----------------------------------------------------------------------------------------------------------------------
Docker
-----------------------------------------------------------------------------------------------------------------------
docker ps
docker images
docker build --progress=plain --no-cache -t spring-boot-app:latest .

-----------------------------------------------------------------------------------------------------------------------
K8s
-----------------------------------------------------------------------------------------------------------------------
kubectl get deployments --namespace=customer-one
kubectl delete deployment spring-app
kubectl apply -f deployment.yaml --namespace=customer-one
kubectl scale deployment/spring-app-deployment --replicas=0 --namespace=customer-one

kubectl get pods --namespace=customer-one
kubectl logs spring-app-deployment-7d7dd6d74c-jchx
kubectl delete pod spring-app-deployment-76744bf556-2dxmx --namespace=customer-one
kubectl top pods --namespace=customer-one


kubectl get services --namespace=customer-one
kubectl delete service spring-app-service
kubectl apply -f service.yaml --namespace=customer-one

kubectl get ns
kubectl apply -f customer-one-namespace.yaml
kubectl apply -f customer-two-namespace.yaml

kubectl apply -f hpa.yaml --namespace=customer-one
kubectl get hpa --namespace=customer-one
C:\Users\ktheja\Work\Softwares\httpd\httpd-2.4.64-250710-win64-VS17\Apache24\bin\ab -n 10000 -c 100 http://localhost:31892/properties
This command simulates 10,000 requests, 100 at a time, to stress the app.
kubectl top pods --namespace=customer-one

kubectl apply -f configmap.yaml --namespace=customer-one
kubectl get configmap spring-app-config -o yaml --namespace=customer-one

kubectl apply -f secret.yaml --namespace=customer-one
kubectl get secrets --namespace=customer-one
kubectl describe secret spring-app-secret --namespace=customer-one

Deploy new version
-----------------------------------------------------------------------------------------------------------------------
kubectl rollout restart deployment/spring-app-deployment --namespace=customer-one
kubectl rollout status deployment/spring-app-deployment --namespace=customer-one

 */