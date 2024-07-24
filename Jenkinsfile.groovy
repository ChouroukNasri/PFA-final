pipeline {
    agent any

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    // Étape pour construire l'image Docker
                    docker.build('nom-de-votre-image:latest')
                }
            }
        }

        stage('Push Docker Image to Registry') {
            steps {
                script {
                    // Étape pour pousser l'image Docker vers un registre (si nécessaire)
                    docker.withRegistry('https://registry.example.com', 'credentials-id') {
                        docker.image('nom-de-votre-image:latest').push()
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    // Étape pour appliquer les fichiers YAML dans Kubernetes
                    kubernetesDeploy(
                        kubeconfigId: 'nom-de-votre-config-kubeconfig',
                        configs: 'chemin-vers-vos-fichiers-yaml/*.yaml'
                    )
                }
            }
        }
    }
}
