def call() {
    dir('backend') {
        sh 'mvn clean package -DskipTests'
    }
}
