def call(Map config) {
    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-creds',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh """
        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin

        docker build -t ${config.backendImage}:${env.BUILD_NUMBER} backend
        docker push ${config.backendImage}:${env.BUILD_NUMBER}

        docker build -t ${config.frontendImage}:${env.BUILD_NUMBER} frontend
        docker push ${config.frontendImage}:${env.BUILD_NUMBER}
        """
    }
}
