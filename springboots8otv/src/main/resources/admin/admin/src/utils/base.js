const base = {
    get() {
        return {
            url : "http://localhost:8080/springboots8otv/",
            name: "springboots8otv",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboots8otv/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "Android安卓的微博客系统"
        } 
    }
}
export default base
