// index.ts
import { createRouter, createWebHashHistory} from 'vue-router';
// 修复了router不跳转的问题
// Detail see: https://blog.csdn.net/weixin_52020362/article/details/127934366
import type { RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
    // 项目打开后进入的默认地址
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        component: () => import('../views/login.vue')
    },
]
const router = createRouter({
    history: createWebHashHistory(), // 本项目采用了哈希模式
    routes
})
export default router
