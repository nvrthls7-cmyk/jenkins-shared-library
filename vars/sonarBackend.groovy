def call() {
    dir('backend') {
        def scannerHome = tool 'sonarqube'
        withCredentials([
            string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')
        ]) {
            sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${env.JOB_NAME}-backend \
            -Dsonar.projectName=${env.JOB_NAME}-backend \
            -Dsonar.host.url=http://sonarqube:9001 \
            -Dsonar.java.binaries=target \
            -Dsonar.token=$SONAR_TOKEN
            """
        }
    }
}
