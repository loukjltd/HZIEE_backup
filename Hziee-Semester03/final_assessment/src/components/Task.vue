<template>
  <div>
    <div id="navBar">
      <ul>
        <li class="navBarCommonItem">
          <router-link to="/"><a>首页</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Question"><a>提问</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Paragraph"><a>专栏</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Task"><a style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">任务</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Notification"><a>通知</a></router-link>
        </li>
        <li>
          <input type="search" placeholder="请搜索想要搜索的内容" id="navBarSearchBox">
          <input type="button" value="搜索" id="navBarSearchButton">
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Creator"><a>创作中心</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Mine"><a>我的</a></router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
/* eslint-disable*/
export default {
  name: "Task"
}
</script>

<style scoped>
@import "../css/Main.css";
</style>