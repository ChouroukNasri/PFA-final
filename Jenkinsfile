pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Étape de construction : construire une image Docker
                    docker.build('mon-image-docker')
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Étape de déploiement : déployer l'image Docker dans Kubernetes
                    // Exemple de commande kubectl, adaptez selon votre environnement
                    sh 'kubectl apply -f deployment.yaml'
                }
            }
        }
    }
}
