def call() {
    dir('frontend') {
        dependencyCheck additionalArguments: '--scan .', odcInstallation: 'dp'
        dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
    }
}
