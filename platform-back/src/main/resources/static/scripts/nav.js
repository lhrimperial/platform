Vue.component('naver', {
    template: "<div>" +
    "<div class=\"header\">\n" +
    "            <div class=\"logo\">后台管理系统</div>\n" +
    "            <div class=\"login-name\"><span>登录人:</span>&nbsp;<span>longhairen</span></div>\n" +
    "            <div class=\"login-name\"><span>当前部门:</span>&nbsp;<span>jituan</span></div>\n" +
    "            <div class=\"user-info\">\n" +
    "                <el-dropdown trigger=\"click\" @command=\"handleCommand\">\n" +
    "                    <span class=\"el-dropdown-link\">\n" +
    "                       <img src=\"../images/loginOut.png\" alt=\"\" width=\"25\">\n" +
    "                    </span>\n" +
    "                    <el-dropdown-menu slot=\"dropdown\" placement=\"top-end\">\n" +
    "                        <el-dropdown-item command=\"logout\">退出</el-dropdown-item>\n" +
    "                        <el-dropdown-item command=\"userInfo\">个人信息</el-dropdown-item>\n" +
    "                        <el-dropdown-item command=\"updatePassword\">修改密码</el-dropdown-item>\n" +
    "                    </el-dropdown-menu>\n" +
    "                </el-dropdown>\n" +
    "            </div>\n" +
    "            <div class=\"headerTimer\">\n" +
    "            </div>\n" +
    "        </div>\n" +
    "        <div class=\"sidebar\">\n" +
    "            <el-menu class=\"el-menu-vertical-demo\" background-color=\"#324157\" text-color=\"#fff\" unique-opened router>\n" +
    "                <template v-for=\"item in items\">\n" +
    "                    <template v-if=\"item.subs\">\n" +
    "                        <el-submenu :index=\"item.index\">\n" +
    "                            <template slot=\"title\"><i :class=\"item.icon\"></i>{{ item.title }}</template>\n" +
    "                            <el-menu-item v-for=\"(subItem,i) in item.subs\" :key=\"i\" :index=\"subItem.index\">{{ subItem.title }}\n" +
    "                            </el-menu-item>\n" +
    "                        </el-submenu>\n" +
    "                    </template>\n" +
    "                    <template v-else>\n" +
    "                        <el-menu-item :index=\"item.index\">\n" +
    "                            <i :class=\"item.icon\"></i>{{ item.title }}\n" +
    "                        </el-menu-item>\n" +
    "                    </template>\n" +
    "                </template>\n" +
    "            </el-menu>\n" +
    "        </div>" +
    "</div>",
    data: function () {
        return {
            items: [{
                    icon: 'el-icon-setting',
                    index: 'generalManagement',
                    title: '综合管理'
                },
                {
                    icon: 'el-icon-menu',
                    index: '2',
                    title: '基础数据',
                    subs: [
                        {
                            index: 'wordManagement',
                            title: '词条管理'
                        }
                    ]
                },
                {
                    icon: 'el-icon-date',
                    index: '3',
                    title: '系统设置',
                    subs: [
                        {
                            index: 'userManagement',
                            title: '用户管理'
                        },
                        {
                            index: 'roleManagement',
                            title: '角色管理'
                        },
                        {
                            index: 'resourceManagement',
                            title: '资源管理'
                        }
                    ]
                }],

        }
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        handleCommand(){

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