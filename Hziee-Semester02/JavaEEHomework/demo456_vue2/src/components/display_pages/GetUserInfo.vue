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
          <router-link to="/FinishedOrders" id="finish_orders">完成点单</router-link>
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
            <p>桌位号</p>
            <select id="tableNumber" v-model="tableNumber">
              <option v-for="selectTableNumber in availableTableNumber" :key="selectTableNumber" :value="selectTableNumber.weiId">{{ selectTableNumber.wei }}</option>
            </select>
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
  // DoSaveOrderNumber0,
  // DoSaveOrderNumber1,
  // DoSaveOrderNumber2, DoSaveOrderNumber3,
  DoOverTimeCheck, GiveMeAllTableNumber,
  ParseUserInfoToDataBase
} from "@/util/api";

export default {
  name: "GetUserInfo",
  data() {
    return {
      phoneNumber: "",
      userNumber: "",
      orderNumber: "",
      tableNumber: "1",
      userInfoList: [],
      availableTableNumber: [],
      generateNumber: "KFC" + "-" + (new Date().getTime()).toString() +
          (Math.floor(Math.random() * 790) + 110).toString()
    }
  },
  mounted() {
    DoOverTimeCheck();
    this.giveMeTableNumber();
    console.log("刷新页面得到的订单号为：" + this.generateNumber);
  },
  methods: {
    submitUserInfo: function () {
      let testParams = {
        dingId: this.generateNumber,
        userName: this.phoneNumber,
        yongHuRS: this.userNumber,
        weiId: this.tableNumber,
      };
      console.log("传递第一次的订单号为：" + this.generateNumber);

      ParseUserInfoToDataBase(testParams).then(res => {
        this.userInfoList = res;
      });
      alert("已提交用户信息！");
      alert("点击确认跳转到菜单页面！");
    },

    giveMeTableNumber: function () {
      GiveMeAllTableNumber().then((res) => {
        this.availableTableNumber = res;
      })
    }


  },
}
</script>

<style scoped>

</style>