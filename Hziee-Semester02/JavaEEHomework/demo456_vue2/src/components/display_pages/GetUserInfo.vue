<template>
  <div>
    <div id="navBar">
      <ul>
        <li><a href="#" style="font-family: Impact, Helvetica, serif; font-size: 24px"><b>Kentucky Fried Chicken</b></a>
        </li>
        <li>
          <router-link to="/"><b>开始点单</b></router-link>
        </li>
        <li>
          <router-link to="/MenuList">菜单</router-link>
        </li>
        <li>
          <router-link to="/ShoppingCart">购物车</router-link>
        </li>
        <li><a href="#">关于KFC</a></li>
        <li><a href="#">查找KFC</a></li>
        <li><a href="#">商城</a></li>
        <li>
          <router-link to="/FinishedOrder" id="finish_order">完成点单</router-link>
        </li>
      </ul>
    </div>

    <div id="mainTitle">
      <p>请输入您的信息</p>
    </div>

    <div id="userInfo">
      <div id="otherInfo">
        <ul>
          <li><a><b>欢迎光临</b></a></li>
          <li><a>KFC</a></li>
          <li><a>杭电信工分店</a></li>
          <br>
        </ul>
      </div>

      <div id="infoCollection">
        <form>
          <label>
            <p>用户名</p>
            <input type="text" placeholder="请输入用户名" v-model="user_name">
            <p>用餐人数</p>
            <input type="text" placeholder="请输入用餐人数" v-model="user_number">
            <p>桌号</p>
            <input type="text" placeholder="请输入桌号" v-model="table_number">
            <br>
            <br>
            <router-link to="/MenuList"><input type="button" value="提交" @click="submit" id="submitInfo"
                                               v-on:click="submitUserInfo()"></router-link>
          </label>
        </form>
      </div>
    </div>

  </div>
</template>

<style>
@import "../using_css/CommonStyleSheet.css";
@import "../using_css/GetUserInfo.css";
</style>

<script>
export default {
  name: "GetUserInfo",
  data() {
    return {
      //
    }
  },
  methods: {
    submitUserInfo: function () {
      alert("已提交用户信息！");
      alert("点击确认跳转到菜单页面！");
    }
  },
}
</script>

<style scoped>

</style>