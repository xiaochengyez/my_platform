stage('pull source code') {
    node('master'){
        git([url: 'git@github.com:xiaochengyez/my_platform.git', branch: 'master'])
    }
}

stage('maven compile & package') {
    node('master'){
        sh "clean install -U -Dmaven.test.skip=true -Ptest"
    }
}

stage('clean docker environment') {
    node('master'){
        try{
            sh 'docker stop myauto'
        }catch(exc){
            echo 'myauto container is not running!'
        }

        try{
            sh 'docker rm myauto'
        }catch(exc){
            echo 'myauto container does not exist!'
        }
        try{
            sh 'docker rmi auto:v1.0'
        }catch(exc){
            echo 'auto:v1.0 image does not exist!'
        }
    }
}

stage('make new docker image') {
    node('master'){
        try{
            sh 'docker build -t auto:v1.0 .'
        }catch(exc){
            echo 'Make auto:v1.0 docker image failed, please check the environment!'
        }
    }
}

stage('start docker container') {
    node('master'){
        try{
            sh 'docker run --name myWebObj -d -p 8111:8080 myweb'
        }catch(exc){
            echo 'Start docker image failed, please check the environment!'
        }
    }
}