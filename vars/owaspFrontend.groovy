def call() {
    sh """
    dependency-check.sh     --project ${env.JOB_NAME}-frontend     --scan .     --format HTML
    """
}
