def call(){
    sh 'trivy fs . >trivyfs.text'
}