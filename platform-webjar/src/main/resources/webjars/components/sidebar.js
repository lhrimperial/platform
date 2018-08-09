Vue.component('sidebar', {
    template:
    "        <div class=\"sidebar\">\n" +
    "            <el-menu class=\"el-menu-vertical-demo\" @open=\"handleOpen\"  background-color=\"#324157\" text-color=\"#fff\" unique-opened >\n" +
    "                <template v-for=\"item in menus\">\n" +
    "                    <template v-if=\"item.subs\">\n" +
    "                        <el-submenu :index=\"item.index\">\n" +
    "                            <template slot=\"title\"><i :class=\"item.icon\"></i>{{ item.title }}</template>\n" +
    "                            <el-menu-item v-for=\"(subItem,i) in item.subs\" :key=\"i\" :index=\"subItem.index\" @click='jumpMenu(subItem)'>{{ subItem.title }}\n" +
    "                            </el-menu-item>\n" +
    "                        </el-submenu>\n" +
    "                    </template>\n" +
    "                    <template v-else>\n" +
    "                        <el-menu-item :index=\"item.index\" @click='jumpMenu(item)'>\n" +
    "                            <i :class=\"item.icon\"></i>{{ item.title }}\n" +
    "                        </el-menu-item>\n" +
    "                    </template>\n" +
    "                </template>\n" +
    "            </el-menu>\n" +
    "        </div>",
    props: ['menus'],
    methods: {
        handleOpen: function (index, indexPath) {
        },
        jumpMenu: function (subMenu) {
            this.$emit('jump-menu', subMenu);
        }
    }
});