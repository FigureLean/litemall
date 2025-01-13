// main.ts
import { createApp } from 'vue'
import './style.css'
/* 引入 ElementPlus */
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
const app = createApp(App)
// 路由设置
import router from './router/index'
app.use(router)

app.use(ElementPlus)  // 此时 ElementPlus 的使用在根组件的挂载之前，是正确的；
app.mount('#app')
