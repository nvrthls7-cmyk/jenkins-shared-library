def call() {
    dir('frontend') {
        def scannerHome = tool 'sonarqube'
        withCredentials([
            string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')
        ]) {
            sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${env.JOB_NAME}-frontend \
            -Dsonar.projectName=${env.JOB_NAME}-frontend \
            -Dsonar.host.url=http://sonarqube:9000 \
            -Dsonar.sources=src \
            -Dsonar.token=$SONAR_TOKEN
            """
        }
    }
}
