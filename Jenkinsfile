#!groovy
pipeline {
  agent { label 'QA_AUTO_WIN10_BE' }

  stages {
    stage('Run Chrome Tests') {
        steps {
            script {
                dir("regression_chrome_atlas") {
                    bat "mvn clean install -U -Preg-chrome"
                }
            }
        }
    }
  }
  post {
    always {
        publishHTML (target: [
            allowMissing: false,
            alwaysLinkToLastBuild: true,
            keepAll: false,
            reportDir: 'regression_chrome_atlas/target/surefire-reports',
            reportFiles: 'Extent.html',
            reportName: "Extent HTML Report",
            includes: "**/*"
        ])
        step([$class: 'Publisher', reportFilenamePattern: '**/target/surefire-reports/testng-results.xml'])
    }
  }
}