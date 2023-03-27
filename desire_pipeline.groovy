pipeline {
    agent any

    stages {
        stage('cloning repo ... ') {
            steps {
                git 'https://github.com/alicommit-malp/jenkins_dsl_example'
            }
        }
        
        stage('build'){
            agent{
                docker { 
                    image 'python:2' 
                    reuseNode true
                }    
            }
            steps{
                echo "pip install -r $WORKSPACE/python/requirements.txt"
                echo "python $WORKSPACE/python/main.py"
            }
        }
            
    }
    post{
        success{
            echo "Cool :)"
        }
    }
}
