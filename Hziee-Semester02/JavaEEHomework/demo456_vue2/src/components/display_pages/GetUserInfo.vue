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
            <el-input type="text" placeholder="请输入手机号" v-model="phoneNumber"></el-input>
            <p>用餐人数</p>
            <el-input type="text" placeholder="请输入用餐人数" v-model="userNumber"></el-input>
            <br>
            <br>
            <router-link to="/MenuList"><input type="button" value="提交" id="submitInfo"
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
import {ParseUserInfoToDataBase} from "@/util/api";
import global from "@/util/global";

export default {
  name: "GetUserInfo",
  data() {
    return {
      phoneNumber: "",
      userNumber: "",
      orderNumber: "KFC" + "-" + (new Date().getTime()).toString(),
      userInfoList: [],
    }
  },
  mounted() {
    console.log(global.presentOrderNumber);
  },

  methods: {
    submitUserInfo: function () {
      let testParams = {
        dingId: this.orderNumber,
        userName: this.phoneNumber,
        yongHuRS: this.userNumber,
      };
      ParseUserInfoToDataBase(testParams).then(res => {this.userInfoList = res;});
      alert("已提交用户信息！");
      alert("点击确认跳转到菜单页面！");
      global.presentOrderNumber = this.orderNumber;
      console.log(global.presentOrderNumber);
    },
  },
}
</script>

<style scoped>

</style>