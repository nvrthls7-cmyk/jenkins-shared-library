def call() {
    dir('backend') {
        dependencyCheck additionalArguments: '--scan .', odcInstallation: 'dp'
        dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
    }
}
