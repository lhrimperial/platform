Vue.component('headbar', {
    template:
    "       <div class=\"header\">\n" +
    "            <div class=\"logo\">后台管理系统</div>\n" +
    "            <div class=\"login-name\"><span>登录人:</span>&nbsp;<span>{{ userInfo.userName }}</span></div>\n" +
    "            <div class=\"user-info\">\n" +
    "                <el-dropdown trigger=\"click\" @command=\"handleCommand\">\n" +
    "                    <span class=\"el-dropdown-link\">\n" +
    "                       <img src=\"/platform/images/loginOut.png\" alt=\"\" width=\"25\">\n" +
    "                    </span>\n" +
    "                    <el-dropdown-menu slot=\"dropdown\" placement=\"top-end\">\n" +
    "                        <el-dropdown-item command=\"logout\">退出</el-dropdown-item>\n" +
    "                        <el-dropdown-item command=\"userInfo\">个人信息</el-dropdown-item>\n" +
    "                        <el-dropdown-item command=\"updatePassword\">修改密码</el-dropdown-item>\n" +
    "                    </el-dropdown-menu>\n" +
    "                </el-dropdown>\n" +
    "            </div>\n" +
    "            <div class=\"headerTimer\"></div>\n" +
    "        </div>",
    props: ['userInfo'],
    methods: {
        handleCommand(command){
            if (command == 'logout'){
                axios.get("logout").then(function (response) {
                    window.location.href = "login.html";
                }).catch(function (error) {
                    console.log(error);
                })
            }

        },
        autoTime(){
            var timeEle=document.querySelector('.headerTimer');
            setInterval(function () {
                let time=new Date();
                var year=time.getFullYear();
                var month=time.getMonth()>=9?(time.getMonth()+1):("0"+(time.getMonth()+1));
                var day=time.getDate()>9?time.getDate():"0"+(time.getDate());
                var hour=time.getHours()>9?time.getHours():"0"+(time.getHours());
                var minute=time.getMinutes()>9?time.getMinutes():"0"+(time.getMinutes());
                var second=time.getSeconds()>9?time.getSeconds():"0"+(time.getSeconds());
                timeEle.innerHTML=year+"-"+month+"-"+day+" "+hour+"-"+minute+"-"+second;
            },1000)
        }
    },
    mounted:function () {
        this.autoTime();
    }
});