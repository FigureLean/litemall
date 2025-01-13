// 引入axios
import axios from 'axios';
import { ElMessage, ElMessageBox } from 'element-plus';

// 设置请求头
axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8';

// 创建axios实例
const service = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    baseURL: import.meta.env.VITE_APP_BASE_API,
    // baseURL: "http://localhost:8085/mumudemo/",
    timeout: 5000 // 请求超时时间
});

// 添加请求拦截器
/*需要拦截请求的原因
  *   1.config中包含了某些不符合服务器要求的信息
  *   2.发送网络请求的时候需要向用户展示一些加载中的图标
  *   3.网站需要登录才能请求资源，也就是需要token才能请求资源
  */

// 添加响应拦截器
// 响应拦截器
service.interceptors.response.use(
    response => {
      const res = response.data;

      if (res.errno === 501) {
        ElMessageBox.alert('系统未登录，请重新登录', '错误', {
          confirmButtonText: '确定',
          type: 'error'
        }).then(() => {
          // 假设你有一个store并且有FedLogOut action
          // store.dispatch('FedLogOut').then(() => {
          //   location.reload()
          // })
        });
        return Promise.reject('error');
      } else if (res.errno === 502) {
        ElMessageBox.alert('系统内部错误，请联系管理员维护', '错误', {
          confirmButtonText: '确定',
          type: 'error'
        });
        return Promise.reject('error');
      } else if (res.errno === 503) {
        ElMessageBox.alert('请求业务目前未支持', '警告', {
          confirmButtonText: '确定',
          type: 'error'
        });
        return Promise.reject('error');
      } else if (res.errno === 504) {
        ElMessageBox.alert('更新数据已经失效，请刷新页面重新操作', '警告', {
          confirmButtonText: '确定',
          type: 'error'
        });
        return Promise.reject('error');
      } else if (res.errno === 505) {
        ElMessageBox.alert('更新失败，请再尝试一次', '警告', {
          confirmButtonText: '确定',
          type: 'error'
        });
        return Promise.reject('error');
      } else if (res.errno === 506) {
        ElMessageBox.alert('没有操作权限，请联系管理员授权', '错误', {
          confirmButtonText: '确定',
          type: 'error'
        });
        return Promise.reject('error');
      } else if (res.errno !== 200) {
        // 非5xx的错误属于业务错误，留给具体页面处理
        return Promise.reject(response);
      } else {
        return response;
      }
    }, error => {
      console.log('err' + error); // for debug
      ElMessage({
        message: '登录连接超时（后台不能连接，请联系系统管理员）',
        type: 'error',
        duration: 5 * 1000
      });
      return Promise.reject(error);
    }
);

// 导出
export default service;