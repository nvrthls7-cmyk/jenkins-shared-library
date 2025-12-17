def call() {
    dir('backend') {
        withCredentials([
            string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')
        ]) {
            sh """
            sonar-scanner \
            -Dsonar.projectKey=${env.JOB_NAME}-backend \
            -Dsonar.projectName=${env.JOB_NAME}-backend \
            -Dsonar.host.url=http://sonarqube:9000 \
            -Dsonar.java.binaries=target \
            -Dsonar.token=$SONAR_TOKEN
            """
        }
    }
}
