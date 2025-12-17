def call(Map config) {

    stage('Git Checkout') {
        gitCheckout()
    }

    stage('Backend Compile') {
        backendBuild()
    }

    stage('SonarQube Analysis (Backend)') {
        sonarBackend()
    }

    stage('OWASP Dependency Check (Backend)') {
        owaspBackend()
    }

    stage('Frontend Build') {
        dir('frontend') {
            frontendBuild()
        }
    }

    stage('SonarQube Analysis (Frontend)') {
        dir('frontend') {
            sonarFrontend()
        }
    }

    stage('OWASP Dependency Check (Frontend)') {
        dir('frontend') {
            owaspFrontend()
        }
    }

    stage('Docker Build & Push') {
        dockerBuildPush(
            backendImage: config.backendImage,
            frontendImage: config.frontendImage
        )
    }
}
