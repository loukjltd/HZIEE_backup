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
<!--            <input type="button" value="提交" id="submitInfo" v-on:click="submitUserInfo()">-->
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
import {
  DoSaveOrderNumber0,
  DoSaveOrderNumber1,
  DoSaveOrderNumber2, DoSaveOrderNumber3,
  ParseUserInfoToDataBase
} from "@/util/api";

export default {
  name: "GetUserInfo",
  data() {
    return {
      phoneNumber: "",
      userNumber: "",
      orderNumber: "",
      userInfoList: [],
      testSavedNumber1: [],
      testSavedNumber2: [],
      testSavedNumber3: [],
      testSavedNumber0: [],
      generateNumber: "KFC" + "-" + (new Date().getTime()).toString() +
          (Math.floor(Math.random() * 790) + 110).toString()
    }
  },
  mounted() {
    console.log("刷新页面得到的订单号为：" + this.generateNumber);
  },
  methods: {
    submitUserInfo: function () {
      let testParams = {
        userName: this.phoneNumber,
        yongHuRS: this.userNumber,
      };
      console.log("传递第一次的订单号为：" + this.generateNumber);


      let onlyOrderNum = {
        dingId: this.generateNumber,
      }
      console.log("传递第二次的订单号为：" + onlyOrderNum.dingId);

      DoSaveOrderNumber0(onlyOrderNum).then(res => {
        this.testSavedNumber0 = res;
      });
      DoSaveOrderNumber1(onlyOrderNum).then(res => {
        this.testSavedNumber1 = res;
      });
      DoSaveOrderNumber2(onlyOrderNum).then(res => {
        this.testSavedNumber2 = res;
      });
      DoSaveOrderNumber3(onlyOrderNum).then(res => {
        this.testSavedNumber3 = res;
      });

      ParseUserInfoToDataBase(testParams).then(res => {
        this.userInfoList = res;
      });
      console.log("完成的test的订单号为：" + onlyOrderNum.dingId);
      console.log("再看一遍原本的：" + this.generateNumber);

      alert("已提交用户信息！");
      alert("点击确认跳转到菜单页面！");
    },


  },
}
</script>

<style scoped>

</style>