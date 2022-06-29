
# Social Network API


## Deploy

To deploy this application you will need of Kubernetes in your computer

Follow these steps:

```bash
$ kubectl apply -f k8s/postgres-credentials.yml
```
```bash
$ kubectl apply -f k8s/postgres-configmap.yml
```

```bash
$ kubectl apply -f k8s/postgres-deployment.yml
```

```bash
$ kubectl apply -f k8s/deployment.yml
```

```bash
kubectl expose deployment springboot-postgres-k8s --type=LoadBalancer --name=springboot-postgres=k8s
```
## Stack used

**Backend:** Java (SpringBoot)

**DataBase**: Postgres

