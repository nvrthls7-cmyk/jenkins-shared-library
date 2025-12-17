def call() {
    withCredentials([
        string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')
    ]) {
        sh """
        sonar-scanner         -Dsonar.projectKey=${env.JOB_NAME}-frontend         -Dsonar.projectName=${env.JOB_NAME}-frontend         -Dsonar.host.url=http://sonarqube:9000         -Dsonar.sources=src         -Dsonar.token=$SONAR_TOKEN
        """
    }
}
