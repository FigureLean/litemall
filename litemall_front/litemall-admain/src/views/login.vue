<template>
  <!-- 需要对界面进行美化 -->
  <div style="background-color: aquamarine;">
  <el-form :inline="false" :model="formInline" class="demo-form-inline">
    <el-form-item label="请输入用户名">
      <el-input v-model="formInline.username" placeholder="用户名" clearable />
    </el-form-item>
    <el-form-item label="请输入密码">
      <el-input v-model="formInline.password" placeholder="密码" clearable />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Query</el-button>
    </el-form-item>
  </el-form>
</div>


</template>

<script lang="ts" setup>
import { reactive } from 'vue'
import {login} from "../api/login"


const formInline = reactive({
  username: '',
  password: '',
})

const onSubmit = async () => {
  try {
    const response = await login(formInline);
    console.log('登录成功', response);
    // 这里可以根据实际需求处理登录成功后的逻辑，例如跳转页面、保存 token 等
  } catch (error) {
    console.error('登录失败', error);
    // 这里可以根据实际需求处理登录失败后的逻辑，例如显示错误信息等
  }
}

</script>

<style>
.demo-form-inline .el-form-item {
  margin-bottom: 20px; /* 可以根据需要调整间距 */
}
</style>
