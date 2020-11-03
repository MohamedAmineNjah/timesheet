pipeline {
agent any
stages{
stage('clone and clean repo'){
steps {
    bat "git clone https://github.com/MohamedAmineNjah/timesheet.git"
    bat "mvn clean -f Bootstrap4"
}

}

}
}
