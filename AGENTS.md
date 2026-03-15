# AGENTS.md - 视觉资产协同管理平台

重要！！
- 开源项目学习笔记：https://gcntf98ec0k2.feishu.cn/wiki/INrVw9MbAi3LpNkXa2gcUpDWnkc（你每次修改我的项目的时候，都根据此文档查看在笔记中是怎么做的，尽量改新的，不要一致）

## 项目概述

**项目名称**：基于 AI 的高校与企业视觉资产协同管理平台

**项目目的**：本项目是将一个开源图库项目重构为具有独立知识产权的视觉资产管理系统，用于申请软件著作权和参加大学生创新创业竞赛（大创）。项目通过引入 AI 技术与协同管理机制，构建一个集图片管理、智能分析与多人协同于一体的云端平台。

**目标用户**：高校班级、社团、团队及中小型企业

---

## 核心功能模块

### 1. 用户与权限管理
- 用户注册与登录
- 角色区分：普通用户、管理员用户、VIP 用户
- 团队创建与成员管理（支持成员、标注成员、访客角色）
- 基于角色的权限控制

### 2. 视觉资产上传与管理
- 上传至腾讯云 COS 存储
- 批量上传与基础信息管理
- 视觉资产分类、标注和维护

### 3. AI 图片智能分析
- 基于 AI 图像识别模型分析图片内容
- AI 自动生成标签（基于预设标签库）
- 支持人工调整标签，实现人机协同

### 4. 智能检索功能
- 基于关键词和标签搜索视觉资产
- 支持模糊查询与多条件筛选

### 5. 协同与共享功能
- 创建团队空间
- 团队成员间共享视觉资产
- 支持实时协同操作

### 6. 管理与统计功能
- 管理员对图片内容进行审核与管理
- 统计图片上传与使用情况
- 为后续优化提供数据支持

---

## 技术架构

### 前端技术栈
- **框架**：Vue 3
- **构建工具**：Vite
- **UI 组件库**：Element Plus
- **状态管理**：Pinia
- **路由管理**：Vue Router 4
- **HTTP 客户端**：Axios
- **代码规范**：ESLint + Prettier

### 后端技术栈
- **框架**：Spring Boot 3.0.2
- **JDK 版本**：Java 17
- **数据库**：MySQL
- **ORM 框架**：MyBatis-Plus 3.5.3.1
- **文件存储**：腾讯云 COS
- **权限控制**：Sa-Token
- **实时通信**：WebSocket
- **AI 能力**：阿里云百炼模型接口或其他 API 中转
- **API 文档**：Knife4j 4.4.0（基于 OpenAPI 3）
- **工具库**：Hutool 5.8.38

---

## 项目目录结构

```
visual-assets/
├── AGENTS.md                 # 项目说明文档（本文件）
├── .gitignore                # 根目录 Git 忽略配置
├── backend/                  # 后端项目（Spring Boot）
│   ├── pom.xml
│   ├── src/
│   │   ├── main/java/com/gyqstd/visualassets/
│   │   │   ├── VisualAssetsApplication.java
│   │   │   ├── config/       # 配置类
│   │   │   ├── controller/   # 控制器层
│   │   │   ├── service/      # 业务逻辑层（待创建）
│   │   │   ├── mapper/       # 数据访问层
│   │   │   └── entity/       # 实体类（待创建）
│   │   └── resources/
│   │       ├── application.yml
│   │       └── static/
│   └── target/               # 编译输出目录
└── frontend/                 # 前端项目（Vue 3）- 待初始化
    ├── package.json
    ├── vite.config.js
    ├── index.html
    └── src/
        ├── api/              # API 接口封装
        ├── assets/           # 静态资源
        ├── components/       # 公共组件
        ├── views/            # 页面视图
        ├── router/           # 路由配置
        ├── stores/           # Pinia 状态管理
        ├── utils/            # 工具函数
        ├── App.vue
        └── main.js
```

---

## 开发规范

本项目所有 Java 代码必须严格遵循以下文档规范。

### 代码规范
- 使用 Lombok 简化实体类代码
- 统一返回结果封装
- 统一异常处理
- 接口使用 RESTful 风格设计

### 数据库规范
- 使用 MyBatis-Plus 进行数据库操作
- 启用逻辑删除（字段：isDelete）
- 关闭下划线转驼峰命名（map-underscore-to-camel-case: false）

### API 文档规范
- 使用 Knife4j 生成 API 文档
- 访问地址：http://localhost:8456/api/doc.html

### 类注释规范

所有类必须包含标准 JavaDoc 注释，格式如下：

```java
/**
 * 类功能描述（说明该类核心职责）
 * 
 * @author GuYuqi
 * @version 1.0
 */
```

规则：
1. 必须使用 JavaDoc 风格（/** */）
2. 必须描述类的主要职责
3. 禁止省略类注释

### 接口注释规范

所有接口必须添加 JavaDoc 注释，要求如上

---

## 前端开发规范

本项目前端基于 Vue 3 + Vite + Ant Design Pro 技术栈，所有前端代码必须遵循以下规范。

### 命名规范

#### 文件命名
- **组件文件**：大驼峰命名法，如 `UserLogin.vue`、`ImageUploadDialog.vue`
- **JS/TS 文件**：小驼峰命名法，如 `userStore.js`、`request.js`
- **常量文件**：全大写下划线分隔，如 `constants.js` 中 `const MAX_UPLOAD_SIZE = 10 * 1024 * 1024`

#### 变量与函数命名
- **变量**：小驼峰，如 `userInfo`、`imageList`
- **常量**：全大写下划线，如 `API_BASE_URL`、`DEFAULT_PAGE_SIZE`
- **函数**：小驼峰，动词开头，如 `fetchUserList`、`handleUpload`
- **组件名**：大驼峰，语义化命名，如 `ImagePreviewCard`
- **事件处理函数**：`handle` + 动作，如 `handleSubmit`、`handleCancel`

### 组件开发规范

#### 单文件组件结构
```vue
<script setup>
/**
 * 组件功能描述
 * @author GuYuqi
 * @version 1.0
 */
import { ref, computed } from 'vue'
import { useUserStore } from '@/stores/userStore'

// 1. 导入声明（按顺序：Vue API -> 第三方库 -> 本地模块）

// 2. Props 定义
const props = defineProps({
  imageUrl: {
    type: String,
    required: true
  },
  width: {
    type: Number,
    default: 200
  }
})

// 3. Emits 定义
const emit = defineEmits(['click', 'delete'])

// 4. 响应式数据
const loading = ref(false)
const imageData = ref(null)

// 5. 计算属性
const displayWidth = computed(() => `${props.width}px`)

// 6. 方法定义
const handleClick = () => {
  emit('click', imageData.value)
}

// 7. 生命周期钩子
onMounted(() => {
  loadImageData()
})
</script>

<template>
  <!-- 模板中使用语义化 class 名 -->
  <div class="image-card" :style="{ width: displayWidth }" @click="handleClick">
    <img :src="imageUrl" alt="图片" />
  </div>
</template>

<style scoped>
/* 使用 scoped 限定样式作用域 */
.image-card {
  border-radius: 8px;
  overflow: hidden;
}
</style>
```

#### 组件注释规范
每个 Vue 组件文件顶部必须包含功能描述注释：
```javascript
/**
 * 组件功能描述（说明该组件核心职责和使用场景）
 * 
 * @author GuYuqi
 * @version 1.0
 */
```

### 代码风格规范

#### 模板规范
- 使用双引号包裹属性值
- 指令使用简写：`@click` 代替 `v-on:click`，`:src` 代替 `v-bind:src`
- 复杂表达式移至计算属性或方法
- 列表渲染必须指定 `key`：`<div v-for="item in list" :key="item.id">`

#### Script 规范
- 使用 `<script setup>` 语法
- 使用 Composition API
- 导入路径使用 `@/` 别名指向 `src` 目录
- 避免使用 `var`，统一使用 `const` 和 `let`

#### 样式规范
- 使用 `scoped` 属性限定组件样式作用域
- 类名使用小写中划线命名法，如 `.image-card`、`.user-avatar`
- 颜色值使用小写十六进制，如 `#ffffff` 简写为 `#fff`
- 优先使用 Element Plus 的 CSS 变量保持主题一致

### API 请求规范

#### 请求封装（utils/request.js）
```javascript
import axios from 'axios'

const request = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL || '/api',
  timeout: 10000
})

// 请求拦截器 - 添加 Token
request.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token')
    if (token) {
      config.headers.Authorization = `Bearer ${token}`
    }
    return config
  },
  (error) => Promise.reject(error)
)

// 响应拦截器 - 统一错误处理
request.interceptors.response.use(
  (response) => response.data,
  (error) => {
    // 统一处理错误，如 401 跳转登录页
    if (error.response?.status === 401) {
      // 处理未授权
    }
    return Promise.reject(error)
  }
)

export default request
```

#### API 模块封装（api/user.js）
```javascript
import request from '@/utils/request'

/**
 * 用户登录
 * @param {Object} data - 登录参数
 * @param {string} data.userAccount - 账号
 * @param {string} data.userPassword - 密码
 * @returns {Promise}
 */
export const userLogin = (data) => {
  return request.post('/user/login', data)
}

/**
 * 获取当前登录用户信息
 * @returns {Promise}
 */
export const getLoginUser = () => {
  return request.get('/user/get/login')
}
```

### 状态管理规范（Pinia）

```javascript
// stores/userStore.js
import { defineStore } from 'pinia'
import { ref, computed } from 'vue'
import { getLoginUser } from '@/api/user'

/**
 * 用户状态管理
 * @author GuYuqi
 * @version 1.0
 */
export const useUserStore = defineStore('user', () => {
  // State
  const userInfo = ref(null)
  const token = ref(localStorage.getItem('token') || '')
  
  // Getters
  const isLogin = computed(() => !!token.value)
  const isAdmin = computed(() => userInfo.value?.userRole === 'admin')
  
  // Actions
  const setToken = (newToken) => {
    token.value = newToken
    localStorage.setItem('token', newToken)
  }
  
  const fetchUserInfo = async () => {
    const res = await getLoginUser()
    userInfo.value = res.data
  }
  
  const logout = () => {
    token.value = ''
    userInfo.value = null
    localStorage.removeItem('token')
  }
  
  return {
    userInfo,
    token,
    isLogin,
    isAdmin,
    setToken,
    fetchUserInfo,
    logout
  }
})
```

### 路由配置规范

```javascript
// router/index.js
import { createRouter, createWebHistory } from 'vue-router'
import { useUserStore } from '@/stores/userStore'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/views/home/index.vue'),
    meta: { title: '首页', requireAuth: false }
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/login/index.vue'),
    meta: { title: '登录', requireAuth: false }
  },
  {
    path: '/picture',
    name: 'Picture',
    component: () => import('@/views/picture/index.vue'),
    meta: { title: '图片管理', requireAuth: true }
  },
  {
    path: '/admin',
    name: 'Admin',
    component: () => import('@/views/admin/index.vue'),
    meta: { title: '管理后台', requireAuth: true, requireAdmin: true }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// 路由守卫
router.beforeEach((to, from, next) => {
  const userStore = useUserStore()
  
  // 设置页面标题
  document.title = to.meta.title ? `${to.meta.title} - 视觉资产管理` : '视觉资产管理'
  
  // 权限校验
  if (to.meta.requireAuth && !userStore.isLogin) {
    next('/login')
  } else if (to.meta.requireAdmin && !userStore.isAdmin) {
    next('/')
  } else {
    next()
  }
})

export default router
```

### 环境变量配置

创建 `.env.development` 和 `.env.production` 文件：

```
# .env.development
VITE_API_BASE_URL=http://localhost:8456/api
VITE_COS_HOST=your-cos-host
```

---

## 环境配置

### 必要环境变量

以下内容通过 application-local.yml 读取
```bash
# 数据库配置
DB_USERNAME=数据库用户名
DB_PASSWORD=数据库密码

# 腾讯云 COS 配置
COS_HOST=对象存储访问域名
COS_SECRET_ID=对象存储 SecretId
COS_SECRET_KEY=对象存储 SecretKey
COS_REGION=对象存储地域
COS_BUCKET=对象存储桶名称
```

### 本地开发
- 激活配置：`spring.profiles.active=local`
- 服务端口号：8456
- 上下文路径：/api
- API 文档：http://localhost:8456/api/doc.html

---

## 参考资源

- 开源项目学习笔记：https://gcntf98ec0k2.feishu.cn/wiki/INrVw9MbAi3LpNkXa2gcUpDWnkc（你每次修改我的项目的时候，都根据此文档查看在笔记中是怎么做的，尽量改新的，不要一致）
- Knife4j 官方文档：https://doc.xiaominfo.com/
- Spring Boot 官方文档：https://spring.io/projects/spring-boot
- MyBatis-Plus 官方文档：https://baomidou.com/
- 原开源项目地址：https://github.com/liyupi/yu-picture（目标是将该项目重构为自己的项目去申请软著并参加竞赛）

---

## 作者信息

- **作者**：GuYuqi
- **版本**：1.0
- **项目用途**：软件著作权申请、大学生创新创业竞赛
