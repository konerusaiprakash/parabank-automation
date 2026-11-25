pipeline {
    agent any

    tools {
        maven 'Maven3'   // name configured in Jenkins > Global Tool Configuration
        jdk 'JDK17'
    }

    triggers {
        cron('H 2 * * 1-5')   // nightly run on weekdays
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Run Tests') {
            steps {
                // headless because Jenkins agents usually have no display
                sh 'mvn clean test -Dheadless=true'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/extent-report/**, target/cucumber-reports/**', allowEmptyArchive: true
        }
    }
}
